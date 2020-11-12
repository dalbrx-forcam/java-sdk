////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.productionorder;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.order.IProductionOrderClient;
import com.forcam.na.ffwebservices.client.api.order.ProductionOrderClient;
import com.forcam.na.ffwebservices.client.api.order.request.GetOperationSequenceRequest;
import com.forcam.na.ffwebservices.client.api.order.request.GetProductionOrderRequest;
import com.forcam.na.ffwebservices.client.api.order.request.GetProductionOrderSchedulingResultsRequest;
import com.forcam.na.ffwebservices.client.api.order.request.GetProductionOrdersRequest;
import com.forcam.na.ffwebservices.client.api.order.request.SearchProductionOrderRequest;
import com.forcam.na.ffwebservices.client.api.order.request.SetProductionOrderSchedulingResultRequest;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderOperationSequenceCollectionPage;
import com.forcam.na.ffwebservices.client.api.order.response.ProductionOrderSchedulingResultCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderEmbed;
import com.forcam.na.ffwebservices.model.order.ProductionOrderResponse;
import com.forcam.na.ffwebservices.model.order.ProductionOrderScheduledDatesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSchedulingResultPropertiesWSModel;
import io.swagger.models.HttpMethod;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Tests for the class {@link ProductionOrderClient}.
 */
@RunWith(GuiceTestRunner.class)
public class ProductionOrderClientTest extends AbstractOpenAPIMockTest {

	// ------------------------------------------------------------------------
	// members
	// ------------------------------------------------------------------------

	/** Helper for test exceptions and messages. */
	@Rule
	public ExpectedException mExpectedException = ExpectedException.none();

	/** The production order client. */
	private IProductionOrderClient mProductionOrderClient;

	// ------------------------------------------------------------------------
	// constructor
	// ------------------------------------------------------------------------

	public ProductionOrderClientTest() {
		mProductionOrderClient = mBridgeAPIComponent.productionOrderClient();
	}

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link ProductionOrderClient#getProductionOrders(GetProductionOrdersRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get production orders.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetProductionOrders() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getProductionOrders.json")));
		final int limit = 3;
		final GetProductionOrdersRequest request = new GetProductionOrdersRequest();
		request.setLimit(limit);
		request
			.embed()
			.erpContext(true)
			.description(true);

		final Page<ProductionOrderResponse> response = mProductionOrderClient.getProductionOrders(request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		//Verify request
		this.verifyBasicCollectionParameters(limit, request.embed(), response);
	}

	/**
	 * Test for the method {@link ProductionOrderClient#searchProductionOrders(SearchProductionOrderRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get production orders.
	 * @throws InterruptedException When unable to take the requestfrom the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testSearchProductionOrders() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/searchProductionOrders.json")));
		final int limit = 3;
		final SearchProductionOrderRequest request = new SearchProductionOrderRequest();
		request.setLimit(limit);
		request
			.embed()
			.erpContext(true)
			.description(true);

		final Page<ProductionOrderResponse> response = mProductionOrderClient.searchProductionOrders(request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		//Verify request
		this.verifyBasicCollectionParameters(limit, request.embed(), response);

		Assert.assertEquals(HttpMethod.POST.name(),
			response
				.getResponse()
				.getPaginationLinks()
				.getFirst()
				.getMethod()
				.name());

		Assert.assertEquals(HttpMethod.POST.name(),
			response
				.getResponse()
				.getPaginationLinks()
				.getSelf()
				.getMethod()
				.name());

		Assert.assertEquals(HttpMethod.POST.name(),
			response
				.getResponse()
				.getPaginationLinks()
				.getLast()
				.getMethod()
				.name());

	}

	/**
	 * Test for the method {@link ProductionOrderClient#getProductionOrder(GetProductionOrderRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get production order.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetProductionOrder() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getProductionOrder.json")));
		final GetProductionOrderRequest request = new GetProductionOrderRequest("TESTID");
		request
			.embed()
			.specification(true)
			.operationSequence(true);
		final ProductionOrderResponse response = mProductionOrderClient.getProductionOrder(request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		//Verify request
		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);

		//Verify response model
		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getSelf());
		Assert.assertNotNull(response.getDescription());
		Assert.assertNotNull(response
			.getDescription()
			.getLink());
		Assert.assertNotNull(response.getErpContext());
		Assert.assertNotNull(response
			.getErpContext()
			.getLink());
		Assert.assertNotNull(response
			.getErpContext()
			.getEmbedded());
		Assert.assertNotNull(response
			.getProductionOrderSpecification()
			.getLink());
		Assert.assertNotNull(response
			.getProductionOrderOperationSequence()
			.getLink());
		Assert.assertNotNull(response.getProperties());
		Assert.assertNotNull(response
			.getProperties()
			.getId());
	}

	/**
	 * Tests getting production orders while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get production orders.
	 */
	@Test
	public void getProductionOrdersShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetProductionOrdersRequest request = new GetProductionOrdersRequest();
		this.shutdownServerAndMockExpectations(request.toString());

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mProductionOrderClient.getProductionOrders(request);
	}

	/**
	 * Tests getting searched production orders while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get production orders.
	 */
	@Test
	public void testSearchProductionOrdersShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final SearchProductionOrderRequest request = new SearchProductionOrderRequest();
		this.shutdownServerAndMockExpectations(request.toString());

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mProductionOrderClient.searchProductionOrders(request);
	}

	/**
	 * Tests getting production order while server is down.
	 *
	 * @throws IOException       When unable to shutdown the server.
	 * @throws ForceAPIException When unable to get production order.
	 */
	@Test
	public void getProductionOrderShutdown() throws IOException, ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetProductionOrderRequest request = new GetProductionOrderRequest("productionOrderId");
		this.shutdownServerAndMockExpectations(request.toString());

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		mProductionOrderClient.getProductionOrder(request);
	}

	/**
	 * Test for the method {@link ProductionOrderClient#getProductionOrderOperationSequence(GetOperationSequenceRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get operations of production order.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetOperationSequence() throws IOException, ForceAPIException, URISyntaxException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getProductionOrderOperationSequence.json")));
		final GetOperationSequenceRequest request = new GetOperationSequenceRequest("ProductionOrderId");
		request.setLimit(3);

		final ProductionOrderOperationSequenceCollectionPage page = mProductionOrderClient.getProductionOrderOperationSequence(request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		//Verify request
		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=3"));
		Assert.assertTrue(requestQuery.contains("offset=0"));

		//Verify response model
		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getPagination());
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getOperation());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getSuccessors());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getPredecessors());
	}

	/**
	 * Shutdown mocked server and mock the expected exception and message.
	 *
	 * @param request String representation of the request for expected message.
	 * @throws IOException When unable to shutdown the server.
	 */
	private void shutdownServerAndMockExpectations(String request) throws IOException {
		mMockWebServer.shutdown();
		mExpectedException.expect(ForceAPIException.class);
		mExpectedException.expectMessage("Unable to execute call using request: " + request);
	}

	/**
	 * Verify the basic conditions of the returned production orders collection.
	 *
	 * @param limit Limit on returned resources.
	 * @param embed Embed parameters.
	 * @param page  Collection response generated from the server.
	 * @throws InterruptedException When unable to take the request from the server.
	 */
	private void verifyBasicCollectionParameters(int limit, ProductionOrderEmbed embed, Page page) throws InterruptedException {
		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("embed=" + embed.toString()));
		Assert.assertTrue(requestQuery.contains("limit=" + limit));

		//Verify response model
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
	 * Test for the method {@link ProductionOrderClient#getProductionOrderSchedulingResults(GetProductionOrderSchedulingResultsRequest)}.
	 *
	 * @throws ForceAPIException    When unable to get scheduling result of production order.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testGetProductionOrderSchedulingResult() throws IOException, ForceAPIException, URISyntaxException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getProductionOrderSchedulingResult.json")));
		final GetProductionOrderSchedulingResultsRequest request = new GetProductionOrderSchedulingResultsRequest("ProductionOrderId");
		request.setLimit(3);

		final ProductionOrderSchedulingResultCollectionPage page = mProductionOrderClient.getProductionOrderSchedulingResults(request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		//Verify request
		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestQuery = recordedRequest
			.getRequestUrl()
			.query();
		Assert.assertNotNull(requestQuery);
		Assert.assertTrue(requestQuery.contains("limit=3"));
		Assert.assertTrue(requestQuery.contains("offset=0"));

		//Verify response model
		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getPagination());
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getOperationId());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getScheduledDates());
	}

	/**
	 * Test for the method {@link ProductionOrderClient#setProductionOrderSchedulingResults(SetProductionOrderSchedulingResultRequest)}.
	 *
	 * @throws ForceAPIException    When unable to set scheduling result of production order.
	 * @throws InterruptedException When unable to take the request from the server.
	 * @throws IOException          When unable to read the JSON file.
	 * @throws URISyntaxException   When unable to create a URI of the JSON file.
	 */
	@Test
	public void testSetProductionOrderSchedulingResult() throws IOException, ForceAPIException, URISyntaxException, InterruptedException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getProductionOrderSchedulingResult.json")));
		final SetProductionOrderSchedulingResultRequest request = new SetProductionOrderSchedulingResultRequest("ProductionOrderId");
		final ProductionOrderSchedulingResultPropertiesWSModel propertiesWSModel = new ProductionOrderSchedulingResultPropertiesWSModel();
		propertiesWSModel.setScheduledEndDate(new Date());
		propertiesWSModel.setScheduledStartDate(new Date());

		final OperationScheduledDatesPropertiesWSModel operationScheduledDatesPropertiesWSModel = new OperationScheduledDatesPropertiesWSModel();
		operationScheduledDatesPropertiesWSModel.setScheduledStartDate(new Date());
		operationScheduledDatesPropertiesWSModel.setScheduledEndDate(new Date());
		operationScheduledDatesPropertiesWSModel.setLatestStartDate(new Date());
		operationScheduledDatesPropertiesWSModel.setLatestEndDate(new Date());
		operationScheduledDatesPropertiesWSModel.setEarliestStartDate(new Date());
		operationScheduledDatesPropertiesWSModel.setEarliestEndDate(new Date());
		final ProductionOrderScheduledDatesWSModel scheduledDatesWSModel = new ProductionOrderScheduledDatesWSModel();
		scheduledDatesWSModel.setOperationId("OperationId");
		scheduledDatesWSModel.setScheduledDates(operationScheduledDatesPropertiesWSModel);

		final List<ProductionOrderScheduledDatesWSModel> scheduledDates = new ArrayList<>();
		scheduledDates.add(scheduledDatesWSModel);

		propertiesWSModel.setElements(scheduledDates);
		request.setSchedulingResult(propertiesWSModel);

		final ProductionOrderSchedulingResultCollectionPage page = mProductionOrderClient.setProductionOrderSchedulingResults(request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		//Verify request
		final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
		final String requestBody = recordedRequest
			.getBody()
			.readUtf8();
		Assert.assertNotNull(requestBody);

		//Verify response model
		Assert.assertNotNull(page);
		Assert.assertNotNull(page
			.getResponse()
			.getPagination());
		Assert.assertNotNull(page
			.getResponse()
			.getPaginationLinks());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getOperationId());
		Assert.assertNotNull(page
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getScheduledDates());
	}
}
