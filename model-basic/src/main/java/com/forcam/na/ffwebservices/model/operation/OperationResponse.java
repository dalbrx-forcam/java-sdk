package com.forcam.na.ffwebservices.model.operation;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.OrderPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderSpecificationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupPropertiesWSModel;

import java.util.List;

public class OperationResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the operation. */
    private OperationPropertiesWSModel mProperties;

    /** The embedded ERP context. */
    private LinkEmbeddedWSModel<ErpContextPropertiesWSModel> mErpContext;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded order. */
    private LinkEmbeddedWSModel<OrderPropertiesWSModel> mOrder;

    /** The embedded planning result. */
    private LinkEmbeddedWSModel<OperationAssignmentWSModel> mPlanningResult;

    /** The embedded operation phase. */
    private LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> mOperationPhase;

    /** The embedded target workplace. */
    private LinkEmbeddedWSModel<WorkplacePropertiesWSModel> mTargetWorkplace;

    /** The embedded planned workplace. */
    private LinkEmbeddedWSModel<WorkplacePropertiesWSModel> mPlannedWorkplace;

    /** The embedded specification. */
    private LinkEmbeddedWSModel<OperationSpecificationPropertiesWSModel> mSpecification;

    /** The embedded production resources and tools. */
    private LinkEmbeddedWSModel<ProductionResourceToolPropertiesWSModel> mProductionResourcesAndTools;

    /** The embedded scheduled dates. */
    private LinkEmbeddedWSModel<OperationScheduledDatesPropertiesWSModel> mScheduledDates;

    /** The embedded taret capacity group. */
    private LinkEmbeddedWSModel<WorkplaceGroupPropertiesWSModel> mTargetCapacityGroup;

    /** The embedded planned capacity group. */
    private LinkEmbeddedWSModel<WorkplaceGroupPropertiesWSModel> mPlannedCapacityGroup;

    /** The embedded forecast result, */
    private LinkEmbeddedWSModel<OperationAssignmentWSModel> mForecastResult;

    /** The embedded manufacturing variants. */
    private LinkEmbeddedWSModel<OperationManufacturingVariantsPropertiesWSModel> mManufacturingVariants;

    /** The embedded quantity summary. */
    private LinkEmbeddedWSModel<OperationQuantitySummaryCollectionPropertiesWSModel> mQuantitySummary;

    /** The embedded production order specification. */
    private LinkEmbeddedWSModel<ProductionOrderSpecificationPropertiesWSModel> mProductionOrderSpecification;

    /** The embedded operation components. */
    private LinkEmbeddedWSModel<OperationComponentCollectionPropertiesWSModel> mComponents;

    /** The embedded operation user fields. */
    private LinkEmbeddedWSModel<UserFieldCollectionPropertiesWSModel> mUserFields;

    /** The embedded alternative workplaces. */
    private LinkEmbeddedWSModel<List<WorkplacePropertiesWSModel>> mAlternativeWorkplaces;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(OperationPropertiesWSModel properties) {
        this.mProperties = properties;
    }

    public LinkEmbeddedWSModel<ErpContextPropertiesWSModel> getErpContext() {
        return mErpContext;
    }

    public void setErpContext(LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext) {
        mErpContext = erpContext;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    public LinkEmbeddedWSModel<OrderPropertiesWSModel> getOrder() {
        return mOrder;
    }

    public void setOrder(LinkEmbeddedWSModel<OrderPropertiesWSModel> order) {
        mOrder = order;
    }

    public LinkEmbeddedWSModel<OperationAssignmentWSModel> getPlanningResult() {
        return mPlanningResult;
    }

    public void setPlanningResult(LinkEmbeddedWSModel<OperationAssignmentWSModel> planningResult) {
        mPlanningResult = planningResult;
    }

    public LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> getOperationPhase() {
        return mOperationPhase;
    }

    public void setOperationPhase(LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> operationPhase) {
        mOperationPhase = operationPhase;
    }

    public LinkEmbeddedWSModel<WorkplacePropertiesWSModel> getTargetWorkplace() {
        return mTargetWorkplace;
    }

    public void setTargetWorkplace(LinkEmbeddedWSModel<WorkplacePropertiesWSModel> targetWorkplace) {
        mTargetWorkplace = targetWorkplace;
    }

    public LinkEmbeddedWSModel<WorkplacePropertiesWSModel> getPlannedWorkplace() {
        return mPlannedWorkplace;
    }

    public void setPlannedWorkplace(LinkEmbeddedWSModel<WorkplacePropertiesWSModel> plannedWorkplace) {
        mPlannedWorkplace = plannedWorkplace;
    }

    public LinkEmbeddedWSModel<OperationSpecificationPropertiesWSModel> getSpecification() {
        return mSpecification;
    }

    public void setSpecification(LinkEmbeddedWSModel<OperationSpecificationPropertiesWSModel> specification) {
        mSpecification = specification;
    }

    public LinkEmbeddedWSModel<ProductionResourceToolPropertiesWSModel> getProductionResourcesAndTools() {
        return mProductionResourcesAndTools;
    }

    public void setProductionResourcesAndTools(LinkEmbeddedWSModel<ProductionResourceToolPropertiesWSModel> productionResourcesAndTools) {
        mProductionResourcesAndTools = productionResourcesAndTools;
    }

    public LinkEmbeddedWSModel<OperationScheduledDatesPropertiesWSModel> getScheduledDates() {
        return mScheduledDates;
    }

    public void setScheduledDates(LinkEmbeddedWSModel<OperationScheduledDatesPropertiesWSModel> scheduledDates) {
        mScheduledDates = scheduledDates;
    }

    public LinkEmbeddedWSModel<WorkplaceGroupPropertiesWSModel> getTargetCapacityGroup() {
        return mTargetCapacityGroup;
    }

    public void setTargetCapacityGroup(LinkEmbeddedWSModel<WorkplaceGroupPropertiesWSModel> targetCapacityGroup) {
        mTargetCapacityGroup = targetCapacityGroup;
    }

    public LinkEmbeddedWSModel<WorkplaceGroupPropertiesWSModel> getPlannedCapacityGroup() {
        return mPlannedCapacityGroup;
    }

    public void setPlannedCapacityGroup(LinkEmbeddedWSModel<WorkplaceGroupPropertiesWSModel> plannedCapacityGroup) {
        mPlannedCapacityGroup = plannedCapacityGroup;
    }

    /**
     * Provides the embedded forecast result.
     *
     * @return The embedded forecast result.
     */
    public LinkEmbeddedWSModel<OperationAssignmentWSModel> getForecastResult() {
        return mForecastResult;
    }

    /**
     * Sets the embedded forecast result.
     *
     * @param forecastResult The embedded forecast result.
     */
    public void setForecastResult(LinkEmbeddedWSModel<OperationAssignmentWSModel> forecastResult) {
        mForecastResult = forecastResult;
    }

    /**
     * Provides the embedded predicted values.
     *
     * @return The embedded predicted values.
     */
    public LinkEmbeddedWSModel<OperationManufacturingVariantsPropertiesWSModel> getManufacturingVariants() {
        return mManufacturingVariants;
    }

    /**
     * Sets the embedded manufacturing variants.
     *
     * @param manufacturingVariants The embedded manufacturing variants.
     */
    public void setManufacturingVariants(LinkEmbeddedWSModel<OperationManufacturingVariantsPropertiesWSModel> manufacturingVariants) {
        mManufacturingVariants = manufacturingVariants;
    }

    public void setQuantitySummary(LinkEmbeddedWSModel<OperationQuantitySummaryCollectionPropertiesWSModel> quantitySummary) {
        mQuantitySummary = quantitySummary;
    }

    public LinkEmbeddedWSModel<OperationQuantitySummaryCollectionPropertiesWSModel> getQuantitySummary() {
        return mQuantitySummary;
    }

    public void setProductionOrderSpecification(LinkEmbeddedWSModel<ProductionOrderSpecificationPropertiesWSModel> productionOrderSpecification) {
        mProductionOrderSpecification = productionOrderSpecification;
    }

    public LinkEmbeddedWSModel<ProductionOrderSpecificationPropertiesWSModel> getProductionOrderSpecification() {
        return mProductionOrderSpecification;
    }

    public LinkEmbeddedWSModel<OperationComponentCollectionPropertiesWSModel> getComponents() {
        return mComponents;
    }

    public void setComponents(LinkEmbeddedWSModel<OperationComponentCollectionPropertiesWSModel> components) {
        mComponents = components;
    }

    public LinkEmbeddedWSModel<UserFieldCollectionPropertiesWSModel> getUserFields() {
        return mUserFields;
    }

    public void setUserFields(LinkEmbeddedWSModel<UserFieldCollectionPropertiesWSModel> userFields) {
        mUserFields = userFields;
    }

    public LinkEmbeddedWSModel<List<WorkplacePropertiesWSModel>> getAlternativeWorkplaces() {
        return mAlternativeWorkplaces;
    }

    public void setAlternativeWorkplaces(LinkEmbeddedWSModel<List<WorkplacePropertiesWSModel>> alternativeWorkplaces) {
        mAlternativeWorkplaces = alternativeWorkplaces;
    }
}
