package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;

import javax.inject.Inject;

/**
 * Creates an operation link model
 * <p>
 * Created: 09.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class OperationLinkModelBuilder extends AbstractLinkModelBuilder<OperationPropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /** Creates new instance. */
    @Inject
    public OperationLinkModelBuilder() {
        super(OperationPropertiesWSModel.class);
    }
}
