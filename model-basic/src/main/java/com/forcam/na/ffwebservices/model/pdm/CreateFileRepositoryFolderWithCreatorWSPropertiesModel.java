package com.forcam.na.ffwebservices.model.pdm;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

;

/**
 * Document folder properties used for creation.
 */
@ApiModel(value = "createFileRepositoryFolderProperties")
@JsonPropertyOrder({ "name", "creator", "status", "workplaceId", "materialNumber" })
public class CreateFileRepositoryFolderWithCreatorWSPropertiesModel extends CreateFileRepositoryFolderWSPropertiesModel {
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace id. */
    private String mWorkplaceId;

    /** The material number. */
    private String mMaterialNumber;

    /** The creator of the folder. */
    private String mCreator;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("workplaceId", mWorkplaceId)
            .append("materialNumber", mMaterialNumber)
            .append("creator", mCreator)
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

    @ApiModelProperty(value = "Person or application that created the folder", position = 2)
    public void setCreator(String creator) {
        mCreator = creator;
    }

    public String getCreator() {
        return mCreator;
    }
}