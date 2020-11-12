package com.forcam.na.ffwebservices.model.machinestatedetail;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created: 05.04.2017
 *
 * @author David Albrecht
 */
@ApiModel(value = "createMachineStateDetailProperties")
@JsonPropertyOrder({ "description", "shortDescription", "code", "color", "isRecodable", "isSplittable", "isAnnotatable", "customerCode"})
public class CreateMachineStateDetailPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The description. */
    private String mDescription;

    /** The short description. */
    private String mShortDescription;

    /** The mnemonic.. */
    private String mCode;

    /** The color. */
    private String mColor;

    /** Customer code. */
    private String mCustomerCode;

    /** Is the machine state detail splittable. */
    private Boolean mIsSplittable;

    /** Is the machine state detail recodable. */
    private Boolean mIsRecodable;

    /** Is the machine state detail annotatable. */
    private Boolean mIsAnnotatable;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(position = 1)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(position = 2)
    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    @ApiModelProperty(position = 3)
    public void setCode(String code) {
        mCode = code;
    }

    public String getCode() {
        return mCode;
    }

    @ApiModelProperty(position = 4)
    public void setColor(String color) {
        mColor = color;
    }

    public String getColor() {
        return mColor;
    }

    public void setCustomerCode(String customerCode) {
        mCustomerCode = customerCode;
    }

    public String getCustomerCode() {
        return mCustomerCode;
    }

    public void setSplittable(boolean isSplittable) {
        mIsSplittable = isSplittable;
    }

    public void setIsSplittable(boolean isSplittable) {
        mIsSplittable = isSplittable;
    }

    public Boolean getIsSplittable() {
        return mIsSplittable;
    }

    public void setRecodable(boolean isRecodable) {
        mIsRecodable = isRecodable;
    }

    public void setIsRecodable(boolean isRecodable) {
        mIsRecodable = isRecodable;
    }

    public Boolean getIsRecodable() {
        return mIsRecodable;
    }

    public void setAnnotatable(boolean isAnnotatable) {
        mIsAnnotatable = isAnnotatable;
    }

    public void setIsAnnotatable(boolean isAnnotatable) {
        mIsAnnotatable = isAnnotatable;
    }

    public Boolean getIsAnnotatable() {
        return mIsAnnotatable;
    }
}