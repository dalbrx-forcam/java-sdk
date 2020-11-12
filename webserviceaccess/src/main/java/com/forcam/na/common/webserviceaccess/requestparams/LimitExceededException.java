package com.forcam.na.common.webserviceaccess.requestparams;

public class LimitExceededException extends RuntimeException {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The requested limit. */
    private final int mLimit;

    /** The max limit. */
    private final int mMaxLimit;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a limit exceed exception.
     *
     * @param limit The requested limit.
     * @param maxLimit The max limit.
     */
    public LimitExceededException(int limit, int maxLimit) {
        mLimit = limit;
        mMaxLimit = maxLimit;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public int getLimit() {
        return mLimit;
    }

    public int getMaxLimit() {
        return mMaxLimit;
    }
}
