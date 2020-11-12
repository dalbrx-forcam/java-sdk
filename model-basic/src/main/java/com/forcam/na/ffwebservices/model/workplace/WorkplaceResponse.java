package com.forcam.na.ffwebservices.model.workplace;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.location.LocationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.machine.MachinePropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.UserFieldCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPropertiesWSModel;

import java.util.List;

public class WorkplaceResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the workplace. */
    private WorkplacePropertiesWSModel mProperties;

    /** The embedded ERP context. */
    private LinkEmbeddedWSModel<ErpContextPropertiesWSModel> mErpContext;

    /** The embedded machine. */
    private LinkEmbeddedWSModel<MachinePropertiesWSModel> mMachine;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded current operations. */
    private List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> mCurrentOperations;

    /** The embedded current staff members. */
    private List<LinkEmbeddedWSModel<StaffMemberPropertiesWSModel>> mCurrentStaffMembers;

    /** The embedded location. */
    private LinkEmbeddedWSModel<LocationPropertiesWSModel> mLocation;

    /** The embedded workplace user fields. */
    private LinkEmbeddedWSModel<UserFieldCollectionPropertiesWSModel> mUserFields;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplacePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(WorkplacePropertiesWSModel properties) {
        this.mProperties = properties;
    }

    public LinkEmbeddedWSModel<ErpContextPropertiesWSModel> getErpContext() {
        return mErpContext;
    }

    public void setErpContext(LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext) {
        mErpContext = erpContext;
    }

    public LinkEmbeddedWSModel<MachinePropertiesWSModel> getMachine() {
        return mMachine;
    }

    public void setMachine(LinkEmbeddedWSModel<MachinePropertiesWSModel> machine) {
        mMachine = machine;
    }

    /**
     * Provides the embedded literal for description.
     *
     * @return The link embedded WS model for workplace description.
     */
    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    /**
     * Sets the embedded literal for workplace description.
     *
     * @param description The link embedded WS model for workplace description.
     */
    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    public List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> getCurrentOperations() {
        return mCurrentOperations;
    }

    public void setCurrentOperations(List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> currentlyExecutedOperations) {
        mCurrentOperations = currentlyExecutedOperations;
    }

    public void setCurrentStaffMembers(List<LinkEmbeddedWSModel<StaffMemberPropertiesWSModel>> currentStaffMembers) {
        mCurrentStaffMembers = currentStaffMembers;
    }

    public List<LinkEmbeddedWSModel<StaffMemberPropertiesWSModel>> getCurrentStaffMembers() {
        return mCurrentStaffMembers;
    }

    public LinkEmbeddedWSModel<LocationPropertiesWSModel> getLocation() {
        return mLocation;
    }

    public void setLocation(LinkEmbeddedWSModel<LocationPropertiesWSModel> location) {
        mLocation = location;
    }

    public LinkEmbeddedWSModel<UserFieldCollectionPropertiesWSModel> getUserFields() {
        return mUserFields;
    }

    public void setUserFields(LinkEmbeddedWSModel<UserFieldCollectionPropertiesWSModel> userFields) {
        mUserFields = userFields;
    }
}
