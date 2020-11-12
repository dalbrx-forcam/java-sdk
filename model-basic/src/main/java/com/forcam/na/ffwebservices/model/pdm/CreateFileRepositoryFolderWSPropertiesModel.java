package com.forcam.na.ffwebservices.model.pdm;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Document folder properties used for creation.
 */
@ApiModel(value = "createFileRepositoryFolderProperties")
@JsonPropertyOrder({ "name", "creator", "status", "workplaceId", "materialNumber" })
public class CreateFileRepositoryFolderWSPropertiesModel extends CommonFileRepositoryFolderWSProperties {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace id. */
    private String mWorkplaceId;

    /** The material number. */
    private String mMaterialNumber;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("mWorkplaceId", mWorkplaceId)
            .append("mMaterialNumber", mMaterialNumber)
            .append(super.toString())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    @ApiModelProperty(value = "UUID of the associated workplace", notes = "If the folder is a production folder, and the production documents only apply to a specific workplace, you can specify the UUID of the workplace here", position = 3)
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    public String getMaterialNumber() {
        return mMaterialNumber;
    }

    @ApiModelProperty(value = "Number of the associated material", notes = "If the folder is a production folder that contains the documents for the production of a particular material, you can specify the number of the material here", position = 4)
    public void setMaterialNumber(String materialNumber) {
        mMaterialNumber = materialNumber;
    }
}