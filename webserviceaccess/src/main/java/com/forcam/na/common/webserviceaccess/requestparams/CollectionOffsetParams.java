package com.forcam.na.common.webserviceaccess.requestparams;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;

/**
 * Created: 07.05.2017
 *
 * @author David Albrecht
 */
public class CollectionOffsetParams extends CollectionLimitRequestParams {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Name of the offset query parameter */
    public static final String PARAM_OFFSET = "offset";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The offset. */
    private Integer mOffset;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("mOffset", mOffset)
            .append(super.toString())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Integer getOffset() {
        if (mOffset == null) {
            return 0;
        }
        return mOffset;
    }

    public void setOffset(Integer offset) {
        if (offset == null) {
            mOffset = 0;
        } else if (offset < 0) {
            throw new InvalidOffsetException(offset);
        }
        mOffset = offset;
    }

}
