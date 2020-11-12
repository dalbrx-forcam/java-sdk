////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.ffwebservices.client.api.tool.request.GetToolCharacteristicsRequest;
import com.forcam.na.ffwebservices.model.tool.CharacteristicGeneralDefinition;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * The request object for putting tool characteristics.
 */
public class PutToolCharacteristicsRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    /** A list of characteristics. */
    private List<CharacteristicGeneralDefinition> mCharacteristics;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetToolCharacteristicsRequest} object with a tool ID and characteristics.
     *
     * @param toolId          The tool ID.
     * @param characteristics The characteristics.
     */
    public PutToolCharacteristicsRequest(String toolId, List<CharacteristicGeneralDefinition> characteristics) {
        mToolId = toolId;
        mCharacteristics = characteristics;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolId", mToolId)
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

    public List<CharacteristicGeneralDefinition> getCharacteristics() {
        return mCharacteristics;
    }

    public void setCharacteristics(List<CharacteristicGeneralDefinition> characteristics) {
        mCharacteristics = characteristics;
    }
}