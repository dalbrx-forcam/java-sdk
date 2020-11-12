////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 29.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import io.swagger.annotations.ApiModel;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The request body for search production resources and tools.
 */
@ApiModel(value = "searchProductionResourcesAndTools")
public class SearchProductionResourcesAndToolsRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id of the operation. */
    private String mOperationId;

    /** The number of the operation. */
    private String mOperationNumber;

    /** The operation split. */
    private String mOperationSplit;

    /** The id of the order. */
    private String mProductionOrderId;

    /** The number of the order. */
    private String mProductionOrderNumber;

    /** The order split. */
    private String mProductionOrderSplit;

    /** The number of the material. */
    private String mMaterialNumber;

    /** The type of production resource. */
    private String mType;

    /** The group of production resource. */
    private String mGroup;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this).append("operationId", mOperationId)
                                                                          .append("operationNumber", mOperationNumber)
                                                                          .append("operationSplit", mOperationSplit)
                                                                          .append("productionOrderId", mProductionOrderId)
                                                                          .append("productionOrderNumber", mProductionOrderNumber)
                                                                          .append("productionOrderSplit", mProductionOrderSplit)
                                                                          .append("materialNumber", mMaterialNumber)
                                                                          .append("type", mType)
                                                                          .append("group", mGroup)
                                                                          .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

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

    public String getProductionOrderId() {
        return mProductionOrderId;
    }

    public void setProductionOrderId(String productionOrderId) {
        mProductionOrderId = productionOrderId;
    }

    public String getProductionOrderNumber() {
        return mProductionOrderNumber;
    }

    public void setProductionOrderNumber(String productionOrderNumber) {
        mProductionOrderNumber = productionOrderNumber;
    }

    public String getProductionOrderSplit() {
        return mProductionOrderSplit;
    }

    public void setProductionOrderSplit(String productionOrderSplit) {
        mProductionOrderSplit = productionOrderSplit;
    }

    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getGroup() {
        return mGroup;
    }

    public void setGroup(String group) {
        mGroup = group;
    }
}