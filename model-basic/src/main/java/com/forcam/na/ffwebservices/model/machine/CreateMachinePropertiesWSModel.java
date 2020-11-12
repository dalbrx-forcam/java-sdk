package com.forcam.na.ffwebservices.model.machine;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "createMachineProperties")
@ApiModel(value = "createMachineProperties")
@JsonPropertyOrder({ "number", "description", "erpContextId", "workplaceId" })
public class CreateMachinePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The number of the machine. */
    private String mNumber;

    /** The description. */
    private String mDescription;

    /** The id of the ERP context. */
    private String mErpContextId;

    /** The id of the workplace. */
    private String mWorkplaceId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Number of the machine", required = true, position = 1)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "Description of the machine", position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "UUID of the ERP Context to which the machine belongs to", required = true, position = 3)
    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

    public String getErpContextId() {
        return mErpContextId;
    }

    @ApiModelProperty(value = "UUID of the assigned workplace", position = 4)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getWorkplaceId() {
        return mWorkplaceId;
    }
}