////////////////////////////////////////////////////////////////////////////////
//
// Created by Dimitri Schulz on 18.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.collection;

import com.forcam.na.ffwebservices.model.DateFormatUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;

import java.util.Date;

/**
 * Pagination identifier model.
 */
@ApiModel(value = "paginationIdentifier")
public class PaginationIdentifierWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /**
     * Pagination identifier, can be a ID or ident...
     */
    private String mIdentifier;

    /**
     * Pagination timestammp.
     */
    private Date mTimestamp;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public PaginationIdentifierWSModel() {
        //empty constructor
    }

    /**
     * Creates a new instance.
     *
     * @param identifier The identifier.
     */
    public PaginationIdentifierWSModel(String identifier) {
        mIdentifier = identifier;
    }

    /**
     * Creates a new instance.
     *
     * @param timestamp The date.
     */
    public PaginationIdentifierWSModel(Date timestamp) {
        mTimestamp = timestamp;
    }

    /**
     * Creates a new instance.
     *
     * @param identifier The identifier.
     * @param timestamp  The date.
     */
    public PaginationIdentifierWSModel(String identifier, Date timestamp) {
        mIdentifier = identifier;
        mTimestamp = timestamp;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
                .append("mIdentifier", mIdentifier)
                .append("mTimestamp", DateFormatUtility.formatLogging(mTimestamp))
                .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link #mIdentifier}.
     *
     * @return Pagination identifirer.
     */
    public String getIdentifier() {
        return mIdentifier;
    }

    @ApiModelProperty(value = "Identifier which makes the pagination entry unique.")
    public void setIdentifier(String identifier) {
        mIdentifier = identifier;
    }

    /**
     * Getter for {@link #mTimestamp}.
     *
     * @return Pagination timestamp.
     */
    public Date getTimestamp() {
        return mTimestamp;
    }

    @ApiModelProperty(value = "Pagination timestamp.")
    public void setTimestamp(Date timestamp) {
        mTimestamp = timestamp;
    }
}
