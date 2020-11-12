////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.model.operation.OperationEmbed;
import com.forcam.na.ffwebservices.model.operation.SearchOperationsRequestBody;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains values that determine what shall be embedded.
 */
public class SearchOperationsRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Search operations. */
    private SearchOperationsRequestBody mSearchOperations = new SearchOperationsRequestBody();

    /** Determines what shall be embedded. */
    private OperationEmbed mEmbed = new OperationEmbed();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public OperationEmbed embed() {
        return mEmbed;
    }

    public void embed(OperationEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("searchOperations", mSearchOperations)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public SearchOperationsRequestBody getSearchOperations() {
        return mSearchOperations;
    }

    public void setSearchOperations(SearchOperationsRequestBody searchOperations) {
        mSearchOperations = searchOperations;
    }
}