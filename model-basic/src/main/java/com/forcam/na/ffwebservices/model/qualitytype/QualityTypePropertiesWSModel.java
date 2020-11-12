package com.forcam.na.ffwebservices.model.qualitytype;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Properties for an operation quantity type.
 */
@XmlRootElement(name = "qualityTypeProperties")
@ApiModel(value = "qualityTypeProperties")
@JsonPropertyOrder({ "id", "description", "shortDescription", "color" })
public class QualityTypePropertiesWSModel extends CreateQualityTypePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** UUID */
    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "ID of the quality type", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }
}