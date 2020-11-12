package com.forcam.na.ffwebservices.model.erpcontext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "createErpContextProperties")
@ApiModel(value = "createErpContextProperties")
@JsonPropertyOrder({ "systemNumber", "type", "identifier1", "identifier2", "identifier3" })
public class CreateErpContextPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The ERP system identifier. */
    private String mSystem;

    /** The ERP context type. */
    private ERPContextType mType;

    /** The identifier 1. */
    private String mIdentifier1;

    /** The identifier 2. */
    private String mIdentifier2;

    /** The identifier 3. */
    private String mIdentifier3;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getSystem() {
        return mSystem;
    }

    @ApiModelProperty(value = "Identifier of the ERP system", required = false, position = 1)
    @JsonProperty("systemNumber")
    public void setSystem(String system) {
        mSystem = system;
    }

    /**
     * Provides the ERP context type.
     *
     * @return The ERP context type.
     */
    public ERPContextType getType() {
        return mType;
    }

    /**
     * Sets the ERP context type.
     *
     * @param type The ERP context type.
     */
    @ApiModelProperty(value = "ERP context type", required = true, position = 2)
    public void setType(ERPContextType type) {
        mType = type;
    }

    public String getIdentifier1() {
        return mIdentifier1;
    }

    @ApiModelProperty(value = "First identifier of ERP key", required = true, position = 3)
    public void setIdentifier1(String identifier1) {
        mIdentifier1 = identifier1;
    }

    public String getIdentifier2() {
        return mIdentifier2;
    }

    @ApiModelProperty(value = "Second identifier of ERP key", required = true, position = 4)
    public void setIdentifier2(String identifier2) {
        mIdentifier2 = identifier2;
    }

    public String getIdentifier3() {
        return mIdentifier3;
    }

    @ApiModelProperty(value = "Third identifier of ERP key", required = true, position = 5)
    public void setIdentifier3(String identifier3) {
        mIdentifier3 = identifier3;
    }
}