package com.forcam.na.ffwebservices.model.qualitydetail;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Properties for a quantity reason.
 */
@XmlRootElement(name = "qualityDetailProperties")
@ApiModel(value = "qualityDetailProperties")
@JsonPropertyOrder({ "id", "description", "shortDescription", "qualityTypeId", "code", "color" })
public class QualityDetailPropertiesWSModel extends CreateQualityDetailPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** UUID */
    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of a quality detail", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }
}