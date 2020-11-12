package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Webservice model for user field.
 * <p>
 * Created: 27.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
@ApiModel(value = "userField")
@JsonPropertyOrder({ "position", "value" })
public class UserFieldWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The position. */
    private int mPosition;

    /** The value. */
    private String mValue;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the position.
     *
     * @param position The position.
     */
    @ApiModelProperty(position = 0)
    public void setPosition(int position) {
        mPosition = position;
    }

    /**
     * Provides the position.
     *
     * @return The position.
     */
    public int getPosition() {
        return mPosition;
    }

    /**
     * Sets the value.
     *
     * @param value The value.
     */
    @ApiModelProperty(position = 1)
    public void setValue(String value) {
        mValue = value;
    }

    /**
     * Provides the value.
     *
     * @return The value.
     */
    public String getValue() {
        return mValue;
    }
}