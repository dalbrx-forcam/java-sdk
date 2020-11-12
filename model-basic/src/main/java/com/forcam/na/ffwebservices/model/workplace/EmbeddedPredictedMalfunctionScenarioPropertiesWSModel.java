////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 25.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplace;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Properties of embedded predicted malfunction scenario.
 */
@XmlRootElement(name = "embeddedPredictedMalfunctionScenarioProperties")
@ApiModel(value = "embeddedPredictedMalfunctionScenarioProperties")
@JsonPropertyOrder({ "id", "creator", "creationDate", "startDate", "endDate" })
public class EmbeddedPredictedMalfunctionScenarioPropertiesWSModel extends CreatePredictedMalfunctionScenarioPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The predicted malfunction scenario ID. */
    private String mId;

    /** The creation date. */
    private Date mCreationDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the malfunction scenario ID.
     *
     * @return The malfunction scenario ID.
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the malfunction scenario ID.
     *
     * @param id The malfunction scenario ID.
     */
    @ApiModelProperty(value = "UUID of the malfunction scenario", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    /**
     * Provides the creation date.
     *
     * @return The creation date.
     */
    public Date getCreationDate() {
        return mCreationDate;
    }

    /**
     * Sets the creation date.
     *
     * @param creationDate The creation date.
     */
    @ApiModelProperty(value = "The point in time at which the malfunction scenario was created", position = 2)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }
}