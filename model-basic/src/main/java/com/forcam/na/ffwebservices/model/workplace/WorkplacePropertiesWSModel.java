package com.forcam.na.ffwebservices.model.workplace;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateGeneralDefinitionWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@ApiModel(value = "workplaceProperties")
@JsonFilter("versionFilter")
@JsonPropertyOrder({ "id", "number", "description", "erpContextId", "capacityGroup", "productionLine", "operatingState", "isManualWorkplace", "workplaceType" })
public class WorkplacePropertiesWSModel extends CreateWorkplacePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id. */
    private String mId;

    /** The current operating state */
    private OperatingStateGeneralDefinitionWSModel mOperatingState;

    /** The capacity group. */
    private WorkplaceGroupPropertiesWSModel mCapacityGroup;

    /** The production line. */
    private WorkplaceGroupPropertiesWSModel mProductionLine;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the workplace ", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    @ApiModelProperty(position = 6)
    public void setOperatingState(OperatingStateGeneralDefinitionWSModel operatingState) {
        mOperatingState = operatingState;
    }

    public OperatingStateGeneralDefinitionWSModel getOperatingState() {
        return mOperatingState;
    }

    public WorkplaceGroupPropertiesWSModel getCapacityGroup() {
        return mCapacityGroup;
    }

    @ApiModelProperty(value = "Capacity group of the workplace", position = 4)
    public void setCapacityGroup(WorkplaceGroupPropertiesWSModel capacityGroup) {
        mCapacityGroup = capacityGroup;
    }

    public WorkplaceGroupPropertiesWSModel getProductionLine() {
        return mProductionLine;
    }

    @ApiModelProperty(value = "Production line of the workplace", position = 5)
    public void setProductionLine(WorkplaceGroupPropertiesWSModel productionLine) {
        mProductionLine = productionLine;
    }
}