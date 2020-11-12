////////////////////////////////////////////////////////////////////////////////
//
// Created by DSchulz on 14.12.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model;

/**
 * Error code Getter.
 */
public interface IErrorCodeGetter {

    /**
     * Returns the error code.
     *
     * @return Error code.
     */
    String getCode();

    /**
     * Return the error code with included http status.
     *
     * @param status http status to include into the error code.
     * @return Error code with included http status.
     */
    String errorCode(int status);
}
