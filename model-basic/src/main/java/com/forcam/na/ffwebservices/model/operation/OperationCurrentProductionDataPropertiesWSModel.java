////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 03.05.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Contains the properties of the operation current production data.
 */
@ApiModel(value = "operationCurrentProductionDataProperties")
@JsonPropertyOrder({ "workplace", "strokes", "phase", "operationTimes" })
public class OperationCurrentProductionDataPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The current workplace of the operation. */
    private WorkplaceGeneralDefinitionWSModel mWorkplace;

    /** The strokes of the operation. */
    private Integer mStrokes;

    /** The current operation phase ID. */
    private OperationPhase mOperationPhaseId;

    /** The list of operation times. */
    private List<OperationTime> mOperationTimes;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplaceGeneralDefinitionWSModel getWorkplace() {
        return mWorkplace;
    }

    @ApiModelProperty(value = "The workplace at which the operation is currently being executed, provided that the operation is currently in execution", position = 0)
    public void setWorkplace(WorkplaceGeneralDefinitionWSModel workplace) {
        mWorkplace = workplace;
    }

    public Integer getStrokes() {
        return mStrokes;
    }

    @ApiModelProperty(position = 1)
    public void setStrokes(Integer strokes) {
        mStrokes = strokes;
    }

    public OperationPhase getOperationPhaseId() {
        return mOperationPhaseId;
    }

    @ApiModelProperty(value = "The identifier of the current operation phase", position = 2)
    public void setOperationPhaseId(OperationPhase operationPhaseId) {
        mOperationPhaseId = operationPhaseId;
    }

    public List<OperationTime> getOperationTimes() {
        return mOperationTimes;
    }

    @ApiModelProperty(value = "The operation times", position = 3)
    public void setOperationTimes(List<OperationTime> operationTimes) {
        mOperationTimes = operationTimes;
    }
}