////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 09.03.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;

/**
 * The common collection properties.
 */
@ApiModel(value = "collectionProperties")
public class PaginationPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** An offset to skip results. */
    private Integer mOffset;

    /** The max amount of displayed results. */
    private int mLimit;

    /** The amount of displayed results. */
    private int mCount;

    /** The amount of found results. */
    private long mTotal;

    /** Start date of current Page */
    private PaginationIdentifierWSModel mFirstIdentifier;

    /** End date of current page */
    private PaginationIdentifierWSModel mLastIdentifier;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("mOffset", mOffset)
            .append("mLimit", mLimit)
            .append("mCount", mCount)
            .append("mTotal", mTotal)
            .append("mFirstIdentifier", mFirstIdentifier)
            .append("mLastIdentifier", mLastIdentifier)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public int getCount() {
        return mCount;
    }

    @ApiModelProperty(value = "Number of elements currently on this page")
    public void setCount(int count) {
        mCount = count;
    }

    public long getTotal() {
        return mTotal;
    }

    @ApiModelProperty(value = "Total amount of elements")
    public void setTotal(long total) {
        this.mTotal = total;
    }

    public int getLimit() {
        return mLimit;
    }

    @ApiModelProperty(value = "Size of the page")
    public void setLimit(int limit) {
        mLimit = limit;
    }

    public Integer getOffset() {
        return mOffset;
    }

    @ApiModelProperty(value = "Offset of the page")
    public void setOffset(Integer offset) {
        mOffset = offset;
    }

    public PaginationIdentifierWSModel getFirstIdentifier() {
        return mFirstIdentifier;
    }

    @ApiModelProperty(value = "Identifier of the first element on page")
    public void setFirstIdentifier(PaginationIdentifierWSModel firstIdentifier) {
        mFirstIdentifier = firstIdentifier;
    }

    public PaginationIdentifierWSModel getLastIdentifier() {
        return mLastIdentifier;
    }

    @ApiModelProperty(value = "Identifier of the last element on page")
    public void setLastIdentifier(PaginationIdentifierWSModel lastIdentifier) {
        mLastIdentifier = lastIdentifier;
    }
}
