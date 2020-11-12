////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 10.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceScheduledMaintenanceTimesPropertiesWSModel;

import java.util.List;

/**
 * Response for the workplace scheduled maintenance times.
 */
public class WorkplaceScheduledMaintenanceTimesCollectionResponse extends AbstractCollectionResponse<TimePeriodWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Workplace scheduled maintenance time properties model. */
    private WorkplaceScheduledMaintenanceTimesPropertiesWSModel mProperties = new WorkplaceScheduledMaintenanceTimesPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public WorkplaceScheduledMaintenanceTimesCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link WorkplaceScheduledMaintenanceTimesCollectionResponse#mProperties}.
     *
     * @return Workplace scheduled maintenance time properties model.
     */
    public WorkplaceScheduledMaintenanceTimesPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Setter for {@link WorkplaceScheduledMaintenanceTimesCollectionResponse#mProperties}.
     *
     * @param properties Workplace scheduled maintenance time properties model.
     */
    public void setProperties(WorkplaceScheduledMaintenanceTimesPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<TimePeriodWSModel> getElements() {
        return mProperties.getElements();
    }
}