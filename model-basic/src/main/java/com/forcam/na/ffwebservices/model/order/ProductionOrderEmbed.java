////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class ProductionOrderEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for ERP context. */
    public static String ERP_CONTEXT = "erpContext";

    /** Constant string for operations. */
    public static String OPERATIONS = "operations";

    public static String OPERATION_SEQUENCE = "operationSequence";

    public static String SPECIFICATION = "specification";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should description be embedded? */
    private boolean mDescription;

    /** Should ERP context be embedded? */
    private boolean mERPContext;

    /** Should operations be embedded? */
    private boolean mOperations;

    /** Should operation sequence be embedded? */
    private boolean mOperationSequence;

    /** Should specification be embedded? */
    private boolean mSpecification;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if ERP context should be embedded.
     *
     * @param ERPContext Should ERP context be embedded?
     * @return The updated production order embed.
     */
    public ProductionOrderEmbed erpContext(boolean ERPContext) {
        mERPContext = ERPContext;
        return this;
    }

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The updated production order embed.
     */
    public ProductionOrderEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    /**
     * Determines if operations should be embedded.
     *
     * @param operations Should operations be embedded?
     * @return The updated production order embed.
     */
    public ProductionOrderEmbed operations(boolean operations) {
        mOperations = operations;
        return this;
    }

    /**
     * Determines if operationSequence should be embedded.
     *
     * @param operationSequence Should operationSequence be embedded?
     * @return The updated production order embed.
     */
    public ProductionOrderEmbed operationSequence(boolean operationSequence) {
        mOperationSequence = operationSequence;
        return this;
    }

    /**
     * Determines if specification should be embedded.
     *
     * @param specification Should specification be embedded?
     * @return The updated production order embed.
     */
    public ProductionOrderEmbed specification(boolean specification) {
        mSpecification = specification;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isDescription()) {
            embeds.add(DESCRIPTION);
        }

        if (this.isERPContext()) {
            embeds.add(ERP_CONTEXT);
        }

        if (this.isOperations()) {
            embeds.add(OPERATIONS);
        }

        if (this.isSpecification()) {
            embeds.add(SPECIFICATION);
        }

        if (this.isOperationSequence()) {
            embeds.add(OPERATION_SEQUENCE);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides flag if operations should be embedded.
     *
     * @return Flag if operations should be embedded.
     */
    public boolean isOperations() {
        return mOperations;
    }

    /**
     * Provides flag if description should be embedded.
     *
     * @return Flag if description should be embedded.
     */
    public boolean isDescription() {
        return mDescription;
    }

    /**
     * Provides flag if erp context should be embedded.
     *
     * @return Flag if erp context should be embedded.
     */
    public boolean isERPContext() {
        return mERPContext;
    }

    /**
     * Provides flag if specification should be embedded.
     *
     * @return Flag if specification should be embedded.
     */
    public boolean isSpecification() {
        return mSpecification;
    }

    /**
     * Provides flag if operation sequence should be embedded.
     *
     * @return Flag if operation sequence should be embedded.
     */
    public boolean isOperationSequence() {
        return mOperationSequence;
    }
}