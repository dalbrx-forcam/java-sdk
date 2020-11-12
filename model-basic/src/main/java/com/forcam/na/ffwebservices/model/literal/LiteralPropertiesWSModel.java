package com.forcam.na.ffwebservices.model.literal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "literalProperties")
@ApiModel(value = "literalProperties")
@JsonPropertyOrder({ "id", "translations"})
public class LiteralPropertiesWSModel extends CreateLiteralPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id. */
    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the literal", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }
}