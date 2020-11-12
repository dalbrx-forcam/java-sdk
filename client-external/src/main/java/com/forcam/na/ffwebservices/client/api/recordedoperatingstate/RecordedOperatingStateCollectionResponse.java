////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.recordedoperatingstate;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.OperatingStateRecordCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.OperatingStateRecordWSModel;

import java.util.List;

/**
 * Can contain a collection of recorded operating states.
 */
public class RecordedOperatingStateCollectionResponse extends AbstractCollectionResponse<OperatingStateRecordWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private OperatingStateRecordCollectionPropertiesWSModel mProperties = new OperatingStateRecordCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    RecordedOperatingStateCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public void setProperties(OperatingStateRecordCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    public OperatingStateRecordCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    @Override
    public List<OperatingStateRecordWSModel> getElements() {
        return mProperties.getElements();
    }
}