////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 02.12.19.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityRemarkRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketActivityRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRemarkRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRemarksRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRequest;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityRemarkResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityResponse;
import org.junit.*;

import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link com.forcam.na.ffwebservices.client.api.ticket.TicketActivityClient}.
 */
public class TicketActivityClientIntegrationTest extends AbstractOpenAPIIntegrationTest {
    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------
    public TicketActivityClientIntegrationTest() {
        final Pattern ticketActivitiesPattern = Pattern.compile(PREFIX_GET_PATH + "/tickets/.{32}/activities\\?.*limit=3.*");
        mFileNames.put(ticketActivitiesPattern, "json/getTicketActivities.json");

        final Pattern ticketActivityPattern = Pattern.compile(PREFIX_GET_PATH + "/tickets/.{32}/activities/.{10}\\?.*");
        mFileNames.put(ticketActivityPattern, "json/getTicketActivity.json");

        final Pattern ticketGetActivityAttachmentsPattern = Pattern.compile(
            PREFIX_GET_PATH + "/tickets/.{32}/activities/.{32}/attachments\\?.*limit=3.*");
        mFileNames.put(ticketGetActivityAttachmentsPattern, "json/getTicketActivityAttachments.json");
    }
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Test
    public void testTicketActivities() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetTicketActivitiesRequest request = new GetTicketActivitiesRequest(this.getTicketId());
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final Page<TicketActivityResponse> ticketActivitiesCollection = mTicketActivityClient.getTicketActivities(request);

        Assert.assertNotNull(ticketActivitiesCollection);
        Assert.assertFalse(ticketActivitiesCollection
                               .getElements()
                               .isEmpty());
    }

    @Test
    public void testTicketActivity() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final GetTicketActivityRequest request = new GetTicketActivityRequest(ticketId, this.getTicketActivityId(ticketId));

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityResponse ticketActivityResponse = mTicketActivityClient.getTicketActivity(request);

        Assert.assertNotNull(ticketActivityResponse);
        Assert.assertNotNull(ticketActivityResponse.getProperties());
    }

    @Test
    public void testCreateTicketActivity() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final CreateTicketActivityRequest request = new CreateTicketActivityRequest(this.getTicketId(), "title", "desc");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityResponse ticketModel = mTicketActivityClient.createTicketActivity(request);
        Assert.assertNotNull(ticketModel);
        Assert.assertNotNull(ticketModel.getProperties());
    }

    @Test
    public void testTicketActivityAttachments() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final GetTicketActivityAttachmentsRequest request = new GetTicketActivityAttachmentsRequest(ticketId, this.getTicketActivityId(ticketId));
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketActivityAttachmentResponse> ticketCollection = mTicketActivityClient.getTicketActivityAttachments(request);

        Assert.assertNotNull(ticketCollection);
        Assert.assertFalse(ticketCollection
                               .getElements()
                               .isEmpty());
    }

    @Test
    public void testTicketActivityAttachment() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final String ticketActivityId = this.getTicketActivityId(ticketId);
        final String ticketActivityAttachmentId = this.getTicketActivityAttachmentId(ticketId, ticketActivityId);
        final GetTicketActivityAttachmentRequest request = new GetTicketActivityAttachmentRequest(ticketId, ticketActivityId, ticketActivityAttachmentId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TicketActivityAttachmentResponse attachment = mTicketActivityClient.getTicketActivityAttachment(request);

        Assert.assertNotNull(attachment);
    }

    @Test
    public void testDeleteTicketActivityAttachment() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------
        final String ticketId = this.getTicketId();
        final String ticketActivityId = this.getTicketActivityId(ticketId);
        final String ticketActivityAttachmentId = this.getTicketActivityAttachmentId(ticketId, ticketActivityId);
        final GetTicketActivityAttachmentRequest request = new GetTicketActivityAttachmentRequest(ticketId, ticketActivityId, ticketActivityAttachmentId);

        //----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        mTicketActivityClient.deleteTicketActivityAttachment(request);
    }

    @Test
    public void testCreateTicketAttachment() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final CreateTicketActivityAttachmentRequest request = new CreateTicketActivityAttachmentRequest(ticketId, this.getTicketActivityId(ticketId), "desc");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityAttachmentResponse ticketAttachmentModel = mTicketActivityClient.createTicketActivityAttachment(request);
        Assert.assertNotNull(ticketAttachmentModel);
        Assert.assertNotNull(ticketAttachmentModel.getProperties());
    }

    @Test
    public void testTicketActivityRemarks() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final GetTicketActivityRemarksRequest request = new GetTicketActivityRemarksRequest(ticketId, this.getTicketActivityId(ticketId));
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<TicketActivityRemarkResponse> ticketCollection = mTicketActivityClient.getTicketActivityRemarks(request);

        Assert.assertNotNull(ticketCollection);
        Assert.assertFalse(ticketCollection
                               .getElements()
                               .isEmpty());
    }

    @Test
    public void testTicketActivityRemark() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final String ticketActivityId = this.getTicketActivityId(ticketId);
        final GetTicketActivityRemarkRequest request = new GetTicketActivityRemarkRequest(ticketId,
                                                                                          ticketActivityId,
                                                                                          this.getTicketActivityRemarkId(ticketId, ticketActivityId));

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final TicketActivityRemarkResponse attachment = mTicketActivityClient.getTicketActivityRemark(request);

        Assert.assertNotNull(attachment);
    }

    @Test
    public void testCreateTicketActivityRemark() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final String ticketActivityId = this.getTicketActivityId(ticketId);
        final CreateTicketActivityRemarkRequest request = new CreateTicketActivityRemarkRequest(ticketId, ticketActivityId, "remark");

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        final TicketActivityRemarkResponse ticketModel = mTicketActivityClient.createTicketActivityRemark(request);
        Assert.assertNotNull(ticketModel);
        Assert.assertNotNull(ticketModel.getProperties());
    }

    @Test
    public void testDeleteTicketActivityRemark() throws ForceAPIException {
        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String ticketId = this.getTicketId();
        final String ticketActivityId = this.getTicketActivityId(ticketId);
        final GetTicketActivityRemarkRequest request = new GetTicketActivityRemarkRequest(ticketId,
                                                                                          ticketActivityId,
                                                                                          this.getTicketActivityRemarkId(ticketId, ticketActivityId));

        //----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------
        mTicketActivityClient.deleteTicketActivityRemark(request);
    }
}
