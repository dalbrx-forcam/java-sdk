////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.miscellaneous;

import com.forcam.na.common.webserviceaccess.requestparams.RequestParams;
import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextRequest;
import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextsRequest;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIErrorMessageException;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralRequest;
import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.entrypoint.EntryPointResponse;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextResponse;
import com.forcam.na.ffwebservices.model.literal.LiteralResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests for the class {@link MiscellaneousClient}.
 */
@RunWith(GuiceTestRunner.class)
public class MiscellaneousClientTest extends AbstractOpenAPIMockTest {

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------

	/** Helper for test exceptions and messages. */
	@Rule
	public ExpectedException mExpectedException = ExpectedException.none();

	/** The miscellaneous client. */
	private IMiscellaneousClient mMiscellaneousClient;

	// ------------------------------------------------------------------------
	// constructor
	// ------------------------------------------------------------------------

	public MiscellaneousClientTest() {
		mMiscellaneousClient = mBridgeAPIComponent.miscellaneousClient();
	}

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link MiscellaneousClient#getErpContexts(GetErpContextsRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get ERP contexts.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getErpContexts() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getErpContexts.json")));
		final int limit = 3;
		final int offset = 0;
		final GetErpContextsRequest request = new GetErpContextsRequest();
		request
			.setLimit(limit)
			.setOffset(offset);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<ErpContextResponse> page = mMiscellaneousClient.getErpContexts(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));
		Assert.assertTrue(requestQuery.contains("offset=" + offset));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks());
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks()
			.getFirst());
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks()
			.getSelf());
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks()
			.getLast());
		Assert.assertFalse(page
			.getElements()
			.isEmpty());
	}

	/**
	 * Test for the method {@link MiscellaneousClient#getErpContext(GetErpContextRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get ERP context.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getErpContext() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getErpContext.json")));
		final GetErpContextRequest request = new GetErpContextRequest("TESTID");

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final ErpContextResponse response = mMiscellaneousClient.getErpContext(request);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getSelf());
		Assert.assertNotNull(response.getProperties());
		Assert.assertNotNull(response
			.getProperties()
			.getId());
	}

	/**
	 * Test for the method {@link MiscellaneousClient#getLiterals(GetLiteralsRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get literals.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getLiterals() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getLiterals.json")));
		final int limit = 3;
		final int offset = 0;
		final GetLiteralsRequest request = new GetLiteralsRequest();
		request
			.setLimit(limit)
			.setOffset(offset);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<LiteralResponse> page = mMiscellaneousClient.getLiterals(request);

		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=" + limit));
		Assert.assertTrue(requestQuery.contains("offset=" + offset));

		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks());
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks()
			.getFirst());
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks()
			.getSelf());
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks()
			.getLast());
		Assert.assertFalse(page
			.getElements()
			.isEmpty());
	}

	/**
	 * Test for the method {@link MiscellaneousClient#getLiteral(GetLiteralRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get literal.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getLiteral() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getLiteral.json")));
		final GetLiteralRequest request = new GetLiteralRequest("TESTID");

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final LiteralResponse response = mMiscellaneousClient.getLiteral(request);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getSelf());
		Assert.assertNotNull(response.getProperties());
		Assert.assertNotNull(response
			.getProperties()
			.getId());
	}

	/**
	 * Test for the method {@link MiscellaneousClient#getEntryPoint(RequestParams)}.
	 *
	 * @throws ForceAPIException    When unable to get entry point.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void getEntryPoint() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getEntryPoint.json")));
		final RequestParams request = new RequestParams();

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final EntryPointResponse response = mMiscellaneousClient.getEntryPoint(request);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getSelf());
		Assert.assertNotNull(response.getProperties());
		Assert.assertNotNull(response.getDocumentation());
		Assert.assertNotNull(response.getProductionOrders());
		Assert.assertNotNull(response.getOperations());
		Assert.assertNotNull(response.getWorkplaces());
		Assert.assertNotNull(response.getStaffMembers());
		Assert.assertNotNull(response.getTools());
	}

	/**
	 * Tests getting ERP contexts while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get ERP contexts.
	 */
	@Test
	public void getErpContextsShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetErpContextsRequest request = new GetErpContextsRequest();
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mMiscellaneousClient.getErpContexts(request);
	}

	/**
	 * Tests getting ERP context while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get ERP context.
	 */
	@Test
	public void getErpContextShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetErpContextRequest request = new GetErpContextRequest("erpContextId");
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mMiscellaneousClient.getErpContext(request);
	}

	/**
	 * Tests getting literals while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get literals.
	 */
	@Test
	public void getLiteralsShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetLiteralsRequest request = new GetLiteralsRequest();
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mMiscellaneousClient.getLiterals(request);
	}

	/**
	 * Tests getting literal while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get literal.
	 */
	@Test
	public void getLiteralShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetLiteralRequest request = new GetLiteralRequest("literalId");
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mMiscellaneousClient.getLiteral(request);
	}

	/**
	 * Tests getting entry point while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get entry point.
	 */
	@Test
	public void getEntryPointShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final RequestParams request = new RequestParams();
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mMiscellaneousClient.getEntryPoint(request);
	}

	@Test
	public void errorMessage() throws IOException, URISyntaxException {
		mMockWebServer.enqueue(new MockResponse()
			.setResponseCode(500)
			.setBody(this.getJson("json/errorMessage.json")));

		final GetErpContextRequest request = new GetErpContextRequest("TESTID");

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		try {
			final ErpContextResponse response = mMiscellaneousClient.getErpContext(request);
			Assert.fail();
		} catch (ForceAPIException e) {
			final ForceAPIErrorMessageException errorMessageException = (ForceAPIErrorMessageException) e;
			Assert.assertEquals(Integer.valueOf(500), e.getHttpCode().get());
			Assert.assertEquals("123",
				errorMessageException
					.getMessageWSModel()
					.getCode());
		}
	}
}