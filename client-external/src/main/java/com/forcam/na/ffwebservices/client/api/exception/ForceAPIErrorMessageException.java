package com.forcam.na.ffwebservices.client.api.exception;

import com.forcam.na.common.webservices.model.ErrorMessageWSModel;

public class ForceAPIErrorMessageException extends ForceAPIException {

    // ----------------------------------------------------------------------
    // members
    // ----------------------------------------------------------------------

    /** The error message model. */
    private ErrorMessageWSModel mMessageWSModel;

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    /**
     * Creates a new force api error message exception.
     *
     * @param model              A message model.
     * @param requestDescription The request description.
     */
    public ForceAPIErrorMessageException(IRequestDescriptor requestDescription, ErrorMessageWSModel model) {
        super(requestDescription, model.getMessage(), model.getStatus());
        mMessageWSModel = model;
    }

    // ----------------------------------------------------------------------
    // getters/setters
    // ----------------------------------------------------------------------

    public ErrorMessageWSModel getMessageWSModel() {
        return mMessageWSModel;
    }
}
