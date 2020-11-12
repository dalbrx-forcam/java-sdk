package com.forcam.na.ffwebservices.client.api.operation.operationplanning.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

/**
 * Operation planning result response.
 * <p>
 * Created: 27.03.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class OperationPlanningResultResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation planning result properties. */
    private OperationAssignmentWSModel mProperties;

    /** The embedded planned workplace. */
    private LinkEmbeddedWSModel<WorkplacePropertiesWSModel> mPlannedWorkplace;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation planning result properties.
     *
     * @return The operation planning result properties WS model.
     */
    public OperationAssignmentWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the operation planning result properties.
     *
     * @param properties The operation planning result properties WS model.
     */
    public void setProperties(OperationAssignmentWSModel properties) {
        mProperties = properties;
    }

    /**
     * Provides the embedded planned workplace.
     *
     * @return The embedded planned workplace.
     */
    public LinkEmbeddedWSModel<WorkplacePropertiesWSModel> getPlannedWorkplace() {
        return mPlannedWorkplace;
    }

    /**
     * Sets the embedded planned workplace.
     *
     * @param plannedWorkplace The embedded planned workplace.
     */
    public void setPlannedWorkplace(LinkEmbeddedWSModel<WorkplacePropertiesWSModel> plannedWorkplace) {
        mPlannedWorkplace = plannedWorkplace;
    }
}
