////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Setup matrix entry.
 */
@ApiModel(value = "setupMatrixEntry")
@JsonPropertyOrder({ "predecessorMaterial", "successorMaterial", "setupTime", "workplaces" })
public class SetupMatrixEntryWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The predecessor material. */
    private MaterialPropertiesWSModel mPredecessorMaterial;

    /** The successor material. */
    private MaterialPropertiesWSModel mSuccessorMaterial;

    /** The setup time. */
    private Long mSetupTime;

    /** List of workplaces. */
    private List<WorkplaceGeneralDefinitionWSModel> mWorkplaces;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<WorkplaceGeneralDefinitionWSModel> getWorkplaces() {
        return mWorkplaces;
    }

    @ApiModelProperty(value = "List of affected workplaces", position = 3)
    public void setWorkplaces(List<WorkplaceGeneralDefinitionWSModel> workplaces) {
        mWorkplaces = workplaces;
    }

    public MaterialPropertiesWSModel getPredecessorMaterial() {
        return mPredecessorMaterial;
    }

    @ApiModelProperty(value = "Material that is produced at the workplace before the setup transition", position = 0)
    public void setPredecessorMaterial(MaterialPropertiesWSModel predecessorMaterial) {
        mPredecessorMaterial = predecessorMaterial;
    }

    public MaterialPropertiesWSModel getSuccessorMaterial() {
        return mSuccessorMaterial;
    }

    @ApiModelProperty(value = "Material that is produced at the workplace after the setup transition", position = 1)
    public void setSuccessorMaterial(MaterialPropertiesWSModel successorMaterial) {
        mSuccessorMaterial = successorMaterial;
    }

    public Long getSetupTime() {
        return mSetupTime;
    }

    @ApiModelProperty(value = "Setup time in msec", position = 2)
    public void setSetupTime(Long setupTime) {
        mSetupTime = setupTime;
    }
}