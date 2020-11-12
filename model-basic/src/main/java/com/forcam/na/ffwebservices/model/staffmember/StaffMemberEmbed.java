////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.staffmember;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class StaffMemberEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for ERP context. */
    public static String ERP_CONTEXT = "erpContext";

    /** Constant string for current operations. */
    public static String CURRENTLY_EXECUTED_OPERATIONS = "currentlyExecutedOperations";

    public static String ASSIGNED_WORKPLACES = "assignedWorkplaces";

    /** Constant string for location. */
    public static String LOCATION = "location";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should ERP context be embedded? */
    private boolean mERPContext;

    /** Should current operations be embedded? */
    private boolean mCurrentlyExecutedOperations;

    private boolean mAssignedWorkplaces;

    /** Should location be embedded? */
    private boolean mLocation;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if ERP context should be embedded.
     *
     * @param ERPContext Should ERP context be embedded?
     * @return The StaffMemberEmbed object with the new value.
     */
    public StaffMemberEmbed erpContext(boolean ERPContext) {
        mERPContext = ERPContext;
        return this;
    }

    /**
     * Determines if the currently executed operations should be embedded.
     *
     * @param currentlyExecutedOperations Should operations be embedded?
     * @return The staff member embed object with the new value.
     */
    public StaffMemberEmbed currentlyExecutedOperations(boolean currentlyExecutedOperations) {
        mCurrentlyExecutedOperations = currentlyExecutedOperations;
        return this;
    }

    public StaffMemberEmbed assignedWorkplaces(boolean assignedWorkplaces) {
        mAssignedWorkplaces = assignedWorkplaces;
        return this;
    }

    /**
     * Determines if location should be embedded.
     *
     * @param location The location.
     * @return The StaffMemberEmbed object with the new value.
     */
    public StaffMemberEmbed location(boolean location) {
        mLocation = location;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isAssignedWorkplaces()) {
            embeds.add(ASSIGNED_WORKPLACES);
        }

        if (this.isERPContext()) {
            embeds.add(ERP_CONTEXT);
        }

        if (this.isCurrentlyExecutedOperations()) {
            embeds.add(CURRENTLY_EXECUTED_OPERATIONS);
        }

        if (this.isLocation()) {
            embeds.add(LOCATION);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isERPContext() {
        return mERPContext;
    }

    public boolean isCurrentlyExecutedOperations() {
        return mCurrentlyExecutedOperations;
    }

    public boolean isAssignedWorkplaces() {
        return mAssignedWorkplaces;
    }

    public boolean isLocation() {
        return mLocation;
    }
}