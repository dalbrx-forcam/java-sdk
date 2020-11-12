package com.forcam.na.ffwebservices.model.command.machine;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import com.forcam.na.ffwebservices.model.definition.MachineState;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

/**
 * Created: 05.04.2017
 *
 * @author David Albrecht
 */
@ApiModel(value = "machineStateCommand", parent = AbstractCommandDataWSModel.class)
public class MachineStateCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The name as a constant string. */
    public static final String NAME = "MACHINE_STATE";

    private static final long serialVersionUID = -4962984050846275660L;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public MachineStateCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The id of the machine. */
    private String mMachineId;

    /** The id of the machine state. */
    private MachineState mMachineStateId;

    /** A list of ids of machine state details. */
    private List<String> mMachineStateDetailIds;

    /** An annotation. */
    private String mAnnotation;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("machineId", mMachineId)
            .append("machineStateId", mMachineStateId)
            .append("machineStateDetailIds", mMachineStateDetailIds)
            .append("annotation", mAnnotation)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MachineStateCommandDataWSModel that = (MachineStateCommandDataWSModel) o;

        return new EqualsBuilder()
            .append(mMachineId, that.mMachineId)
            .append(mMachineStateId, that.mMachineStateId)
            .append(mMachineStateDetailIds, that.mMachineStateDetailIds)
            .append(mAnnotation, that.mAnnotation)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mMachineId)
            .append(mMachineStateId)
            .append(mMachineStateDetailIds)
            .append(mAnnotation)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getMachineId() {
        return mMachineId;
    }

    public void setMachineId(String machineId) {
        mMachineId = machineId;
    }

    public String getAnnotation() {
        return mAnnotation;
    }

    public void setAnnotation(String annotation) {
        mAnnotation = annotation;
    }

    public List<String> getMachineStateDetailIds() {
        return mMachineStateDetailIds;
    }

    public void setMachineStateDetailIds(List<String> statusDetailIds) {
        mMachineStateDetailIds = statusDetailIds;
    }

    public MachineState getMachineStateId() {
        return mMachineStateId;
    }

    public void setMachineStateId(MachineState machineStateId) {
        mMachineStateId = machineStateId;
    }
}