////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 24.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;

/**
 * The response model for production resources and tools.
 */
public class ProductionResourceToolResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the production resources and tools. */
    private ProductionResourceToolPropertiesWSModel mProperties;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded quantity unit. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mQuantityUnit;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ProductionResourceToolPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(ProductionResourceToolPropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getQuantityUnit() {
        return mQuantityUnit;
    }

    public void setQuantityUnit(LinkEmbeddedWSModel<LiteralPropertiesWSModel> quantityUnit) {
        mQuantityUnit = quantityUnit;
    }
}