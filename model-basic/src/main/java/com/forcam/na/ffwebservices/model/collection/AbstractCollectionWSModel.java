package com.forcam.na.ffwebservices.model.collection;

public abstract class AbstractCollectionWSModel<T> extends AbstractBaseCollectionWSModel<T> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A collection of property models. */
    private PaginationPropertiesWSModel mPagination;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public PaginationPropertiesWSModel getPagination() {
        return mPagination;
    }

    public void setPagination(PaginationPropertiesWSModel pagination) {
        this.mPagination = pagination;
    }
}