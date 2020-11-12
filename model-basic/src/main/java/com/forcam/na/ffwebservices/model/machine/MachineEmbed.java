////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.machine;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class MachineEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for ERP context. */
    public static String ERP_CONTEXT = "erpContext";

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for workplace. */
    public static String WORKPLACE = "workplace";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should ERP context be embedded? */
    private boolean mERPContext;

    /** Should description be embedded? */
    private boolean mDescription;

    /** Should workplace be embedded? */
    private boolean mWorkplace;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if workplace should be embedded.
     *
     * @param workplace Should workplace be embedded?
     * @return The MachineEmbed object with the new value.
     */
    public MachineEmbed workplace(boolean workplace) {
        mWorkplace = workplace;
        return this;
    }

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The MachineEmbed object with the new value.
     */
    public MachineEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    /**
     * Determines if ERP context should be embedded.
     *
     * @param ERPContext Should ERP context be embedded?
     * @return The MachineEmbed object with the new value.
     */
    public MachineEmbed erpContext(boolean ERPContext) {
        mERPContext = ERPContext;
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

        if (this.isWorkplace()) {
            embeds.add(WORKPLACE);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isERPContext() {
        return mERPContext;
    }

    public boolean isDescription() {
        return mDescription;
    }

    public boolean isWorkplace() {
        return mWorkplace;
    }
}