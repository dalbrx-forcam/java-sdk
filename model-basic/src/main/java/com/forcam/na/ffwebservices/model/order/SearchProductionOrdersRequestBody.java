////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.forcam.na.ffwebservices.model.Constants;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import io.swagger.annotations.ApiModel;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * The request body for search operations.
 */
@ApiModel(value = "searchProductionOrders")
public class SearchProductionOrdersRequestBody {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** Production orderid. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mProductionOrderIds;

    /** Production order number. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mProductionOrderNumbers;

    /** Production order split. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mProductionOrderSplits;

    /** Production order erp context. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mERPContextIds;

    /** Production order material number. */
    @Size(max = Constants.IN_CLAUSE_LIMIT)
    private List<String> mMaterialNumbers;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The actual start date from. */
    private Date mActualStartDateFrom;

    /** The actual start date until. */
    private Date mActualEndDateUntil;

    /** The basic start date from. */
    private Date mBasicStartDateFrom;

    /** The basic end date until. */
    private Date mBasicEndDateUntil;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
                .append("mProductionOrderIds", mProductionOrderIds)
                .append("productionOrderNumbers", mProductionOrderNumbers)
                .append("productionOrderSplits", mProductionOrderSplits)
                .append("materialNumbers", mMaterialNumbers)
                .append("erpContextIds", mERPContextIds)
                .append("startDate", DateFormatUtility.formatLogging(mStartDate))
                .append("endDate", DateFormatUtility.formatLogging(mEndDate))
                .append("actualStartDateFrom", DateFormatUtility.formatLogging(mActualStartDateFrom))
                .append("actualEndDateUntil", DateFormatUtility.formatLogging(mActualEndDateUntil))
                .append("basicStartDateFrom", DateFormatUtility.formatLogging(mBasicStartDateFrom))
                .append("basicEndDateUntil", DateFormatUtility.formatLogging(mBasicEndDateUntil))
                .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link SearchProductionOrdersRequestBody#mProductionOrderNumbers}.
     *
     * @return Production order number.
     */
    public List<String> getProductionOrderNumbers() {
        return mProductionOrderNumbers;
    }

    /**
     * Setter for {@link SearchProductionOrdersRequestBody#mProductionOrderNumbers}.
     *
     * @param productionOrderNumbers Production order number.
     */
    public void setProductionOrderNumbers(List<String> productionOrderNumbers) {
        mProductionOrderNumbers = productionOrderNumbers;
    }

    public List<String> getProductionOrderSplits() {
        return mProductionOrderSplits;
    }

    public void setProductionOrderSplits(List<String> productionOrderSplits) {
        mProductionOrderSplits = productionOrderSplits;
    }

    /**
     * Getter for {@link SearchProductionOrdersRequestBody#mStartDate}.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Setter for {@link SearchProductionOrdersRequestBody#mStartDate}.
     *
     * @param startDate The start date.
     */
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Getter for {@link SearchProductionOrdersRequestBody#mEndDate}.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Setter for {@link SearchProductionOrdersRequestBody#mEndDate}.
     *
     * @param endDate The end date.
     */
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    /**
     * Getter for {@link SearchProductionOrdersRequestBody#mActualStartDateFrom}.
     *
     * @return The actual start date from.
     */
    public Date getActualStartDateFrom() {
        return mActualStartDateFrom;
    }

    /**
     * Setter for {@link SearchProductionOrdersRequestBody#mActualStartDateFrom}.
     *
     * @param actualStartDateFrom The actual start date from.
     */
    public void setActualStartDateFrom(Date actualStartDateFrom) {
        mActualStartDateFrom = actualStartDateFrom;
    }

    /**
     * Getter for {@link SearchProductionOrdersRequestBody#mActualEndDateUntil}.
     *
     * @return The actual start date until.
     */
    public Date getActualEndDateUntil() {
        return mActualEndDateUntil;
    }

    /**
     * Setter for {@link SearchProductionOrdersRequestBody#mActualEndDateUntil}.
     *
     * @param actualEndDateUntil The actual start date until.
     */
    public void setActualEndDateUntil(Date actualEndDateUntil) {
        mActualEndDateUntil = actualEndDateUntil;
    }

    /**
     * Getter for {@link SearchProductionOrdersRequestBody#mBasicStartDateFrom}.
     *
     * @return The basic start date from.
     */
    public Date getBasicStartDateFrom() {
        return mBasicStartDateFrom;
    }

    /**
     * Setter for {@link SearchProductionOrdersRequestBody#mBasicStartDateFrom}.
     *
     * @param basicStartDateFrom The basic start date from.
     */
    public void setBasicStartDateFrom(Date basicStartDateFrom) {
        mBasicStartDateFrom = basicStartDateFrom;
    }

    /**
     * Getter for {@link SearchProductionOrdersRequestBody#mBasicEndDateUntil}.
     *
     * @return The basic end date until.
     */
    public Date getBasicEndDateUntil() {
        return mBasicEndDateUntil;
    }

    /**
     * Setter for {@link SearchProductionOrdersRequestBody#mBasicEndDateUntil}.
     *
     * @param basicEndDateUntil The basic end date until.
     */
    public void setBasicEndDateUntil(Date basicEndDateUntil) {
        mBasicEndDateUntil = basicEndDateUntil;
    }

    public List<String> getProductionOrderIds() {
        return mProductionOrderIds;
    }

    public void setProductionOrderIds(List<String> productionOrderIds) {
        mProductionOrderIds = productionOrderIds;
    }

    public List<String> getERPContextIds() {
        return mERPContextIds;
    }

    @JsonProperty("erpContextIds")
    public void setERPContextIds(List<String> ERPContextIds) {
        mERPContextIds = ERPContextIds;
    }

    public List<String> getMaterialNumbers() {
        return mMaterialNumbers;
    }

    public void setMaterialNumbers(List<String> materialNumbers) {
        mMaterialNumbers = materialNumbers;
    }
}