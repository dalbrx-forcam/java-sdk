////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 11.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.miscellaneous;

import com.forcam.na.common.webserviceaccess.requestparams.RequestParams;
import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextRequest;
import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextsRequest;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralRequest;
import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralsRequest;
import com.forcam.na.ffwebservices.client.api.material.request.GetMaterialRequest;
import com.forcam.na.ffwebservices.client.api.material.request.GetMaterialsRequest;
import com.forcam.na.ffwebservices.client.api.material.response.MaterialResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.entrypoint.EntryPointResponse;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextResponse;
import com.forcam.na.ffwebservices.model.literal.LiteralResponse;

/**
 * An interface with methods that request miscellaneous.
 */
public interface IMiscellaneousClient {

    /**
     * Sends a request to the server and gets a collection of ERP contexts as response.
     *
     * @param request A collection of parameters.
     * @return The ERP context collection response.
     * @throws ForceAPIException When unable to get ERP contexts.
     */
    Page<ErpContextResponse> getErpContexts(GetErpContextsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets an ERP context model as response.
     *
     * @param request A collection of parameters.
     * @return An ERP context model.
     * @throws ForceAPIException When unable to get ERP context.
     */
    ErpContextResponse getErpContext(GetErpContextRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of literals as response.
     *
     * @param request A collection of parameters.
     * @return The literal collection response.
     * @throws ForceAPIException When unable to get literals.
     */
    Page<LiteralResponse> getLiterals(GetLiteralsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a literal model as response.
     *
     * @param request A collection of parameters.
     * @return A literal model.
     * @throws ForceAPIException When unable to get literal.
     */
    LiteralResponse getLiteral(GetLiteralRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets an entry point model as response.
     *
     * @param request A collection of parameters.
     * @return An entry point model.
     * @throws ForceAPIException When unable to get entry point.
     */
    EntryPointResponse getEntryPoint(RequestParams request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of materials as response.
     *
     * @param request A collection of parameters.
     * @return The material collection response.
     * @throws ForceAPIException When unable to get materials.
     */
    Page<MaterialResponse> getMaterials(GetMaterialsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a literal model as response.
     *
     * @param request A collection of parameters.
     * @return A material model.
     * @throws ForceAPIException When unable to get material.
     */
    MaterialResponse getMaterial(GetMaterialRequest request) throws ForceAPIException;
}