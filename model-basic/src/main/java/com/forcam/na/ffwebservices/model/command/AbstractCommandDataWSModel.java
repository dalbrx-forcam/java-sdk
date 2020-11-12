package com.forcam.na.ffwebservices.model.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.command.domain.DomainAttributeChangeCommandWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineCountCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineQuantityCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStateRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.machine.MachineStrokeCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationPhaseRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationProductionStateCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationProductionStateRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.operation.OperationQuantityRevisionInsertCommandDataWsModel;
import com.forcam.na.ffwebservices.model.command.staffmember.StaffMemberOperationStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.staffmember.StaffMemberOperationStateRevisionInsertCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.staffmember.StaffMemberTimeAttendanceBreakCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.staffmember.StaffMemberTimeAttendanceBreakRevisionInsertCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.staffmember.StaffMemberTimeAttendanceCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.staffmember.StaffMemberTimeAttendanceRevisionInsertCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.staffmember.StaffMemberWorkplaceStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.staffmember.StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.workplace.PlannedMaintenanceStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.workplace.ShiftStateCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.workplace.WorkplaceMaintenanceRequestCommandDataWSModel;
import com.forcam.na.ffwebservices.model.command.workplace.WorkplaceMaintenanceStateCommandDataWSModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created: 23.02.2017
 *
 * @author David Albrecht
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({ @JsonSubTypes.Type(value = OperationPhaseCommandDataWsModel.class, name = OperationPhaseCommandDataWsModel.NAME),
                @JsonSubTypes.Type(value = MachineStateCommandDataWSModel.class, name = MachineStateCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = MachineQuantityCommandDataWSModel.class, name = MachineQuantityCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = MachineStateRevisionInsertCommandDataWsModel.class, name = MachineStateRevisionInsertCommandDataWsModel.NAME),
                @JsonSubTypes.Type(value = MachineCountCommandDataWSModel.class, name = MachineCountCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = MachineStrokeCommandDataWSModel.class, name = MachineStrokeCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = OperationPhaseRevisionInsertCommandDataWsModel.class, name = OperationPhaseRevisionInsertCommandDataWsModel.NAME),
                @JsonSubTypes.Type(value = OperationQuantityCommandDataWsModel.class, name = OperationQuantityCommandDataWsModel.NAME),
                @JsonSubTypes.Type(value = OperationQuantityRevisionInsertCommandDataWsModel.class, name = OperationQuantityRevisionInsertCommandDataWsModel.NAME),
                @JsonSubTypes.Type(value = StaffMemberOperationStateCommandDataWSModel.class, name = StaffMemberOperationStateCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = StaffMemberOperationStateRevisionInsertCommandDataWSModel.class, name = StaffMemberOperationStateRevisionInsertCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = StaffMemberWorkplaceStateCommandDataWSModel.class, name = StaffMemberWorkplaceStateCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel.class, name = StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = PlannedMaintenanceStateCommandDataWSModel.class, name = PlannedMaintenanceStateCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = WorkplaceMaintenanceRequestCommandDataWSModel.class, name = WorkplaceMaintenanceRequestCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = WorkplaceMaintenanceStateCommandDataWSModel.class, name = WorkplaceMaintenanceStateCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = ShiftStateCommandDataWSModel.class, name = ShiftStateCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel.class, name = StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = StaffMemberTimeAttendanceCommandDataWSModel.class, name = StaffMemberTimeAttendanceCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = StaffMemberTimeAttendanceRevisionInsertCommandDataWSModel.class, name = StaffMemberTimeAttendanceRevisionInsertCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = StaffMemberTimeAttendanceBreakCommandDataWSModel.class, name = StaffMemberTimeAttendanceBreakCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = StaffMemberTimeAttendanceBreakRevisionInsertCommandDataWSModel.class, name = StaffMemberTimeAttendanceBreakRevisionInsertCommandDataWSModel.NAME),
                @JsonSubTypes.Type(value = OperationProductionStateCommandDataWsModel.class, name = OperationProductionStateCommandDataWsModel.NAME),
                @JsonSubTypes.Type(value = OperationProductionStateRevisionInsertCommandDataWsModel.class, name = OperationProductionStateRevisionInsertCommandDataWsModel.NAME),
                @JsonSubTypes.Type(value = DomainAttributeChangeCommandWSModel.class, name = DomainAttributeChangeCommandWSModel.NAME)})
@ApiModel(value = "commandData", subTypes = { OperationPhaseCommandDataWsModel.class, MachineStateCommandDataWSModel.class,
                                              MachineStateRevisionInsertCommandDataWsModel.class, OperationQuantityCommandDataWsModel.class,
                                              MachineQuantityCommandDataWSModel.class, MachineCountCommandDataWSModel.class,
                                              MachineStrokeCommandDataWSModel.class, OperationPhaseRevisionInsertCommandDataWsModel.class,
                                              MachineStrokeCommandDataWSModel.class, OperationQuantityRevisionInsertCommandDataWsModel.class,
                                              StaffMemberOperationStateCommandDataWSModel.class,
                                              StaffMemberOperationStateRevisionInsertCommandDataWSModel.class,
                                              StaffMemberWorkplaceStateCommandDataWSModel.class,
                                              StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel.class, PlannedMaintenanceStateCommandDataWSModel.class,
                                              WorkplaceMaintenanceRequestCommandDataWSModel.class, WorkplaceMaintenanceStateCommandDataWSModel.class,
                                              ShiftStateCommandDataWSModel.class, StaffMemberWorkplaceStateRevisionInsertCommandDataWSModel.class,
                                              StaffMemberTimeAttendanceCommandDataWSModel.class,
                                              StaffMemberTimeAttendanceRevisionInsertCommandDataWSModel.class,
                                              StaffMemberTimeAttendanceBreakCommandDataWSModel.class,
                                              StaffMemberTimeAttendanceBreakRevisionInsertCommandDataWSModel.class,
                                              OperationProductionStateCommandDataWsModel.class,
                                              OperationProductionStateRevisionInsertCommandDataWsModel.class,
                                              DomainAttributeChangeCommandWSModel.class}, discriminator = "type")
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractCommandDataWSModel implements Serializable {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** The seperator. */
    public static final String SEPERATOR = ",";

    private static final long serialVersionUID = -399498135109646014L;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param type The type.
     */
    public AbstractCommandDataWSModel(String type) {
        mType = type;
    }

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Corresponds to com.forcam.na.runtimeaccess.command.AbstractCommand.WEBTOUCH */
    private String mSource;

    /** The type of the model. */
    private String mType;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getSource() {
        return mSource;
    }

    @ApiModelProperty(value = "The source of the command", allowableValues = "MACHINE,TERMINAL", required = false)
    public void setSource(String source) {
        mSource = source;
    }

    public String getType() {
        return mType;
    }

    @ApiModelProperty(value = "The type of the command", allowableValues = OperationPhaseCommandDataWsModel.NAME + SEPERATOR +
                                                                           MachineStateCommandDataWSModel.NAME + SEPERATOR +
                                                                           MachineQuantityCommandDataWSModel.NAME + SEPERATOR +
                                                                           MachineStateRevisionInsertCommandDataWsModel.NAME + SEPERATOR +
                                                                           MachineCountCommandDataWSModel.NAME + SEPERATOR +
                                                                           MachineStrokeCommandDataWSModel.NAME + SEPERATOR +
                                                                           OperationQuantityCommandDataWsModel.NAME + SEPERATOR +
                                                                           OperationPhaseRevisionInsertCommandDataWsModel.NAME + SEPERATOR +
                                                                           OperationQuantityRevisionInsertCommandDataWsModel.NAME + SEPERATOR +
                                                                           StaffMemberWorkplaceStateCommandDataWSModel.NAME + SEPERATOR +
                                                                           StaffMemberOperationStateCommandDataWSModel.NAME + SEPERATOR +
                                                                           StaffMemberTimeAttendanceCommandDataWSModel.NAME + SEPERATOR +
                                                                           StaffMemberTimeAttendanceRevisionInsertCommandDataWSModel.NAME + SEPERATOR +
                                                                           StaffMemberTimeAttendanceBreakCommandDataWSModel.NAME + SEPERATOR +
                                                                           StaffMemberTimeAttendanceBreakRevisionInsertCommandDataWSModel.NAME + SEPERATOR +
                                                                           OperationProductionStateCommandDataWsModel.NAME + SEPERATOR +
                                                                           OperationProductionStateRevisionInsertCommandDataWsModel.NAME + SEPERATOR +
                                                                           DomainAttributeChangeCommandWSModel.NAME, required = true)
    public void setType(String type) {
        mType = type;
    }

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("source", mSource)
            .append("type", mType)
            .toString();
    }
}
