////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.erpcontext.ERPContextLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.operation.request.*;
import com.forcam.na.ffwebservices.client.api.operation.response.*;
import com.forcam.na.ffwebservices.client.api.order.OrderLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.order.ProductionOrderSpecificationLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.workplacegroup.WorkplaceGroupLinkModelBuilder;
import com.forcam.na.ffwebservices.client.statusdefinition.StatusDefinitionLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operatingstate.OperatingStateSummaryPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operatingstate.OperationPhaseCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationComponentCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationComponentsEmbed;
import com.forcam.na.ffwebservices.model.operation.OperationEmbed;
import com.forcam.na.ffwebservices.model.operation.OperationManufacturingVariantsPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationResponse;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationUserFieldEmbed;
import com.forcam.na.ffwebservices.model.operation.ProductionResourceToolPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.UserFieldCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.OrderPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSpecificationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.recordedoutputquantities.RecordedOutputQuantitiesCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupPropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for operations.
 */
public class OperationResponseBuilder extends AbstractResponseBuilder implements IOperationResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the erp context. */
    private final ERPContextLinkModelBuilder mERPContextLinkModelBuilder;

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /** The link model builder of the order. */
    private final OrderLinkModelBuilder mOrderLinkModelBuilder;

    /** Operation link model builder. */
    private final OperationLinkModelBuilder mOperationLinkModelBuilder;

    /** The link model builder of the workplace. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    /** The link model builder of the operation planning result. */
    private final OperationPlanningResultLinkModelBuilder mOperationPlanningResultLinkModelBuilder;

    /** The link model builder of the operation phase. */
    private final StatusDefinitionLinkModelBuilder mStatusDefinitionLinkModelBuilder;

    /** The link model builder of the workplace group. */
    private final WorkplaceGroupLinkModelBuilder mWorkplaceGroupLinkModelBuilder;

    /** The link model builder of the operation specification. */
    private final OperationSpecificationLinkModelBuilder mOperationSpecificationLinkModelBuilder;

    /** The link model builder of the operation scheduled dates. */
    private final OperationScheduledDatesLinkModelBuilder mOperationScheduledDatesLinkModelBuilder;

    /** The link model builder of the production resources and tools. */
    private final ProductionResourceToolLinkModelBuilder mProductionResourceToolLinkModelBuilder;

    /** The link model builder of the operation forecast result. */
    private final OperationForecastResultLinkModelBuilder mOperationForecastResultLinkModelBuilder;

    /** The link model builder of the operation manufacturing variants. */
    private final OperationManufacturingVariantsLinkModelBuilder mOperationManufacturingVariantsLinkModelBuilder;

    private final OperationQuantitySummaryLinkModelBuilder mOperationQuantitySummaryLinkModelBuilder;

    private final ProductionOrderSpecificationLinkModelBuilder mProductionOrderSpecificationLinkModelBuilder;

    /** The link model builder of the operation components. */
    private final OperationComponentsLinkModelBuilder mOperationComponentsLinkModelBuilder;

    /** The link model builder of the operation user fields. */
    private final OperationUserFieldsLinkModelBuilder mOperationUserFieldsLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public OperationResponseBuilder(ERPContextLinkModelBuilder erpContextLinkModelBuilder, LiteralLinkModelBuilder literalLinkModelBuilder,
                                    OrderLinkModelBuilder orderLinkModelBuilder, OperationLinkModelBuilder operationLinkModelBuilder,
                                    WorkplaceLinkModelBuilder workplaceLinkModelBuilder,
                                    OperationPlanningResultLinkModelBuilder operationPlanningResultLinkModelBuilder,
                                    StatusDefinitionLinkModelBuilder statusDefinitionLinkModelBuilder,
                                    WorkplaceGroupLinkModelBuilder workplaceGroupLinkModelBuilder,
                                    OperationSpecificationLinkModelBuilder operationSpecificationLinkModelBuilder,
                                    OperationScheduledDatesLinkModelBuilder operationScheduledDatesLinkModelBuilder,
                                    ProductionResourceToolLinkModelBuilder productionResourceToolLinkModelBuilder,
                                    OperationForecastResultLinkModelBuilder operationForecastResultLinkModelBuilder,
                                    OperationManufacturingVariantsLinkModelBuilder operationManufacturingVariantsLinkModelBuilder,
                                    OperationQuantitySummaryLinkModelBuilder operationQuantitySummaryLinkModelBuilder,
                                    ProductionOrderSpecificationLinkModelBuilder productionOrderSpecificationLinkModelBuilder,
                                    OperationUserFieldsLinkModelBuilder operationUserFieldsLinkModelBuilder,
                                    OperationComponentsLinkModelBuilder operationComponentsLinkModelBuilder) {
        mERPContextLinkModelBuilder = erpContextLinkModelBuilder;
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
        mOrderLinkModelBuilder = orderLinkModelBuilder;
        mOperationLinkModelBuilder = operationLinkModelBuilder;
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
        mOperationPlanningResultLinkModelBuilder = operationPlanningResultLinkModelBuilder;
        mStatusDefinitionLinkModelBuilder = statusDefinitionLinkModelBuilder;
        mWorkplaceGroupLinkModelBuilder = workplaceGroupLinkModelBuilder;
        mOperationSpecificationLinkModelBuilder = operationSpecificationLinkModelBuilder;
        mOperationScheduledDatesLinkModelBuilder = operationScheduledDatesLinkModelBuilder;
        mProductionResourceToolLinkModelBuilder = productionResourceToolLinkModelBuilder;
        mOperationForecastResultLinkModelBuilder = operationForecastResultLinkModelBuilder;
        mOperationManufacturingVariantsLinkModelBuilder = operationManufacturingVariantsLinkModelBuilder;
        mOperationQuantitySummaryLinkModelBuilder = operationQuantitySummaryLinkModelBuilder;
        mProductionOrderSpecificationLinkModelBuilder = productionOrderSpecificationLinkModelBuilder;
        mOperationComponentsLinkModelBuilder = operationComponentsLinkModelBuilder;
        mOperationUserFieldsLinkModelBuilder = operationUserFieldsLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<OperationResponse> getOperationCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<OperationResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> operations = embedded.get("operations");

        final List<OperationResponse> operationModels = operations
            .stream()
            .map(this::getOperationResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(operationModels);
        return collectionResponse;
    }

    @Override
    public OperationResponse getOperationResponse(HALWSModel serverModel) {
        final OperationResponse operationModel = new OperationResponse();
        operationModel.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        operationModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext = mERPContextLinkModelBuilder.buildLinkModel(serverModel, OperationEmbed.ERP_CONTEXT);
        operationModel.setErpContext(erpContext);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, OperationEmbed.DESCRIPTION);
        operationModel.setDescription(description);

        final LinkEmbeddedWSModel<OrderPropertiesWSModel> order = mOrderLinkModelBuilder.buildLinkModel(serverModel, OperationEmbed.ORDER);
        operationModel.setOrder(order);

        final LinkEmbeddedWSModel<OperationAssignmentWSModel> planningResult = mOperationPlanningResultLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                       OperationEmbed.PLANNING_RESULT);
        operationModel.setPlanningResult(planningResult);

        final LinkEmbeddedWSModel<WorkplacePropertiesWSModel> targetWorkplace = mWorkplaceLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                          OperationEmbed.TARGET_WORKPLACE);
        operationModel.setTargetWorkplace(targetWorkplace);

        final LinkEmbeddedWSModel<WorkplacePropertiesWSModel> plannedWorkplace = mWorkplaceLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                           OperationEmbed.PLANNED_WORKPLACE);
        operationModel.setPlannedWorkplace(plannedWorkplace);

        final LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> operationPhase = mStatusDefinitionLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                       OperationEmbed.OPERATION_PHASE);
        operationModel.setOperationPhase(operationPhase);

        final LinkEmbeddedWSModel<WorkplaceGroupPropertiesWSModel> targetCapacityGroup = mWorkplaceGroupLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                        OperationEmbed.TARGET_CAPACITY_GROUP);
        operationModel.setTargetCapacityGroup(targetCapacityGroup);

        final LinkEmbeddedWSModel<WorkplaceGroupPropertiesWSModel> plannedCapacityGroup = mWorkplaceGroupLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                         OperationEmbed.PLANNED_CAPACITY_GROUP);
        operationModel.setPlannedCapacityGroup(plannedCapacityGroup);

        final LinkEmbeddedWSModel<OperationSpecificationPropertiesWSModel> specification = mOperationSpecificationLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                                  OperationEmbed.SPECIFICATION);
        operationModel.setSpecification(specification);

        final LinkEmbeddedWSModel<OperationScheduledDatesPropertiesWSModel> scheduledDates = mOperationScheduledDatesLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                                     OperationEmbed.SCHEDULED_DATES);
        operationModel.setScheduledDates(scheduledDates);

        final LinkEmbeddedWSModel<OperationAssignmentWSModel> forecastResult = mOperationForecastResultLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                       OperationEmbed.FORECAST_RESULT);
        operationModel.setForecastResult(forecastResult);

        final LinkEmbeddedWSModel<OperationManufacturingVariantsPropertiesWSModel> manufacturingVariants = mOperationManufacturingVariantsLinkModelBuilder.buildLinkModel(
            serverModel,
            OperationEmbed.MANUFACTURING_VARIANTS);
        operationModel.setManufacturingVariants(manufacturingVariants);

        final LinkEmbeddedWSModel<ProductionResourceToolPropertiesWSModel> productionResourcesAndTools = mProductionResourceToolLinkModelBuilder.buildLinkModel(
            serverModel,
            OperationEmbed.PRODUCTION_RESOURCES_AND_TOOLS);
        operationModel.setProductionResourcesAndTools(productionResourcesAndTools);

        final LinkEmbeddedWSModel<OperationQuantitySummaryCollectionPropertiesWSModel> quantitySummaryCollection = mOperationQuantitySummaryLinkModelBuilder.buildLinkModel(
            serverModel,
            OperationEmbed.QUANTITY_SUMMARY);
        operationModel.setQuantitySummary(quantitySummaryCollection);

        final LinkEmbeddedWSModel<ProductionOrderSpecificationPropertiesWSModel> orderSpecification = mProductionOrderSpecificationLinkModelBuilder.buildLinkModel(
            serverModel,
            OperationEmbed.PRODUCTION_ORDER_SPECIFICATION);
        operationModel.setProductionOrderSpecification(orderSpecification);

        final LinkEmbeddedWSModel<OperationComponentCollectionPropertiesWSModel> components = mOperationComponentsLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                                  OperationEmbed.COMPONENTS);
        operationModel.setComponents(components);

        final LinkEmbeddedWSModel<UserFieldCollectionPropertiesWSModel> userFields = mOperationUserFieldsLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                         OperationEmbed.USER_FIELDS);
        operationModel.setUserFields(userFields);

        final LinkEmbeddedWSModel<List<WorkplacePropertiesWSModel>> alternativeWorkplaces = mWorkplaceLinkModelBuilder.buildLinkToCollectionModel(serverModel,
                                                                                                                                                  OperationEmbed.ALTERNATIVE_WORKPLACES);
        operationModel.setAlternativeWorkplaces(alternativeWorkplaces);

        return operationModel;
    }

    @Override
    public OperationUserFieldCollectionResponse getOperationUserFieldCollectionResponse(GetOperationUserFieldsRequest request, HALWSModel collectionWSModel) {
        final OperationUserFieldCollectionResponse operationUserFieldCollectionResponse = new OperationUserFieldCollectionResponse(request);
        operationUserFieldCollectionResponse.setProperties(mMapper.convertValue(collectionWSModel.getProperties(), UserFieldCollectionPropertiesWSModel.class));

        final LinkEmbeddedWSModel<OperationPropertiesWSModel> operation = mOperationLinkModelBuilder.buildLinkModel(collectionWSModel,
                                                                                                                    OperationUserFieldEmbed.OPERATION);
        operationUserFieldCollectionResponse.setOperation(operation);
        operationUserFieldCollectionResponse.setPagination(collectionWSModel.getPagination());
        operationUserFieldCollectionResponse.setPaginationLinks(collectionWSModel.getLinkModels());

        return operationUserFieldCollectionResponse;
    }

    @Override
    public OperationComponentCollectionResponse getOperationComponentCollectionResponse(GetOperationComponentsRequest request, HALWSModel model) {
        final OperationComponentCollectionResponse collectionResponse = new OperationComponentCollectionResponse(request);
        collectionResponse.setProperties(mMapper.convertValue(model.getProperties(), OperationComponentCollectionPropertiesWSModel.class));

        final LinkEmbeddedWSModel<OperationPropertiesWSModel> operation = mOperationLinkModelBuilder.buildLinkModel(model, OperationComponentsEmbed.OPERATION);
        collectionResponse.setOperation(operation);
        collectionResponse.setPagination(model.getPagination());
        collectionResponse.setPaginationLinks(model.getLinkModels());

        return collectionResponse;
    }

    @Override
    public OperationManufacturingVariantsResponse getOperationManufacturingVariantsResponse(HALWSModel serverModel) {
        final OperationManufacturingVariantsResponse response = new OperationManufacturingVariantsResponse();
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationManufacturingVariantsPropertiesWSModel.class));
        response.setSelf(this.createSelfLinkModel(serverModel));

        return response;
    }

    @Override
    public OperationOperatingStateSummaryResponse getOperationOperatingStateSummaryResponse(GetOperationOperatingStateSummaryRequest request,
                                                                                            HALWSModel serverModel) {
        final OperationOperatingStateSummaryResponse response = new OperationOperatingStateSummaryResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), OperatingStateSummaryPropertiesWSModel.class));

        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());

        return response;
    }

    @Override
    public OperationRecordedOperationPhasesResponse getOperationRecordedOperationPhasesResponse(GetOperationRecordedOperationPhasesRequest request,
                                                                                                HALWSModel serverModel) {
        final OperationRecordedOperationPhasesResponse response = new OperationRecordedOperationPhasesResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationPhaseCollectionPropertiesWSModel.class));

        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());

        return response;
    }

    @Override
    public OperationRecordedOutputQuantitiesResponse getOperationRecordedOutputQuantitiesResponse(GetOperationRecordedOutputQuantitiesRequest request,
                                                                                                  HALWSModel serverModel) {
        final OperationRecordedOutputQuantitiesResponse response = new OperationRecordedOutputQuantitiesResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), RecordedOutputQuantitiesCollectionPropertiesWSModel.class));

        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());

        return response;
    }
}
