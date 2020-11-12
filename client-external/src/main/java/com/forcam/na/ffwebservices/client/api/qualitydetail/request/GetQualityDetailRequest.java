////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitydetail.request;

import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an ID and values that determine what shall be embedded.
 */
public class GetQualityDetailRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A quality detail ID. */
    private String mId;

    /** Determines what shall be embedded. */
    private QualityDetailEmbed mEmbed = new QualityDetailEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetQualityDetailRequest} object with a quality detail ID.
     *
     * @param qualityDetailId The quality detail ID.
     */
    public GetQualityDetailRequest(String qualityDetailId) {
        mId = qualityDetailId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public QualityDetailEmbed embed() {
        return mEmbed;
    }

    public void embed(QualityDetailEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("id", mId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}