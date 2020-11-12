package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht david.albrecht@forcam.com
 */
@ApiModel(value = "createStaffMemberProperties")
@JsonPropertyOrder({ "staffNumber", "firstName", "lastName", "erpContextId", "staffGroupId", "identificationNumber" })
public class CreateStaffMemberPropertiesWSModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mStaffNumber;

    private String mFirstName;

    private String mLastName;

    private String mErpContextId;

    private String mIdentificationNumber;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Staff number of a staff member", position = 1)
    public void setStaffNumber(String staffNumber) {
        mStaffNumber = staffNumber;
    }

    public String getStaffNumber() {
        return mStaffNumber;
    }

    @ApiModelProperty(value = "First name of a staff member", position = 2)
    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    @ApiModelProperty(value = "Last name of a staff member", position = 3)
    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getLastName() {
        return mLastName;
    }

    @ApiModelProperty(value = "UUID of the ERP context in which the workplace number is a unique identifier for a workplace or a workplace group. In SAP ERP, for example, this context is defined by the client, the company code, and the plant", position = 4)
    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

    public String getErpContextId() {
        return mErpContextId;
    }

    @ApiModelProperty(value = "Identification number of the staff member as it is typically found on an employee's ID card", position = 6)
    public void setIdentificationNumber(String identificationNumber) {
        mIdentificationNumber = identificationNumber;
    }

    public String getIdentificationNumber() {
        return mIdentificationNumber;
    }
}