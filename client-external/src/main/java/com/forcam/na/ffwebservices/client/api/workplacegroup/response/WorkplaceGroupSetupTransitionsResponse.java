////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 28.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplacegroup.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.workplacegroup.SetupMatrixEntryWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.SetupTransitionsPropertiesWSModel;

import java.util.List;

/**
 * Response for the workplace group setup transitions.
 */
public class WorkplaceGroupSetupTransitionsResponse extends AbstractCollectionResponse<SetupMatrixEntryWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The setup transitions properties. */
    private SetupTransitionsPropertiesWSModel mProperties = new SetupTransitionsPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public WorkplaceGroupSetupTransitionsResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the setup transitions properties.
     *
     * @return The setup transitions properties.
     */
    public SetupTransitionsPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the setup transitions properties.
     *
     * @param properties The setup transitions properties.
     */
    public void setProperties(SetupTransitionsPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<SetupMatrixEntryWSModel> getElements() {
        return mProperties.getElements();
    }
}