package com.forcam.na.ffwebservices.model.staffmember;

public enum StaffMemberState {

    SIGNED_ON(1),

    SIGNED_OFF(2);

    /** The code. */
    private final long mCode;

    /**
     * Creates a new personnel status with a code.
     *
     * @param code The code.
     */
    StaffMemberState(long code) {
        mCode = code;
    }

    /**
     * Returns the code.
     *
     * @return The code.
     */
    public long getCode() {
        return mCode;
    }

    /**
     * Returns the personnel status by code.
     *
     * @param code The code.
     * @return The personnel status.
     */
    public static StaffMemberState getByCode(long code) {
        switch ((int) code) {
            case 1:
                return SIGNED_ON;
            case 2:
                return SIGNED_OFF;
        }

        throw new IllegalArgumentException();
    }
}
