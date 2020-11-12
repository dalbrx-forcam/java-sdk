////////////////////////////////////////////////////////////////////////////////
//
// Created by RGupta on 6/16/2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.trace;

import java.io.Serializable;
import java.util.List;

/**
 * Describe the warehouse feedback.
 */
public class WarehouseFeedbackWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------
    /** Serial version id. */
    private static final long serialVersionUID = 3770145427278266183L;
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Warehouse message type. */
    private String mWarehouseMessageType;

    /** Warehouse order information. */
    private WarehouseOrderWSModel mOrderInfo;

    /** Warehouse erp info. */
    private WarehouseERPWSModel mERPInfo;

    /** Ware house entities. */
    private List<WarehouseEntityWSModel> mWarehouseEntities;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWarehouseMessageType() {
        return mWarehouseMessageType;
    }

    public void setWarehouseMessageType(String warehouseMessageType) {
        mWarehouseMessageType = warehouseMessageType;
    }

    public WarehouseOrderWSModel getOrderInfo() {
        return mOrderInfo;
    }

    public void setOrderInfo(WarehouseOrderWSModel orderInfo) {
        mOrderInfo = orderInfo;
    }

    public WarehouseERPWSModel getERPInfo() {
        return mERPInfo;
    }

    public void setERPInfo(WarehouseERPWSModel erpInfo) {
        mERPInfo = erpInfo;
    }

    public List<WarehouseEntityWSModel> getWarehouseEntities() {
        return mWarehouseEntities;
    }

    public void setWarehouseEntities(List<WarehouseEntityWSModel> warehouseEntities) {
        mWarehouseEntities = warehouseEntities;
    }

}
