////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 29.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.pdm;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Properties of the NC Element.
 */
@ApiModel(value = "fileRepositoryDocumentProperties")
@JsonPropertyOrder({ "id", "name", "extension", "size", "creator", "editor", "lastChangeDate", "lastTransferToMachine", "lastTransferedFromWorkplaceId",
                     "lastTransferedToWorkplaceId", "numberOfMachineTransfers", "documentState", "version", "origin", "type", "tags" })
public class FileRepositoryDocumentWSModelProperties extends CreateFileRepositoryDocumentWithCreatorWSModelProperties {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** UUID for an nc element. */
    private String mId;

    /** The date of creation. */
    private Date mCreationDate;

    /** The date of the last change. */
    private Date mLastChangedDate;

    /** Timestamp when the last transaction to a machine occured. */
    private Date mLastTransferToMachine;

    /** The id of the workplace to which the element has been transfered last. */
    private String mLastTransferedToWorkplaceId;

    /** The id of the workplace from which the element has been transfered last. */
    private String mLastTransferedFromWorkplaceId;

    /** The total amount of transfers. */
    private long mNumberOfMachineTransfers;

    /** The file name. */
    private String mName;

    /** The file extension. */
    private String mExtension;

    /** The file size in bytes. */
    private Long mSize;

    /** The last editor. */
    private String mEditor;

    /** The version of the nc element. */
    private int mVersion;

    /** The status of the nc element. */
    private String mDocumentStateId;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provide the UUID of an order.
     *
     * @return UUID
     */
    public String getId() {
        return mId;
    }

    /**
     * Set the UUID for an order.
     *
     * @param id UUID
     */
    @ApiModelProperty(value = "UUID of the document", required = true, position = 0)
    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    @ApiModelProperty(value = "Name of the corresponding file", position = 1)
    public void setName(String name) {
        mName = name;
    }

    public String getExtension() {
        return mExtension;
    }

    @ApiModelProperty(value = "Extension of the corresponding file", position = 2)
    public void setExtension(String extension) {
        mExtension = extension;
    }

    public Long getSize() {
        return mSize;
    }

    @ApiModelProperty(value = "Size of the corresponding file in bytes", position = 3)
    public void setSize(Long size) {
        mSize = size;
    }

    public Date getCreationDate() {
        return mCreationDate;
    }

    @ApiModelProperty(value = "Timestamp when the folder was created", position = 5)
    public void setCreationDate(Date creationDate) {
        mCreationDate = creationDate;
    }

    public String getEditor() {
        return mEditor;
    }

    @ApiModelProperty(value = "Person or application that last edited the document", position = 6)
    public void setEditor(String editor) {
        mEditor = editor;
    }

    public Date getLastChangedDate() {
        return mLastChangedDate;
    }

    @ApiModelProperty(value = "Timestamp when the document was last changed", position = 7)
    public void setLastChangedDate(Date lastChangedDate) {
        mLastChangedDate = lastChangedDate;
    }

    public Date getLastTransferToMachine() {
        return mLastTransferToMachine;
    }

    @ApiModelProperty(value = "Timestamp of the last transfer to a machine", position = 8)
    public void setLastTransferToMachine(Date lastTransferToMachine) {
        mLastTransferToMachine = lastTransferToMachine;
    }

    public String getLastTransferedFromWorkplaceId() {
        return mLastTransferedFromWorkplaceId;
    }

    @ApiModelProperty(value = "ID of the workplace from which it was last transferred", position = 9)
    public void setLastTransferedFromWorkplaceId(String lastTransferedFromWorkplaceId) {
        mLastTransferedFromWorkplaceId = lastTransferedFromWorkplaceId;
    }

    public String getLastTransferedToWorkplaceId() {
        return mLastTransferedToWorkplaceId;
    }

    @ApiModelProperty(value = "ID of the workplace to which it was last transferred", position = 10)
    public void setLastTransferedToWorkplaceId(String lastTransferedToWorkplaceId) {
        mLastTransferedToWorkplaceId = lastTransferedToWorkplaceId;
    }

    public long getNumberOfMachineTransfers() {
        return mNumberOfMachineTransfers;
    }

    @ApiModelProperty(value = "Total number of machine transfers", position = 11)
    public void setNumberOfMachineTransfers(long numberOfMachineTransfers) {
        mNumberOfMachineTransfers = numberOfMachineTransfers;
    }

    public String getDocumentStateId() {
        return mDocumentStateId;
    }

    @ApiModelProperty(value = "State of the document", position = 12)
    public void setDocumentStateId(String documentStateId) {
        mDocumentStateId = documentStateId;
    }

    public int getVersion() {
        return mVersion;
    }

    @ApiModelProperty(value = "Version of the document", position = 13)
    public void setVersion(int version) {
        mVersion = version;
    }

}
