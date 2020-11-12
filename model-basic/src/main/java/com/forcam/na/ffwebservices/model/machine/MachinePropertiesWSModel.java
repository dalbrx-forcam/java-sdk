package com.forcam.na.ffwebservices.model.machine;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.definition.MachineState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "machineProperties")
@ApiModel(value = "machineProperties")
@JsonPropertyOrder({ "id", "number", "description", "erpContextId", "workplaceId" })
public class MachinePropertiesWSModel extends CreateMachinePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id. */
    private String mId;

    private MachineState mMachineStateId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the machine", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public void setMachineStateId(MachineState machineStateId) {
        mMachineStateId = machineStateId;
    }

    public MachineState getMachineStateId() {
        return mMachineStateId;
    }
}