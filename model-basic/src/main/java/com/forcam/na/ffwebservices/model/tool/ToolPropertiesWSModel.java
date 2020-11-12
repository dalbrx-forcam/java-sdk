package com.forcam.na.ffwebservices.model.tool;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The tool properties.
 */
@ApiModel(value = "toolProperties")
@JsonPropertyOrder({ "id", "name", "description", "identifier1", "identifier2", "identifier3", "toolStateId", "documentUrl", "group", "class" })
public class ToolPropertiesWSModel extends GetToolPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The tool uuid */
    private String mId;

    /** The tool status */
    private String mToolStateId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the tool", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "ID of the tool state", required = false, position = 6)
    public void setToolStateId(String toolStateId) {
        mToolStateId = toolStateId;
    }

    public String getToolStateId() {
        return mToolStateId;
    }
}