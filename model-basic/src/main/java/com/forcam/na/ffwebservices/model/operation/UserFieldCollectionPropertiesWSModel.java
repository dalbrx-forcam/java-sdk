package com.forcam.na.ffwebservices.model.operation;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Operation user field collection properties.
 *
 * Created: 27.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
@ApiModel(value = "operationUserFieldCollectionProperties")
public class UserFieldCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation user fields. */
    private List<UserFieldWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the list of operation user fields.
     *
     * @param elements List of operation user field WS models.
     */
    public void setElements(List<UserFieldWSModel> elements) {
        mElements = elements;
    }

    /**
     * Sets the list of operation user fields.
     *
     * @return The list of operation user field WS models.
     */
    public List<UserFieldWSModel> getElements() {
        return mElements;
    }
}
