////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitytype.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityType;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypeEmbed;

;

/**
 * Contains an ID and values that determine what shall be embedded.
 */
public class GetQualityTypeRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A quality type ID. */
    private QualityType mId;

    /** Determines what shall be embedded. */
    private QualityTypeEmbed mEmbed = new QualityTypeEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetQualityTypeRequest} object with a quality type ID.
     *
     * @param qualityTypeId The quality type ID.
     */
    public GetQualityTypeRequest(QualityType qualityTypeId) {
        mId = qualityTypeId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public QualityTypeEmbed embed() {
        return mEmbed;
    }

    public void embed(QualityTypeEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("id", mId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public QualityType getId() {
        return mId;
    }

    public void setId(QualityType id) {
        mId = id;
    }
}