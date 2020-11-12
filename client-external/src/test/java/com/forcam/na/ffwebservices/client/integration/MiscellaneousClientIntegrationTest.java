////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 11.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextRequest;
import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextsRequest;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralRequest;
import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralsRequest;
import com.forcam.na.ffwebservices.client.api.miscellaneous.MiscellaneousClient;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.entrypoint.EntryPointResponse;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextResponse;
import com.forcam.na.ffwebservices.model.literal.LiteralResponse;
import com.forcam.na.common.webserviceaccess.requestparams.RequestParams;
import org.junit.*;

import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link MiscellaneousClient}.
 */
public class MiscellaneousClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public MiscellaneousClientIntegrationTest() {
        final Pattern erpContextsPattern = Pattern.compile(PREFIX_GET_PATH + "/erpContexts\\?.*limit=3.*");
        mFileNames.put(erpContextsPattern, "json/getErpContexts.json");

        final Pattern erpContextPattern = Pattern.compile(PREFIX_GET_PATH + "/erpContexts/.{32}");
        mFileNames.put(erpContextPattern, "json/getErpContext.json");

        final Pattern literalsPattern = Pattern.compile(PREFIX_GET_PATH + "/literals\\?.*limit=3.*");
        mFileNames.put(literalsPattern, "json/getLiterals.json");

        final Pattern literalPattern = Pattern.compile(PREFIX_GET_PATH + "/literals/.{32}");
        mFileNames.put(literalPattern, "json/getLiteral.json");

        final Pattern entryPointPattern = Pattern.compile(PREFIX_GET_PATH + "/?");
        mFileNames.put(entryPointPattern, "json/getEntryPoint.json");
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link MiscellaneousClient#getErpContexts(GetErpContextsRequest)}.
     *
     * @throws ForceAPIException When unable to get ERP contexts.
     */
    @Test
    public void testGetErpContexts() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetErpContextsRequest request = new GetErpContextsRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<ErpContextResponse> erpContextCollection = mMiscellaneousClient.getErpContexts(request);

        Assert.assertNotNull(erpContextCollection);
        Assert.assertFalse(erpContextCollection
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MiscellaneousClient#getErpContext(GetErpContextRequest)}.
     *
     * @throws ForceAPIException When unable to get ERP context.
     */
    @Test
    public void testGetErpContext() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetErpContextsRequest erpContextsRequest = new GetErpContextsRequest();
        erpContextsRequest.setLimit(1);
        final Page<ErpContextResponse> erpContextCollection = mMiscellaneousClient.getErpContexts(erpContextsRequest);

        Assert.assertNotNull(erpContextCollection);
        Assert.assertFalse(erpContextCollection
                               .getElements()
                               .isEmpty());

        final ErpContextResponse erpContext = erpContextCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(erpContext);
        Assert.assertNotNull(erpContext.getProperties());

        final String erpContextId = erpContext
            .getProperties()
            .getId();

        final GetErpContextRequest erpContextRequest = new GetErpContextRequest(erpContextId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ErpContextResponse erpContextModel = mMiscellaneousClient.getErpContext(erpContextRequest);

        Assert.assertNotNull(erpContextModel);
        Assert.assertNotNull(erpContextModel.getProperties());
    }

    /**
     * Test for the method {@link MiscellaneousClient#getLiterals(GetLiteralsRequest)}.
     *
     * @throws ForceAPIException When unable to get literals.
     */
    @Test
    public void testGetLiterals() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetLiteralsRequest request = new GetLiteralsRequest();
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<LiteralResponse> literalCollection = mMiscellaneousClient.getLiterals(request);

        Assert.assertNotNull(literalCollection);
        Assert.assertFalse(literalCollection
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link MiscellaneousClient#getLiteral(GetLiteralRequest)}.
     *
     * @throws ForceAPIException When unable to get literal.
     */
    @Test
    public void testGetLiteral() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetLiteralsRequest literalsRequest = new GetLiteralsRequest();
        literalsRequest.setLimit(1);
        final Page<LiteralResponse> literalCollection = mMiscellaneousClient.getLiterals(literalsRequest);

        Assert.assertNotNull(literalCollection);
        Assert.assertFalse(literalCollection
                               .getElements()
                               .isEmpty());

        final LiteralResponse literal = literalCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(literal);
        Assert.assertNotNull(literal.getProperties());

        final String literalId = literal
            .getProperties()
            .getId();

        final GetLiteralRequest literalRequest = new GetLiteralRequest(literalId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final LiteralResponse literalModel = mMiscellaneousClient.getLiteral(literalRequest);

        Assert.assertNotNull(literalModel);
        Assert.assertNotNull(literalModel.getProperties());
    }

    /**
     * Test for the method {@link MiscellaneousClient#getEntryPoint(RequestParams)}.
     *
     * @throws ForceAPIException When unable to get entry point.
     */
    @Test
    public void testGetEntryPoint() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final RequestParams request = new RequestParams();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final EntryPointResponse entryPointModel = mMiscellaneousClient.getEntryPoint(request);

        Assert.assertNotNull(entryPointModel);
        Assert.assertNotNull(entryPointModel.getProperties());
    }
}