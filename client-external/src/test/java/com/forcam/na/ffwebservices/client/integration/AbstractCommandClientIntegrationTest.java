////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 27.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machine.request.GetMachinesRequest;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.request.GetMachineStateDetailsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailsRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacesRequest;
import com.forcam.na.ffwebservices.model.command.CommandResponse;
import com.forcam.na.ffwebservices.model.command.machine.MachineCountCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineQuantityCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateRevisionInsertCommandRequest;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStrokeCommandRequest;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseCommandRequest;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseRevisionInsertCommandRequest;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityCommandRequest;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityRevisionInsertCommandRequest;
import com.forcam.na.ffwebservices.model.definition.MachineState;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.machine.MachineResponse;
import com.forcam.na.ffwebservices.model.machinestatedetail.MachineStateDetailResponse;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Contains common code for {@link CommandClientIntegrationTest} and {@link CommandClientAsyncIntegrationTest}.
 */
public class AbstractCommandClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Initializes and returns an {@link OperationPhaseCommandRequest}.
     *
     * @return An operation phase command request.
     * @throws ForceAPIException When unable to get IDs.
     */
    public OperationPhaseCommandRequest getOperationPhaseCommandRequest() throws ForceAPIException {
        final String workplaceId = this
            .getWorkplaceProperties()
            .getId();
        final String operationId = this.getOperationId();
        final OperationPhase operationPhase = OperationPhase.SETUP;

        return new OperationPhaseCommandRequest(operationId, workplaceId, operationPhase);
    }

    /**
     * Initializes and returns a {@link OperationPhaseRevisionInsertCommandRequest}.
     *
     * @return A operation phase revision insert command request.
     * @throws ForceAPIException When unable to get IDs.
     */
    public OperationPhaseRevisionInsertCommandRequest getOperationPhaseRevisionInsertCommandRequest() throws ForceAPIException {
        final OperationPhaseCommandRequest operationPhaseCommandRequest = this.getOperationPhaseCommandRequest();

        final CommandResponse<OperationPhaseCommandDataWsModel> operationPhaseModel = mCommandClient.sendOperationPhaseCommand(operationPhaseCommandRequest);
        Assert.assertNotNull(operationPhaseModel);
        Assert.assertNotNull(operationPhaseModel.getProperties());
        Assert.assertNotNull(operationPhaseModel
                                 .getProperties()
                                 .getData());

        final OperationPhaseCommandDataWsModel operationPhaseDataModel = operationPhaseModel
            .getProperties()
            .getData();
        final Date insertionTimestamp = new Date();
        return new OperationPhaseRevisionInsertCommandRequest(operationPhaseDataModel, insertionTimestamp);
    }

    /**
     * Initializes and returns an {@link OperationQuantityCommandRequest}.
     *
     * @return An operation quantity command request.
     * @throws ForceAPIException When unable to get IDs.
     */
    public OperationQuantityCommandRequest getOperationQuantityCommandRequest() throws ForceAPIException {
        final String workplaceId = this
            .getWorkplaceProperties()
            .getId();
        final String operationId = this.getOperationId();
        final double quantity = 2;
        final String qualityDetailId = this.getQualityDetailId();
        final String staffMemberId = StringUtils.EMPTY;
        final String annotation = StringUtils.EMPTY;
        final String ticketId = StringUtils.EMPTY;

        final OperationQuantityCommandRequest commandRequest = new OperationQuantityCommandRequest(operationId, workplaceId, quantity, qualityDetailId);
        commandRequest.setStaffMemberId(staffMemberId);
        commandRequest.setAnnotation(annotation);
        commandRequest.setTicketId(ticketId);
        return commandRequest;
    }

    /**
     * Initializes and returns a {@link MachineCountCommandRequest}.
     *
     * @return A machine count command request.
     * @throws ForceAPIException When unable to get IDs.
     */
    public MachineCountCommandRequest getMachineCountCommandRequest() throws ForceAPIException {
        final String machineId = this.getMachineId();
        final long counterNumber = 1;
        final long count = 1;

        return new MachineCountCommandRequest(machineId, counterNumber, count);
    }

    public MachineQuantityCommandRequest getMachineQuantityCommandRequest() throws ForceAPIException {
        final String machineId = this.getMachineId();
        final String qualityDetailId = this.getQualityDetailId();
        final double quantity = 1;

        final MachineQuantityCommandRequest commandRequest = new MachineQuantityCommandRequest(machineId, quantity, qualityDetailId);

        //async is true because machine quantity command needs a special logic
        commandRequest.setAsync(true);

        return commandRequest;
    }

    /**
     * Initializes and returns a {@link MachineStateCommandRequest}.
     *
     * @return A machine state command request.
     * @throws ForceAPIException When unable to get IDs.
     */
    public MachineStateCommandRequest getMachineStateCommandRequest() throws ForceAPIException {
        final String machineId = this.getMachineId();
        final List<String> machineStateDetailIds = Collections.emptyList();
        final MachineState machineStatus = MachineState.PRODUCTION;
        final String annotation = StringUtils.EMPTY;

        final MachineStateCommandRequest commandRequest = new MachineStateCommandRequest(machineId, machineStatus);
        commandRequest.setMachineStateDetailIds(machineStateDetailIds);
        commandRequest.setAnnotation(annotation);
        return commandRequest;
    }

    /**
     * Initializes and returns a {@link MachineStateRevisionInsertCommandRequest}.
     *
     * @return A machine state revision insert command request.
     * @throws ForceAPIException When unable to get IDs.
     */
    public MachineStateRevisionInsertCommandRequest getMachineStateRevisionInsertCommandRequest() throws ForceAPIException {
        final MachineStateCommandRequest machineStateCommandRequest = this.getMachineStateCommandRequest();
        machineStateCommandRequest.setMachineStateDetailIds(this.getMachineStateDetailIds(1));

        final CommandResponse<MachineStateCommandDataWSModel> machineStateModel = mCommandClient.sendMachineStateCommand(machineStateCommandRequest);
        Assert.assertNotNull(machineStateModel);
        Assert.assertNotNull(machineStateModel.getProperties());
        Assert.assertNotNull(machineStateModel
                                 .getProperties()
                                 .getData());

        final MachineStateCommandDataWSModel machineStateDataModel = machineStateModel
            .getProperties()
            .getData();
        final Date insertionTimestamp = new Date();
        return new MachineStateRevisionInsertCommandRequest(machineStateDataModel, insertionTimestamp);
    }

    /**
     * Initializes and returns a {@link MachineStrokeCommandRequest}.
     *
     * @return A machine stroke command request.
     * @throws ForceAPIException When unable to get IDs.
     */
    public MachineStrokeCommandRequest getMachineStrokeCommandRequest() throws ForceAPIException {
        final String machineId = this.getMachineId();
        final short counterNumber = 0;
        final int strokes = 2;
        return new MachineStrokeCommandRequest(machineId, counterNumber, strokes);
    }

    /**
     * Gets the properties of a workplace from the server.
     *
     * @return A workplace properties model.
     * @throws ForceAPIException When unable to get workplaces.
     */
    private WorkplacePropertiesWSModel getWorkplaceProperties() throws ForceAPIException {
        final GetWorkplacesRequest request = new GetWorkplacesRequest();
        request.setLimit(1);
        final Page<WorkplaceResponse> collection = mWorkplaceClient.getWorkplaces(request);

        Assert.assertNotNull(collection);
        Assert.assertFalse(collection
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(collection
                                 .getElements()
                                 .get(0)
                                 .getProperties());

        return collection
            .getElements()
            .get(0)
            .getProperties();
    }

    /**
     * Gets a machine id from the server.
     *
     * @return A machine id.
     * @throws ForceAPIException When unable to get workplaces.
     */
    private String getMachineId() throws ForceAPIException {
        final String workplaceNumber = this
            .getWorkplaceProperties()
            .getNumber();

        final GetMachinesRequest machineRequest = new GetMachinesRequest();
        machineRequest.setWorkplaceNumber(workplaceNumber);
        machineRequest.setLimit(1);
        final Page<MachineResponse> machineCollection = mMachineClient.getMachines(machineRequest);

        Assert.assertNotNull(machineCollection);
        Assert.assertFalse(machineCollection
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(machineCollection
                                 .getElements()
                                 .get(0)
                                 .getProperties());

        return machineCollection
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }

    /**
     * Gets a quality detail id from the server.
     *
     * @return A quality detail id.
     * @throws ForceAPIException When unable to get quality details.
     */
    private String getQualityDetailId() throws ForceAPIException {
        final GetQualityDetailsRequest request = new GetQualityDetailsRequest();
        request.setLimit(1);
        final Page<QualityDetailResponse> collection = mMasterDataClient.getQualityDetails(request);

        Assert.assertNotNull(collection);
        Assert.assertFalse(collection
                               .getElements()
                               .isEmpty());
        Assert.assertNotNull(collection
                                 .getElements()
                                 .get(0)
                                 .getProperties());

        return collection
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }

    /**
     * Gets machine state detail ids from the server.
     *
     * @param amount Requested amount of machine state detail ids.
     * @return A list of machine state detail ids.
     * @throws ForceAPIException When unable to get machine state details.
     */
    private List<String> getMachineStateDetailIds(int amount) throws ForceAPIException {
        final GetMachineStateDetailsRequest request = new GetMachineStateDetailsRequest();
        request.setLimit(amount);
        final Page<MachineStateDetailResponse> collection = mMachineStateDetailClient.getMachineStateDetails(request);

        Assert.assertNotNull(collection);
        Assert.assertFalse(collection
                               .getElements()
                               .isEmpty());
        Assert.assertEquals(amount,
                            collection
                                .getElements()
                                .size());

        final List<String> machineStateDetailIds = new ArrayList<>(amount);
        for (MachineStateDetailResponse response : collection.getElements()) {
            Assert.assertNotNull(response.getProperties());
            machineStateDetailIds.add(response
                                          .getProperties()
                                          .getId());
        }

        return machineStateDetailIds;
    }

    /**
     * Initializes and returns a {@link OperationQuantityRevisionInsertCommandRequest}.
     *
     * @return A operation quantity revision insert command request.
     * @throws ForceAPIException When unable to get IDs.
     */
    public OperationQuantityRevisionInsertCommandRequest getOperationQuantityRevisionInsertCommandRequest() throws ForceAPIException {
        final OperationQuantityCommandRequest operationQuantityCommandRequest = this.getOperationQuantityCommandRequest();

        final CommandResponse<OperationQuantityCommandDataWsModel> machineStateModel = mCommandClient.sendOperationQuantityCommand(
            operationQuantityCommandRequest);
        Assert.assertNotNull(machineStateModel);
        Assert.assertNotNull(machineStateModel.getProperties());
        Assert.assertNotNull(machineStateModel
                                 .getProperties()
                                 .getData());

        final OperationQuantityCommandDataWsModel quantityCommandDataModel = machineStateModel
            .getProperties()
            .getData();
        final Date insertionTimestamp = new Date();
        return new OperationQuantityRevisionInsertCommandRequest(quantityCommandDataModel, insertionTimestamp);
    }
}