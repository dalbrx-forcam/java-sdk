package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetOperatingStateSummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRecordedOutputQuantitiesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceOperatingStateSummaryResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOutputQuantitiesResponse;
import com.forcam.na.ffwebservices.model.recordedoutputquantities.RecordedOutputQuantitiesCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WpOperatingStateSummaryPropertiesWSModel;

import javax.inject.Inject;

/**
 * Workplace operating state summary response builder.
 * <p>
 * Created: 05.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class WorkplaceOperatingStateSummaryResponseBuilder extends AbstractResponseBuilder implements IWorkplaceOperatingStateSummaryResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    @Inject
    public WorkplaceOperatingStateSummaryResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public WorkplaceOperatingStateSummaryResponse getOperatingStateSummaryResponse(GetOperatingStateSummaryRequest request, HALWSModel model) {
        final WorkplaceOperatingStateSummaryResponse response = new WorkplaceOperatingStateSummaryResponse(request);
        final WpOperatingStateSummaryPropertiesWSModel propertiesWSModel = mMapper.convertValue(model.getProperties(),
                                                                                                WpOperatingStateSummaryPropertiesWSModel.class);

        response.setProperties(propertiesWSModel);
        response.setPagination(model.getPagination());
        response.setPaginationLinks(model.getLinkModels());

        return response;
    }

    @Override
    public WorkplaceRecordedOutputQuantitiesResponse getWorkplaceRecordedOutputQuantitiesResponse(GetWorkplaceRecordedOutputQuantitiesRequest request,
                                                                                                  HALWSModel model) {
        final WorkplaceRecordedOutputQuantitiesResponse response = new WorkplaceRecordedOutputQuantitiesResponse(request);
        final RecordedOutputQuantitiesCollectionPropertiesWSModel propertiesWSModel = mMapper.convertValue(model.getProperties(),
                                                                                                           RecordedOutputQuantitiesCollectionPropertiesWSModel.class);

        response.setProperties(propertiesWSModel);
        response.setPagination(model.getPagination());
        response.setPaginationLinks(model.getLinkModels());

        return response;
    }
}
