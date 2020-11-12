////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 23.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The basic properties of a tool.
 */
@ApiModel(value = "getToolProperties")
@JsonPropertyOrder({ "name", "description", "identifier1", "identifier2", "identifier3", "documentUrl", "group", "class" })
public class GetToolPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Tool number / name */
    private String mName;

    /** Tool description */
    private String mDescription;

    /** First tool identifier */
    private String mIdentifier1;

    /** Second tool identifier */
    private String mIdentifier2;

    /** Third tool identifier */
    private String mIdentifier3;

    /** Url to a document related to the  tool */
    private String mDocumentUrl;

    /** The tool group */
    private ToolIdentifierValueWSModel mGroup = new ToolIdentifierValueWSModel();

    /** The tool class */
    private ToolIdentifierValueWSModel mClass = new ToolIdentifierValueWSModel();

    /** The tool edge life time */
    private LifeTime mLifeTime = new LifeTime();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mIdentifier1", mIdentifier1)
            .append("mIdentifier2", mIdentifier2)
            .append("mIdentifier3", mIdentifier3)
            .append("mDocumentUrl", mDocumentUrl)
            .append("mName", mName)
            .append("mDescription", mDescription)
            .append("mClass", mClass)
            .append("mGroup", mGroup)
            .append("mLifeTime", mLifeTime)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Technical description of the tool", position = 1)
    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    @ApiModelProperty(value = "Description of the tool", required = false, position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "A domain specific identifier of the tool in practice, which is usually the tool number", required = true, position = 3)
    public void setIdentifier1(String id) {
        mIdentifier1 = id;
    }

    public String getIdentifier1() {
        return mIdentifier1;
    }

    @ApiModelProperty(value = "An additional identifier of the tool in operational practice", required = false, position = 4)
    public void setIdentifier2(String toolName) {
        mIdentifier2 = toolName;
    }

    public String getIdentifier2() {
        return mIdentifier2;
    }

    @ApiModelProperty(value = "An additional identifier of the tool in operational practice", required = false, position = 5)
    public void setIdentifier3(String toolIdentifier3) {
        mIdentifier3 = toolIdentifier3;
    }

    public String getIdentifier3() {
        return mIdentifier3;
    }

    @ApiModelProperty(value = "URL at which the technical documents for the tool can be found", required = false, position = 7)
    public void setDocumentUrl(String url) {
        mDocumentUrl = url;
    }

    public String getDocumentUrl() {
        return mDocumentUrl;
    }

    @ApiModelProperty(value = "Tool group to which the tool belongs", required = false, position = 8)
    public void setGroup(ToolIdentifierValueWSModel group) {
        mGroup = group;
    }

    public ToolIdentifierValueWSModel getGroup() {
        return mGroup;
    }

    @JsonProperty(value = "class")
    @ApiModelProperty(value = "Specific tool class within the tool group", required = false, position = 9)
    public void setToolClass(ToolIdentifierValueWSModel toolClass) {
        mClass = toolClass;
    }

    @JsonProperty(value = "class")
    public ToolIdentifierValueWSModel getToolClass() {
        return mClass;
    }

    @ApiModelProperty(value = "Information on service life", required = false, position = 10)
    public void setLifeTime(LifeTime lifeTime) {
        mLifeTime = lifeTime;
    }

    public LifeTime getLifeTime() {
        return mLifeTime;
    }
}