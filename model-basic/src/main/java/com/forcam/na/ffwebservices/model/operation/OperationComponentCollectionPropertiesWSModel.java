package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Operation component collection properties webservice model.
 * <p>
 * Created: 03.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
@ApiModel(value = "operationComponentCollectionProperties")
@JsonPropertyOrder({ "elements" })
public class OperationComponentCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation components. */
    private List<OperationComponentWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the list of operation components.
     *
     * @param elements List of operation component WS models.
     */
    @ApiModelProperty(value = "Array of operation components", position = 0)
    public void setElements(List<OperationComponentWSModel> elements) {
        mElements = elements;
    }

    /**
     * Sets the list of operation components.
     *
     * @return The list of operation component WS models.
     */
    public List<OperationComponentWSModel> getElements() {
        return mElements;
    }
}