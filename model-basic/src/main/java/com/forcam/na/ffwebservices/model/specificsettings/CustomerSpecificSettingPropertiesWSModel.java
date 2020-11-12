////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 16.01.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.specificsettings;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Properties of the  customer specific setting.
 */
@ApiModel("customerSpecificSettingProperties")
@JsonPropertyOrder({ "id", "topic", "value", "description" })
public class CustomerSpecificSettingPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;
    private String mTopic;
    private String mDescription;
    private String mValue;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The ID of the customer specific setting", required = true, position = 0)
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    @ApiModelProperty(value = "The topic", required = true, position = 1)
    public void setTopic(String topic) {
        mTopic = topic;
    }

    public String getTopic() {
        return mTopic;
    }

    @ApiModelProperty(value = "The value", required = true, position = 2)
    public void setValue(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    @ApiModelProperty(value = "The description", required = true, position = 3)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }
}
