////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplacegroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains booleans to determine what shall be embedded.
 */
public class WorkplaceGroupEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for description. */
    public static String DESCRIPTION = "description";

    /** Constant string for workplaces. */
    public static String WORKPLACES = "workplaces";

    /** Contant string for ERP contaxt. */
    public static String ERP_CONTEXT = "erpContext";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should description be embedded? */
    private boolean mDescription;

    /** Should workplaces be embedded? */
    private boolean mWorkplaces;

    /** Should ERP context be embedded? */
    private boolean mErpContext;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if workplaces should be embedded.
     *
     * @param workplaces Should workplaces be embedded?
     * @return The WorkplaceGroupEmbed object with the new value.
     */
    public WorkplaceGroupEmbed workplaces(boolean workplaces) {
        mWorkplaces = workplaces;
        return this;
    }

    /**
     * Determines if description should be embedded.
     *
     * @param description Should description be embedded?
     * @return The WorkplaceGroupEmbed object with the new value.
     */
    public WorkplaceGroupEmbed description(boolean description) {
        mDescription = description;
        return this;
    }

    /**
     * Determines if ERP context should be embedded.
     *
     * @param erpContext Should ERP context be embedded?
     * @return The workplace group embed object with the new value.
     */
    public WorkplaceGroupEmbed erpContext(boolean erpContext) {
        mErpContext = erpContext;
        return this;
    }

    @Override
    public String toString() {
        final List<String> embeds = new ArrayList<>();

        if (this.isDescription()) {
            embeds.add(DESCRIPTION);
        }

        if (this.isErpContext()) {
            embeds.add(ERP_CONTEXT);
        }

        if (this.isWorkplaces()) {
            embeds.add(WORKPLACES);
        }

        return String.join(",", embeds);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isDescription() {
        return mDescription;
    }

    public boolean isWorkplaces() {
        return mWorkplaces;
    }

    /**
     * Gets flag if ERP context should be embedded.
     *
     * @return Flag if ERP context should be embedded.
     */
    public boolean isErpContext() {
        return mErpContext;
    }
}