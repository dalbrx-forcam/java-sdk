////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractPaginationResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.LinkWSModel;
import com.forcam.na.ffwebservices.model.collection.AbstractBaseCollectionWSModel;
import com.forcam.na.ffwebservices.model.collection.AbstractCollectionWSModel;

import javax.inject.Inject;
import java.util.Optional;

/**
 * The super class of response builders.
 */
public abstract class AbstractResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Jackson's objectmapper. */
    @Inject
    public ObjectMapper mMapper;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Initializes a collection response.
     *
     * @param collectionModel    Contains values for the collection response.
     * @param collectionResponse The collection response to initialize.
     */
    protected void initializeCollectionResponse(AbstractCollectionWSModel collectionModel, AbstractCollectionResponse collectionResponse) {
        this.initializeLinks(collectionModel, collectionResponse);
        collectionResponse.setPagination(collectionModel.getPagination());
    }

    /**
     * Creates a self link model.
     *
     * @param model A HAL model.
     * @return A link embedded model.
     */
    protected LinkEmbeddedWSModel<Object> createSelfLinkModel(HALWSModel model) {
        final Optional<LinkWSModel> selfLink = model.getLinkModel("self");
        final LinkEmbeddedWSModel<Object> selfLinkModel = new LinkEmbeddedWSModel<>();
        selfLink.ifPresent(selfLinkModel::setLink);
        return selfLinkModel;
    }

    /**
     * Initializes the links.
     *
     * @param collectionModel    Contains values for the collection response.
     * @param collectionResponse The collection response to initialize.
     */
    protected void initializeLinks(AbstractBaseCollectionWSModel collectionModel, AbstractPaginationResponse collectionResponse) {
        if (collectionModel.getLinks() != null) {
            collectionResponse.setPaginationLinks(collectionModel.getLinks());
        }
    }
}