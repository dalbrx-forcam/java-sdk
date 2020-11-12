////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 30.10.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.ticket;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * The basic properties of a ticket.
 */
@ApiModel(value = "ticketProperties")
@JsonPropertyOrder({ "id", "number", "title", "description", "rootCause", "priority", "editor", "creationDate", "ticketStateId", "ticketClassId", "operationId",
                     "material", "workplace", "shiftId" })

public class TicketPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;

    private Date mCreationDate;

    private String mNumber;

    private String mTitle;

    private String mDescription;

    private String mRootCause;

    private TicketPriority mPriority;

    private WorkplaceGeneralDefinitionWSModel mWorkplace;

    private MaterialPropertiesWSModel mMaterial;

    private String mOperationId;

    private String mShiftId;

    private TicketState mTicketStateId;

    private String mTicketClassId;

    private String mEditor;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "", position = 0, required = true)
    public void setId(String id) {
        mId = id;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    @ApiModelProperty(value = "", position = 6, required = true)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }

    public String getTitle() {
        return mTitle;
    }

    @ApiModelProperty(value = "", position = 2, required = true)
    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "", position = 3)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getRootCause() {
        return mRootCause;
    }

    @ApiModelProperty(value = "", position = 4)
    public void setRootCause(String rootCause) {
        mRootCause = rootCause;
    }

    public TicketPriority getPriority() {
        return mPriority;
    }

    @ApiModelProperty(value = "", position = 5, required = true)
    public void setPriority(TicketPriority ticketPriority) {
        mPriority = ticketPriority;
    }

    public String getEditor() {
        return mEditor;
    }

    @ApiModelProperty(value = "", position = 6)
    public void setEditor(String editor) {
        mEditor = editor;
    }

    public WorkplaceGeneralDefinitionWSModel getWorkplace() {
        return mWorkplace;
    }

    @ApiModelProperty(value = "", position = 11)
    public void setWorkplace(WorkplaceGeneralDefinitionWSModel workplace) {
        mWorkplace = workplace;
    }

    public MaterialPropertiesWSModel getMaterial() {
        return mMaterial;
    }

    @ApiModelProperty(value = "", position = 10)
    public void setMaterial(MaterialPropertiesWSModel material) {
        mMaterial = material;
    }

    public String getOperationId() {
        return mOperationId;
    }

    @ApiModelProperty(value = "", position = 9)
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    @ApiModelProperty(value = "", position = 12)
    public void setShiftId(String shiftId) {
        mShiftId = shiftId;
    }

    public String getShiftId() {
        return mShiftId;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "", position = 1)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getTicketClassId() {
        return mTicketClassId;
    }

    @ApiModelProperty(value = "", position = 8)
    public void setTicketClassId(String ticketClassId) {
        this.mTicketClassId = ticketClassId;
    }

    public TicketState getTicketStateId() {
        return mTicketStateId;
    }

    @ApiModelProperty(value = "", position = 7)
    public void setTicketStateId(TicketState ticketStateId) {
        mTicketStateId = ticketStateId;
    }
}
