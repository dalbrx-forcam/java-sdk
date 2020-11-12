////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 15.11.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.statusdefinition;

import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 */
@ApiModel(value = "operatingStateGeneralDefinition")
public class OperatingStateGeneralDefinitionWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mId;

    private WorkplaceState mWorkplaceStateId;

    /** The description. */
    private String mDescription;

    /** The code. */
    private String mCode;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "UUID of the operating state", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "A description of the operating state", position = 1)
    public void setDescription(String description) {
        mDescription = description;
    }

    public WorkplaceState getWorkplaceStateId() {
        return mWorkplaceStateId;
    }

    @ApiModelProperty(value = "ID of the corresponding workplace state", position = 3)
    public void setWorkplaceStateId(WorkplaceState workplaceStateId) {
        mWorkplaceStateId = workplaceStateId;
    }

    public String getCode() {
        return mCode;
    }

    @ApiModelProperty(value = "The code assigned to the operating state", position = 2)
    public void setCode(String code) {
        mCode = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final OperatingStateGeneralDefinitionWSModel that = (OperatingStateGeneralDefinitionWSModel) o;

        final EqualsBuilder builder = new EqualsBuilder();
        builder.append(mId, that.mId);
        builder.append(mWorkplaceStateId, that.mWorkplaceStateId);
        builder.append(mDescription, that.mDescription);
        builder.append(mCode, that.mCode);

        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(mId);
        builder.append(mWorkplaceStateId);
        builder.append(mDescription);
        builder.append(mCode);
        return builder.hashCode();
    }

}
