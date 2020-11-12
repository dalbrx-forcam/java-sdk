package com.forcam.na.ffwebservices.model.operation;

/**
 * Contains booleans to determine what shall be embedded.
 * <p>
 * Created: 10.04.2018
 *
 * @author Nadine Uebele nadine.uebele@forcam.com
 */
public class OperationComponentsEmbed {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Constant string for operation. */
    public static final String OPERATION = "operation";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Should operation be embedded? */
    private boolean mOperation;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Determines if operation should be embedded.
     *
     * @param operation Should operation be embedded?
     * @return The OperationComponentsEmbed object with the new value.
     */
    public OperationComponentsEmbed operation(boolean operation) {
        mOperation = operation;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isOperation()) {
            builder.append(OperationComponentsEmbed.OPERATION);
        }

        return builder.toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the flag if operation should be embedded.
     *
     * @return Flag if operation should be embedded.
     */
    public boolean isOperation() {
        return mOperation;
    }
}