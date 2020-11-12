////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 30.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model;

/**
 * The error domains.
 */
public enum ErrorDomain implements IErrorCodeGetter {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    NONE("00"),

    ORDER("10"),

    OPERATION("11"),

    WORKPLACE("12"),

    MATERIAL("13"),

    ERP_KEY("14"),

    STATUS_DEFINITION("15"),

    STAFF_MEMBER("16"),

    MACHINE("17"),

    LITERAL("18"),

    MALFUNCTION_REASON("19"),

    QUALITY_TYPE("20"),

    QUANTITY_REASON("21"),

    TOOL("22"),

    SKILL("23"),

    CALLBACK("24"),

    SHIFT("25"),

    SHIFT_TYPE("26"),

    DEVICE("27"),

    WORKPLACE_GROUP("28"),

    QUALITY("29"),

    TRACE_DATA("30"),

    CAQ("31"),

    /** Trace inventory container data. */
    INVENTORY_CONTAINER_DATA("32"),

    REPORTING("33"),

    TICKET("34"),

    TICKET_CLASS("35"),

    TICKET_STATE("36"),

    TICKET_ACTIVITY_STATE("37"),

    DATA_SOURCE("80"),

    DATA_TYPE("81"),

    DATA_FORMAT("82"),

    FILTER_CRITERION("83"),

    FILTER_DEFINITION("84"),

    DATA_SOURCE_COLUMN("85"),

    PUBLIC_DATA_SOURCE_RESULT("86"),

    NC_PACKAGE("87"),

    NC_ELEMENT("88"),

    COMMAND("90"),

    ACTIVITY("91"),

    ERP("92");

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The code */
    private String mCode;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    ErrorDomain(String code) {
        mCode = code;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public String getCode() {
        return mCode;
    }

    /**
     * Generates a error code for a sub domain.
     *
     * @param status    The http status code.
     * @param subDomain The {@link ErrorSubDomain}.
     * @return The error code.
     */
    public String errorCode(int status, ErrorSubDomain subDomain) {
        return this.getCode() + subDomain.getCode() + getErrorCode(status, 0);
    }

    /**
     * Generates a error code for a sub domain.
     *
     * @param status The http status code.
     * @return The error code.
     */
    public String errorCode(int status) {
        return this.getCode() + "00" + getErrorCode(status, 0);
    }

    /**
     * Returns the error code as 6-digit number with leading zeros.
     *
     * @param status The http status.
     * @param num    The error code number.
     * @return The error code as 3-digit number.
     */
    private static String getErrorCode(int status, int num) {
        return getString(status) + getString(num);
    }

    /**
     * Returns a 3-digit string representation of a number with leading zeros.
     *
     * @param num The error code number.
     * @return The error code as 3-digit number.
     */
    private static String getString(int num) {
        return String.format("%03d", num);
    }

}

