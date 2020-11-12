////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.qualitydetail;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypePropertiesWSModel;

/**
 * A quality detail model.
 */
public class QualityDetailResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the quality detail. */
    private QualityDetailPropertiesWSModel mProperties;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded short description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mShortDescription;

    /** The embedded quality type. */
    private LinkEmbeddedWSModel<QualityTypePropertiesWSModel> mQualityType;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public QualityDetailPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(QualityDetailPropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> shortDescription) {
        mShortDescription = shortDescription;
    }

    public LinkEmbeddedWSModel<QualityTypePropertiesWSModel> getQualityType() {
        return mQualityType;
    }

    public void setQualityType(LinkEmbeddedWSModel<QualityTypePropertiesWSModel> qualityType) {
        mQualityType = qualityType;
    }
}