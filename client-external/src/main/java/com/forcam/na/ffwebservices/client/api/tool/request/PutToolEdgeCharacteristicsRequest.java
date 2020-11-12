////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 04.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.ffwebservices.model.tool.CharacteristicGeneralDefinition;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * The request object for putting tool cut edge characteristics.
 */
public class PutToolEdgeCharacteristicsRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    /** A cut edge ID. */
    private String mEdgeId;

    /** A list of characteristics. */
    private List<CharacteristicGeneralDefinition> mCharacteristics;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link PutToolEdgeCharacteristicsRequest} object with a tool ID, a cut edge ID and characteristics.
     *
     * @param toolId          The tool ID.
     * @param edgeId          The cut edge ID.
     * @param characteristics The characteristics.
     */
    public PutToolEdgeCharacteristicsRequest(String toolId, String edgeId, List<CharacteristicGeneralDefinition> characteristics) {
        mToolId = toolId;
        mEdgeId = edgeId;
        mCharacteristics = characteristics;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolId", mToolId)
            .append("edgeId", mEdgeId)
            .append("characteristics", mCharacteristics)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getToolId() {
        return mToolId;
    }

    public void setToolId(String toolId) {
        mToolId = toolId;
    }

    public String getEdgeId() {
        return mEdgeId;
    }

    public void setEdgeId(String edgeId) {
        mEdgeId = edgeId;
    }

    public List<CharacteristicGeneralDefinition> getCharacteristics() {
        return mCharacteristics;
    }

    public void setCharacteristics(List<CharacteristicGeneralDefinition> characteristics) {
        mCharacteristics = characteristics;
    }
}