////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.07.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.callback;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.event.EventWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The callback notification properties model.
 */
@ApiModel(value = "callbackNotificationProperties")
public class CallbackNotificationPropertiesWSModel extends EventWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    private static final long serialVersionUID = 6888202920535580984L;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The callback id. */
    private String mCallbackId;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mCallbackId", mCallbackId)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final CallbackNotificationPropertiesWSModel that = (CallbackNotificationPropertiesWSModel) o;

        return new EqualsBuilder()
            .appendSuper(super.equals(o))
            .append(mCallbackId, that.mCallbackId)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .appendSuper(super.hashCode())
            .append(mCallbackId)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getCallbackId() {
        return mCallbackId;
    }

    @ApiModelProperty(value = "UUID of the callback which leads to the notification")
    public void setCallbackId(String callbackId) {
        mCallbackId = callbackId;
    }

}
