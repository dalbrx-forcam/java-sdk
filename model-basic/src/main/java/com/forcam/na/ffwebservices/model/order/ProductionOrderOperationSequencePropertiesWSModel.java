////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 08.05.2018.
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
 * Production order operation sequence properties model.
 */
@ApiModel(value = "productionOrderOperationSequenceProperties")
@JsonPropertyOrder({ "elements"})
public class ProductionOrderOperationSequencePropertiesWSModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The order operation sequences. */
    private List<ProductionOrderOperationSequenceWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the list of order operation sequence.
     *
     * @param elements List of order operation sequence WS models.
     */
    @ApiModelProperty(position = 0)
    public void setElements(List<ProductionOrderOperationSequenceWSModel> elements) {
        mElements = elements;
    }

    /**
     * Sets the list of order operation sequence.
     *
     * @return The list of order operation sequence WS models.
     */
    public List<ProductionOrderOperationSequenceWSModel> getElements() {
        return mElements;
    }
}