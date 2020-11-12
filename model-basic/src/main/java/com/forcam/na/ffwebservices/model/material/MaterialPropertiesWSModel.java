package com.forcam.na.ffwebservices.model.material;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "materialProperties")
@ApiModel(value = "materialProperties")
@JsonPropertyOrder({ "id", "number", "description", "type" })
public class MaterialPropertiesWSModel extends CreateMaterialPropertiesWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The id. */
    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the material", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }
}