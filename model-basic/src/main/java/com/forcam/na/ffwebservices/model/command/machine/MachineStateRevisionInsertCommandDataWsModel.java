package com.forcam.na.ffwebservices.model.command.machine;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.DateFormatUtility;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created: 17.05.2017
 *
 * @author Tobias Salzbrunn
 */
@ApiModel(value = "machineStateRevisionInsertCommand", parent = AbstractCommandDataWSModel.class)
public class MachineStateRevisionInsertCommandDataWsModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The name as a constant string. */
    public static final String NAME = "MACHINE_STATE_REVISION_INSERT";

    private static final long serialVersionUID = -8007999259738252334L;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------
    /** A model of the machine status command. */
    private MachineStateCommandDataWSModel mMachineStateCommand;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    /** The insertion timestamp. */
    private Date mInsertionTimestamp;

    /**
     * Creates a new instance.
     */
    public MachineStateRevisionInsertCommandDataWsModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("machineStateCommand", mMachineStateCommand)
            .append("insertionTimestamp", DateFormatUtility.formatLogging(mInsertionTimestamp))
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

        MachineStateRevisionInsertCommandDataWsModel that = (MachineStateRevisionInsertCommandDataWsModel) o;

        return new EqualsBuilder()
            .append(mMachineStateCommand, that.mMachineStateCommand)
            .append(mInsertionTimestamp, that.mInsertionTimestamp)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mMachineStateCommand)
            .append(mInsertionTimestamp)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Date getInsertionTimestamp() {
        return mInsertionTimestamp;
    }

    @ApiModelProperty(value = "The timestamp where the machine state command should be inserted", required = true)
    public void setInsertionTimestamp(Date insertionTimestamp) {
        mInsertionTimestamp = insertionTimestamp;
    }

    public MachineStateCommandDataWSModel getMachineStateCommand() {
        return mMachineStateCommand;
    }

    public void setMachineStateCommand(MachineStateCommandDataWSModel machineStateCommand) {
        this.mMachineStateCommand = machineStateCommand;
    }
}