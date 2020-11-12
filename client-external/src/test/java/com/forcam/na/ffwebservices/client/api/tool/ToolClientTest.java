////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.pagination.PageNotAvailableException;
import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.client.api.tool.request.*;
import com.forcam.na.ffwebservices.client.api.tool.response.CharacteristicCollectionPage;
import com.forcam.na.ffwebservices.client.api.tool.response.CharacteristicCollectionResponse;
import com.forcam.na.ffwebservices.model.tool.CharacteristicGeneralDefinition;
import com.forcam.na.ffwebservices.model.tool.CreateToolEdgePropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.CreateToolLocationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.CreateToolPropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolEdgePropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolEdgeResponse;
import com.forcam.na.ffwebservices.model.tool.ToolLocationResponse;
import com.forcam.na.ffwebservices.model.tool.ToolResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

/**
 * Tests for the class {@link ToolClient}.
 */
@RunWith(GuiceTestRunner.class)
public class ToolClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The tool client. */
    private IToolClient mToolClient;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    public ToolClientTest() {
        mToolClient = mBridgeAPIComponent.toolClient();
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link ToolClient#getTools(GetToolsRequest)}.
     *
     * @throws ForceAPIException    When unable to get tools.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getTools() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTools.json")));
        final int limit = 3;
        final int offset = 0;
        final GetToolsRequest request = new GetToolsRequest();
        request
            .setLimit(limit)
            .setOffset(offset);
        request
            .embed()
            .workplace(true)
            .description(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<ToolResponse> response = mToolClient.getTools(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("embed=" + request
            .embed()
            .toString()));
        Assert.assertTrue(requestQuery.contains("limit=" + limit));
        Assert.assertTrue(requestQuery.contains("offset=" + offset));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
        Assert.assertFalse(response
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link ToolClient#createTool(CreateToolRequest)}.
     *
     * @throws ForceAPIException    When unable to create tool.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void createTool() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createTool.json")));
        final CreateToolRequest request = new CreateToolRequest();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolResponse response = mToolClient.createTool(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final CreateToolPropertiesWSModel requestModel = mMapper.readValue(body, CreateToolPropertiesWSModel.class);
        Assert.assertEquals(request.getToolData(), requestModel);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link ToolClient#getTool(GetToolRequest)}.
     *
     * @throws ForceAPIException    When unable to get tool.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getTool() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTool.json")));
        final GetToolRequest request = new GetToolRequest("TESTID");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolResponse response = mToolClient.getTool(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getWorkplace());
        Assert.assertNotNull(response
                                 .getWorkplace()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link ToolClient#getCharacteristics(GetToolCharacteristicsRequest)}.
     *
     * @throws ForceAPIException    When unable to get characteristics.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getCharacteristics() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getToolCharacteristics.json")));
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getToolCharacteristics.json")));
        final int limit = 3;
        final int offset = 0;
        final GetToolCharacteristicsRequest request = new GetToolCharacteristicsRequest("TESTID");
        request
            .setLimit(limit)
            .setOffset(offset);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final SpecificPage<CharacteristicGeneralDefinition, CharacteristicCollectionResponse> page = mToolClient.getCharacteristics(request);

        try {
            page.getNextPage();
        } catch (PageNotAvailableException e) {
            e.printStackTrace();
        }

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
    }

    /**
     * Test for the method {@link ToolClient#putCharacteristics(PutToolCharacteristicsRequest)}.
     *
     * @throws ForceAPIException    When unable to put characteristics.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void putCharacteristics() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/putToolCharacteristics.json")));
        final PutToolCharacteristicsRequest request = new PutToolCharacteristicsRequest("TESTID", Collections.emptyList());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CharacteristicCollectionPage page = mToolClient.putCharacteristics(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final List<CharacteristicGeneralDefinition> requestModel = mMapper.readValue(body, List.class);
        Assert.assertEquals(request.getCharacteristics(), requestModel);

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
    }

    /**
     * Test for the method {@link ToolClient#getEdges(GetToolEdgesRequest)}.
     *
     * @throws ForceAPIException    When unable to get edges.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getEdges() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getToolEdges.json")));
        final GetToolEdgesRequest request = new GetToolEdgesRequest("TESTID");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<ToolEdgeResponse> response = mToolClient.getEdges(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getFirst());
        Assert.assertNotNull(response
                                 .getResponse()
                                 .getPaginationLinks()
                                 .getSelf());
    }

    /**
     * Test for the method {@link ToolClient#createEdge(CreateToolEdgeRequest)}.
     *
     * @throws ForceAPIException    When unable to create edge.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void createEdge() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createToolEdge.json")));
        final CreateToolEdgeRequest request = new CreateToolEdgeRequest("TESTID", new CreateToolEdgePropertiesWSModel());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolEdgeResponse response = mToolClient.createEdge(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final CreateToolEdgePropertiesWSModel requestModel = mMapper.readValue(body, CreateToolEdgePropertiesWSModel.class);
        Assert.assertEquals(request.getToolEdge(), requestModel);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link ToolClient#getEdge(GetToolEdgeRequest)}.
     *
     * @throws ForceAPIException    When unable to get edge.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getEdge() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getToolEdge.json")));
        final GetToolEdgeRequest request = new GetToolEdgeRequest("TESTID", "TESTID");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolEdgeResponse response = mToolClient.getEdge(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link ToolClient#updateEdge(UpdateToolEdgeRequest)}.
     *
     * @throws ForceAPIException    When unable to update edge.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void updateEdge() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/updateToolEdge.json")));
        final UpdateToolEdgeRequest request = new UpdateToolEdgeRequest("TESTID", "TESTID", new ToolEdgePropertiesWSModel());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolEdgeResponse response = mToolClient.updateEdge(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final ToolEdgePropertiesWSModel requestModel = mMapper.readValue(body, ToolEdgePropertiesWSModel.class);
        Assert.assertEquals(request.getToolEdge(), requestModel);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Test for the method {@link ToolClient#getEdge(GetToolEdgeRequest)}.
     *
     * @throws ForceAPIException    When unable to get edge characteristics.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getEdgeCharacteristics() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getToolEdgeCharacteristics.json")));
        final int limit = 3;
        final int offset = 0;
        final GetToolEdgeCharacteristicsRequest request = new GetToolEdgeCharacteristicsRequest("TESTID", "TESTID");
        request
            .setLimit(limit)
            .setOffset(offset);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CharacteristicCollectionPage page = mToolClient.getEdgeCharacteristics(request);

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
    }

    /**
     * Test for the method {@link ToolClient#putEdgeCharacteristics(PutToolEdgeCharacteristicsRequest)}.
     *
     * @throws ForceAPIException    When unable to put edge characteristics.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void putEdgeCharacteristics() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/putToolEdgeCharacteristics.json")));
        final PutToolEdgeCharacteristicsRequest request = new PutToolEdgeCharacteristicsRequest("TESTID", "TESTID", Collections.emptyList());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CharacteristicCollectionPage page = mToolClient.putEdgeCharacteristics(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final List<CharacteristicGeneralDefinition> requestModel = mMapper.readValue(body, List.class);
        Assert.assertEquals(request.getCharacteristics(), requestModel);

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
    }

    /**
     * Test for the method {@link ToolClient#getLocation(GetToolLocationRequest)}.
     *
     * @throws ForceAPIException    When unable to get location.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void getLocation() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getToolLocation.json")));
        final GetToolLocationRequest request = new GetToolLocationRequest("TESTID");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolLocationResponse response = mToolClient.getLocation(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getTool());
        Assert.assertNotNull(response
                                 .getTool()
                                 .getLink());
        Assert.assertNotNull(response.getWorkplace());
        Assert.assertNotNull(response
                                 .getWorkplace()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
    }

    /**
     * Test for the method {@link ToolClient#putLocation(PutToolLocationRequest)}.
     *
     * @throws ForceAPIException    When unable to put location.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void putLocation() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/putToolLocation.json")));
        final PutToolLocationRequest request = new PutToolLocationRequest("TESTID", new CreateToolLocationPropertiesWSModel());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolLocationResponse response = mToolClient.putLocation(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getTool());
        Assert.assertNotNull(response
                                 .getTool()
                                 .getLink());
        Assert.assertNotNull(response.getWorkplace());
        Assert.assertNotNull(response
                                 .getWorkplace()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
    }

    /**
     * Test for the method {@link ToolClient#deleteLocation(DeleteToolLocationRequest)}.
     *
     * @throws ForceAPIException    When unable to delete location.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void deleteLocation() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse());
        final DeleteToolLocationRequest request = new DeleteToolLocationRequest("TESTID");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.deleteLocation(request);
    }

    /**
     * Test for the method {@link ToolClient#setToolState(SetToolStateRequest)}.
     *
     * @throws ForceAPIException    When unable to set tool state.
     * @throws InterruptedException When unable to take the request from the server.
     * @throws IOException          When unable to read the JSON file.
     * @throws URISyntaxException   When unable to create a URI of the JSON file.
     */
    @Test
    public void setToolState() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/setToolState.json")));
        final SetToolStateRequest request = new SetToolStateRequest("TESTID", "TESTID");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolResponse response = mToolClient.setToolState(request);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
        Assert.assertNotNull(response.getDescription());
        Assert.assertNotNull(response
                                 .getDescription()
                                 .getLink());
        Assert.assertNotNull(response.getWorkplace());
        Assert.assertNotNull(response
                                 .getWorkplace()
                                 .getLink());
        Assert.assertNotNull(response.getProperties());
        Assert.assertNotNull(response
                                 .getProperties()
                                 .getId());
    }

    /**
     * Tests getting tools while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get tools.
     */
    @Test
    public void getToolsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolsRequest request = new GetToolsRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.getTools(request);
    }

    /**
     * Tests creating tool while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to create tool.
     */
    @Test
    public void createToolShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CreateToolRequest request = new CreateToolRequest();
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.createTool(request);
    }

    /**
     * Tests getting tool while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get tool.
     */
    @Test
    public void getToolShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolRequest request = new GetToolRequest("toolId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.getTool(request);
    }

    /**
     * Tests deleting tool while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to delete tool.
     */
    @Test
    public void deleteToolShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final DeleteToolRequest request = new DeleteToolRequest("toolId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.deleteTool(request);
    }

    /**
     * Tests getting tool characteristics while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get characteristics.
     */
    @Test
    public void getCharacteristicsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolCharacteristicsRequest request = new GetToolCharacteristicsRequest("toolId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.getCharacteristics(request);
    }

    /**
     * Tests putting tool characteristics while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to put characteristics.
     */
    @Test
    public void putCharacteristicsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final PutToolCharacteristicsRequest request = new PutToolCharacteristicsRequest("toolId", Collections.emptyList());
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.putCharacteristics(request);
    }

    /**
     * Tests getting tool cut edges while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get edges.
     */
    @Test
    public void getEdgesShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolEdgesRequest request = new GetToolEdgesRequest("toolId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.getEdges(request);
    }

    /**
     * Tests creating tool cut edge while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to create edge.
     */
    @Test
    public void createEdgeShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CreateToolEdgeRequest request = new CreateToolEdgeRequest("toolId", new CreateToolEdgePropertiesWSModel());
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.createEdge(request);
    }

    /**
     * Tests getting tool cut edge while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get edge.
     */
    @Test
    public void getEdgeShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolEdgeRequest request = new GetToolEdgeRequest("toolId", "edgeId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.getEdge(request);
    }

    /**
     * Tests updating tool cut edge while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to update edge.
     */
    @Test
    public void updateEdgeShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final UpdateToolEdgeRequest request = new UpdateToolEdgeRequest("toolId", "edgeId", new ToolEdgePropertiesWSModel());
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.updateEdge(request);
    }

    /**
     * Tests getting tool cut edge characteristics while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get edge characteristics.
     */
    @Test
    public void getEdgeCharacteristicsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolEdgeCharacteristicsRequest request = new GetToolEdgeCharacteristicsRequest("toolId", "edgeId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.getEdgeCharacteristics(request);
    }

    /**
     * Tests putting tool cut edge characteristics while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to put edge characteristics.
     */
    @Test
    public void putEdgeCharacteristicsShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final PutToolEdgeCharacteristicsRequest request = new PutToolEdgeCharacteristicsRequest("toolId", "edgeId", Collections.emptyList());
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.putEdgeCharacteristics(request);
    }

    /**
     * Tests getting tool location while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to get location.
     */
    @Test
    public void getLocationShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolLocationRequest request = new GetToolLocationRequest("toolId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.getLocation(request);
    }

    /**
     * Tests putting tool location while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to put location.
     */
    @Test
    public void putLocationShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final PutToolLocationRequest request = new PutToolLocationRequest("toolId", new CreateToolLocationPropertiesWSModel());
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.putLocation(request);
    }

    /**
     * Tests deleting tool location while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to delete location.
     */
    @Test
    public void deleteLocationShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final DeleteToolLocationRequest request = new DeleteToolLocationRequest("toolId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.deleteLocation(request);
    }

    /**
     * Tests setting tool state while server is down.
     *
     * @throws IOException       When unable to shutdown the server.
     * @throws ForceAPIException When unable to set tool state.
     */
    @Test
    public void setToolStateShutdown() throws IOException, ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final SetToolStateRequest request = new SetToolStateRequest("toolId", "toolStateId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.setToolState(request);
    }
}