////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 05.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.erp;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;

/**
 * Provides methods for the ERP API.
 */
public interface IERPClient {
    void createERPOrder(String xml) throws ForceAPIException;

    void createERPStaffMembers(String xml) throws ForceAPIException;
}
