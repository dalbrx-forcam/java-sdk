////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 30.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model;

/**
 * The error sub domains.
 */
public enum ErrorSubDomain implements IErrorCodeGetter {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    NONE__INVALID_JSON(ErrorDomain.NONE, "01"),

    NONE__PARAMETERS(ErrorDomain.NONE, "02"),

    TOOL__EDGE(ErrorDomain.TOOL, "01"),

    TOOL__ORDER(ErrorDomain.TOOL, "02"),

    TOOL__LOCATION(ErrorDomain.TOOL, "03"),

    TICKET__ATTACHMENT(ErrorDomain.TICKET, "01"),

    ACTIVITY_ATTACHMENT(ErrorDomain.TICKET, "01"),

    ACTIVITY_REMARK(ErrorDomain.TICKET, "02"),

    PUBLIC_DATA_SOURCE__PARAMETERS(ErrorDomain.PUBLIC_DATA_SOURCE_RESULT, "01"),

    PUBLIC_DATA_SOURCE__FILTER_CONFIGURATION(ErrorDomain.PUBLIC_DATA_SOURCE_RESULT, "02"),

    OPERATION__TOOL_ASSEMBLY_STATUS(ErrorDomain.OPERATION, "01"),

    OPERATION__PLANNING_RESULT(ErrorDomain.OPERATION, "02"),

    OPERATION__FORECAST_RESULT(ErrorDomain.OPERATION, "03"),

    OPERATION__PLANNING_SCENARIO(ErrorDomain.OPERATION, "04"),

    WORKPLACE__ACTIVE_OPERATIONS(ErrorDomain.WORKPLACE, "01"),

    WORKPLACE__LOCATION(ErrorDomain.WORKPLACE, "02"),

    WORKPLACE__DEVICES_NOT_FOUND(ErrorDomain.WORKPLACE, "03"),

    ORDER__SCHEDULING_RESULT(ErrorDomain.ORDER, "01"),

    STAFF_MEMBER__LOCATION(ErrorDomain.STAFF_MEMBER, "01"),

    DEVICE__LOCATION(ErrorDomain.DEVICE, "01"),

    DEVICE__DEVICES_NOT_FOUND(ErrorDomain.DEVICE, "02"),

    DEVICE__LIMIT_NOT_SET(ErrorDomain.DEVICE, "03"),

    DEVICE__TIME_SERIES_NOT_FOUND(ErrorDomain.DEVICE, "04"),

    DEVICE__NOT_FOUND(ErrorDomain.DEVICE, "05"),

    QUALITY__MATERIAL_NOT_FOUND(ErrorDomain.QUALITY, "01"),

    QUALITY__NODE_NOT_FOUND(ErrorDomain.QUALITY, "02"),

    QUALITY__OPERATION_NOT_FOUND(ErrorDomain.QUALITY, "03"),

    QUALITY__REFERENCE_ID_NOT_FOUND(ErrorDomain.QUALITY, "04"),

    QUALITY__WORKPLACE_NOT_FOUND(ErrorDomain.QUALITY, "05"),

    TRACE_DATA__OPERATION_CONTEXT_NOT_FOUND(ErrorDomain.TRACE_DATA, "01"),

    TRACE_DATA__NO_TRACE_DATA_PRESENT(ErrorDomain.TRACE_DATA, "02"),

    TRACE_DATA__SINGLE_PIECE_OR_BATCH_NOT_FOUND(ErrorDomain.TRACE_DATA, "03"),

    TRACE_DATA__DYNAMIC_CAPTURING_NOT_ALLOWED(ErrorDomain.TRACE_DATA, "04"),

    CAQ__OPERATION_CONTEXT_NOT_FOUND(ErrorDomain.CAQ, "02"),

    CAQ__DYNAMIC_CAPTURING_NOT_ALLOWED(ErrorDomain.CAQ, "04"),

    CAQ__REFERENCE_ID_NOT_FOUND(ErrorDomain.QUALITY, "04"),

    CAQ_INSPECTION_NOT_FOUND(ErrorDomain.CAQ, "05"),

    CAQ_INSPECTION_ALREADY_FINISHED(ErrorDomain.CAQ, "06"),

    CAQ_CYCLE_DATA_NOT_FOUND(ErrorDomain.CAQ, "07"),

    CAQ_CYCLE_DATA_NO_BATCHTYPE(ErrorDomain.CAQ, "08"),

    ERP_DOWNLOAD(ErrorDomain.ERP, "01");

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /** Error domain. */
    private ErrorDomain mDomain;

    /** Error code. */
    private String mCode;

    /**
     * Error sub domain.
     *
     * @param domain The domain.
     * @param code   The code.
     */
    ErrorSubDomain(ErrorDomain domain, String code) {
        mDomain = domain;
        mCode = code;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getCode() {
        return mCode;
    }

    public ErrorDomain getDomain() {
        return mDomain;
    }

    /**
     * Generates a error code for a sub domain.
     *
     * @param status The http status code.
     * @return The error code.
     */
    public String errorCode(int status) {
        return this
            .getDomain()
            .errorCode(status, this);
    }
}
