package com.forcam.na.ffwebservices.model.workplace;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "createWorkplaceProperties")
@ApiModel(value = "createWorkplaceProperties")
@JsonPropertyOrder({ "number", "description", "erpContextId", "isManualWorkplace", "workplaceType" })
public class CreateWorkplacePropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The name. */
    private String mNumber;

    /** The description. */
    private String mDescription;

    /** The id of the ERP context. */
    private String mErpContextId;

    /** Is it a manual workplace? */
    private boolean mIsManualWorkplace;

    /** The type of workplace */
    private WorkplaceType mWorkplaceType;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "The workplace number which is unique in its ERP context", position = 1)
    public void setNumber(String number) {
        mNumber = number;
    }

    public String getNumber() {
        return mNumber;
    }

    @ApiModelProperty(value = "A description of the workplace ", position = 2)
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    @ApiModelProperty(value = "UUID of the ERP context in which the workplace number is a unique identifier for a workplace or a workplace group. In SAP ERP, for example, this context is defined by the client, the company code, and the plant", position = 3)
    public void setErpContextId(String erpContextId) {
        mErpContextId = erpContextId;
    }

    public String getErpContextId() {
        return mErpContextId;
    }

    @Deprecated
    @ApiModelProperty(hidden = true, value = "Deprecated: Please use workplaceType instead. Boolean to indicate the workplace as manually operated or not.", position = 7)
    public void setIsManualWorkplace(boolean isManualWorkplace) {
        mIsManualWorkplace = isManualWorkplace;
    }

    @Deprecated
    public boolean isIsManualWorkplace() {
        return mIsManualWorkplace;
    }

    @ApiModelProperty(value = "The type of the workplace e.g. 'MANUAL MACHINE WORKPLACE','MANUAL WORKPLACE' or 'MACHINE WORKPLACE'", position = 7)
    public void setWorkplaceType(WorkplaceType workplaceType) {
        mWorkplaceType = workplaceType;
    }

    public WorkplaceType getWorkplaceType() {
        return mWorkplaceType;
    }
}