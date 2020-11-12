////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

/**
 * The response object for the specification of an operation.
 */
public class OperationSpecificationResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties for the specification of an operation. */
    private OperationSpecificationPropertiesWSModel mProperties;

    /** The embedded target workplace. */
    private LinkEmbeddedWSModel<WorkplacePropertiesWSModel> mTargetWorkplace;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationSpecificationPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(OperationSpecificationPropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<WorkplacePropertiesWSModel> getTargetWorkplace() {
        return mTargetWorkplace;
    }

    public void setTargetWorkplace(LinkEmbeddedWSModel<WorkplacePropertiesWSModel> targetWorkplace) {
        mTargetWorkplace = targetWorkplace;
    }
}