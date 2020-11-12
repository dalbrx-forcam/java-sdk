package com.forcam.na.ffwebservices.model.operationProductionStateDetail;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.machinestatedetail.CreateMachineStateDetailPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created: 05.04.2017
 *
 * @author David Albrecht
 */
@ApiModel(value = "operationProductionStateDetailProperties")
@JsonPropertyOrder({ "id", "description", "shortDescription", "code", "color", "isRecodable", "isSplittable", "isAnnotatable", "customerCode" })
public class OperationProductionStateDetailPropertiesWSModel extends CreateMachineStateDetailPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(position = 0, required = true)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }
}