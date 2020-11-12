////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 29.11.19.
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
import com.forcam.na.ffwebservices.model.ticket.TicketActivityAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityRemarkResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityResponse;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests ticket activities.
 */
public class TicketActivityClient extends AbstractClient implements ITicketActivityClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** The ticket activity endpoint. */
    private final TicketActivityEndpoint mTicketActivityEndpoint;

    /** The ticket response builder. */
    private final ITicketActivityResponseBuilder mTicketActivityResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------
    @Inject
    public TicketActivityClient(TicketActivityEndpoint ticketActivityEndpoint, ITicketActivityResponseBuilder ticketActivityResponseBuilder) {
        mTicketActivityEndpoint = ticketActivityEndpoint;
        mTicketActivityResponseBuilder = ticketActivityResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    @Override
    public Page<TicketActivityResponse> getTicketActivities(GetTicketActivitiesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mTicketActivityEndpoint.getTicketActivities(request.getTicketId(),
                                                                                            request.getTitle(),
                                                                                            request.getEditor(),
                                                                                            request.getDueDateStart(),
                                                                                            request.getDueDateEnd(),
                                                                                            request.getTicketActivityStateId(),
                                                                                            request.getLimit(),
                                                                                            request.getPaginationDirection(),
                                                                                            request.getPaginationTimestamp(),
                                                                                            request.getPaginationIdentifier());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<TicketActivityResponse> response = mTicketActivityResponseBuilder.getTicketCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public TicketActivityResponse getTicketActivity(GetTicketActivityRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketActivityEndpoint.getTicketActivity(request.getTicketId(),
                                                                                request.getActivityId(),
                                                                                request
                                                                                    .embed()
                                                                                    .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketActivityResponseBuilder.getTicketActivityResponse(responseModel);
    }

    @Override
    public TicketActivityResponse createTicketActivity(CreateTicketActivityRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketActivityEndpoint.createTicketActivity(request.getTicketId(), request.getTicketActivityData());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketActivityResponseBuilder.getTicketActivityResponse(responseModel);
    }

    @Override
    public TicketActivityResponse updateTicketActivity(UpdateTicketActivityRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketActivityEndpoint.updateTicketActivity(request.getTicketId(),
                                                                                   request.getActivityId(),
                                                                                   request.getTicketActivityData());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketActivityResponseBuilder.getTicketActivityResponse(responseModel);
    }

    @Override
    public void deleteTicketActivity(GetTicketActivityRequest request) throws ForceAPIException {
        final Call<Void> call = mTicketActivityEndpoint.deleteTicketActivity(request.getTicketId(), request.getActivityId());
        this.executeCall(request, call);
    }

    @Override
    public TicketActivityResponse setTicketActivityState(SetTicketActivityStateRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketActivityEndpoint.setTicketActivityState(request.getTicketId(),
                                                                                     request.getActivityId(),
                                                                                     request.getTicketActivityState());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketActivityResponseBuilder.getTicketActivityResponse(responseModel);
    }

    @Override
    public Page<TicketActivityAttachmentResponse> getTicketActivityAttachments(GetTicketActivityAttachmentsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mTicketActivityEndpoint.getTicketActivityAttachments(request.getTicketId(),
                                                                                                     request.getActivityId(),
                                                                                                     request.getName(),
                                                                                                     request.getCreationDateFrom(),
                                                                                                     request.getCreationDateTo(),
                                                                                                     request.getLimit(),
                                                                                                     request.getPaginationDirection(),
                                                                                                     request.getPaginationTimestamp(),
                                                                                                     request.getPaginationIdentifier());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<TicketActivityAttachmentResponse> response = mTicketActivityResponseBuilder.getTicketActivityAttachmentCollectionResponse(
            request,
            responseModel);
        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public TicketActivityAttachmentResponse getTicketActivityAttachment(GetTicketActivityAttachmentRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketActivityEndpoint.getTicketActivityAttachment(request.getTicketId(),
                                                                                          request.getActivityId(),
                                                                                          request.getAttachmentId(),
                                                                                          request
                                                                                              .embed()
                                                                                              .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketActivityResponseBuilder.getTicketActivityAttachmentResponse(responseModel);
    }

    @Override
    public byte[] getTicketActivityAttachmentData(GetTicketActivityAttachmentRequest request) throws ForceAPIException {
        final Call<byte[]> call = mTicketActivityEndpoint.getTicketActivityAttachmentData(request.getTicketId(),
                                                                                          request.getActivityId(),
                                                                                          request.getAttachmentId(),
                                                                                          request
                                                                                              .embed()
                                                                                              .toString());
        return this.executeCall(request, call);
    }

    @Override
    public void deleteTicketActivityAttachment(GetTicketActivityAttachmentRequest request) throws ForceAPIException {
        final Call<Void> call = mTicketActivityEndpoint.deleteTicketActivityAttachment(request.getTicketId(),
                                                                                       request.getActivityId(),
                                                                                       request.getAttachmentId());
        this.executeCall(request, call);
    }

    @Override
    public TicketActivityAttachmentResponse createTicketActivityAttachment(CreateTicketActivityAttachmentRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketActivityEndpoint.createTicketActivityAttachment(request.getTicketId(),
                                                                                             request.getActivityId(),
                                                                                             request.getTicketActivityAttachmentData());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketActivityResponseBuilder.getTicketActivityAttachmentResponse(responseModel);
    }

    @Override
    public byte[] createTicketActivityAttachmentData(CreateTicketActivityAttachmentDataRequest request) throws ForceAPIException {
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
        final Call<byte[]> call = mTicketActivityEndpoint.createTicketActivityAttachmentData(request.getTicketUuId(),
                                                                                             request.getActivityUuId(),
                                                                                             request.getUuId(),
                                                                                             filePart,
                                                                                             request
                                                                                                 .getFileData()
                                                                                                 .getMediaType(),
                                                                                             request.getCreator());
        return this.executeCall(request, call);
    }

    @Override
    public Page<TicketActivityRemarkResponse> getTicketActivityRemarks(GetTicketActivityRemarksRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mTicketActivityEndpoint.getTicketActivityRemarks(request.getTicketId(),
                                                                                                 request.getActivityId(),
                                                                                                 request.getEditor(),
                                                                                                 request.getCreationDateFrom(),
                                                                                                 request.getCreationDateTo(),
                                                                                                 request.getLimit(),
                                                                                                 request.getPaginationDirection(),
                                                                                                 request.getPaginationTimestamp(),
                                                                                                 request.getPaginationIdentifier());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);

        final CollectionResponse<TicketActivityRemarkResponse> response = mTicketActivityResponseBuilder.getTicketActivityRemarkCollectionResponse(request,
                                                                                                                                                   responseModel);
        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public TicketActivityRemarkResponse getTicketActivityRemark(GetTicketActivityRemarkRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketActivityEndpoint.getTicketActivityRemark(request.getTicketId(),
                                                                                      request.getActivityId(),
                                                                                      request.getRemarkId(),
                                                                                      request
                                                                                          .embed()
                                                                                          .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketActivityResponseBuilder.getTicketActivityRemarkResponse(responseModel);
    }

    @Override
    public TicketActivityRemarkResponse createTicketActivityRemark(CreateTicketActivityRemarkRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketActivityEndpoint.createTicketActivityRemark(request.getTicketId(),
                                                                                         request.getActivityId(),
                                                                                         request.getTicketActivityRemarkData());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketActivityResponseBuilder.getTicketActivityRemarkResponse(responseModel);
    }

    @Override
    public void deleteTicketActivityRemark(GetTicketActivityRemarkRequest request) throws ForceAPIException {
        final Call<Void> call = mTicketActivityEndpoint.deleteTicketActivityRemark(request.getTicketId(), request.getActivityId(), request.getRemarkId());
        this.executeCall(request, call);
    }
}
