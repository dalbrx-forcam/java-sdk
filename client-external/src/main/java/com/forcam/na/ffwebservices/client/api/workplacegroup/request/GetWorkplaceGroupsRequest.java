////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplacegroup.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupEmbed;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupType;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetWorkplaceGroupsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private WorkplaceGroupEmbed mEmbed = new WorkplaceGroupEmbed();

    /** The workplace group number. */
    private String mWorkplaceGroupNumber;

    /** The workplace group type. */
    private WorkplaceGroupType mType;

    /** The ERP context ID. */
    private String mErpContextId;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public WorkplaceGroupEmbed embed() {
        return mEmbed;
    }

    public void embed(WorkplaceGroupEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("workplaceGroupNumber", mWorkplaceGroupNumber)
            .append("type", mType)
            .append("erpContextId", mErpContextId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceGroupNumber() {
        return mWorkplaceGroupNumber;
    }

    public void setWorkplaceGroupNumber(String workplaceGroupNumber) {
        mWorkplaceGroupNumber = workplaceGroupNumber;
    }

    public WorkplaceGroupType getType() {
        return mType;
    }

    public void setType(WorkplaceGroupType type) {
        mType = type;
    }

    public String getErpContextId() {
        return mErpContextId;
    }

    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }
}