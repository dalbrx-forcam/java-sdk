package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.material.CreateMaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@JsonPropertyOrder({ "number", "split", "description", "material", "erpContextId" })
public class CreateOrderPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The order number. */
    private String mNumber;

    /** The order split. */
    private String mSplit;

    /** The description. */
    private String mDescription;

    /** The id of the ERP context. */
    private String mErpContextId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The production order number (most likely overtaken from ERP) the operation belongs to", required = true, position = 1)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "The production order split", required = false, position = 2)
    public void setSplit(String split) {
        mSplit = split;
    }

    public String getSplit() {
        return mSplit;
    }

    @ApiModelProperty(value = "A description of the order", required = false, position = 3)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "UUID of the ERP context in which the combination of an order number and order split is a unique identifier for a production order. In SAP ERP, for example, this context is defined by the client. Further context information is the company code and the plant", required = false, position = 10)
    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

    public String getErpContextId() {
        return mErpContextId;
    }
}