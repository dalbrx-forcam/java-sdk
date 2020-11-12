package com.forcam.na.ffwebservices.model.callback;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * The callback object filter model.
 */
@ApiModel(value = "callbackObjectFilter")
@JsonPropertyOrder({ "name", "value" })
public class CallbackObjectFilterWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The filter name. */
    private String mName;

    /** The filter value. */
    private String mValue;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The object name", position = 0)
    public void setName(String name) {
        mName = name;
    }

    @NotBlank
    public String getName() {
        return mName;
    }

    @ApiModelProperty(value = "The filter value", position = 1)
    public void setValue(String value) {
        mValue = value;
    }

    @NotBlank
    public String getValue() {
        return mValue;
    }
}