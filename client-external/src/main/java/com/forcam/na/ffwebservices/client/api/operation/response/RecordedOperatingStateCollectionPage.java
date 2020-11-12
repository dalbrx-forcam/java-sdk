////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 13.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.client.api.recordedoperatingstate.RecordedOperatingStateCollectionResponse;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.OperatingStateRecordWSModel;

import java.lang.reflect.Method;

/**
 * Page containing recorded operating states.
 */
public class RecordedOperatingStateCollectionPage extends SpecificPage<OperatingStateRecordWSModel, RecordedOperatingStateCollectionResponse> {

    /**
     * Creates a new instance.
     *
     * @param client       The client.
     * @param clientMethod The client method.
     * @param response     The response.
     */
    public RecordedOperatingStateCollectionPage(Object client, Method clientMethod, RecordedOperatingStateCollectionResponse response) {
        super(client, clientMethod, response);
    }
}
