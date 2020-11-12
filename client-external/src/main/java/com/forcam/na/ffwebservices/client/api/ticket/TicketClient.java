////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.ticket;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketAttachmentDataRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.CreateTicketRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.DeleteTicketAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.DeleteTicketRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketAttachmentRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.SetTicketStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.UpdateTicketRequest;
import com.forcam.na.ffwebservices.model.ticket.TicketAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests tickets.
 */
public class TicketClient extends AbstractClient implements ITicketClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** The ticket endpoint. */
    private final TicketEndpoint mTicketEndpoint;

    /** The ticket response builder. */
    private final ITicketResponseBuilder mTicketResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param ticketEndpoint        The ticket endpoint.
     * @param ticketResponseBuilder The ticket response builder.
     */
    @Inject
    public TicketClient(TicketEndpoint ticketEndpoint, ITicketResponseBuilder ticketResponseBuilder) {
        mTicketEndpoint = ticketEndpoint;
        mTicketResponseBuilder = ticketResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<TicketResponse> getTickets(GetTicketsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mTicketEndpoint.getTickets(request.getWorkplaceNumber(),
                                                                           request.getWorkplaceId(),
                                                                           request.getTicketTitle(),
                                                                           request.getTicketNumber(),
                                                                           request.getCreationDateFrom(),
                                                                           request.getCreationDateTo(),
                                                                           request.getOperationId(),
                                                                           request.getMaterialNumber(),
                                                                           request.getTicketPriority(),
                                                                           request.getTicketStateId(),
                                                                           request.getTicketClassId(),
                                                                           request.getLimit(),
                                                                           request.getPaginationDirection(),
                                                                           request.getPaginationTimestamp(),
                                                                           request.getPaginationIdentifier(),
                                                                           request
                                                                               .embed()
                                                                               .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<TicketResponse> response = mTicketResponseBuilder.getTicketCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public TicketResponse getTicket(GetTicketRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketEndpoint.getTicket(request.getId(),
                                                                request
                                                                    .embed()
                                                                    .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketResponseBuilder.getTicketResponse(responseModel);
    }

    @Override
    public void deleteTicket(DeleteTicketRequest request) throws ForceAPIException {
        final Call<Void> call = mTicketEndpoint.deleteTicket(request.getId());
        this.executeCall(request, call);
    }

    @Override
    public TicketResponse setTicketState(SetTicketStateRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketEndpoint.setTicketState(request.getTicketId(), request.getTicketStateId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketResponseBuilder.getTicketResponse(responseModel);
    }

    @Override
    public TicketResponse createTicket(CreateTicketRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketEndpoint.createTicket(request.getTicketData());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketResponseBuilder.getTicketResponse(responseModel);
    }

    @Override
    public TicketResponse updateTicket(UpdateTicketRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketEndpoint.updateTicket(request.getId(), request.getTicketData());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketResponseBuilder.getTicketResponse(responseModel);
    }

    @Override
    public Page<TicketAttachmentResponse> getTicketAttachments(GetTicketAttachmentsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mTicketEndpoint.getTicketAttachments(request.getTicketId(),
                                                                                     request.getName(),
                                                                                     request.getCreationDateFrom(),
                                                                                     request.getCreationDateTo(),
                                                                                     request.getLimit(),
                                                                                     request.getPaginationDirection(),
                                                                                     request.getPaginationTimestamp(),
                                                                                     request.getPaginationIdentifier());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<TicketAttachmentResponse> response = mTicketResponseBuilder.getTicketAttachmentCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public TicketAttachmentResponse getTicketAttachment(GetTicketAttachmentRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketEndpoint.getTicketAttachment(request.getAttachmentId(),
                                                                          request.getTicketId(),
                                                                          request
                                                                              .embed()
                                                                              .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketResponseBuilder.getTicketAttachmentResponse(responseModel);
    }

    @Override
    public TicketAttachmentResponse createTicketAttachment(CreateTicketAttachmentRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketEndpoint.createTicketAttachment(request.getTicketId(), request.getTicketAttachmentData());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketResponseBuilder.getTicketAttachmentResponse(responseModel);
    }

    @Override
    public void deleteTicketAttachment(DeleteTicketAttachmentRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketEndpoint.deleteTicketAttachment(request.getId(), request.getTicketId());
        this.executeCall(request, call);
    }

    @Override
    public byte[] getTicketAttachmentData(GetTicketAttachmentRequest request) throws ForceAPIException {
        final Call<byte[]> call = mTicketEndpoint.getTicketAttachmentData(request.getTicketId(), request.getAttachmentId());
        return this.executeCall(request, call);
    }

    @Override
    public byte[] createTicketAttachmentData(CreateTicketAttachmentDataRequest request) throws ForceAPIException {
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("data",
                                                                        request
                                                                            .getFileData()
                                                                            .getFile()
                                                                            .getName(),
                                                                        RequestBody.create(MediaType.parse(request
                                                                                                               .getFileData()
                                                                                                               .getMediaType()),
                                                                                           request
                                                                                               .getFileData()
                                                                                               .getFile()));
        final Call<byte[]> call = mTicketEndpoint.createTicketAttachmentData(request.getTicketUuId(),
                                                                             request.getUuId(),
                                                                             filePart,
                                                                             request
                                                                                 .getFileData()
                                                                                 .getMediaType(),
                                                                             request.getCreator());
        return this.executeCall(request, call);
    }
}
