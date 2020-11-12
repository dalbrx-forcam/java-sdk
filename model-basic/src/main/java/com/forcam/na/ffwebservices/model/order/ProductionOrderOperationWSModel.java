////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 08.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.CreateOperationPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement(name = "productionOrderOperation")
@ApiModel(value = "productionOrderOperation")
@JsonPropertyOrder({ "id", "number", "split", "description", "productionOrder", "material", "erpContextId" })
public class ProductionOrderOperationWSModel extends CreateOperationPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation ID. */
    private String mId;

    private MaterialPropertiesWSModel mMaterial;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductionOrderOperationWSModel)) {
            return false;
        }

        final ProductionOrderOperationWSModel other = (ProductionOrderOperationWSModel) obj;

        final EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(this.getId(), other.getId());
        equalsBuilder.append(this.getDescription(), other.getDescription());
        equalsBuilder.append(this.getErpContextId(), other.getErpContextId());
        equalsBuilder.append(this.getMaterial(), other.getMaterial());
        equalsBuilder.append(this.getNumber(), other.getNumber());
        equalsBuilder.append(this.getProductionOrder(), other.getProductionOrder());
        equalsBuilder.append(this.getSplit(), other.getSplit());

        return equalsBuilder.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCodeBuilder.append(this.getId());
        hashCodeBuilder.append(this.getDescription());
        hashCodeBuilder.append(this.getErpContextId());
        hashCodeBuilder.append(this.getNumber());
        hashCodeBuilder.append(this.getSplit());
        hashCodeBuilder.append(this.getProductionOrder());
        hashCodeBuilder.append(this.getMaterial());

        return hashCodeBuilder.hashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the operation", required = true, position = 0)
    public void setId(String id) {
        this.mId = id;
    }

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "The material to be produced by the operation", required = true, position = 6)
    public void setMaterial(MaterialPropertiesWSModel material) {
        mMaterial = material;
    }

    public MaterialPropertiesWSModel getMaterial() {
        return mMaterial;
    }
}