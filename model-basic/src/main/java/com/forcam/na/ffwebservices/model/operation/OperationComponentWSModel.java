package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.material.CreateMaterialPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Operation component webservice model.
 * <p>
 * Created: 03.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
@ApiModel(value = "operationComponent")
@JsonPropertyOrder({ "material", "quantity", "quantityUnit" })
public class OperationComponentWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The material properties. */
    private CreateMaterialPropertiesWSModel mMaterial = new CreateMaterialPropertiesWSModel();

    /** The quantity. */
    private Double mQuantity;

    /** The quantity unit. */
    private String mQuantityUnit;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the material properties.
     *
     * @param material The create material properties WS model.
     */
    @ApiModelProperty(value = "Required material of the component", position = 0)
    public void setMaterial(CreateMaterialPropertiesWSModel material) {
        mMaterial = material;
    }

    /**
     * Provides the material properties.
     *
     * @return The create material properties WS model.
     */
    public CreateMaterialPropertiesWSModel getMaterial() {
        return mMaterial;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity The quantity.
     */
    @ApiModelProperty(value = "Required quantity of the material", position = 1)
    public void setQuantity(Double quantity) {
        mQuantity = quantity;
    }

    /**
     * Provides the quantity.
     *
     * @return The quantity.
     */
    public Double getQuantity() {
        return mQuantity;
    }

    /**
     * Sets the quantity unit.
     *
     * @param quantityUnit The quantity unit.
     */
    @ApiModelProperty(value = "Unit of the required quantity", position = 2)
    public void setQuantityUnit(String quantityUnit) {
        mQuantityUnit = quantityUnit;
    }

    /**
     * Provides the quantity unit.
     *
     * @return The quantity unit.
     */
    public String getQuantityUnit() {
        return mQuantityUnit;
    }
}