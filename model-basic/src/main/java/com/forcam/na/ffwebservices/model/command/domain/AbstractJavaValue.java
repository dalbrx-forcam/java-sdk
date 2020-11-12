////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 09.09.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Abstract class for java values.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({ @JsonSubTypes.Type(value = IntegerJavaValue.class, name = IntegerJavaValue.NAME),
                @JsonSubTypes.Type(value = LongJavaValue.class, name = LongJavaValue.NAME),
                @JsonSubTypes.Type(value = DoubleJavaValue.class, name = DoubleJavaValue.NAME),
                @JsonSubTypes.Type(value = MapJavaValue.class, name = MapJavaValue.NAME),
                @JsonSubTypes.Type(value = StringJavaValue.class, name = StringJavaValue.NAME)})
@ApiModel(value = "domainEventValue", subTypes = { IntegerJavaValue.class,
                                                   LongJavaValue.class,
                                                   DoubleJavaValue.class,
                                                   MapJavaValue.class,
                                                   StringJavaValue.class}, discriminator = "type")
public abstract class AbstractJavaValue {

    // ------------------------------------------------------------------------
    // members
    // -----------------------------------------------------------------------
    //

    private String mType;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public AbstractJavaValue(String type) {
        mType = type;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public abstract Serializable getValue();

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}
