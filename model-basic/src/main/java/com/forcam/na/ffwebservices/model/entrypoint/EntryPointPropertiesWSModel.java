////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 24.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.entrypoint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The properties model for entry points.
 */
@XmlRootElement(name = "entryPointProperties")
@ApiModel(value = "entryPointProperties")
public class EntryPointPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The API version. */
    private String mVersion;

    /** The API title. */
    private String mTitle;

    /** The API license. */
    private String mLicense;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getVersion() {
        return mVersion;
    }

    @ApiModelProperty(value = "Version of the API")
    public void setVersion(String version) {
        mVersion = version;
    }

    public String getTitle() {
        return mTitle;
    }

    @ApiModelProperty(value = "Title of the API")
    public void setTitle(String title) {
        mTitle = title;
    }

    public String getLicense() {
        return mLicense;
    }

    @ApiModelProperty(value = "License model in use", example = "Creative Commons Attribution-NoDerivs 3.0 Unported License.")
    public void setLicense(String license) {
        mLicense = license;
    }
}