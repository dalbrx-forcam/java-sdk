////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 02.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.recordedoperatingstate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.AbstractTimestampModel;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * The operating state record model.
 */
@ApiModel(value = "operatingStateRecord")
@JsonPropertyOrder({ "operatingState", "timePeriod" })
public class OperatingStateRecordWSModel extends AbstractTimestampModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The recorded operating state */
    private OperatingStateGeneralDefinitionWSModel mOperatingState;

    /** Time period of the recorded operating state */
    private TimePeriodWSModel mTimePeriod;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Recorded operating state", position = 0)
    public void setOperatingState(OperatingStateGeneralDefinitionWSModel operatingState) {
        mOperatingState = operatingState;
    }

    public OperatingStateGeneralDefinitionWSModel getOperatingState() {
        return mOperatingState;
    }

    @ApiModelProperty(value = "Time period from start date to end date of the operating state", position = 1)
    public void setTimePeriod(TimePeriodWSModel timePeriod) {
        mTimePeriod = timePeriod;
    }

    public TimePeriodWSModel getTimePeriod() {
        return mTimePeriod;
    }

    @Override
    public Date getPaginationDate() {
        return mTimePeriod.getStartDate();
    }
}