////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 20.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 */
@ApiModel("productionOrderGeneralDefinition")
@JsonPropertyOrder({ "id", "number", "split", "description", "material", "erpContextId" })
public class ProductionOrderGeneralDefinitionWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The order id */
    private String mId;

    /** The order number */
    private String mNumber;

    /** The order split */
    private String mSplit;

    /** The order description */
    private String mDescription;

    /** The order materal */
    private MaterialPropertiesWSModel mMaterial;

    /** The erp context id */
    private String mErpContextId;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProductionOrderGeneralDefinitionWSModel)) {
            return false;
        }

        final ProductionOrderGeneralDefinitionWSModel other = (ProductionOrderGeneralDefinitionWSModel) obj;

        final EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(this.getId(), other.getId());
        equalsBuilder.append(this.getDescription(), other.getDescription());
        equalsBuilder.append(this.getErpContextId(), other.getErpContextId());
        equalsBuilder.append(this.getMaterial(), other.getMaterial());
        equalsBuilder.append(this.getNumber(), other.getNumber());
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
        hashCodeBuilder.append(this.getMaterial());

        return hashCodeBuilder.hashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the production order", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "The order number", required = true, position = 1)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "The order split", position = 2)
    public void setSplit(String split) {
        mSplit = split;
    }

    public String getSplit() {
        return mSplit;
    }

    @ApiModelProperty(value = "A description of the order", position = 3)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "The material to be produced by the order", position = 4)
    public void setMaterial(MaterialPropertiesWSModel material) {
        mMaterial = material;
    }

    public MaterialPropertiesWSModel getMaterial() {
        return mMaterial;
    }

    @ApiModelProperty(value = "UUID of the ERP context in which the workplace number is a unique identifier for a workplace or a workplace group. In SAP ERP, for example, this context is defined by the client, the company code, and the plant", position = 5)
    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

    public String getErpContextId() {
        return mErpContextId;
    }
}