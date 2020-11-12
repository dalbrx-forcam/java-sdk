////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class OperationEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for ERP context. */
    public static String ERP_CONTEXT = "erpContext";

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for order. */
    public static String ORDER = "productionOrder";

    /** Constant string for planning result. */
    public static final String PLANNING_RESULT = "planningResult";

    /** Constant string for operation phase. */
    public static final String OPERATION_PHASE = "operationPhase";

    /** Constant string for target workplace. */
    public static final String TARGET_WORKPLACE = "targetWorkplace";

    /** Constant string for target capacity group. */
    public static final String TARGET_CAPACITY_GROUP = "targetCapacityGroup";

    /** Constant string for planned workplace. */
    public static final String PLANNED_WORKPLACE = "plannedWorkplace";

    /** Constant string for planned capacity group. */
    public static final String PLANNED_CAPACITY_GROUP = "plannedCapacityGroup";

    /** Constant string for specification. */
    public static final String SPECIFICATION = "specification";

    /** Constant string for scheduled dates. */
    public static final String SCHEDULED_DATES = "scheduledDates";

    /** Constant string for production resources and tools. */
    public static final String PRODUCTION_RESOURCES_AND_TOOLS = "productionResourcesAndTools";

    /** Constant string for forecast result. */
    public static final String FORECAST_RESULT = "forecastResult";

    /** Constant string for manufacturing variants. */
    public static final String MANUFACTURING_VARIANTS = "manufacturingVariants";

    public static final String QUANTITY_SUMMARY = "quanitySummary";

    public static final String PRODUCTION_ORDER_SPECIFICATION = "productionOrderSpecification";

    /** Constant string for operation components. */
    public static final String COMPONENTS = "components";

    /** Constant string for operation user fields. */
    public static final String USER_FIELDS = "userFields";

    /** Constant string for alternative workplaces. */
    public static final String ALTERNATIVE_WORKPLACES = "alternativeWorkplaces";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should ERP context be embedded? */
    private boolean mERPContext;

    /** Should description be embedded? */
    private boolean mDescription;

    /** Should order be embedded? */
    private boolean mOrder;

    /** Should planning result be embedded? */
    private boolean mPlanningResult;

    /** Should operation phase be embedded? */
    private boolean mOperationPhase;

    /** Should target workplace be embedded? */
    private boolean mTargetWorkplace;

    /** Should planned workplace be embedded? */
    private boolean mPlannedWorkplace;

    /** Should specification be embedded? */
    private boolean mSpecification;

    /** Should production resources and tools be embedded? */
    private boolean mProductionResourcesAndTools;

    /** Should scheduled dates be embedded? */
    private boolean mScheduledDates;

    /** Should target capacity group be embedded? */
    private boolean mTargetCapacityGroup;

    /** Should planned capacity group be embedded? */
    private boolean mPlannedCapacityGroup;

    /** Should manufacturing variants be embedded? */
    private boolean mManufacturingVariants;

    /** Should forecast result be embedded? */
    private boolean mForecastResult;

    /** Should quantity summary be embedded? */
    private boolean mQuantitySummary;

    /** Should production order specificiation be embedded? */
    private boolean mProductionOrderSpecification;

    /** Should operation components be embedded? */
    private boolean mComponents;

    /** Should operation user fields be embedded? */
    private boolean mUserFields;

    /** Should alternative workplaces be embedded? */
    private boolean mAlternativeWorkplaces;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if alternative workplaces should be embedded.
     *
     * @param alternativeWorkplaces Should alternative workplaces be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed alternativeWorkplaces(boolean alternativeWorkplaces) {
        mAlternativeWorkplaces = alternativeWorkplaces;
        return this;
    }

    /**
     * Determines if operation user fields should be embedded.
     *
     * @param userFields Should operation user fields be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed userFields(boolean userFields) {
        mUserFields = userFields;
        return this;
    }

    /**
     * Determines if operation components should be embedded.
     *
     * @param components Should operation components be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed components(boolean components) {
        mComponents = components;
        return this;
    }

    /**
     * Determines if forecast result should be embedded.
     *
     * @param forecastResult Should forecast result be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed forecastResult(boolean forecastResult) {
        mForecastResult = forecastResult;
        return this;
    }

    /**
     * Determines if manufacturing variants should be embedded.
     *
     * @param predictedValues Should manufacturing variants be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed predictedValues(boolean predictedValues) {
        mManufacturingVariants = predictedValues;
        return this;
    }

    /**
     * Determines if order should be embedded.
     *
     * @param order Should order be embedded?
     * @return The OperationEmbed object with the new value.
     */
    public OperationEmbed order(boolean order) {
        mOrder = order;
        return this;
    }

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The OperationEmbed object with the new value.
     */
    public OperationEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    /**
     * Determines if ERP context should be embedded.
     *
     * @param ERPContext Should ERP context be embedded?
     * @return The OperationEmbed object with the new value.
     */
    public OperationEmbed erpContext(boolean ERPContext) {
        mERPContext = ERPContext;
        return this;
    }

    /**
     * Determines if planning result should be embedded.
     *
     * @param planningResult Should planning result be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed planningResult(boolean planningResult) {
        mPlanningResult = planningResult;
        return this;
    }

    /**
     * Determines if operation phase should be embedded.
     *
     * @param operationPhase Should operation phase be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed operationPhase(boolean operationPhase) {
        mOperationPhase = operationPhase;
        return this;
    }

    /**
     * Determines if target workplace should be embedded.
     *
     * @param targetWorkplace Should target workplace be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed targetWorkplace(boolean targetWorkplace) {
        mTargetWorkplace = targetWorkplace;
        return this;
    }

    /**
     * Determines if target capacity group should be embedded.
     *
     * @param targetCapacityGroup Should target capacity group be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed targetCapacityGroup(boolean targetCapacityGroup) {
        mTargetCapacityGroup = targetCapacityGroup;
        return this;
    }

    /**
     * Determines if planned workplace should be embedded.
     *
     * @param plannedWorkplace Should planned workplace be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed plannedWorkplace(boolean plannedWorkplace) {
        mPlannedWorkplace = plannedWorkplace;
        return this;
    }

    /**
     * Determines if planned capacity group should be embedded.
     *
     * @param plannedCapacityGroup Should planned capacity group be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed plannedCapacityGroup(boolean plannedCapacityGroup) {
        mPlannedCapacityGroup = plannedCapacityGroup;
        return this;
    }

    /**
     * Determines if specification should be embedded.
     *
     * @param specification Should specification be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed specification(boolean specification) {
        mSpecification = specification;
        return this;
    }

    /**
     * Determines if production resources and tools should be embedded.
     *
     * @param productionResourcesAndTools Should production resources and tools be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed productionResourcesAndTools(boolean productionResourcesAndTools) {
        mProductionResourcesAndTools = productionResourcesAndTools;
        return this;
    }

    /**
     * Determines if scheduled dates should be embedded.
     *
     * @param scheduledDates Should scheduled dates be embedded?
     * @return The operation embed object with the new value.
     */
    public OperationEmbed scheduledDates(boolean scheduledDates) {
        mScheduledDates = scheduledDates;
        return this;
    }

    public OperationEmbed quantitySummary(boolean quantitySummary) {
        mQuantitySummary = quantitySummary;
        return this;
    }

    public OperationEmbed productionOrderSpecification(boolean productionOrderSpecification) {
        mProductionOrderSpecification = productionOrderSpecification;
        return this;
    }

    @Override
    public String toString() {

        final List<String> embeds = new ArrayList<>();
        if (this.isOrder()) {
            embeds.add(ORDER);
        }

        if (this.isDescription()) {
            embeds.add(DESCRIPTION);
        }

        if (this.isOperationPhase()) {
            embeds.add(OPERATION_PHASE);
        }

        if (this.isPlannedCapacityGroup()) {
            embeds.add(PLANNED_CAPACITY_GROUP);
        }

        if (this.isPlannedWorkplace()) {
            embeds.add(PLANNED_WORKPLACE);
        }

        if (this.isProductionResourcesAndTools()) {
            embeds.add(PRODUCTION_RESOURCES_AND_TOOLS);
        }

        if (this.isScheduledDates()) {
            embeds.add(SCHEDULED_DATES);
        }

        if (this.isSpecification()) {
            embeds.add(SPECIFICATION);
        }

        if (this.isTargetCapacityGroup()) {
            embeds.add(TARGET_CAPACITY_GROUP);
        }

        if (this.isTargetWorkplace()) {
            embeds.add(TARGET_WORKPLACE);
        }

        if (this.isERPContext()) {
            embeds.add(ERP_CONTEXT);
        }

        if (this.isForecastResult()) {
            embeds.add(FORECAST_RESULT);
        }

        if (this.isManufacturingVariants()) {
            embeds.add(MANUFACTURING_VARIANTS);
        }

        if (this.isPlanningResult()) {
            embeds.add(PLANNING_RESULT);
        }

        if (this.isProductionOrderSpecification()) {
            embeds.add(PRODUCTION_ORDER_SPECIFICATION);
        }

        if (this.isComponents()) {
            embeds.add(COMPONENTS);
        }

        if (this.isUserFields()) {
            embeds.add(USER_FIELDS);
        }

        if (this.isAlternativeWorkplaces()) {
            embeds.add(ALTERNATIVE_WORKPLACES);
        }

        if (this.isQuantitySummary()) {
            embeds.add(QUANTITY_SUMMARY);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides flag if forecast result should be embedded.
     *
     * @return Flag if forecast result should be embedded.
     */
    public boolean isForecastResult() {
        return mForecastResult;
    }

    /**
     * Provides flag if manufacturing variants should be embedded.
     *
     * @return Flag if manufacturing variants should be embedded.
     */
    public boolean isManufacturingVariants() {
        return mManufacturingVariants;
    }

    /**
     * Provides flag if planning result should be embedded.
     *
     * @return Flag if planning result should be embedded.
     */
    public boolean isPlanningResult() {
        return mPlanningResult;
    }

    public boolean isERPContext() {
        return mERPContext;
    }

    public boolean isDescription() {
        return mDescription;
    }

    public boolean isOrder() {
        return mOrder;
    }

    public boolean isOperationPhase() {
        return mOperationPhase;
    }

    public boolean isPlannedCapacityGroup() {
        return mPlannedCapacityGroup;
    }

    public boolean isPlannedWorkplace() {
        return mPlannedWorkplace;
    }

    public boolean isProductionResourcesAndTools() {
        return mProductionResourcesAndTools;
    }

    public boolean isScheduledDates() {
        return mScheduledDates;
    }

    public boolean isSpecification() {
        return mSpecification;
    }

    public boolean isTargetCapacityGroup() {
        return mTargetCapacityGroup;
    }

    public boolean isTargetWorkplace() {
        return mTargetWorkplace;
    }

    public boolean isQuantitySummary() {
        return mQuantitySummary;
    }

    public boolean isProductionOrderSpecification() {
        return mProductionOrderSpecification;
    }

    public boolean isComponents() {
        return mComponents;
    }

    public boolean isUserFields() {
        return mUserFields;
    }

    public boolean isAlternativeWorkplaces() {
        return mAlternativeWorkplaces;
    }
}
