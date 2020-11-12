////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplacegroup;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;

/**
 * The response object for a workplace group.
 */
public class WorkplaceGroupResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the workplace group. */
    private WorkplaceGroupPropertiesWSModel mProperties;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded ERP context. */
    private LinkEmbeddedWSModel<ErpContextPropertiesWSModel> mErpContext;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the workplace group properties.
     *
     * @return The workplace group properties WS model.
     */
    public WorkplaceGroupPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the workplace group properties.
     *
     * @param properties The workplace group properties WS model.
     */
    public void setProperties(WorkplaceGroupPropertiesWSModel properties) {
        mProperties = properties;
    }

    /**
     * Provides the embedded description.
     *
     * @return The link embedded WS model of description litersl.
     */
    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    /**
     * Sets the embedded description.
     *
     * @param description The link embedded WS model of description litersl.
     */
    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    /**
     * Provides the embedded ERP context.
     *
     * @return The link embedded WS model of ERP context.
     */
    public LinkEmbeddedWSModel<ErpContextPropertiesWSModel> getErpContext() {
        return mErpContext;
    }

    /**
     * Sets the embedded ERP context.
     *
     * @param erpContext The link embedded WS model of ERP context.
     */
    public void setErpContext(LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext) {
        mErpContext = erpContext;
    }
}