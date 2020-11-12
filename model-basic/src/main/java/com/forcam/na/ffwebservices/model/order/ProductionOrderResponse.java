////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.order;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;

import java.util.List;

/**
 * The response object for a production order.
 */
public class ProductionOrderResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the production order. */
    private OrderPropertiesWSModel mProperties;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded ERP context. */
    private LinkEmbeddedWSModel<ErpContextPropertiesWSModel> mErpContext;

    /** The embedded operations. */
    private List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> mOperations;

    /** The embedded specification. */
    private LinkEmbeddedWSModel<ProductionOrderSpecificationPropertiesWSModel> mProductionOrderSpecification;

    /** The embedded operation sequence. */
    private LinkEmbeddedWSModel<ProductionOrderOperationSequencePropertiesWSModel> mProductionOrderOperationSequence;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> getOperations() {
        return mOperations;
    }

    public void setOperations(List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> operations) {
        mOperations = operations;
    }

    public OrderPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(OrderPropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    public LinkEmbeddedWSModel<ErpContextPropertiesWSModel> getErpContext() {
        return mErpContext;
    }

    public void setErpContext(LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext) {
        mErpContext = erpContext;
    }

    public LinkEmbeddedWSModel<ProductionOrderSpecificationPropertiesWSModel> getProductionOrderSpecification() {
        return mProductionOrderSpecification;
    }

    public void setProductionOrderSpecification(LinkEmbeddedWSModel<ProductionOrderSpecificationPropertiesWSModel> productionOrderSpecification) {
        mProductionOrderSpecification = productionOrderSpecification;
    }

    public void setProductionOrderOperationSequence(LinkEmbeddedWSModel<ProductionOrderOperationSequencePropertiesWSModel> productionOrderOperationSequence) {
        mProductionOrderOperationSequence = productionOrderOperationSequence;
    }

    public LinkEmbeddedWSModel<ProductionOrderOperationSequencePropertiesWSModel> getProductionOrderOperationSequence() {
        return mProductionOrderOperationSequence;
    }
}
