////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 02.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.statusdefinition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * WS model to create an operating state.
 */
@ApiModel(value = "createOperatingStateProperties")
@JsonPropertyOrder({ "description", "shortDescription", "code", "color", "isRecodable", "isSplittable", "isAnnotatable", "customerCode", "workplaceStateId",
                     "operatingStateClassId", })
public class CreateOperatingStatePropertiesWSModel extends CreateStatusDefinitionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private WorkplaceState mWorkplaceStateId;

    private String mOperatingStateClassId;

    /** Workplace state code. */
    private long mWorkplaceStateCode;

    private Set<String> mTimeBases = new HashSet<>();

    private String mCustomerCode;

    private boolean mIsRecodable;

    private boolean mIsSplittable;

    private boolean mIsAnnotatable;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "ID of the corresponding workplace state", position = 5)
    public void setWorkplaceStateId(WorkplaceState workplaceStateId) {
        mWorkplaceStateId = workplaceStateId;
    }

    public WorkplaceState getWorkplaceStateId() {
        return mWorkplaceStateId;
    }

    @ApiModelProperty(value = "UUID of the operating state class", position = 6)
    public void setOperatingStateClassId(String operatingStateClassId) {
        mOperatingStateClassId = operatingStateClassId;
    }

    public String getOperatingStateClassId() {
        return mOperatingStateClassId;
    }

    /**
     * Sets the workplace state code.
     *
     * @param workplaceStateCode The workplace state code.
     */
    @ApiModelProperty(position = 7)
    public void setWorkplaceStateCode(long workplaceStateCode) {
        mWorkplaceStateCode = workplaceStateCode;
    }

    /**
     * Provides the workplace state code.
     *
     * @return The workplace state code.
     */
    @JsonIgnore
    public long getWorkplaceStateCode() {
        return mWorkplaceStateCode;
    }

    @ApiModelProperty(position = 8)
    public void setTimeBases(Set<String> timeBases) {
        mTimeBases = timeBases;
    }

    @JsonIgnore
    public Set<String> getTimeBases() {
        return mTimeBases;
    }

    public void setCustomerCode(String customerCode) {
        mCustomerCode = customerCode;
    }

    public String getCustomerCode() {
        return mCustomerCode;
    }

    public void setIsRecodable(boolean isRecodable) {
        mIsRecodable = isRecodable;
    }

    public boolean getIsRecodable() {
        return mIsRecodable;
    }

    public void setIsSplittable(boolean isSplittable) {
        mIsSplittable = isSplittable;
    }

    public boolean getIsSplittable() {
        return mIsSplittable;
    }

    public void setIsAnnotatable(boolean isAnnotatable) {
        mIsAnnotatable = isAnnotatable;
    }

    public boolean getIsAnnotatable() {
        return mIsAnnotatable;
    }
}