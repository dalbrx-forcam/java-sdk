package com.forcam.na.ffwebservices.model.command.machine;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model for machine quantity command.
 * <p>
 * Created: 04.08.2017
 *
 * @author Richa Bali
 */
@XmlRootElement(name = "machineQuantityCommand")
@ApiModel(value = "machineQuantityCommand", parent = AbstractCommandDataWSModel.class)
public class MachineQuantityCommandDataWSModel extends AbstractCommandDataWSModel {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The name as a constant string. */
    public static final String NAME = "MACHINE_QUANTITY";

    private static final long serialVersionUID = -9033078692195385131L;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    public MachineQuantityCommandDataWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Machine id. */
    private String mMachineId;
    /** Quantity amount. */
    private double mQuantity;
    /** UUID for reason id. */
    private String mQualityDetailId;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("machineId", mMachineId)
            .append("quantity", mQuantity)
            .append("qualityDetailId", mQualityDetailId)
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

        MachineQuantityCommandDataWSModel that = (MachineQuantityCommandDataWSModel) o;

        return new EqualsBuilder()
            .append(mMachineId, that.mMachineId)
            .append(mQuantity, that.mQuantity)
            .append(mQualityDetailId, that.mQualityDetailId)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(mMachineId)
            .append(mQuantity)
            .append(mQualityDetailId)
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

    public double getQuantity() {
        return mQuantity;
    }

    public void setQuantity(double quantityAmount) {
        mQuantity = quantityAmount;
    }

    public String getQualityDetailId() {
        return mQualityDetailId;
    }

    public void setQualityDetailId(String mQualityDetailId) {
        this.mQualityDetailId = mQualityDetailId;
    }
}