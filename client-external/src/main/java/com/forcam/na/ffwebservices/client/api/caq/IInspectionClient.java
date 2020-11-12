////////////////////////////////////////////////////////////////////////////////
//
// Created by DSchulz on 25.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.caq;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;

/**
 * Client for instection handling.
 */
public interface IInspectionClient {

    /**
     * Inspection ready.
     *
     * @param request The request.
     * @throws ForceAPIException The force api exception.
     */
    void inspectionReady(PostInspectionRedyRequest request) throws ForceAPIException;
}
