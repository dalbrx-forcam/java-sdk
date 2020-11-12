package com.forcam.na.ffwebservices.client.api;

import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;

import java.util.List;

public interface LinkModelBuilder<T> {

    /**
     * Builds the link model.
     *
     * @param model    A HAL Model.
     * @param linkName Name of the link.
     * @return A link embedded model.
     */
    LinkEmbeddedWSModel<T> buildLinkModel(HALWSModel model, String linkName);

    /**
     * Builds a list of link models. Has to be used for an array of links.
     *
     * @param model    The HAL Model.
     * @param linkName Name of the link.
     * @return List of {@link LinkEmbeddedWSModel}.
     */
    List<LinkEmbeddedWSModel<T>> buildListOfLinkModels(HALWSModel model, String linkName);

    /**
     * Builds a link model for collection links.
     *
     * @param model    The HAL Model.
     * @param linkName Name of the link.
     * @return The {@link LinkEmbeddedWSModel} containing the collection models.
     */
    LinkEmbeddedWSModel<List<T>> buildLinkToCollectionModel(HALWSModel model, String linkName);
}