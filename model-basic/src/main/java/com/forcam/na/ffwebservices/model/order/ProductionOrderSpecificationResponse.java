////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 18.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.order;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The production order specification response.
 */
public class ProductionOrderSpecificationResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the production order specification . */
    private ProductionOrderSpecificationPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ProductionOrderSpecificationPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(ProductionOrderSpecificationPropertiesWSModel properties) {
        mProperties = properties;
    }

}
