package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.material.CreateMaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Properties for an order.
 */
@ApiModel(value = "productionOrderProperties")
@JsonPropertyOrder({ "id", "number", "split", "description", "material", "erpContextId" })
public class OrderPropertiesWSModel extends CreateOrderPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** UUID for an order. */
    private String mId;

    /** The id of the material. */
    private MaterialPropertiesWSModel mMaterial;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Set the UUID for an order.
     *
     * @param id UUID
     */
    @ApiModelProperty(value = "UUID of the production order", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    /**
     * Provide the UUID of an order.
     *
     * @return UUID
     */
    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "The material to be produced", position = 4)
    public void setMaterial(MaterialPropertiesWSModel material) {
        mMaterial = material;
    }

    public CreateMaterialPropertiesWSModel getMaterial() {
        return mMaterial;
    }
}