package com.forcam.na.ffwebservices.model.operation;

/**
 * Contains booleans to determine what shall be embedded.
 * <p>
 * Created: 10.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class OperationPlanningResultEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for planned workplace. */
    public static final String PLANNED_WORKPLACE = "workplace";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should planned workplace be embedded? */
    private boolean mPlannedWorkplace;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if planned workplace should be embedded.
     *
     * @param plannedWorkplace Should planned workplace be embedded?
     * @return The OperationPlanningResultEmbed object with the new value.
     */
    public OperationPlanningResultEmbed plannedWorkplace(boolean plannedWorkplace) {
        mPlannedWorkplace = plannedWorkplace;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isPlannedWorkplace()) {
            builder.append(OperationPlanningResultEmbed.PLANNED_WORKPLACE);
        }

        return builder.toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public boolean isPlannedWorkplace() {
        return mPlannedWorkplace;
    }
}