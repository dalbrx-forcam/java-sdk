////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.pagination.response;

import com.forcam.na.ffwebservices.model.LinkWSModel;
import com.forcam.na.ffwebservices.model.collection.PaginationLinksWSModel;

import java.util.Map;

/**
 * The pagination response.
 */
public class AbstractPaginationResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A collection model of links. */
    private PaginationLinksWSModel mPaginationLinks;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setPaginationLinks(PaginationLinksWSModel paginationLinks) {
        mPaginationLinks = paginationLinks;
    }

    public PaginationLinksWSModel getPaginationLinks() {
        return mPaginationLinks;
    }

    /**
     * Sets pagination links from map of links.
     *
     * @param links Map of links.
     */
    public void setPaginationLinks(Map<String, LinkWSModel> links) {
        final PaginationLinksWSModel collectionLinksWSModel = new PaginationLinksWSModel();
        collectionLinksWSModel.setSelf(links.get("self"));
        collectionLinksWSModel.setFirst(links.get("first"));
        collectionLinksWSModel.setLast(links.get("last"));
        collectionLinksWSModel.setNext(links.get("next"));
        collectionLinksWSModel.setPrev(links.get("prev"));
        mPaginationLinks = collectionLinksWSModel;
    }

}