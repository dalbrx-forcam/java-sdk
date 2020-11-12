package com.forcam.na.ffwebservices.model.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 27.04.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "commandProperties")
@ApiModel(value = "commandProperties")
public class CommandPropertiesWSModel<T extends AbstractCommandDataWSModel> extends CreateCommandPropertiesWSModel<T> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id. */
    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "UUID of the command")
    public void setId(String id) {
        mId = id;
    }

}
