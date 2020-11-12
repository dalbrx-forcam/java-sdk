package com.forcam.na.ffwebservices.model;

/**
 * The abstract super class for models.
 */
public class AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A link to itself. */
    private LinkEmbeddedWSModel<Object> mSelf;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public LinkEmbeddedWSModel getSelf() {
        return mSelf;
    }

    @SuppressWarnings("unchecked")
    public void setSelf(LinkEmbeddedWSModel self) {
        this.mSelf = self;
    }
}