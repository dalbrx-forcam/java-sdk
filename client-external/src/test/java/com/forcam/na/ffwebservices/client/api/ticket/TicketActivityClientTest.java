////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 29.11.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.AbstractOpenAPIMockTest;
import com.forcam.na.ffwebservices.client.api.config.GuiceTestRunner;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityAttachmentDataRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityRemarkRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRemarkRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRemarksRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.SetTicketActivityStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.UpdateTicketActivityRequest;
import com.forcam.na.ffwebservices.model.pdm.FileData;
import com.forcam.na.ffwebservices.model.ticket.CreateTicketActivityAttachmentPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.CreateTicketActivityRemarkPropertiesWSModel;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityRemarkResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityState;
import com.forcam.na.ffwebservices.model.ticket.WriteTicketActivityPropertiesWSModel;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.*;
import org.junit.rules.*;
import org.junit.runner.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.Date;

/**
 * Tests for the class{@link TicketActivityClient}
 */
@RunWith(GuiceTestRunner.class)
public class TicketActivityClientTest extends AbstractOpenAPIMockTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Helper for test exceptions and messages. */
    @Rule
    public ExpectedException mExpectedException = ExpectedException.none();

    /** The ticket activity client. */
    private ITicketActivityClient mITicketActivityClient;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------
    public TicketActivityClientTest() {mITicketActivityClient = mBridgeAPIComponent.ticketActivityClient();}
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link TicketActivityClient#getTicketActivities(GetTicketActivitiesRequest)}.
     */
    @Test
    public void getTicketActivities() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketActivities.json")));
        final int limit = 3;
        final GetTicketActivitiesRequest request = new GetTicketActivitiesRequest("testId");
        request.setLimit(limit);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketActivityResponse> response = mITicketActivityClient.getTicketActivities(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

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

    @Test
    public void getTicketActivity() throws ForceAPIException, InterruptedException, IOException, URISyntaxException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketActivity.json")));
        final GetTicketActivityRequest request = new GetTicketActivityRequest("activityId", "testId");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TicketActivityResponse response = mITicketActivityClient.getTicketActivity(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertNotNull(response);
    }

    @Test
    public void createTicketActivity() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createTicketActivity.json")));
        final CreateTicketActivityRequest request = new CreateTicketActivityRequest("TESTID", "title", "desc");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityResponse response = mITicketActivityClient.createTicketActivity(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final WriteTicketActivityPropertiesWSModel requestModel = mMapper.readValue(body, WriteTicketActivityPropertiesWSModel.class);
        Assert.assertEquals(request
                                .getTicketActivityData()
                                .getDescription(), requestModel.getDescription());
    }

    @Test
    public void updateTicketActivity() throws IOException, URISyntaxException, ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketActivity.json")));
        final UpdateTicketActivityRequest request = new UpdateTicketActivityRequest("activityId",
                                                                                    "testId",
                                                                                    "title",
                                                                                    "description",
                                                                                    TicketActivityState.NEW,
                                                                                    Date.from(Instant.now()));

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityResponse response = mITicketActivityClient.updateTicketActivity(request);
        Assert.assertNotNull(response);
    }

    @Test
    public void deleteTicketActivityShutDown() throws IOException, ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketActivityRequest request = new GetTicketActivityRequest("activityId", "testId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mITicketActivityClient.deleteTicketActivity(request);
    }

    @Test
    public void testSetTicketActivityStateShutdown() throws ForceAPIException, IOException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final SetTicketActivityStateRequest request = new SetTicketActivityStateRequest("ticketId", "10", TicketActivityState.IN_PROGRESS);
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mITicketActivityClient.setTicketActivityState(request);
    }

    @Test
    public void getTicketActivityAttachments() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketActivityAttachments.json")));
        final int limit = 3;
        final GetTicketActivityAttachmentsRequest request = new GetTicketActivityAttachmentsRequest("TESTID", "TESTID");
        request.setLimit(limit);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketActivityAttachmentResponse> response = mITicketActivityClient.getTicketActivityAttachments(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

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

    @Test
    public void getTicketActivityAttachment() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketActivityAttachment.json")));
        final GetTicketActivityAttachmentRequest request = new GetTicketActivityAttachmentRequest("TESTID", "TESTID", "TESTATTACHMENTID");
        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityAttachmentResponse response = mITicketActivityClient.getTicketActivityAttachment(request);
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
    }

    @Test
    public void getTicketActivityAttachmentData() throws IOException, ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final GetTicketActivityAttachmentRequest request = new GetTicketActivityAttachmentRequest("TESTID", "TESTID", "TESTATTACHMENTID");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);
        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        mITicketActivityClient.getTicketActivityAttachmentData(request);
    }

    @Test
    public void deleteTicketActivityAttachmentShutDown() throws IOException, ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketActivityAttachmentRequest request = new GetTicketActivityAttachmentRequest("TESTID", "TESTID", "TESTATTACHMENTID");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mITicketActivityClient.deleteTicketActivityAttachment(request);
    }

    @Test
    public void testCreateTicketActivityAttachment() throws ForceAPIException, IOException, URISyntaxException, InterruptedException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createTicketActivityAttachment.json")));
        final CreateTicketActivityAttachmentRequest request = new CreateTicketActivityAttachmentRequest("TESTID", "ACTIVITYID", "desc");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityAttachmentResponse response = mITicketActivityClient.createTicketActivityAttachment(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final CreateTicketActivityAttachmentPropertiesWSModel requestModel = mMapper.readValue(body, CreateTicketActivityAttachmentPropertiesWSModel.class);
        Assert.assertEquals(request
                                .getTicketActivityAttachmentData()
                                .getDescription(), requestModel.getDescription());
    }

    @Test
    public void testCreateTicketActivityAttachmentData() throws ForceAPIException, IOException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final FileData fileData = new FileData("text/plain", File.createTempFile("test", ".txt"));
        final CreateTicketActivityAttachmentDataRequest request = new CreateTicketActivityAttachmentDataRequest("ticketId",
                                                                                                                "activityId",
                                                                                                                "attachmentId",
                                                                                                                fileData,
                                                                                                                "testCreator");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);
        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        mITicketActivityClient.createTicketActivityAttachmentData(request);

    }

    @Test
    public void getTicketActivityRemarks() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketActivityRemarks.json")));
        final int limit = 3;
        final GetTicketActivityRemarksRequest request = new GetTicketActivityRemarksRequest("TESTID", "TESTID");
        request.setLimit(limit);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketActivityRemarkResponse> response = mITicketActivityClient.getTicketActivityRemarks(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);
        Assert.assertTrue(requestQuery.contains("limit=" + limit));

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

    @Test
    public void getTicketActivityRemark() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/getTicketActivityRemark.json")));
        final GetTicketActivityRemarkRequest request = new GetTicketActivityRemarkRequest("TESTID", "TESTID", "TESTREMARID");
        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityRemarkResponse response = mITicketActivityClient.getTicketActivityRemark(request);
        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String requestQuery = recordedRequest
            .getRequestUrl()
            .query();
        Assert.assertNotNull(requestQuery);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSelf());
    }

    @Test
    public void createTicketActivityRemark() throws IOException, URISyntaxException, ForceAPIException, InterruptedException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        mMockWebServer.enqueue(new MockResponse().setBody(this.getJson("json/createTicketActivityRemark.json")));
        final CreateTicketActivityRemarkRequest request = new CreateTicketActivityRemarkRequest("TESTID", "TESTACTIVITYID", "remark");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityRemarkResponse response = mITicketActivityClient.createTicketActivityRemark(request);

        final RecordedRequest recordedRequest = mMockWebServer.takeRequest();
        final String body = recordedRequest
            .getBody()
            .readUtf8();
        final CreateTicketActivityRemarkPropertiesWSModel requestModel = mMapper.readValue(body, CreateTicketActivityRemarkPropertiesWSModel.class);
        Assert.assertEquals(request
                                .getTicketActivityRemarkData()
                                .getRemark(), requestModel.getRemark());
    }

    @Test
    public void deleteTicketActivityRemarkShutDown() throws IOException, ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketActivityRemarkRequest request = new GetTicketActivityRemarkRequest("activityId", "testId", "testRemarkId");
        mMockWebServer.shutdown();
        mExpectedException.expect(ForceAPIException.class);
        mExpectedException.expectMessage("Unable to execute call using request: " + request);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mITicketActivityClient.deleteTicketActivityRemark(request);
    }
}
