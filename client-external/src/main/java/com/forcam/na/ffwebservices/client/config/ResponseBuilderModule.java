////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 24.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.config;

import com.forcam.na.ffwebservices.client.api.callback.CallbackResponseBuilder;
import com.forcam.na.ffwebservices.client.api.callback.ICallbackResponseBuilder;
import com.forcam.na.ffwebservices.client.api.device.DeviceResponseBuilder;
import com.forcam.na.ffwebservices.client.api.device.IDeviceResponseBuilder;
import com.forcam.na.ffwebservices.client.api.entrypoint.EntryPointResponseBuilder;
import com.forcam.na.ffwebservices.client.api.entrypoint.IEntryPointResponseBuilder;
import com.forcam.na.ffwebservices.client.api.erpcontext.ErpContextResponseBuilder;
import com.forcam.na.ffwebservices.client.api.erpcontext.IErpContextResponseBuilder;
import com.forcam.na.ffwebservices.client.api.literal.ILiteralResponseBuilder;
import com.forcam.na.ffwebservices.client.api.literal.LiteralResponseBuilder;
import com.forcam.na.ffwebservices.client.api.machine.IMachineResponseBuilder;
import com.forcam.na.ffwebservices.client.api.machine.MachineResponseBuilder;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.IMachineStateDetailResponseBuilder;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.MachineStateDetailResponseBuilder;
import com.forcam.na.ffwebservices.client.api.material.IMaterialResponseBuilder;
import com.forcam.na.ffwebservices.client.api.material.MaterialResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.IOperationProductionResourceToolResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.IOperationQuantitySummaryResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.IOperationResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.IOperationScheduledDatesResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.IOperationSpecificationResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.OperationProductionResourceToolResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.OperationQuantitySummaryResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.OperationResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.OperationScheduledDatesResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.OperationSpecificationResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.IPlanningScenarioResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.PlanningScenarioResponseBuilder;
import com.forcam.na.ffwebservices.client.api.order.IProductionOrderResponseBuilder;
import com.forcam.na.ffwebservices.client.api.order.ProductionOrderResponseBuilder;
import com.forcam.na.ffwebservices.client.api.pdm.FileRepositoryResponseBuilder;
import com.forcam.na.ffwebservices.client.api.pdm.IFileRepositoryResponseBuilder;
import com.forcam.na.ffwebservices.client.api.qualitydetail.IQualityDetailResponseBuilder;
import com.forcam.na.ffwebservices.client.api.qualitydetail.QualityDetailResponseBuilder;
import com.forcam.na.ffwebservices.client.api.qualitytype.IQualityTypeResponseBuilder;
import com.forcam.na.ffwebservices.client.api.qualitytype.QualityTypeResponseBuilder;
import com.forcam.na.ffwebservices.client.api.recordedoperatingstate.IRecordedOperatingStateResponseBuilder;
import com.forcam.na.ffwebservices.client.api.recordedoperatingstate.RecordedOperatingStateResponseBuilder;
import com.forcam.na.ffwebservices.client.api.reporting.IReportingResponseBuilder;
import com.forcam.na.ffwebservices.client.api.reporting.ReportingResponseBuilder;
import com.forcam.na.ffwebservices.client.api.shift.IWorkplaceShiftResponseBuilder;
import com.forcam.na.ffwebservices.client.api.shift.WorkplaceShiftResponseBuilder;
import com.forcam.na.ffwebservices.client.api.shifttype.IShiftTypeResponseBuilder;
import com.forcam.na.ffwebservices.client.api.shifttype.ShiftTypeResponseBuilder;
import com.forcam.na.ffwebservices.client.api.specificsettings.CustomerSpecificSettingsResponseBuilder;
import com.forcam.na.ffwebservices.client.api.specificsettings.ICustomerSpecificSettingsResponseBuilder;
import com.forcam.na.ffwebservices.client.api.staffmember.IStaffMemberResponseBuilder;
import com.forcam.na.ffwebservices.client.api.staffmember.StaffMemberResponseBuilder;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.IStaffMemberPlanningResponseBuilder;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.StaffMemberPlanningResponseBuilder;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketActivityResponseBuilder;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketMasterDataResponseBuilder;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketResponseBuilder;
import com.forcam.na.ffwebservices.client.api.ticket.TicketActivityResponseBuilder;
import com.forcam.na.ffwebservices.client.api.ticket.TicketMasterDataResponseBuilder;
import com.forcam.na.ffwebservices.client.api.ticket.TicketResponseBuilder;
import com.forcam.na.ffwebservices.client.api.tool.CharacteristicResponseBuilder;
import com.forcam.na.ffwebservices.client.api.tool.ICharacteristicResponseBuilder;
import com.forcam.na.ffwebservices.client.api.tool.IToolEdgeResponseBuilder;
import com.forcam.na.ffwebservices.client.api.tool.IToolLocationResponseBuilder;
import com.forcam.na.ffwebservices.client.api.tool.IToolResponseBuilder;
import com.forcam.na.ffwebservices.client.api.tool.ToolEdgeResponseBuilder;
import com.forcam.na.ffwebservices.client.api.tool.ToolLocationResponseBuilder;
import com.forcam.na.ffwebservices.client.api.tool.ToolResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceOperatingStateSummaryResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceQuantitySummaryResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceOperatingStateSummaryResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceQuantitySummaryResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplacegroup.IWorkplaceGroupResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplacegroup.WorkplaceGroupResponseBuilder;
import com.forcam.na.ffwebservices.client.api.masterdata.document.builder.DocumentStateResponseBuilder;
import com.forcam.na.ffwebservices.client.api.masterdata.document.builder.IDocumentStateResponseBuilder;
import com.forcam.na.ffwebservices.client.statusdefinition.IOperatingStateResponseBuilder;
import com.forcam.na.ffwebservices.client.statusdefinition.IStatusDefinitionResponseBuilder;
import com.forcam.na.ffwebservices.client.statusdefinition.OperatingStateResponseBuilder;
import com.forcam.na.ffwebservices.client.statusdefinition.StatusDefinitionResponseBuilder;
import dagger.Module;
import dagger.Provides;

/**
 * The response builder module.
 */
@Module
public class ResponseBuilderModule {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Provides
    public IWorkplaceResponseBuilder workplaceResponseBuilder(WorkplaceResponseBuilder workplaceResponseBuilder) {
        return workplaceResponseBuilder;
    }

    @Provides
    public IWorkplaceShiftResponseBuilder workplaceShiftResponseBuilder(WorkplaceShiftResponseBuilder workplaceShiftResponseBuilder) {
        return workplaceShiftResponseBuilder;
    }

    @Provides
    public IShiftTypeResponseBuilder shiftTypeResponseBuilder(ShiftTypeResponseBuilder shiftTypeResponseBuilder) {
        return shiftTypeResponseBuilder;
    }

    @Provides
    public IOperationResponseBuilder operationResponseBuilder(OperationResponseBuilder operationResponseBuilder) {
        return operationResponseBuilder;
    }

    @Provides
    public IStatusDefinitionResponseBuilder statusDefinitionResponesBuilder(StatusDefinitionResponseBuilder statusDefinitionResponseBuilder) {
        return statusDefinitionResponseBuilder;
    }

    @Provides
    public IQualityDetailResponseBuilder qualityDetailResponseBuilder(QualityDetailResponseBuilder qualityDetailResponseBuilder) {
        return qualityDetailResponseBuilder;
    }

    @Provides
    public IMachineStateDetailResponseBuilder machineStateDetailResponseBuilder(MachineStateDetailResponseBuilder machineStateDetailResponseBuilder) {
        return machineStateDetailResponseBuilder;
    }

    @Provides
    public IMachineResponseBuilder machineResponseBuilder(MachineResponseBuilder machineResponseBuilder) {
        return machineResponseBuilder;
    }

    @Provides
    public IOperationScheduledDatesResponseBuilder operationScheduledDatesResponseBuilder(
        OperationScheduledDatesResponseBuilder operationScheduledDatesResponseBuilder) {
        return operationScheduledDatesResponseBuilder;
    }

    @Provides
    public IOperationSpecificationResponseBuilder operationSpecificationResponseBuilder(
        OperationSpecificationResponseBuilder operationSpecificationResponseBuilder) {
        return operationSpecificationResponseBuilder;
    }

    @Provides
    public IOperationProductionResourceToolResponseBuilder operationProductionResourceToolResponseBuilder(
        OperationProductionResourceToolResponseBuilder operationProductionResourceToolResponseBuilder) {
        return operationProductionResourceToolResponseBuilder;
    }

    @Provides
    public IRecordedOperatingStateResponseBuilder recordedOperatingStateResponseBuilder(
        RecordedOperatingStateResponseBuilder recordedOperatingStateResponseBuilder) {
        return recordedOperatingStateResponseBuilder;
    }

    @Provides
    public IOperationQuantitySummaryResponseBuilder operationQuantitySummaryResponseBuilde(
        OperationQuantitySummaryResponseBuilder operationQuantitySummaryResponseBuilder) {
        return operationQuantitySummaryResponseBuilder;
    }

    @Provides
    public IProductionOrderResponseBuilder productionOrderResponseBuilder(ProductionOrderResponseBuilder productionOrderResponseBuilder) {
        return productionOrderResponseBuilder;
    }

    @Provides
    public IStaffMemberResponseBuilder staffMemberResponseBuilder(StaffMemberResponseBuilder staffMemberResponseBuilder) {
        return staffMemberResponseBuilder;
    }

    @Provides
    public IErpContextResponseBuilder erpContextResponseBuilder(ErpContextResponseBuilder erpContextResponseBuilder) {
        return erpContextResponseBuilder;
    }

    @Provides
    public ILiteralResponseBuilder literalResponseBuilder(LiteralResponseBuilder literalResponseBuilder) {
        return literalResponseBuilder;
    }

    @Provides
    public IToolResponseBuilder toolResponseBuilder(ToolResponseBuilder toolResponseBuilder) {
        return toolResponseBuilder;
    }

    @Provides
    public ICharacteristicResponseBuilder characteristicResponseBuilder(CharacteristicResponseBuilder characteristicResponseBuilder) {
        return characteristicResponseBuilder;
    }

    @Provides
    public IToolEdgeResponseBuilder toolEdgeResponseBuilder(ToolEdgeResponseBuilder toolEdgeResponseBuilder) {
        return toolEdgeResponseBuilder;
    }

    @Provides
    public IToolLocationResponseBuilder toolLocationResponseBuilder(ToolLocationResponseBuilder toolLocationResponseBuilder) {
        return toolLocationResponseBuilder;
    }

    @Provides
    public IOperatingStateResponseBuilder operatingStateResponseBuilder(OperatingStateResponseBuilder operatingStateResponseBuilder) {
        return operatingStateResponseBuilder;
    }

    @Provides
    public IQualityTypeResponseBuilder qualityTypeResponseBuilder(QualityTypeResponseBuilder qualityTypeResponseBuilder) {
        return qualityTypeResponseBuilder;
    }

    @Provides
    public IEntryPointResponseBuilder entryPointResponseBuilder(EntryPointResponseBuilder entryPointResponseBuilder) {
        return entryPointResponseBuilder;
    }

    @Provides
    public IWorkplaceQuantitySummaryResponseBuilder workplaceQuantitySummaryResponseBuilder(
        WorkplaceQuantitySummaryResponseBuilder workplaceQuantitySummaryResponseBuilder) {
        return workplaceQuantitySummaryResponseBuilder;
    }

    @Provides
    public IWorkplaceGroupResponseBuilder workplaceGroupResponseBuilder(WorkplaceGroupResponseBuilder workplaceGroupResponseBuilder) {
        return workplaceGroupResponseBuilder;
    }

    @Provides
    public IWorkplaceOperatingStateSummaryResponseBuilder workplaceOperatingStateSummaryResponseBuilder(
        WorkplaceOperatingStateSummaryResponseBuilder workplaceOperatingStateSummaryResponseBuilder) {
        return workplaceOperatingStateSummaryResponseBuilder;
    }

    @Provides
    public IPlanningScenarioResponseBuilder planningScenarioResponseBuilder(PlanningScenarioResponseBuilder planningScenarioResponseBuilder) {
        return planningScenarioResponseBuilder;
    }

    @Provides
    public IDeviceResponseBuilder deviceResponseBuilder(DeviceResponseBuilder deviceResponseBuilder) {
        return deviceResponseBuilder;
    }

    @Provides
    public ICallbackResponseBuilder callbackResponseBuilder(CallbackResponseBuilder callbackResponseBuilder) {
        return callbackResponseBuilder;
    }

    @Provides
    public IFileRepositoryResponseBuilder fileRepositoryResponseBuilder(FileRepositoryResponseBuilder fileRepositoryResponseBuilder) {
        return fileRepositoryResponseBuilder;
    }

    @Provides
    public IStaffMemberPlanningResponseBuilder staffMemberPlanningResponseBuilder(StaffMemberPlanningResponseBuilder staffMemberPlanningResponseBuilder) {
        return staffMemberPlanningResponseBuilder;
    }

    @Provides
    public IReportingResponseBuilder reportingResponseBuilder(ReportingResponseBuilder reportingResponseBuilder) {
        return reportingResponseBuilder;
    }

    @Provides
    public ITicketResponseBuilder ticketResponseBuilder(TicketResponseBuilder ticketResponseBuilder) {
        return ticketResponseBuilder;
    }

    @Provides
    public ITicketMasterDataResponseBuilder ticketMasterDataResponseBuilder(
        TicketMasterDataResponseBuilder ticketMasterDataResponseBuilder) {return ticketMasterDataResponseBuilder; }

    @Provides
    public ITicketActivityResponseBuilder ticketActivityResponseBuilder(TicketActivityResponseBuilder ticketActivityResponseBuilder) {
        return ticketActivityResponseBuilder;
    }

    @Provides
    public ICustomerSpecificSettingsResponseBuilder customerSpecificSettingsResponseBuilder(
        CustomerSpecificSettingsResponseBuilder customerSpecificSettingsResponseBuilder) {
        return customerSpecificSettingsResponseBuilder;
    }

    @Provides
    public IMaterialResponseBuilder materialResponseBuilder(MaterialResponseBuilder materialResponseBuilder) {
        return materialResponseBuilder;
    }

    @Provides
    public IDocumentStateResponseBuilder documentStateResponseBuilder(DocumentStateResponseBuilder documentStateResponseBuilder) {
        return documentStateResponseBuilder;
    }

}
