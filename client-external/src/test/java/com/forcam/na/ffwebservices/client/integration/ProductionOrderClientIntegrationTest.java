////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.request.SetOperationPhaseRequest;
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
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderResponse;
import com.forcam.na.ffwebservices.model.order.ProductionOrderScheduledDatesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSchedulingResultPropertiesWSModel;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link ProductionOrderClient}.
 */
public class ProductionOrderClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

	// ------------------------------------------------------------------------
	// constructors
	// ------------------------------------------------------------------------

	public ProductionOrderClientIntegrationTest() {
		final Pattern productionOrderPattern = Pattern.compile(PREFIX_GET_PATH + "/productionOrders/.{32}\\?.*");
		mFileNames.put(productionOrderPattern, "json/getProductionOrder.json");

		final Pattern productionOrdersPattern = Pattern.compile(PREFIX_GET_PATH + "/productionOrders\\?.*limit=3.*");
		mFileNames.put(productionOrdersPattern, "json/getProductionOrders.json");

		final Pattern searchProductionOrdersPattern = Pattern.compile(PREFIX_POST_PATH + "/productionOrders/search\\?.*limit=3.*");
		mFileNames.put(searchProductionOrdersPattern, "json/searchProductionOrders.json");

		final Pattern operationSequencePattern = Pattern.compile(PREFIX_GET_PATH + "/productionOrders/.{32}/operationSequence\\?.*limit=3.*");
		mFileNames.put(operationSequencePattern, "json/getProductionOrderOperationSequence.json");

		final Pattern productionOrderSchedulingResultPattern = Pattern.compile(
			PREFIX_GET_PATH + "/productionOrders/.{32}/scheduledDates\\?.*limit=3.*");
		mFileNames.put(productionOrderSchedulingResultPattern, "json/getProductionOrderSchedulingResult.json");
	}

	// ------------------------------------------------------------------------
	// methods
	// ------------------------------------------------------------------------

	/**
	 * Test for the method {@link ProductionOrderClient#getProductionOrders(GetProductionOrdersRequest)}.
	 *
	 * @throws ForceAPIException When unable to get production orders.
	 */
	@Test
	public void testGetProductionOrders() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetProductionOrdersRequest request = new GetProductionOrdersRequest();
		request.setLimit(3);
		request.setStartDate(new Date(0));
		request
			.embed()
			.erpContext(true)
			.description(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<ProductionOrderResponse> productionOrderCollectionResponse = mProductionOrderClient.getProductionOrders(request);

		Assert.assertNotNull(productionOrderCollectionResponse);
		Assert.assertFalse(productionOrderCollectionResponse
			.getElements()
			.isEmpty());
	}

	/**
	 * Test for the method {@link ProductionOrderClient#searchProductionOrders(SearchProductionOrderRequest)}.
	 *
	 * @throws ForceAPIException When unable to search production orders.
	 */
	@Test
	public void testSearchProductionOrders() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final SearchProductionOrderRequest request = new SearchProductionOrderRequest();
		request.setLimit(3);
		request
			.embed()
			.erpContext(true)
			.description(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final Page<ProductionOrderResponse> productionOrderCollectionResponse = mProductionOrderClient.searchProductionOrders(request);

		Assert.assertNotNull(productionOrderCollectionResponse);
		Assert.assertFalse(productionOrderCollectionResponse
			.getElements()
			.isEmpty());
		Assert.assertEquals(request.getLimit(),
			productionOrderCollectionResponse
				.getResponse()
				.getPagination()
				.getLimit());
	}

	/**
	 * Test for the method {@link ProductionOrderClient#getProductionOrder(GetProductionOrderRequest)}.
	 *
	 * @throws ForceAPIException When unable to get production order.
	 */
	@Test
	public void testGetProductionOrder() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetProductionOrderRequest productionOrderRequest = new GetProductionOrderRequest(this.getProductionOrderId());
		productionOrderRequest
			.embed()
			.erpContext(true)
			.description(true)
			.operations(true);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		final ProductionOrderResponse productionOrderModel = mProductionOrderClient.getProductionOrder(productionOrderRequest);

		Assert.assertNotNull(productionOrderModel);
		Assert.assertNotNull(productionOrderModel.getProperties());
		Assert.assertEquals(productionOrderRequest.getId(),
			productionOrderModel
				.getProperties()
				.getId());
	}

	/**
	 * Test for the method {@link ProductionOrderClient#getProductionOrderOperationSequence(GetOperationSequenceRequest)}.
	 *
	 * @throws ForceAPIException When unable to get operations of production order.
	 */
	@Test
	public void testGetOperationSequence() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetOperationSequenceRequest request = new GetOperationSequenceRequest(this.getProductionOrderId());
		request.setLimit(3);

		final ProductionOrderOperationSequenceCollectionPage page = mProductionOrderClient.getProductionOrderOperationSequence(request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

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
			.getElements());
	}

	/**
	 * Test for the method {@link ProductionOrderClient#getProductionOrderSchedulingResults(GetProductionOrderSchedulingResultsRequest)}.
	 *
	 * @throws ForceAPIException When unable to get scheduling result of production order.
	 */
	@Test
	public void testGetProductionOrderSchedulingResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final GetProductionOrderSchedulingResultsRequest request = new GetProductionOrderSchedulingResultsRequest(this.getProductionOrderId());
		request.setLimit(3);

		final ProductionOrderSchedulingResultCollectionPage page = mProductionOrderClient.getProductionOrderSchedulingResults(request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

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
			.getElements());
	}

	/**
	 * Test for the method {@link ProductionOrderClient#setProductionOrderSchedulingResults(SetProductionOrderSchedulingResultRequest)}.
	 *
	 * @throws ForceAPIException When unable to set scheduling result of production order.
	 */
	@Test
	public void testSetProductionOrderSchedulingResult() throws ForceAPIException {

		// ----------------------------------------------------------------------
		// test fixture
		// ----------------------------------------------------------------------

		final Date scheduledStartDateProductionOrder = new Date(1000000);
		final Date scheduledEndDateProductionOrder = new Date(8000000);
		final Date scheduledStartDate = new Date(1050000);
		final Date scheduledEndDate = new Date(3000000);
		final Date earliestStartDate = new Date(1000000);
		final Date earliestEndDate = new Date(2500000);
		final Date latestStartDate = new Date(1500000);
		final Date latestEndDate = new Date(3500000);

		final GetProductionOrderSchedulingResultsRequest getSchedulingResultsRequest = new GetProductionOrderSchedulingResultsRequest(
			this.getProductionOrderId());
		getSchedulingResultsRequest.setLimit(1);
		final ProductionOrderSchedulingResultCollectionPage schedulingResults = mProductionOrderClient.getProductionOrderSchedulingResults(
			getSchedulingResultsRequest);
		Assert.assertNotNull(schedulingResults
			.getResponse()
			.getProperties()
			.getElements()
			.get(0));

		final String operationId = schedulingResults
			.getResponse()
			.getProperties()
			.getElements()
			.get(0)
			.getOperationId();

		final SetOperationPhaseRequest operationPhaseRequest = new SetOperationPhaseRequest(operationId, OperationPhase.RELEASED);
		mOperationClient.setOperationPhase(operationPhaseRequest);

		final SetProductionOrderSchedulingResultRequest request = new SetProductionOrderSchedulingResultRequest(this.getProductionOrderId());
		final ProductionOrderSchedulingResultPropertiesWSModel propertiesWSModel = new ProductionOrderSchedulingResultPropertiesWSModel();
		propertiesWSModel.setScheduledEndDate(scheduledEndDateProductionOrder);
		propertiesWSModel.setScheduledStartDate(scheduledStartDateProductionOrder);

		final OperationScheduledDatesPropertiesWSModel operationScheduledDatesPropertiesWSModel = new OperationScheduledDatesPropertiesWSModel();
		operationScheduledDatesPropertiesWSModel.setScheduledStartDate(scheduledStartDate);
		operationScheduledDatesPropertiesWSModel.setScheduledEndDate(scheduledEndDate);
		operationScheduledDatesPropertiesWSModel.setLatestStartDate(latestStartDate);
		operationScheduledDatesPropertiesWSModel.setLatestEndDate(latestEndDate);
		operationScheduledDatesPropertiesWSModel.setEarliestStartDate(earliestStartDate);
		operationScheduledDatesPropertiesWSModel.setEarliestEndDate(earliestEndDate);

		final ProductionOrderScheduledDatesWSModel scheduledDatesWSModel = new ProductionOrderScheduledDatesWSModel();
		scheduledDatesWSModel.setOperationId(operationId);
		scheduledDatesWSModel.setScheduledDates(operationScheduledDatesPropertiesWSModel);

		final List<ProductionOrderScheduledDatesWSModel> scheduledDates = new ArrayList<>();
		scheduledDates.add(scheduledDatesWSModel);

		propertiesWSModel.setElements(scheduledDates);
		request.setSchedulingResult(propertiesWSModel);

		final ProductionOrderSchedulingResultCollectionPage page = mProductionOrderClient.setProductionOrderSchedulingResults(request);

		// ----------------------------------------------------------------------
		// test
		// ----------------------------------------------------------------------

		Optional<ProductionOrderScheduledDatesWSModel> firstProductionOrderScheduledDatesWSModel = page.getElements()
																									   .stream()
																									   .filter(element -> element.getOperationId()
																																 .equals(operationId))
																									   .findFirst();
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
			.get(0));

		Assert.assertTrue(firstProductionOrderScheduledDatesWSModel.isPresent());
		final OperationScheduledDatesPropertiesWSModel operationScheduledDates =
			firstProductionOrderScheduledDatesWSModel.get()
													 .getScheduledDates();

		Assert.assertEquals(scheduledStartDateProductionOrder,
			page
				.getResponse()
				.getProperties()
				.getScheduledStartDate());
		Assert.assertEquals(scheduledEndDateProductionOrder,
			page
				.getResponse()
				.getProperties()
				.getScheduledEndDate());
		Assert.assertEquals(earliestStartDate, operationScheduledDates.getEarliestStartDate());
		Assert.assertEquals(earliestEndDate, operationScheduledDates.getEarliestEndDate());
		Assert.assertEquals(latestStartDate, operationScheduledDates.getLatestStartDate());
		Assert.assertEquals(latestEndDate, operationScheduledDates.getLatestEndDate());
		Assert.assertEquals(scheduledStartDate, operationScheduledDates.getScheduledStartDate());
		Assert.assertEquals(scheduledEndDate, operationScheduledDates.getScheduledEndDate());
	}

	/**
	 * Gets production order ID.
	 *
	 * @return The production order ID.
	 */
	private String getProductionOrderId() throws ForceAPIException {
		final GetProductionOrdersRequest productionOrdersRequest = new GetProductionOrdersRequest();
		productionOrdersRequest.setLimit(1);
		productionOrdersRequest.setStartDate(new Date(0));
		final Page<ProductionOrderResponse> productionOrderCollection = mProductionOrderClient.getProductionOrders(productionOrdersRequest);
		Assert.assertNotNull(productionOrderCollection);
		Assert.assertFalse(productionOrderCollection
			.getElements()
			.isEmpty());

		final ProductionOrderResponse productionOrder = productionOrderCollection
			.getElements()
			.get(0);
		Assert.assertNotNull(productionOrder.getProperties());

		return productionOrder
			.getProperties()
			.getId();
	}
}