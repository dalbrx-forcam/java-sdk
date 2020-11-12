package com.forcam.na.ffwebservices.model.command.machine;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * WS model for Machine count command.
 * <p>
 * Created: 04.08.2017
 *
 * @author Richa Bali
 */
@XmlRootElement(name = "machineCountCommand")
@ApiModel(value = "machineCountCommand", parent = AbstractCommandDataWSModel.class)
public class MachineCountCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The name as a constant string. */
    public static final String NAME = "MACHINE_COUNT";

    private static final long serialVersionUID = 570145441412963768L;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public MachineCountCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Machine id. */
    private String mMachineId;
    /** Counter number. */
    private long mCounterNumber;
    /** Count. */
    private long mCount;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("machineId", mMachineId)
            .append("counterNumber", mCounterNumber)
            .append("count", mCount)
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

        MachineCountCommandDataWSModel that = (MachineCountCommandDataWSModel) o;

        return new EqualsBuilder()
            .append(mMachineId, that.mMachineId)
            .append(mCounterNumber, that.mCounterNumber)
            .append(mCount, that.mCount)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mMachineId)
            .append(mCounterNumber)
            .append(mCount)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link MachineCountCommandDataWSModel#mMachineId}.
     *
     * @return Machine id.
     */
    public String getMachineId() {
        return mMachineId;
    }

    /**
     * Setter for {@link MachineCountCommandDataWSModel#mMachineId}.
     *
     * @param machineId Machine id.
     */
    public void setMachineId(String machineId) {
        mMachineId = machineId;
    }

    /**
     * Getter for {@link MachineCountCommandDataWSModel#mCounterNumber}.
     *
     * @return Counter number.
     */
    public long getCounterNumber() {
        return mCounterNumber;
    }

    /**
     * Setter for {@link MachineCountCommandDataWSModel#mCounterNumber}.
     *  
     *
     * @param counterNumber Counter number.
     */
    public void setCounterNumber(long counterNumber) {
        mCounterNumber = counterNumber;
    }

    /**
     * Getter for {@link MachineCountCommandDataWSModel#mCount}.
     *  
     *
     * @return Count.
     */
    public long getCount() {
        return mCount;
    }

    /**
     * Setter for {@link MachineCountCommandDataWSModel#mCount}.
     *  
     *
     * @param count Count.
     */
    public void setCount(long count) {
        mCount = count;
    }

}