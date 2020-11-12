package com.forcam.na.ffwebservices.model.operation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.ffwebservices.model.definition.OperationPhase;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceGeneralDefinitionWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created: 08.03.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "operationProperties")
@ApiModel(value = "operationProperties")
@JsonPropertyOrder({ "id", "number", "split", "sequenceNumber", "description", "startDate", "endDate", "productionOrder", "material", "erpContextId",
                     "currentWorkplace", "operationPhaseId" })
public class OperationPropertiesWSModel extends CreateOperationPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id. */
    private String mId;

    /** The current operation phase id. */
    private OperationPhase mOperationPhaseId;

    /** The current workplace of the operation. */
    private WorkplaceGeneralDefinitionWSModel mCurrentWorkplace;

    private MaterialPropertiesWSModel mMaterial;

    private Date mStartDate;

    private Date mEndDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "UUID of the operation", required = true, position = 0)
    public void setId(String id) {
        this.mId = id;
    }

    public String getId() {
        return mId;
    }

    @ApiModelProperty(value = "The workplace at which the operation is currently being executed, provided that the operation is currently in execution", position = 10)
    public void setCurrentWorkplace(WorkplaceGeneralDefinitionWSModel currentWorkplace) {
        mCurrentWorkplace = currentWorkplace;
    }

    public WorkplaceGeneralDefinitionWSModel getCurrentWorkplace() {
        return mCurrentWorkplace;
    }

    @ApiModelProperty(value = "The identifier of the current operation phase", position = 11)
    public void setOperationPhaseId(OperationPhase operationPhaseId) {
        mOperationPhaseId = operationPhaseId;
    }

    public OperationPhase getOperationPhaseId() {
        return mOperationPhaseId;
    }

    @ApiModelProperty(value = "The material to be produced by the operation", required = true, position = 6)
    public void setMaterial(MaterialPropertiesWSModel material) {
        mMaterial = material;
    }

    public MaterialPropertiesWSModel getMaterial() {
        return mMaterial;
    }

    @ApiModelProperty(value = "The start date of the operation", position = 5)
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    @ApiModelProperty(value = "The end date of the operation", position = 6)
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public Date getEndDate() {
        return mEndDate;
    }
}