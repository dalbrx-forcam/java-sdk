////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.command.machine;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;

import java.util.List;

/**
 * Request body for machine state.
 */
@ApiModel(value = "machineStateRequestBody")
@JsonPropertyOrder({ "machineStateDetailIds", "remark"})
public class MachineStateRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The machine state details. */
    private List<String> mMachineStateDetailIds;

    /** Remark for the machine state. */
    private String mRemark;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this).append("mRemark", mRemark).append("mMachineStateDetailIds", mMachineStateDetailIds).toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Array of UUIDs of machine state details", position = 0)
    public void setMachineStateDetailIds(List<String> machineStateDetailIds) {
        mMachineStateDetailIds = machineStateDetailIds;
    }

    public List<String> getMachineStateDetailIds() {
        return mMachineStateDetailIds;
    }

    @ApiModelProperty(value = "An additional remark concerning the machine state", position = 1)
    public void setRemark(String remark) {
        mRemark = remark;
    }

    public String getRemark() {
        return mRemark;
    }
}