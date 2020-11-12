////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitydetail.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailEmbed;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityType;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetQualityDetailsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private QualityDetailEmbed mEmbed = new QualityDetailEmbed();

    /** The quality detail mnemonic. */
    private String mCode;

    /** The ID of the quality type. */
    private QualityType mQualityTypeId;

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
            .appendSuper(super.toString())
            .append("embed", mEmbed)
            .append("code", mCode)
            .append("qualityTypeId", mQualityTypeId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public QualityType getQualityTypeId() {
        return mQualityTypeId;
    }

    public void setQualityTypeId(QualityType qualityTypeId) {
        mQualityTypeId = qualityTypeId;
    }
}