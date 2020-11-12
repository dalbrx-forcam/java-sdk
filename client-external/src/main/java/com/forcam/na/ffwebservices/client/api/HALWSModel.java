package com.forcam.na.ffwebservices.client.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forcam.na.ffwebservices.model.LinkWSModel;
import com.forcam.na.ffwebservices.model.collection.PaginationPropertiesWSModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HALWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger for class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(HALWSModel.class);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A map containing the properties. */
    private Map<String, Object> mProperties;

    /** The pagination. */
    private PaginationPropertiesWSModel mPagination;

    /** Embedded resources. */
    @JsonProperty(value = "_embedded")
    private Map<String, Object> mEmbedded;

    /** A map containing links. */
    @JsonProperty(value = "_links")
    private Map<String, Object> mLinks;

    @JsonIgnore
    private ObjectMapper mObjectMapper = new ObjectMapper();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Map<String, Object> getLinks() {
        return mLinks;
    }

    public void setLinks(Map<String, Object> links) {
        this.mLinks = links;
    }

    public Map<String, Object> getEmbedded() {
        return mEmbedded;
    }

    public void setEmbedded(Map<String, Object> embedded) {
        this.mEmbedded = embedded;
    }

    public Map<String, Object> getProperties() {
        return mProperties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.mProperties = properties;
    }

    public PaginationPropertiesWSModel getPagination() {
        return mPagination;
    }

    public void setPagination(PaginationPropertiesWSModel pagination) {
        mPagination = pagination;
    }

    /**
     * Get all links which contain a single link object.
     *
     * @return Map with linkName as key, and {@link LinkWSModel} as value.
     */
    public Map<String, LinkWSModel> getLinkModels() {
        final Map<String, LinkWSModel> links = new HashMap<>();

        if (mLinks == null) {
            return links;
        }

        for (Map.Entry<String, Object> entry : mLinks.entrySet()) {
            if (!(entry.getValue() instanceof List)) {
                try {
                    final String json = mObjectMapper.writeValueAsString(entry.getValue());
                    final LinkWSModel model = mObjectMapper.readValue(json, LinkWSModel.class);
                    links.put(entry.getKey(), model);
                } catch (IOException e) {
                    LOGGER.error("Unable to map to LinkWSModel", e);
                }
            }
        }

        return links;
    }

    public Optional<LinkWSModel> getLinkModel(String linkName) {
        return Optional.ofNullable(this
                                       .getLinkModels()
                                       .get(linkName));
    }

    /**
     * Get all links which contain a collection of links.
     *
     * @return Map with linkName as key, and List of {@link LinkWSModel} as value.
     */
    private Map<String, List<LinkWSModel>> getLinkModelLists() {
        final Map<String, List<LinkWSModel>> links = new HashMap<>();
        for (Map.Entry<String, Object> entry : mLinks.entrySet()) {
            if (entry.getValue() instanceof List) {
                final List<LinkWSModel> linkList = new ArrayList<>();
                links.put(entry.getKey(), linkList);
                final List linkArray = (List) entry.getValue();
                for (Object link : linkArray) {
                    try {
                        final String json = mObjectMapper.writeValueAsString(link);
                        final LinkWSModel model = mObjectMapper.readValue(json, LinkWSModel.class);
                        linkList.add(model);
                    } catch (IOException e) {
                        LOGGER.error("Unable to map to LinkWSModel", e);
                    }
                }

            }
        }

        return links;
    }

    /**
     * Get a link which contains a collection of links.
     *
     * @param linkName The link name.
     * @return The list of links.
     */
    public List<LinkWSModel> getLinkModelList(String linkName) {
        return Optional
            .ofNullable(this
                            .getLinkModelLists()
                            .get(linkName))
            .orElse(Collections.emptyList());
    }
}
