package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;

import javax.inject.Inject;

/**
 * Link model builder for operation planning result.
 * <p>
 * Created: 17.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class OperationPlanningResultLinkModelBuilder extends AbstractLinkModelBuilder<OperationAssignmentWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /** Creates new instance. */
    @Inject
    public OperationPlanningResultLinkModelBuilder() {
        super(OperationAssignmentWSModel.class);
    }
}