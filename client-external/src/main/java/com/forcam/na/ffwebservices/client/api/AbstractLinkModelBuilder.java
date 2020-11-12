package com.forcam.na.ffwebservices.client.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.LinkWSModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Builds a link model.
 *
 * @param <T> Type of the link model builder.
 */
public abstract class AbstractLinkModelBuilder<T> implements LinkModelBuilder<T> {

    // ----------------------------------------------------------------------
    // members
    // ----------------------------------------------------------------------

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractLinkModelBuilder.class);

    /** Jackson's objectmapper. */
    protected final ObjectMapper mMapper = new ObjectMapper();

    /** The class type of a properties model. */
    private Class<T> mClass;

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /**
     * Constructor for link model builder.
     *
     * @param clazz The class type of a properties model.
     */
    public AbstractLinkModelBuilder(Class<T> clazz) {
        mClass = clazz;
    }

    // ----------------------------------------------------------------------
    // methods
    // ----------------------------------------------------------------------

    @Override
    @SuppressWarnings(value = "unchecked")
    public LinkEmbeddedWSModel<T> buildLinkModel(HALWSModel model, String linkName) {
        final LinkEmbeddedWSModel<T> linkModel = new LinkEmbeddedWSModel<>();
        final Optional<LinkWSModel> objectLinkModel = model.getLinkModel(linkName);
        objectLinkModel.ifPresent(linkModel::setLink);

        final Optional<Object> embeddedObject = this.getEmbedded(model, linkName);
        embeddedObject.ifPresent(embedded -> {
            if (embedded instanceof Map) {
                final Map<String, Map<String, Object>> embeddedResource = (Map) embedded;
                final Map<String, Object> properties = embeddedResource.get("properties");
                final T convertedModel = mMapper.convertValue(properties, mClass);
                linkModel.setEmbedded(convertedModel);
            } else {
                LOGGER.warn("Embedded object with link name {} can not be mapped to properties model. Object have to be instance of map", linkName);
            }
        });

        return linkModel;
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public List<LinkEmbeddedWSModel<T>> buildListOfLinkModels(HALWSModel model, String linkName) {
        final List<LinkWSModel> objectLinkModel = model.getLinkModelList(linkName);

        final List<LinkEmbeddedWSModel<T>> linkModels = objectLinkModel
            .stream()
            .map(link -> {
                final LinkEmbeddedWSModel<T> linkEmbeddedWSModel = new LinkEmbeddedWSModel<>();
                linkEmbeddedWSModel.setLink(link);
                return linkEmbeddedWSModel;
            })
            .collect(Collectors.toList());

        final Optional<Object> embeddedObject = this.getEmbedded(model, linkName);

        if (embeddedObject.isEmpty() && !linkModels.isEmpty()) {
            LOGGER.warn("Unexpected difference in list size embedded: {} links: {}", 0, linkModels.size());
            return Collections.emptyList();
        }

        if (embeddedObject.isPresent()) {
            if (embeddedObject.get() instanceof List) {
                final List<Map<String, Map<String, Object>>> embeddedResources = (List) embeddedObject.get();

                if (embeddedResources.size() != linkModels.size()) {
                    LOGGER.warn("Unexpected difference in list size embedded: {} links: {}", embeddedResources.size(), linkModels.size());
                    return Collections.emptyList();
                }

                for (int i = 0; i < linkModels.size(); i++) {
                    final Map<String, Map<String, Object>> embeddedResource = embeddedResources.get(i);
                    final Map<String, Object> objectMap = mMapper.convertValue(embeddedResource, Map.class);
                    Map<String, Object> properties = (Map) objectMap.get("properties");
                    T convertedValue = mMapper.convertValue(properties, mClass);
                    linkModels
                        .get(i)
                        .setEmbedded(convertedValue);
                }
            } else {
                LOGGER.warn("Embedded object with link name {} can not be mapped to list of properties models. Object have to be instance of list", linkName);
            }

        }

        return linkModels;
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public LinkEmbeddedWSModel<List<T>> buildLinkToCollectionModel(HALWSModel model, String linkName) {
        final LinkEmbeddedWSModel<List<T>> linkModel = new LinkEmbeddedWSModel<>();
        final Optional<LinkWSModel> link = model.getLinkModel(linkName);

        link.ifPresent(linkModel::setLink);

        final Optional<Object> embedded = this
            .getEmbedded(model, linkName)
            .flatMap(embeddedCol -> {
                try {
                    final String json = mMapper.writeValueAsString(embeddedCol);
                    final HALWSModel halwsModel = mMapper.readValue(json, HALWSModel.class);
                    return halwsModel
                        .getEmbedded()
                        .values()
                        .stream()
                        .findFirst();

                } catch (IOException e) {
                    LOGGER.error("Unable to map collection to HALWSModel", e);
                    return Optional.empty();
                }
            });
        embedded.ifPresent(embeddedCol -> {
            if (embeddedCol instanceof List) {
                final List<Map<String, Map<String, Object>>> embeddedResources = (List) embeddedCol;
                final List<T> convertedModels = embeddedResources
                    .stream()
                    .map(object -> {
                        final Map<String, Object> objectMap = mMapper.convertValue(object, Map.class);
                        Map<String, Object> properties = (Map) objectMap.get("properties");
                        return mMapper.convertValue(properties, mClass);
                    })
                    .collect(Collectors.toList());
                linkModel.setEmbedded(convertedModels);
            } else {
                LOGGER.warn("Embedded object with link name {} can not be mapped to list of properties models. Object have to be instance of list", linkName);
            }
        });
        return linkModel;
    }

    /**
     * Gets embedded resource object with given link name of HAL model if present.
     *
     * @param model    The HAL WS model.
     * @param linkName The link name of embedded resource.
     * @return The embedded resource object if present.
     */
    private Optional<Object> getEmbedded(HALWSModel model, String linkName) {
        if (model.getEmbedded() != null) {
            return Optional.ofNullable(model
                                           .getEmbedded()
                                           .get(linkName));
        }
        return Optional.empty();
    }
}