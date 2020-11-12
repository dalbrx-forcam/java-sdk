////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.staffmember;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.location.LocationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

import java.util.List;

/**
 * The response object for a staff member.
 */
public class StaffMemberResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the staff member. */
    private StaffMemberPropertiesWSModel mProperties;

    /** The embedded ERP context. */
    private LinkEmbeddedWSModel<ErpContextPropertiesWSModel> mErpContext;

    /** The current operations. */
    private List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> mCurrentlyExecutedOperations;

    /** The embedded assigned workplace. */
    private LinkEmbeddedWSModel<List<WorkplacePropertiesWSModel>> mAssignedWorkplaces;

    /** The embedded location. */
    private LinkEmbeddedWSModel<LocationPropertiesWSModel> mLocation;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public StaffMemberPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(StaffMemberPropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<ErpContextPropertiesWSModel> getErpContext() {
        return mErpContext;
    }

    public void setErpContext(LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext) {
        mErpContext = erpContext;
    }

    public void setCurrentlyExecutedOperations(List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> currentlyExecutedOperations) {
        mCurrentlyExecutedOperations = currentlyExecutedOperations;
    }

    public List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> getCurrentlyExecutedOperations() {
        return mCurrentlyExecutedOperations;
    }

    public void setAssignedWorkplaces(LinkEmbeddedWSModel<List<WorkplacePropertiesWSModel>> assignedWorkplaces) {
        mAssignedWorkplaces = assignedWorkplaces;
    }

    public LinkEmbeddedWSModel<List<WorkplacePropertiesWSModel>> getAssignedWorkplaces() {
        return mAssignedWorkplaces;
    }

    public LinkEmbeddedWSModel<LocationPropertiesWSModel> getLocation() {
        return mLocation;
    }

    public void setLocation(LinkEmbeddedWSModel<LocationPropertiesWSModel> location) {
        mLocation = location;
    }
}