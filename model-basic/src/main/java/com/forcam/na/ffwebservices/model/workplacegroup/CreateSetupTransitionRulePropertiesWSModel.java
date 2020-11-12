////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplacegroup;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Properties for creating a new setup transition rule.
 */
@XmlRootElement(name = "createSetupTransitionRuleProperties")
@ApiModel(value = "createSetupTransitionRuleProperties")
@JsonPropertyOrder({ "origin", "criterion", "predecessorConditions", "successorConditions", "setupTimeIncrement", "setupTime" })
public class CreateSetupTransitionRulePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The origin. */
    private Origin mOrigin;

    /** The criterion that affects the setup time. */
    private Criterion mCriterion;

    /** The predecessor conditions. */
    private String mPredecessorConditions;

    /** The successor conditions. */
    private String mSuccessorConditions;

    /** The increase of the setup time. */
    private Long mSetupTimeIncrement;

    /** The absolute setup time for the transition. */
    private Long mSetupTime;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Origin getOrigin() {
        return mOrigin;
    }

    @ApiModelProperty(value = "The origin of the entry that is either “MANUAL_DATA_MAINTENANCE” if the entry was created by manual data maintenance, or “AUTOMATIC_EVALUATION_SYSTEM” if an evaluation system has generated the entry", required = true, position = 1)
    public void setOrigin(Origin origin) {
        mOrigin = origin;
    }

    public Criterion getCriterion() {
        return mCriterion;
    }

    @ApiModelProperty(value = "The criterion that affects the setup time, which can be MATERIAL_NUMBER or MATERIAL_CHARACTERISTICS", required = true, position = 4)
    public void setCriterion(Criterion criterion) {
        mCriterion = criterion;
    }

    public String getPredecessorConditions() {
        return mPredecessorConditions;
    }

    @ApiModelProperty(value =
        "If the material number is the criterion, a specification of the predecessor material by the material number (the UUID of the ERP context is not required because the material number is unique in the context of a workplace group)." +
        "\n" +
        "If a material characteristic is the criterion: A condition relating to the characteristics of the material that is produced at the workplace before the setup transition (e.g. color==black;width=lt=40)", required = true, position = 5)
    public void setPredecessorConditions(String predecessorConditions) {
        mPredecessorConditions = predecessorConditions;
    }

    public String getSuccessorConditions() {
        return mSuccessorConditions;
    }

    @ApiModelProperty(value =
        "If the material number is the criterion, a specification of the successor material by the material number (the UUID of the ERP context is not required because the material number is unique in the context of a workplace group)." +
        "\n" +
        "If a material characteristic is the criterion: A condition relating to the characteristics of the material that is produced at the workplace after the setup transition (e.g. color==white;width=gt=40)", required = true, position = 6)
    public void setSuccessorConditions(String successorConditions) {
        mSuccessorConditions = successorConditions;
    }

    public Long getSetupTimeIncrement() {
        return mSetupTimeIncrement;
    }

    @ApiModelProperty(value = "The increase of the setup time in msec if predecessor and successor meet the conditions with respect to the criterion (not to be specified for the criterion MATERIAL_NUMBER)", position = 7)
    public void setSetupTimeIncrement(Long setupTimeIncrement) {
        mSetupTimeIncrement = setupTimeIncrement;
    }

    public Long getSetupTime() {
        return mSetupTime;
    }

    @ApiModelProperty(value = "The absolute setup time for the transition from the specified predecessor material to the specified successor material (only to be specified for the criterion MATERIAL_NUMBER)", position = 8)
    public void setSetupTime(Long setupTime) {
        mSetupTime = setupTime;
    }
}