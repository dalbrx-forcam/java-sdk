////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.config;

import com.forcam.na.ffwebservices.client.api.callback.CallbackEndpoint;
import com.forcam.na.ffwebservices.client.api.command.CommandEndpoint;
import com.forcam.na.ffwebservices.client.api.device.DeviceEndpoint;
import com.forcam.na.ffwebservices.client.api.entrypoint.EntryPointEndpoint;
import com.forcam.na.ffwebservices.client.api.erp.ERPEndpoint;
import com.forcam.na.ffwebservices.client.api.erpcontext.ErpContextEndpoint;
import com.forcam.na.ffwebservices.client.api.event.EventEndpoint;
import com.forcam.na.ffwebservices.client.api.literal.LiteralEndpoint;
import com.forcam.na.ffwebservices.client.api.machine.MachineEndpoint;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.MachineStateDetailEndpoint;
import com.forcam.na.ffwebservices.client.api.masterdata.document.enpoint.DocumentStateEndpoint;
import com.forcam.na.ffwebservices.client.api.material.MaterialEndpoint;
import com.forcam.na.ffwebservices.client.api.operation.OperationEndpoint;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.OperationPlanningEndpoint;
import com.forcam.na.ffwebservices.client.api.order.ProductionOrderEndpoint;
import com.forcam.na.ffwebservices.client.api.pdm.FileRepositoryDocumentEndpoint;
import com.forcam.na.ffwebservices.client.api.pdm.FileRepositoryEndpoint;
import com.forcam.na.ffwebservices.client.api.qualitydetail.QualityDetailEndpoint;
import com.forcam.na.ffwebservices.client.api.qualitytype.QualityTypeEndpoint;
import com.forcam.na.ffwebservices.client.api.reporting.ReportingEndpoint;
import com.forcam.na.ffwebservices.client.api.shifttype.ShiftTypeEndpoint;
import com.forcam.na.ffwebservices.client.api.specificsettings.CustomerSpecificSettingsEndpoint;
import com.forcam.na.ffwebservices.client.api.staffmember.StaffMemberEndpoint;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.StaffMemberPlanningEndpoint;
import com.forcam.na.ffwebservices.client.api.ticket.TicketActivityEndpoint;
import com.forcam.na.ffwebservices.client.api.ticket.TicketEndpoint;
import com.forcam.na.ffwebservices.client.api.ticket.TicketMasterDataEndpoint;
import com.forcam.na.ffwebservices.client.api.tool.ToolEndpoint;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceEndpoint;
import com.forcam.na.ffwebservices.client.api.workplacegroup.WorkplaceGroupEndpoint;
import com.forcam.na.ffwebservices.client.statusdefinition.StatusDefinitionEndpoint;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 *
 */
@Module
public class EndpointModule {

    @Provides
    public MachineEndpoint machineEndpoint(Retrofit retrofit) {
        return retrofit.create(MachineEndpoint.class);
    }

    @Provides
    public ProductionOrderEndpoint productionOrderEndpoint(Retrofit retrofit) {
        return retrofit.create(ProductionOrderEndpoint.class);
    }

    @Provides
    public CallbackEndpoint callbackEndpoint(Retrofit retrofit) {
        return retrofit.create(CallbackEndpoint.class);
    }

    @Provides
    public MachineStateDetailEndpoint machineStateDetailEndpoint(Retrofit retrofit) {
        return retrofit.create(MachineStateDetailEndpoint.class);
    }

    @Provides
    public StatusDefinitionEndpoint statusDefinitionEndpoint(Retrofit retrofit) {
        return retrofit.create(StatusDefinitionEndpoint.class);
    }

    @Provides
    public QualityDetailEndpoint qualityDetailEndpoint(Retrofit retrofit) {
        return retrofit.create(QualityDetailEndpoint.class);
    }

    @Provides
    public QualityTypeEndpoint qualityTypeEndpoint(Retrofit retrofit) {
        return retrofit.create(QualityTypeEndpoint.class);
    }

    @Provides
    public ShiftTypeEndpoint shiftTypeEndpoint(Retrofit retrofit) {
        return retrofit.create(ShiftTypeEndpoint.class);
    }

    @Provides
    public ErpContextEndpoint erpContextEndpoint(Retrofit retrofit) {
        return retrofit.create(ErpContextEndpoint.class);
    }

    @Provides
    public LiteralEndpoint literalEndpoint(Retrofit retrofit) {
        return retrofit.create(LiteralEndpoint.class);
    }

    @Provides
    public EntryPointEndpoint entryPointEndpoint(Retrofit retrofit) {
        return retrofit.create(EntryPointEndpoint.class);
    }

    @Provides
    public WorkplaceEndpoint workplaceEndpoint(Retrofit retrofit) {
        return retrofit.create(WorkplaceEndpoint.class);
    }

    @Provides
    public OperationEndpoint operationClient(Retrofit retrofit) {
        return retrofit.create(OperationEndpoint.class);
    }

    @Provides
    public CommandEndpoint commandEndpoint(Retrofit retrofit) {
        return retrofit.create(CommandEndpoint.class);
    }

    @Provides
    public StaffMemberEndpoint staffMemberEndpoint(Retrofit retrofit) {
        return retrofit.create(StaffMemberEndpoint.class);
    }

    @Provides
    public ToolEndpoint toolEndpoint(Retrofit retrofit) {
        return retrofit.create(ToolEndpoint.class);
    }

    @Provides
    public WorkplaceGroupEndpoint workplaceGroupEndpoint(Retrofit retrofit) {
        return retrofit.create(WorkplaceGroupEndpoint.class);
    }

    @Provides
    public OperationPlanningEndpoint planningScenarioEndpoint(Retrofit retrofit) {
        return retrofit.create(OperationPlanningEndpoint.class);
    }

    @Provides
    public DeviceEndpoint deviceEndpoint(Retrofit retrofit) {
        return retrofit.create(DeviceEndpoint.class);
    }

    @Provides
    public EventEndpoint eventEndpoint(Retrofit retrofit) {
        return retrofit.create(EventEndpoint.class);
    }

    @Provides
    public FileRepositoryEndpoint fileRepositoryEndpoint(Retrofit retrofit) {
        return retrofit.create(FileRepositoryEndpoint.class);
    }

    @Provides
    public FileRepositoryDocumentEndpoint fileRepositoryDocumentEndpoint(Retrofit retrofit) {
        return retrofit.create(FileRepositoryDocumentEndpoint.class);
    }

    @Provides
    public StaffMemberPlanningEndpoint staffMemberPlanningEndpoint(Retrofit retrofit) {
        return retrofit.create(StaffMemberPlanningEndpoint.class);
    }

    @Provides
    public ReportingEndpoint reportingEndpoint(Retrofit retrofit) {
        return retrofit.create(ReportingEndpoint.class);
    }

    @Provides
    public TicketEndpoint ticketEndpoint(Retrofit retrofit) {
        return retrofit.create(TicketEndpoint.class);
    }

    @Provides
    public TicketMasterDataEndpoint ticketMasterDataEndpoint(Retrofit retrofit) {
        return retrofit.create(TicketMasterDataEndpoint.class);
    }

    @Provides
    public TicketActivityEndpoint ticketActivityEndpoint(Retrofit retrofit) {
        return retrofit.create(TicketActivityEndpoint.class);
    }

    @Provides
    public CustomerSpecificSettingsEndpoint customerSpecificSettingsEndpoint(Retrofit retrofit) {
        return retrofit.create(CustomerSpecificSettingsEndpoint.class);
    }

    @Provides
    public ERPEndpoint erpEndpoint(Retrofit retrofit) {
        return retrofit.create(ERPEndpoint.class);
    }

    @Provides
    public MaterialEndpoint materialEndpoint(Retrofit retrofit) {
        return retrofit.create(MaterialEndpoint.class);
    }

    @Provides
    public DocumentStateEndpoint documentStateEndpoint(Retrofit retrofit) { return retrofit.create(DocumentStateEndpoint.class); }

}
