////////////////////////////////////////////////////////////////////////////////
//
// Created by DZeise on 09.03.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.statusdefinition;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;

/**
 * A document state model.
 */
public class DocumentStateResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the document state. */
    private DocumentStatePropertiesWSModel mProperties;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public DocumentStatePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(DocumentStatePropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }
}
