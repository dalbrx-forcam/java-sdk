////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.order.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.model.order.ProductionOrderEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetProductionOrdersRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private ProductionOrderEmbed mEmbed = new ProductionOrderEmbed();

    /** The production order number. */
    private String mProductionOrderNumber;

    /** The production order split. */
    private String mProductionOrderSplit;

    /** The material number. */
    private String mMaterialNumber;

    /** The ID of the ERP context. */
    private String mErpContextId;
    /** The start date. */
    private Date mStartDate;
    /** The end date. */
    private Date mEndDate;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public ProductionOrderEmbed embed() {
        return mEmbed;
    }

    public void embed(ProductionOrderEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("productionOrderNumber", mProductionOrderNumber)
            .append("productionOrderSplit", mProductionOrderSplit)
            .append("materialNumber", mMaterialNumber)
            .append("erpContextId", mErpContextId)
            .append("embed", mEmbed)
            .append("startDate", mStartDate)
            .append("endDate", mEndDate)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ProductionOrderEmbed getEmbed() {
        return mEmbed;
    }

    public void setEmbed(ProductionOrderEmbed embed) {
        mEmbed = embed;
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

    public String getErpContextId() {
        return mErpContextId;
    }

    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

    /**
     * Getter for {@link GetProductionOrdersRequest#mStartDate}.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Setter for {@link GetProductionOrdersRequest#mStartDate}.
     *
     * @param startDate The start date.
     */
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Getter for {@link GetProductionOrdersRequest#mEndDate}.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Setter for {@link GetProductionOrdersRequest#mEndDate}.
     *
     * @param endDate The end date.
     */
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }
}