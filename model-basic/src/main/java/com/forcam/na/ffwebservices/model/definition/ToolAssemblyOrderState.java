package com.forcam.na.ffwebservices.model.definition;

public enum ToolAssemblyOrderState {

    REQUESTED(46),

    INITIATED(47),

    ASSEMBLED(48),

    PRESETTING(49),

    RELEASED(50),

    UNAVAILABLE(99);

    private final long mCode;

    /**
     * Creates a new tool assembly status with a code.
     *
     * @param code The code.
     */
    ToolAssemblyOrderState(long code) { mCode = code; }

    /**
     * Returns the code.
     *
     * @return The code.
     */
    public long getCode() {
        return mCode;
    }

    /**
     * Returns the tool assembly status by code.
     *
     * @param code The code.
     * @return The tool assembly status.
     */
    public static ToolAssemblyOrderState getByCode(long code) {
        switch ((int) code) {
            case 46:
                return REQUESTED;
            case 47:
                return INITIATED;
            case 48:
                return ASSEMBLED;
            case 49:
                return PRESETTING;
            case 50:
                return RELEASED;
            case 99:
                return UNAVAILABLE;
        }

        throw new IllegalArgumentException();
    }
}
