package com.forcam.na.ffwebservices.model.tool;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created: 13.03.2017
 *
 * @author David Albrecht
 */
@ApiModel("toolIdentifierValue")
public class ToolIdentifierValueWSModel {
    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mIdentifier;

    private String mName;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getName() {
        return mName;
    }

    @ApiModelProperty(value = "The name of the identifier")
    public void setName(String name) {
        mName = name;
    }

    public String getIdentifier() {
        return mIdentifier;
    }

    @ApiModelProperty(value = "A domain specific identifier of the tool group")
    public void setIdentifier(String identifier) {
        mIdentifier = identifier;
    }

}
