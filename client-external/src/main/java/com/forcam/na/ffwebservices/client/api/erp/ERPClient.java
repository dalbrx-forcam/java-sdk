////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 05.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.erp;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

import javax.inject.Inject;

/**
 * ERP client.
 */
public class ERPClient extends AbstractClient implements IERPClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private ERPEndpoint mERPEndpoint;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public ERPClient(ERPEndpoint erpEndpoint) {
        mERPEndpoint = erpEndpoint;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public void createERPOrder(String xml) throws ForceAPIException {
        final RequestBody body = RequestBody.create(MediaType.get("text/plain"), xml);
        final Call<Void> call = mERPEndpoint.createERPOrder(body);
        this.executeCall(xml, call);
    }

    @Override
    public void createERPStaffMembers(String xml) throws ForceAPIException {
        final RequestBody body = RequestBody.create(MediaType.get("text/plain"), xml);
        final Call<Void> call = mERPEndpoint.createERPStaffMembers(body);
        this.executeCall(xml, call);
    }
}
