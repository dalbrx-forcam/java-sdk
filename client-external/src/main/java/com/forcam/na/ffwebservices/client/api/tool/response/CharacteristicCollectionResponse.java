////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.tool.CharacteristicGeneralDefinition;
import com.forcam.na.ffwebservices.model.tool.ToolCharacteristicCollectionPropertiesWSModel;

import java.util.List;

/**
 * Can contain a collection of characteristics.
 */
public class CharacteristicCollectionResponse extends AbstractCollectionResponse<CharacteristicGeneralDefinition> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The tool characteristic properties. */
    private ToolCharacteristicCollectionPropertiesWSModel mProperties = new ToolCharacteristicCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public CharacteristicCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getter/setter
    // ------------------------------------------------------------------------

    public ToolCharacteristicCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(ToolCharacteristicCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<CharacteristicGeneralDefinition> getElements() {
        return mProperties.getElements();
    }
}