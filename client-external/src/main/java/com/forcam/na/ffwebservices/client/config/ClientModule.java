////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 24.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.config;

import com.forcam.na.ffwebservices.client.api.callback.CallbackClient;
import com.forcam.na.ffwebservices.client.api.callback.ICallbackClient;
import com.forcam.na.ffwebservices.client.api.command.CommandClient;
import com.forcam.na.ffwebservices.client.api.command.CommandClientAsync;
import com.forcam.na.ffwebservices.client.api.command.ICommandClient;
import com.forcam.na.ffwebservices.client.api.command.ICommandClientAsync;
import com.forcam.na.ffwebservices.client.api.device.DeviceClient;
import com.forcam.na.ffwebservices.client.api.device.IDeviceClient;
import com.forcam.na.ffwebservices.client.api.erp.ERPClient;
import com.forcam.na.ffwebservices.client.api.erp.IERPClient;
import com.forcam.na.ffwebservices.client.api.event.EventClient;
import com.forcam.na.ffwebservices.client.api.event.IEventClient;
import com.forcam.na.ffwebservices.client.api.machine.IMachineClient;
import com.forcam.na.ffwebservices.client.api.machine.MachineClient;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.IMachineStateDetailClient;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.MachineStateDetailClient;
import com.forcam.na.ffwebservices.client.api.masterdata.IMasterDataClient;
import com.forcam.na.ffwebservices.client.api.masterdata.MasterDataClient;
import com.forcam.na.ffwebservices.client.api.miscellaneous.IMiscellaneousClient;
import com.forcam.na.ffwebservices.client.api.miscellaneous.MiscellaneousClient;
import com.forcam.na.ffwebservices.client.api.operation.IOperationClient;
import com.forcam.na.ffwebservices.client.api.operation.OperationClient;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.IOperationPlanningClient;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.OperationPlanningClient;
import com.forcam.na.ffwebservices.client.api.order.IProductionOrderClient;
import com.forcam.na.ffwebservices.client.api.order.ProductionOrderClient;
import com.forcam.na.ffwebservices.client.api.pdm.FileRepositoryClient;
import com.forcam.na.ffwebservices.client.api.pdm.IFileRepositoryClient;
import com.forcam.na.ffwebservices.client.api.reporting.IReportingClient;
import com.forcam.na.ffwebservices.client.api.reporting.ReportingClient;
import com.forcam.na.ffwebservices.client.api.staffmember.IStaffMemberClient;
import com.forcam.na.ffwebservices.client.api.staffmember.StaffMemberClient;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.IStaffMemberPlanningClient;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.StaffMemberPlanningClient;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketActivityClient;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketClient;
import com.forcam.na.ffwebservices.client.api.ticket.TicketActivityClient;
import com.forcam.na.ffwebservices.client.api.ticket.TicketClient;
import com.forcam.na.ffwebservices.client.api.tool.IToolClient;
import com.forcam.na.ffwebservices.client.api.tool.ToolClient;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceClient;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceClient;
import com.forcam.na.ffwebservices.client.api.workplacegroup.IWorkplaceGroupClient;
import com.forcam.na.ffwebservices.client.api.workplacegroup.WorkplaceGroupClient;
import com.forcam.na.ffwebservices.client.statusdefinition.IStatusDefinitionClient;
import com.forcam.na.ffwebservices.client.statusdefinition.StatusDefinitionClient;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * The client module.
 */
@Module(includes = ResponseBuilderModule.class)
public class ClientModule {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Provides
    @Singleton
    public IWorkplaceClient workplaceClient(WorkplaceClient workplaceClient) {
        return workplaceClient;
    }

    @Provides
    @Singleton
    public IOperationClient operationClient(OperationClient operationClient) {
        return operationClient;
    }

    @Provides
    @Singleton
    public IStatusDefinitionClient statusDefinitionClient(StatusDefinitionClient statusDefinitionClient) {
        return statusDefinitionClient;
    }

    @Provides
    @Singleton
    public ICommandClient commandClient(CommandClient commandClient) {
        return commandClient;
    }

    @Provides
    @Singleton
    public IMachineStateDetailClient machineStateDetailClient(MachineStateDetailClient machineStateDetailClient) {
        return machineStateDetailClient;
    }

    @Provides
    @Singleton
    public ICommandClientAsync commandClientAsync(CommandClientAsync commandClientAsync) {
        return commandClientAsync;
    }

    @Provides
    @Singleton
    public IMachineClient machineClient(MachineClient machineClient) {
        return machineClient;
    }

    @Provides
    @Singleton
    public IProductionOrderClient productionOrderClient(ProductionOrderClient productionOrderClient) {
        return productionOrderClient;
    }

    @Provides
    @Singleton
    public IStaffMemberClient staffMemberClient(StaffMemberClient staffMemberClient) {
        return staffMemberClient;
    }

    @Provides
    @Singleton
    public IToolClient toolClient(ToolClient toolClient) {
        return toolClient;
    }

    @Provides
    @Singleton
    public IMasterDataClient masterDataClient(MasterDataClient masterDataClient) {
        return masterDataClient;
    }

    @Provides
    @Singleton
    public IMiscellaneousClient miscellaneousClient(MiscellaneousClient miscellaneousClient) {
        return miscellaneousClient;
    }

    @Provides
    @Singleton
    public IWorkplaceGroupClient workplaceGroupClient(WorkplaceGroupClient workplaceGroupClient) {
        return workplaceGroupClient;
    }

    @Provides
    @Singleton
    public IOperationPlanningClient planningScenarioClient(OperationPlanningClient operationPlanningClient) {
        return operationPlanningClient;
    }

    @Provides
    @Singleton
    public IDeviceClient deviceClient(DeviceClient deviceClient) {
        return deviceClient;
    }

    @Provides
    @Singleton
    public ICallbackClient callbackClient(CallbackClient callbackClient) {
        return callbackClient;
    }

    @Provides
    @Singleton
    public IEventClient eventClient(EventClient eventClient) {
        return eventClient;
    }

    @Provides
    @Singleton
    public IFileRepositoryClient fileRepositoryClient(FileRepositoryClient fileRepositoryClient) {
        return fileRepositoryClient;
    }

    @Provides
    @Singleton
    public IStaffMemberPlanningClient staffMemberPlanningClient(StaffMemberPlanningClient staffMemberPlanningClient) {
        return staffMemberPlanningClient;
    }

    @Provides
    @Singleton
    public IReportingClient reportingClient(ReportingClient reportingClient) {
        return reportingClient;
    }

    @Provides
    @Singleton
    public ITicketClient ticketClient(TicketClient ticketClient) { return ticketClient; }

    @Provides
    @Singleton
    public ITicketActivityClient ticketActivityClient(TicketActivityClient ticketActivityClient) {
        return ticketActivityClient;
    }

    @Provides
    @Singleton
    public IERPClient erpClient(ERPClient erpClient) {
        return erpClient;
    }
}