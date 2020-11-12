////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 3/9/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.TimePeriodWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceScheduledOperatingTimesPropertiesWSModel;

import java.util.List;

/**
 * Response for the workplace scheduled operating times.
 */
public class WorkplaceScheduledOperatingTimesCollectionResponse extends AbstractCollectionResponse<TimePeriodWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Workplace scheduled operating time properties model. */
    private WorkplaceScheduledOperatingTimesPropertiesWSModel mProperties = new WorkplaceScheduledOperatingTimesPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public WorkplaceScheduledOperatingTimesCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link WorkplaceScheduledOperatingTimesCollectionResponse#mProperties}.
     *
     * @return Workplace scheduled operating time properties model.
     */
    public WorkplaceScheduledOperatingTimesPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Setter for {@link WorkplaceScheduledOperatingTimesCollectionResponse#mProperties}.
     *
     * @param properties Workplace scheduled operating time properties model.
     */
    public void setProperties(WorkplaceScheduledOperatingTimesPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<TimePeriodWSModel> getElements() {
        return mProperties.getElements();
    }
}