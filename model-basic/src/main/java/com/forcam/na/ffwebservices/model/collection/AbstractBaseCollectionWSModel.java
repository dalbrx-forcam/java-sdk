////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 31.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.collection;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * The base collection model.
 */
public abstract class AbstractBaseCollectionWSModel<T> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A map of embedded HAL models. */
    @JsonProperty(value = "_embedded")
    private Map<String, List<T>> mEmbedded;

    /** A collection of link models. */
    @JsonProperty(value = "_links")
    private PaginationLinksWSModel mLinks;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Map<String, List<T>> getEmbedded() {
        return mEmbedded;
    }

    public void setEmbedded(Map<String, List<T>> embedded) {
        this.mEmbedded = embedded;
    }

    public PaginationLinksWSModel getLinks() {
        return mLinks;
    }

    public void setLinks(PaginationLinksWSModel links) {
        this.mLinks = links;
    }
}