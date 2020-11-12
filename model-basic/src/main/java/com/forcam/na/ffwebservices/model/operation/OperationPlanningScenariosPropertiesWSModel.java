////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 21.06.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Operation planning scenarios properties WS model
 */
@XmlRootElement(name = "operationPlanningScenariosProperties")
@ApiModel(value = "operationPlanningScenariosProperties")
@JsonPropertyOrder({ "id", "creator", "creationDate", "startDate", "endDate", "numberOfWorkplaces", "scheduledOperatingTime", "plannedProcessingTime",
                     "plannedExecutionTime", "numberOfPlannedProductionOrders", "plannedLeadTime", "minimumLeadTimeWithSetup",
                     "numberOfPartiallyPlannedProductionOrders", "adherenceToDeliveryDates", "schedulingEfficiency", "occupancyRate", "setupReduction" })
public class OperationPlanningScenariosPropertiesWSModel extends CreateOperationPlanningScenariosPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The planning scenario ID. */
    private String mId;

    /** Created date. */
    private Date mCreationDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the planning scenario ID.
     *
     * @param id The planning scenario ID.
     */
    @ApiModelProperty(value = "UUID of the operation planning scenario", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    /**
     * Provides the planing scenario ID.
     *
     * @return The planning scenario ID.
     */
    public String getId() {
        return mId;
    }

    /**
     * Setter for creation date.
     *
     * @param creationDate Creation date.
     */
    @ApiModelProperty(value = "Timestamp at which the planning scenario was created", position = 1)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }

    /**
     * Getter for creation date.
     *
     * @return Creation date.
     */
    public Date getCreationDate() {
        return mCreationDate;
    }
}