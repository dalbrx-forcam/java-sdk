package com.forcam.na.ffwebservices.client.api.staffmember.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberAbsenceCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberAbsenceWSModel;

import java.util.List;

/**
 * Collection response for person absence times.
 * <p>
 * Created: 14.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class StaffMemberAbsenceCollectionResponse extends AbstractCollectionResponse<StaffMemberAbsenceWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The person absence collection properties WS model. */
    private StaffMemberAbsenceCollectionPropertiesWSModel mProperties = new StaffMemberAbsenceCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public StaffMemberAbsenceCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the person absence collection properties.
     *
     * @param properties The person absence collection properties WS model.
     */
    public void setProperties(StaffMemberAbsenceCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    /**
     * Provides the person absece collection properties.
     *
     * @return The person absence collection properties WS model.
     */
    public StaffMemberAbsenceCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    @Override
    public List<StaffMemberAbsenceWSModel> getElements() {
        return mProperties.getElements();
    }
}
