////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 27.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentCollectionPropertiesWSModel;

/**
 * Server model for the operation assignment collection.
 */
public class OperationAssignmentCollectionServerModel extends HALCollectionWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation assignment collection properties. */
    private OperationAssignmentCollectionPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation assignment collection properties.
     *
     * @return The operation assignment collection properties WS model.
     */
    public OperationAssignmentCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the operation assignment collection properties.
     *
     * @param properties The operation assignment collection properties WS model.
     */
    public void setProperties(OperationAssignmentCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }
}