////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 25.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.entrypoint;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;

/**
 * The response object for an entry point.
 */
public class EntryPointResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the entry point. */
    private EntryPointPropertiesWSModel mProperties;

    /** The link of the documentation. */
    private LinkEmbeddedWSModel mDocumentation;

    /** The link of production orders. */
    private LinkEmbeddedWSModel mProductionOrders;

    /** The link of operations. */
    private LinkEmbeddedWSModel mOperations;

    /** The link of workplaces. */
    private LinkEmbeddedWSModel mWorkplaces;

    /** The link of staff members. */
    private LinkEmbeddedWSModel mStaffMembers;

    /** The link of tools. */
    private LinkEmbeddedWSModel mTools;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public EntryPointPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(EntryPointPropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel getDocumentation() {
        return mDocumentation;
    }

    public void setDocumentation(LinkEmbeddedWSModel documentation) {
        mDocumentation = documentation;
    }

    public LinkEmbeddedWSModel getProductionOrders() {
        return mProductionOrders;
    }

    public void setProductionOrders(LinkEmbeddedWSModel productionOrders) {
        mProductionOrders = productionOrders;
    }

    public LinkEmbeddedWSModel getOperations() {
        return mOperations;
    }

    public void setOperations(LinkEmbeddedWSModel operations) {
        mOperations = operations;
    }

    public LinkEmbeddedWSModel getWorkplaces() {
        return mWorkplaces;
    }

    public void setWorkplaces(LinkEmbeddedWSModel workplaces) {
        mWorkplaces = workplaces;
    }

    public LinkEmbeddedWSModel getStaffMembers() {
        return mStaffMembers;
    }

    public void setStaffMembers(LinkEmbeddedWSModel staffMembers) {
        mStaffMembers = staffMembers;
    }

    public LinkEmbeddedWSModel getTools() {
        return mTools;
    }

    public void setTools(LinkEmbeddedWSModel tools) {
        mTools = tools;
    }
}