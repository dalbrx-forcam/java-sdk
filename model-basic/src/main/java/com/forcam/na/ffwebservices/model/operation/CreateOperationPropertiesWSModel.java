package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.material.CreateMaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.order.ProductionOrderGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "createOperationProperties")
@ApiModel(value = "createOperationProperties")
@JsonPropertyOrder({ "number", "split", "sequenceNumber", "description", "productionOrder", "material", "erpContextId" })
public class CreateOperationPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The number of the operation. */
    private String mNumber;

    /** The operation split. */
    private String mSplit;

    /** The description. */
    private String mDescription;

    /** The id of the order. */
    private ProductionOrderGeneralDefinitionWSModel mProductionOrder;

    private String mSequenceNumber;

    /** The id of the ERP context. */
    private String mErpContextId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The operation number within the ERP system", required = true, position = 1)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "Number of the operation split", notes = "Which is empty if the operation has not been split", position = 2)
    public void setSplit(String split) {
        mSplit = split;
    }

    public String getSplit() {
        return mSplit;
    }

    public String getSequenceNumber() {
        return mSequenceNumber;
    }

    @ApiModelProperty(value = "The operation sequence number within the ERP system", notes = "Which is empty if the operation has only one sequence", position = 3)
    public void setSequenceNumber(String sequenceNumber) {
        mSequenceNumber = sequenceNumber;
    }

    @ApiModelProperty(value = "A description of the operation", position = 4)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "The corresponding production order", required = true, position = 7)
    public void setProductionOrder(ProductionOrderGeneralDefinitionWSModel productionOrder) {
        mProductionOrder = productionOrder;
    }

    public ProductionOrderGeneralDefinitionWSModel getProductionOrder() {
        return mProductionOrder;
    }

    @ApiModelProperty(value = "UUID of the ERP context in which the workplace number is a unique identifier for a workplace or a workplace group. In SAP ERP, for example, this context is defined by the client, the company code, and the plant", required = true, position = 7)
    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

    public String getErpContextId() {
        return mErpContextId;
    }
}