package com.forcam.na.ffwebservices.model.command.machine;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * WS model for Machine stroke command.
 * <p>
 * Created: 10.08.2017
 *
 * @author Richa Bali
 */
@XmlRootElement(name = "machineStrokeCommand")
@ApiModel(value = "machineStrokeCommand", parent = AbstractCommandDataWSModel.class)
public class MachineStrokeCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The name as a constant string. */
    public static final String NAME = "MACHINE_STROKE";

    private static final long serialVersionUID = -6655682885975900917L;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public MachineStrokeCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Machine id. */
    private String mMachineId;
    /** Counter number. */
    private short mCounterNumber;
    /** Strokes. */
    private int mStrokes;

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
            .append("strokes", mStrokes)
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

        MachineStrokeCommandDataWSModel that = (MachineStrokeCommandDataWSModel) o;

        return new EqualsBuilder()
            .append(mMachineId, that.mMachineId)
            .append(mCounterNumber, that.mCounterNumber)
            .append(mStrokes, that.mStrokes)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mMachineId)
            .append(mCounterNumber)
            .append(mStrokes)
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link MachineStrokeCommandDataWSModel#mMachineId}.
     *
     * @return Machine id.
     */
    public String getMachineId() {
        return mMachineId;
    }

    /**
     * Setter for {@link MachineStrokeCommandDataWSModel#mMachineId}.
     *
     * @param machineId Machine id .
     */
    public void setMachineId(String machineId) {
        mMachineId = machineId;
    }

    /**
     * Getter for {@link MachineStrokeCommandDataWSModel#mCounterNumber}.
     *
     * @return Counter number.
     */
    public short getCounterNumber() {
        return mCounterNumber;
    }

    /**
     * Setter for {@link MachineStrokeCommandDataWSModel#mCounterNumber}.
     *
     * @param counterNumber Counter number.
     */
    public void setCounterNumber(short counterNumber) {
        mCounterNumber = counterNumber;
    }

    /**
     * Getter for {@link MachineStrokeCommandDataWSModel#mStrokes}.
     *
     * @return Stroke.
     */
    public int getStrokes() {
        return mStrokes;
    }

    /**
     * Setter for {@link MachineStrokeCommandDataWSModel#mStrokes}.
     *
     * @param strokes Strokes.
     */
    public void setStrokes(int strokes) {
        mStrokes = strokes;
    }
}