////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 29.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.pdm;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

;

/**
 * NC package properties model.
 */
@ApiModel(value = "fileRepositoryFolderProperties")
@JsonPropertyOrder({ "id", "name", "creator", "creationDate", "editor", "lastChangeDate", "workplaceId", "materialNumber" })
public class FileRepositoryFolderWSPropertiesModel extends CommonFileRepositoryFolderWSProperties {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** UUID for an nc package. */
    private String mId;

    /** The creation date. */
    private Date mCreationDate;

    /** The last change date. */
    private Date mLastChangeDate;

    /** The creator of the folder. */
    private String mCreator;

    /** The editor. */
    private String mEditor;

    /** The material. */
    private MaterialPropertiesWSModel mMaterial;

    /** The workplace. */
    private WorkplaceGeneralDefinitionWSModel mWorkplace;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mId", mId)
            .append("mCreationDate", mCreationDate)
            .append("mLastChangeDate", mLastChangeDate)
            .append("mEditor", mEditor)
            .append("mMaterial", mMaterial)
            .append("mWorkplace", mWorkplace)
            .append(super.toString())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Set the UUID for an order.
     *
     * @param id UUID
     */
    @ApiModelProperty(value = "UUID of the document folder", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    /**
     * Provide the UUID of an order.
     *
     * @return UUID
     */
    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "Person or application that created the folder", position = 2)
    public void setCreator(String creator) {
        mCreator = creator;
    }

    public String getCreator() {
        return mCreator;
    }

    @ApiModelProperty(value = "Timestamp when the folder was created", position = 3)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    @ApiModelProperty(value = "Person or application that created the folder", position = 4)
    public void setEditor(String editor) {
        mEditor = editor;
    }

    public String getEditor() {
        return mEditor;
    }

    @ApiModelProperty(value = "Timestamp when the folder was last changed", position = 5)
    public void setLastChangeDate(Date lastChangeDate) {
        mLastChangeDate = lastChangeDate;
    }

    public Date getLastChangeDate() {
        return mLastChangeDate;
    }

    @ApiModelProperty(notes = "If the folder is a production folder that contains the documents for the production of a particular material, this material is specified here", position = 7)
    public void setMaterial(MaterialPropertiesWSModel material) {
        mMaterial = material;
    }

    public MaterialPropertiesWSModel getMaterial() {
        return mMaterial;
    }

    @ApiModelProperty(notes = "Specifies the workplace for which the production documents are valid for exclusively. Applies only if the folder is a production folder", position = 8)
    public void setWorkplace(WorkplaceGeneralDefinitionWSModel workplace) {
        mWorkplace = workplace;
    }

    public WorkplaceGeneralDefinitionWSModel getWorkplace() {
        return mWorkplace;
    }
}