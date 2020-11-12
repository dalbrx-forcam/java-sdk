////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 6/18/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;

/**
 * Represents the warehouse order information.
 */
public class WarehouseOrderWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = 8218840234322847279L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Material number. */
    private String mMaterialNumber;

    /** Order uuid. */
    private String mOrderId;

    /** Order number. */
    private String mOrderNumber;

    /** Order split. */
    private String mOrderSplit;

    /** Order production version. */
    private String mOrderProductionVersion;

    /** Operation uuid. */
    private String mOperationId;

    /** Operation number. */
    private String mOperationNumber;

    /** Operation split. */
    private String mOperationSplit;

    /** Operation sequence. */
    private String mOperationSequence;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }

    public String getOrderId() {
        return mOrderId;
    }

    public void setOrderId(String orderId) {
        mOrderId = orderId;
    }

    public String getOrderNumber() {
        return mOrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        mOrderNumber = orderNumber;
    }

    public String getOrderSplit() {
        return mOrderSplit;
    }

    public void setOrderSplit(String orderSplit) {
        mOrderSplit = orderSplit;
    }

    public String getOrderProductionVersion() {
        return mOrderProductionVersion;
    }

    public void setOrderProductionVersion(String orderProductionVersion) {
        mOrderProductionVersion = orderProductionVersion;
    }

    public String getOperationId() {
        return mOperationId;
    }

    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    public String getOperationNumber() {
        return mOperationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        mOperationNumber = operationNumber;
    }

    public String getOperationSplit() {
        return mOperationSplit;
    }

    public void setOperationSplit(String operationSplit) {
        mOperationSplit = operationSplit;
    }

    public String getOperationSequence() {
        return mOperationSequence;
    }

    public void setOperationSequence(String operationSequence) {
        mOperationSequence = operationSequence;
    }
}
