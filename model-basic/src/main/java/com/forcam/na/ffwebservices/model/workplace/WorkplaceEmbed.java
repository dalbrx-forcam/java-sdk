////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.workplace;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class WorkplaceEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for ERP context. */
    public static String ERP_CONTEXT = "erpContext";

    /** Constant string for machine. */
    public static String MACHINE = "machine";

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for current operations. */
    public static String CURRENT_OPERATIONS = "currentOperations";

    /** Constant string for current operations. */
    public static String CURRENT_STAFF_MEMBERS = "currentStaffMembers";

    /** Constant string for location. */
    public static String LOCATION = "location";

    /** Constant string for user fields. */
    public static String USER_FIELDS = "userFields";

    /** Should ERP context be embedded? */
    private boolean mERPContext;

    /** Should machine be embedded? */
    private boolean mMachine;

    /** Should description be embedded? */
    private boolean mDescription;

    /** Should current operations be embedded? */
    private boolean mCurrentOperations;

    /** Should current staff members be embedded? */
    private boolean mCurrentStaffMembers;

    /** Should location be embedded? */
    private boolean mLocation;

    /** Should user filed be embedded? */
    private boolean mUserFields;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if machine should be embedded.
     *
     * @param machine Should machine be embedded?
     * @return The WorkplaceEmbed object with the new value.
     */
    public WorkplaceEmbed machine(boolean machine) {
        mMachine = machine;
        return this;
    }

    /**
     * Determines if ERP context should be embedded.
     *
     * @param ERPContext Should ERP context be embedded?
     * @return The WorkplaceEmbed object with the new value.
     */
    public WorkplaceEmbed erpContext(boolean ERPContext) {
        mERPContext = ERPContext;
        return this;
    }

    /**
     * Determines if the description literal should be embedded.
     *
     * @param description Should description be embedded?
     * @return The workplace embed object with the new value.
     */
    public WorkplaceEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    /**
     * Determines if the currently executed operations should be embedded.
     *
     * @param currentOperations Should operations be embedded?
     * @return The workplace embed object with the new value.
     */
    public WorkplaceEmbed currentOperations(boolean currentOperations) {
        mCurrentOperations = currentOperations;
        return this;
    }

    /**
     * Determines if the currently assigned staff members should be embedded.
     *
     * @param currentStaffMembers Should staff members be embedded?
     * @return The workplace embed object with the new value.
     */
    public WorkplaceEmbed currentStaffMembers(boolean currentStaffMembers) {
        mCurrentStaffMembers = currentStaffMembers;
        return this;
    }

    /**
     * Determines if location should be embedded.
     *
     * @param location The location.
     * @return The WorkplaceEmbed object with the new value.
     */
    public WorkplaceEmbed location(boolean location) {
        mLocation = location;
        return this;
    }

    /**
     * Determines if the user fields should be embedded.
     *
     * @param userFields Should description be embedded?
     * @return The workplace embed object with the new value.
     */
    public WorkplaceEmbed userFields(boolean userFields) {
        mUserFields = userFields;
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

        if (this.isMachine()) {
            embeds.add(MACHINE);
        }

        if (this.isLocation()) {
            embeds.add(LOCATION);
        }

        if (this.isCurrentOperations()) {
            embeds.add(CURRENT_OPERATIONS);
        }

        if (this.isCurrentStaffMembers()) {
            embeds.add(CURRENT_STAFF_MEMBERS);
        }

        if (this.isUserFields()) {
            embeds.add(USER_FIELDS);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isERPContext() {
        return mERPContext;
    }

    public boolean isMachine() {
        return mMachine;
    }

    /**
     * Provides the flag if description should be embedded.
     *
     * @return Flag if description should be embedded.
     */
    public boolean isDescription() {
        return mDescription;
    }

    public boolean isCurrentOperations() {
        return mCurrentOperations;
    }

    public boolean isLocation() {
        return mLocation;
    }

    public boolean isUserFields() {
        return mUserFields;
    }

    public boolean isCurrentStaffMembers() {
        return mCurrentStaffMembers;
    }
}