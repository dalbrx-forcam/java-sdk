////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.config;

import com.forcam.na.ffwebservices.client.api.callback.ICallbackClient;
import com.forcam.na.ffwebservices.client.api.command.ICommandClient;
import com.forcam.na.ffwebservices.client.api.command.ICommandClientAsync;
import com.forcam.na.ffwebservices.client.api.device.IDeviceClient;
import com.forcam.na.ffwebservices.client.api.erp.IERPClient;
import com.forcam.na.ffwebservices.client.api.event.IEventClient;
import com.forcam.na.ffwebservices.client.api.machine.IMachineClient;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.IMachineStateDetailClient;
import com.forcam.na.ffwebservices.client.api.masterdata.IMasterDataClient;
import com.forcam.na.ffwebservices.client.api.miscellaneous.IMiscellaneousClient;
import com.forcam.na.ffwebservices.client.api.operation.IOperationClient;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.IOperationPlanningClient;
import com.forcam.na.ffwebservices.client.api.order.IProductionOrderClient;
import com.forcam.na.ffwebservices.client.api.pdm.IFileRepositoryClient;
import com.forcam.na.ffwebservices.client.api.reporting.IReportingClient;
import com.forcam.na.ffwebservices.client.api.staffmember.IStaffMemberClient;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.IStaffMemberPlanningClient;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketActivityClient;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketClient;
import com.forcam.na.ffwebservices.client.api.tool.IToolClient;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceClient;
import com.forcam.na.ffwebservices.client.api.workplacegroup.IWorkplaceGroupClient;
import com.forcam.na.ffwebservices.client.statusdefinition.IStatusDefinitionClient;
import dagger.Component;
import okhttp3.OkHttpClient;

import javax.inject.Singleton;

/**
 * An interface for the Bridge API components.
 */
@Singleton
@Component(modules = { ClientModule.class, EndpointModule.class, ForceAPIModule.class, InterceptorModule.class, ResponseBuilderModule.class })
public interface BridgeAPIComponent {

    ICommandClient commandClient();

    IWorkplaceClient workplaceClient();

    IOperationClient operationClient();

    IStatusDefinitionClient statusDefinitionClient();

    IMachineStateDetailClient machineStateDetailClient();

    ICommandClientAsync commandClientAsync();

    IMachineClient machineClient();

    IOperationPlanningClient planningScenarioClient();

    IProductionOrderClient productionOrderClient();

    IStaffMemberClient staffMemberClient();

    IToolClient toolClient();

    IMasterDataClient masterDataClient();

    IMiscellaneousClient miscellaneousClient();

    IWorkplaceGroupClient workplaceGroupClient();

    ICallbackClient callbackClient();

    IEventClient eventClient();

    IDeviceClient deviceClient();

    OkHttpClient okHttpClient();

    IFileRepositoryClient fileRepositoryClient();

    IStaffMemberPlanningClient staffMemberPlanningClient();

    IReportingClient reportingClient();

    ITicketClient ticketClient();

    ITicketActivityClient ticketActivityClient();

    IERPClient erpClient();
}
