////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 14.08.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation.quantity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.AbstractQuantitySummaryDetailPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model for properties of operation quantity summary detail.
 */
@XmlRootElement(name = "operationQuantitySummaryDetailProperties")
@ApiModel(value = "operationQuantitySummaryDetailProperties")
@JsonPropertyOrder({ "workplaceId", "quantities", "unconfirmedQuantities", "totalQuantity" })
public class OperationQuantitySummaryDetailPropertiesWSModel extends AbstractQuantitySummaryDetailPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The uuid of the workplace where the quantities were booked */
    private String mWorkplaceId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Setter for workplace id.
     *
     * @param workplaceId The workplace id.
     */
    @ApiModelProperty(value = "UUID of the workplace at which the quantity was recorded", position = 0)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    /**
     * Retrieves workplace id.
     *
     * @return Workplace id.
     */
    public String getWorkplaceId() {
        return mWorkplaceId;
    }
}