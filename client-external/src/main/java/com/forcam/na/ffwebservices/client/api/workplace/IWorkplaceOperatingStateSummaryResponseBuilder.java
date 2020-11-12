package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetOperatingStateSummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRecordedOutputQuantitiesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceOperatingStateSummaryResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOutputQuantitiesResponse;

/**
 * Workplace operating state summary response builder.
 * <p>
 * Created: 05.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public interface IWorkplaceOperatingStateSummaryResponseBuilder {

    /**
     * Maps HAL model from the server to the workplace operating state summary response model.
     *
     * @param request The request.
     * @param model   The server model.
     * @return The workplace operating state summary response.
     */
    WorkplaceOperatingStateSummaryResponse getOperatingStateSummaryResponse(GetOperatingStateSummaryRequest request, HALWSModel model);

    /**
     * Maps HAL model from the server to the workplace recorded output quantities response model.
     *
     * @param request The request.
     * @param model   The server model.
     * @return The workplace recorded output quantities response model.
     */
    WorkplaceRecordedOutputQuantitiesResponse getWorkplaceRecordedOutputQuantitiesResponse(GetWorkplaceRecordedOutputQuantitiesRequest request,
                                                                                           HALWSModel model);
}
