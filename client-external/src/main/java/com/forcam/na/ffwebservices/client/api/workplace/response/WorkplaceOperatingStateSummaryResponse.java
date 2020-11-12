package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.operatingstate.OperatingStateSummaryWSModel;
import com.forcam.na.ffwebservices.model.workplace.WpOperatingStateSummaryPropertiesWSModel;

import java.util.List;

/**
 * Workplace operating state summary response model.
 * <p>
 * Created: 05.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class WorkplaceOperatingStateSummaryResponse extends AbstractCollectionResponse<OperatingStateSummaryWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operating state summary properties of a workplace. */
    private WpOperatingStateSummaryPropertiesWSModel mProperties = new WpOperatingStateSummaryPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public WorkplaceOperatingStateSummaryResponse(PaginationRequest request) {
        super(request);
    }

    @Override
    public List<OperatingStateSummaryWSModel> getElements() {
        return mProperties.getElements();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the workplace operating state summary properties.
     *
     * @return The workplace operating state summary properties WS model.
     */
    public WpOperatingStateSummaryPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the workplace operating state summary properties.
     *
     * @param properties The workplace operating state summary properties WS model.
     */
    public void setProperties(WpOperatingStateSummaryPropertiesWSModel properties) {
        mProperties = properties;
    }
}
