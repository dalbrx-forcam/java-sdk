package com.forcam.na.ffwebservices.model.pdm;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

;

/**
 * NC Element properties used for creation.
 */
@ApiModel(value = "createFileRepositoryDocumentProperties")
@JsonPropertyOrder({ "origin", "type" })
public class CreateFileRepositoryDocumentWSModelProperties {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The source of the document. */
    private PDMSource mOrigin;

    /** The type of the nc document. */
    private String mType;

    //TODO clarify if a annotation should be a resource
    // private String mAnnotationId;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mOrigin", mOrigin)
            .append("mType", mType)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public PDMSource getOrigin() {
        return mOrigin;
    }

    @ApiModelProperty(value = "Origin of the document, which is either externally created, internally created at the machine or optimized at the machine", required = true, position = 14)
    public void setOrigin(PDMSource origin) {
        mOrigin = origin;
    }

    public String getType() {
        return mType;
    }

    @ApiModelProperty(value = "Type of the document", required = true, position = 15)
    public void setType(String type) {
        mType = type;
    }
}
