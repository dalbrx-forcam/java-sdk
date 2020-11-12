////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 30.04.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.order;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Order operation sequence WS model.
 */
@ApiModel(value = "productionOrderOperationSequence")
@JsonPropertyOrder({ "operation", "predecessors", "successors"})
public class ProductionOrderOperationSequenceWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation properties. */
    private ProductionOrderOperationWSModel mOperation = new ProductionOrderOperationWSModel();

    /** List of predecessors of operation. */
    private List<PredecessorWSModel> mPredecessors = new ArrayList<>();

    /** List of successors of operation. */
    private List<SuccessorWSModel> mSuccessors = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the operation properties.
     *
     * @param operation The operation properties.
     */
    @ApiModelProperty(position = 0)
    public void setOperation(ProductionOrderOperationWSModel operation) {
        mOperation = operation;
    }

    /**
     * Provides the operation properties.
     *
     * @return The operation properties.
     */
    public ProductionOrderOperationWSModel getOperation() {
        return mOperation;
    }

    /**
     * Sets the list of predecessors of the operation.
     *
     * @param predecessors The list of predecessors.
     */
    @ApiModelProperty(position = 1)
    public void setPredecessors(List<PredecessorWSModel> predecessors) {
        mPredecessors = predecessors;
    }

    /**
     * Provides list of predecessors of the operation.
     *
     * @return The list of predecessors.
     */
    public List<PredecessorWSModel> getPredecessors() {
        return mPredecessors;
    }

    /**
     * Sets the list of successors of the operation.
     *
     * @param successors The list of successors.
     */
    @ApiModelProperty(position = 2)
    public void setSuccessors(List<SuccessorWSModel> successors) {
        mSuccessors = successors;
    }

    /**
     * Provides the list of successors of the operation.
     *
     * @return The list of successors.
     */
    public List<SuccessorWSModel> getSuccessors() {
        return mSuccessors;
    }
}