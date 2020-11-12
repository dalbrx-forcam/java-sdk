////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 18.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Model containing common properties for create and update.
 */
@ApiModel(value = "writeTicketProperties")
@JsonPropertyOrder({ "title", "description", "rootCause", "priority", "ticketStateId", "ticketClassId", "operationId", "materialNumber", "workplaceId",
                     "shiftId" })
public class WriteTicketPropertiesWSModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mTitle;
    private String mDescription;
    private String mRootCause;
    private TicketPriority mPriority;
    private TicketState mTicketStateId;
    private String mTicketClassId;
    private String mMaterialNumber;
    private String mWorkplaceId;
    private String mOperationId;
    private String mShiftId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @NotBlank
    public String getTitle() {
        return mTitle;
    }

    @ApiModelProperty(position = 1, required = true)
    public void setTitle(String title) {
        mTitle = title;
    }

    @NotBlank
    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(position = 2, required = true)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getRootCause() {
        return mRootCause;
    }

    @ApiModelProperty(position = 3)
    public void setRootCause(String rootCause) {
        mRootCause = rootCause;
    }

    @NotNull
    public TicketPriority getPriority() {
        return mPriority;
    }

    @ApiModelProperty(position = 4, required = true)
    public void setPriority(TicketPriority ticketPriority) {
        mPriority = ticketPriority;
    }

    @NotNull
    public TicketState getTicketStateId() {
        return mTicketStateId;
    }

    @ApiModelProperty(position = 6, required = true)
    public void setTicketStateId(TicketState ticketStateId) {
        mTicketStateId = ticketStateId;
    }

    public String getTicketClassId() {
        return mTicketClassId;
    }

    @ApiModelProperty(position = 7)
    public void setTicketClassId(String ticketClassId) {
        mTicketClassId = ticketClassId;
    }

    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    @ApiModelProperty(position = 9)
    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    @ApiModelProperty(position = 10)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getOperationId() {
        return mOperationId;
    }

    @ApiModelProperty(position = 8)
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    public String getShiftId() {
        return mShiftId;
    }

    @ApiModelProperty(position = 11)
    public void setShiftId(String shiftId) {
        mShiftId = shiftId;
    }

}
