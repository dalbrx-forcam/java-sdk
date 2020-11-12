////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.machine;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

/**
 * A model for machines.
 */
public class MachineResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the operation. */
    private MachinePropertiesWSModel mProperties;

    /** The embedded ERP context. */
    private LinkEmbeddedWSModel<ErpContextPropertiesWSModel> mErpContext;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded workplace. */
    private LinkEmbeddedWSModel<WorkplacePropertiesWSModel> mWorkplace;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public MachinePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(MachinePropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<ErpContextPropertiesWSModel> getErpContext() {
        return mErpContext;
    }

    public void setErpContext(LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext) {
        mErpContext = erpContext;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    public LinkEmbeddedWSModel<WorkplacePropertiesWSModel> getWorkplace() {
        return mWorkplace;
    }

    public void setWorkplace(LinkEmbeddedWSModel<WorkplacePropertiesWSModel> workplace) {
        mWorkplace = workplace;
    }
}