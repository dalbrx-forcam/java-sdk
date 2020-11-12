package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht david.albrecht@forcam.com
 */
@ApiModel(value = "staffMemberProperties")
@JsonPropertyOrder({ "id", "number", "firstName", "lastName", "erpContextId", "staffGroupId", "identificationNumber" })
public class StaffMemberPropertiesWSModel extends CreateStaffMemberPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of a staff member", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }
}