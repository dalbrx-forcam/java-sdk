////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.masterdata;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailRequest;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailsRequest;
import com.forcam.na.ffwebservices.client.api.qualitytype.request.GetQualityTypeRequest;
import com.forcam.na.ffwebservices.client.api.qualitytype.request.GetQualityTypesRequest;
import com.forcam.na.ffwebservices.client.api.shifttype.request.GetShiftTypeRequest;
import com.forcam.na.ffwebservices.client.api.shifttype.request.GetShiftTypesRequest;
import com.forcam.na.ffwebservices.client.api.specificsettings.request.GetCustomerSpecificSettingCollectionRequest;
import com.forcam.na.ffwebservices.client.api.specificsettings.request.GetCustomerSpecificSettingRequest;
import com.forcam.na.ffwebservices.client.api.specificsettings.response.CustomerSpecificSettingResponse;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketClassRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketClassesRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketStatesRequest;
import com.forcam.na.ffwebservices.client.api.masterdata.document.request.GetDocumentStateCollectionRequest;
import com.forcam.na.ffwebservices.client.api.masterdata.document.request.GetDocumentStateRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateClassCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateClassRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperationPhaseCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperationPhaseRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetToolAssemblyOrderStateCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetToolAssemblyOrderStateRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetWorkplaceStateCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetWorkplaceStateRequest;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailResponse;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypeResponse;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypeResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.DocumentStateResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityStateResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketClassResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketStateResponse;

/**
 * An interface with methods that request master data.
 */
public interface IMasterDataClient {

    /**
     * Sends a request to the server and gets a collection of operating state classes as response.
     *
     * @param request A collection of parameters.
     * @return The operating state class collection response.
     * @throws ForceAPIException When unable to get operating state classes.
     */
    Page<StatusDefinitionResponse> getOperatingStateClasses(GetOperatingStateClassCollectionRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets an operating state class as response.
     *
     * @param request A collection of parameters.
     * @return An operating state class model.
     * @throws ForceAPIException When unable to get operating state class.
     */
    StatusDefinitionResponse getOperatingStateClass(GetOperatingStateClassRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of operating states as response.
     *
     * @param request A collection of parameters.
     * @return The operating state collection response.
     * @throws ForceAPIException When unable to get operating states.
     */
    Page<OperatingStateResponse> getOperatingStates(GetOperatingStateCollectionRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets an operating state as response.
     *
     * @param request A collection of parameters.
     * @return An operating state model.
     * @throws ForceAPIException When unable to get operating state.
     */
    OperatingStateResponse getOperatingState(GetOperatingStateRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of operation phases as response.
     *
     * @param request A collection of parameters.
     * @return The operation phase collection response.
     * @throws ForceAPIException When unable to get operation phases.
     */
    Page<StatusDefinitionResponse> getOperationPhases(GetOperationPhaseCollectionRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets an operation phase as response.
     *
     * @param request A collection of parameters.
     * @return An operation phase model.
     * @throws ForceAPIException When unable to get operation phase.
     */
    StatusDefinitionResponse getOperationPhase(GetOperationPhaseRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of quality details as response.
     *
     * @param request A collection of parameters.
     * @return The quality detail collection response.
     * @throws ForceAPIException When unable to get quality details.
     */
    Page<QualityDetailResponse> getQualityDetails(GetQualityDetailsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a quality detail as response.
     *
     * @param request A collection of parameters.
     * @return A quality detail model.
     * @throws ForceAPIException When unable to get quality detail.
     */
    QualityDetailResponse getQualityDetail(GetQualityDetailRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of quality types as response.
     *
     * @param request A collection of parameters.
     * @return The quality type collection response.
     * @throws ForceAPIException When unable to get quality types.
     */
    Page<QualityTypeResponse> getQualityTypes(GetQualityTypesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a quality type as response.
     *
     * @param request A collection of parameters.
     * @return A quality type model.
     * @throws ForceAPIException When unable to get quality type.
     */
    QualityTypeResponse getQualityType(GetQualityTypeRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of shift types as response.
     *
     * @param request A collection of parameters.
     * @return The shift type collection response.
     * @throws ForceAPIException When unable to get shift types.
     */
    Page<ShiftTypeResponse> getShiftTypes(GetShiftTypesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a shift type as response.
     *
     * @param request A collection of parameters.
     * @return A shift type model.
     * @throws ForceAPIException When unable to get shift type.
     */
    ShiftTypeResponse getShiftType(GetShiftTypeRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of tool assembly order states as response.
     *
     * @param request A collection of parameters.
     * @return The tool assembly order state collection response.
     * @throws ForceAPIException When unable to get tool assembly order states.
     */
    Page<StatusDefinitionResponse> getToolAssemblyOrderStates(GetToolAssemblyOrderStateCollectionRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a tool assembly order state as response.
     *
     * @param request A collection of parameters.
     * @return A tool assembly order state model.
     * @throws ForceAPIException When unable to get tool assembly order state.
     */
    StatusDefinitionResponse getToolAssemblyOrderState(GetToolAssemblyOrderStateRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of workplace states as response.
     *
     * @param request A collection of parameters.
     * @return The workplace state collection response.
     * @throws ForceAPIException When unable to get workplace states.
     */
    Page<StatusDefinitionResponse> getWorkplaceStates(GetWorkplaceStateCollectionRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a workplace state as response.
     *
     * @param request A collection of parameters.
     * @return A workplace state model.
     * @throws ForceAPIException When unable to get workplace state.
     */
    StatusDefinitionResponse getWorkplaceState(GetWorkplaceStateRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of ticket states as response.
     *
     * @param request A collection of parameters.
     * @return The ticket state collection response.
     * @throws ForceAPIException When unable to get ticket states.
     */
    Page<TicketStateResponse> getTicketStates(GetTicketStatesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a ticket state as response.
     *
     * @param request A collection of parameters.
     * @return A ticket state model.
     * @throws ForceAPIException When unable to get ticket state.
     */
    TicketStateResponse getTicketState(GetTicketStateRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of ticket activity states as response.
     *
     * @param request A collection of parameters.
     * @return The ticket activity state collection response.
     * @throws ForceAPIException When unable to get ticket activity states.
     */
    Page<TicketActivityStateResponse> getTicketActivityStates(CollectionRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a ticket activity state as response.
     *
     * @param request A collection of parameters.
     * @return A ticket activity state model.
     * @throws ForceAPIException When unable to get ticket activity state.
     */
    TicketActivityStateResponse getTicketActivityState(GetTicketActivityStateRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of ticket classes as response.
     *
     * @param request A collection of parameters.
     * @return The ticket classes collection response.
     * @throws ForceAPIException When unable to get ticket classes.
     */
    Page<TicketClassResponse> getTicketClasses(GetTicketClassesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a ticket class as response.
     *
     * @param request A collection of parameters.
     * @return A ticket class model.
     * @throws ForceAPIException When unable to get ticket class.
     */
    TicketClassResponse getTicketClass(GetTicketClassRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of customer specific settings as response.
     *
     * @param request A collection of parameters.
     * @return The customer specific setting collection response.
     * @throws ForceAPIException When unable to get customer specific settings.
     */
    Page<CustomerSpecificSettingResponse> getCustomerSpecificSettings(GetCustomerSpecificSettingCollectionRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a customer specific setting as response.
     *
     * @param request A collection of parameters.
     * @return A customer specific setting model.
     * @throws ForceAPIException When unable to get customer specific setting.
     */
    CustomerSpecificSettingResponse getCustomerSpecificSetting(GetCustomerSpecificSettingRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of document states as response.
     *
     * @param request A collection of parameters.
     * @return The document state collection response.
     * @throws ForceAPIException When unable to get document states.
     */
    Page<DocumentStateResponse> getDocumentStates(GetDocumentStateCollectionRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a document state as response.
     *
     * @param request A collection of parameters.
     * @return A document state model.
     * @throws ForceAPIException When unable to get document states.
     */
    DocumentStateResponse getDocumentState(GetDocumentStateRequest request) throws ForceAPIException;
}