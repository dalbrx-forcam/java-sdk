package com.forcam.na.ffwebservices.model.staffmember;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Staff member absence collection properties.
 * <p>
 * Created: 13.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
@ApiModel(value = "staffMemberAbsenceProperties")
@JsonPropertyOrder({ "elements"})
public class StaffMemberAbsenceCollectionPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member absence times. */
    private List<StaffMemberAbsenceWSModel> mElements = new ArrayList<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the list of staff member absence times.
     *
     * @param elements List of staff member absence WS models.
     */
    @ApiModelProperty(position = 0)
    public void setElements(List<StaffMemberAbsenceWSModel> elements) {
        mElements = elements;
    }

    /**
     * Sets the list of staff member absence times.
     *
     * @return The list of staff member absence WS models.
     */
    public List<StaffMemberAbsenceWSModel> getElements() {
        return mElements;
    }
}