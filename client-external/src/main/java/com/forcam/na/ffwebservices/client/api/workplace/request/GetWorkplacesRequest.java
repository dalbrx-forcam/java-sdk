////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 11.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceEmbed;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceType;

;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetWorkplacesRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private WorkplaceEmbed mEmbed = new WorkplaceEmbed();
    /** The name of the workplace. */
    private String mWorkplaceName;
    /** The id of the ERP key. */
    private String mErpKeyId;
    /** The id of the workplace group number. */
    private String mWorkplaceGroupNumber;
    /** The workplace group ID. */
    private String mWorkplaceGroupId;
    /** The workplace type code. */
    private WorkplaceType mWorkplaceTypeCode;
    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public WorkplaceEmbed embed() {
        return mEmbed;
    }

    public void embed(WorkplaceEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("embed", mEmbed)
            .append("workplaceName", mWorkplaceName)
            .append("erpKeyId", mErpKeyId)
            .append("workplaceGroupNumber", mWorkplaceGroupNumber)
            .append("workplaceGroupId", mWorkplaceGroupId)
            .append("workplaceTypeCode", mWorkplaceTypeCode)
            .toString();
    }

    /**
     * Getter for {@link GetWorkplacesRequest#mWorkplaceName}.
     *
     * @return The name of the workplace.
     */
    public String getWorkplaceName() {
        return mWorkplaceName;
    }

    /**
     * Setter for {@link GetWorkplacesRequest#mWorkplaceName}.
     *
     * @param workplaceName The name of the workplace.
     */
    public void setWorkplaceName(String workplaceName) {
        mWorkplaceName = workplaceName;
    }

    /**
     * Getter for {@link GetWorkplacesRequest#mErpKeyId}.
     *
     * @return The id of the ERP key.
     */
    public String getErpKeyId() {
        return mErpKeyId;
    }

    /**
     * Setter for {@link GetWorkplacesRequest#mErpKeyId}.
     *
     * @param erpKeyId The id of the ERP key.
     */
    public void setErpKeyId(String erpKeyId) {
        mErpKeyId = erpKeyId;
    }

    /**
     * Getter for {@link GetWorkplacesRequest#mWorkplaceGroupNumber}.
     *
     * @return The id of the workplace group number.
     */
    public String getWorkplaceGroupNumber() {
        return mWorkplaceGroupNumber;
    }

    /**
     * Setter for {@link GetWorkplacesRequest#mWorkplaceGroupNumber}.
     *
     * @param workplaceGroupNumber The id of the workplace group number.
     */
    public void setWorkplaceGroupNumber(String workplaceGroupNumber) {
        mWorkplaceGroupNumber = workplaceGroupNumber;
    }

    /**
     * Getter for {@link GetWorkplacesRequest#mWorkplaceGroupId}.
     *
     * @return The workplace group ID.
     */
    public String getWorkplaceGroupId() {
        return mWorkplaceGroupId;
    }

    /**
     * Setter for {@link GetWorkplacesRequest#mWorkplaceGroupId}.
     *
     * @param workplaceGroupId The workplace group ID.
     */
    public void setWorkplaceGroupId(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }

    /**
     * Getter for {@link GetWorkplacesRequest#mWorkplaceTypeCode}.
     *
     * @return The type code of workplace.
     */
    public WorkplaceType getWorkplaceTypeCode() {
        return mWorkplaceTypeCode;
    }

    /**
     * Setter for {@link GetWorkplacesRequest#mWorkplaceTypeCode}.
     *
     * @param workplaceTypeCode The type code of workplace.
     */
    public void setWorkplaceTypeCode(WorkplaceType workplaceTypeCode) {
        mWorkplaceTypeCode = workplaceTypeCode;
    }
}