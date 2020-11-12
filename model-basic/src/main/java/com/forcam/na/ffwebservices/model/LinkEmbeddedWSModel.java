package com.forcam.na.ffwebservices.model;

public class LinkEmbeddedWSModel<T> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A link model. */
    private LinkWSModel mLink;

    /** Embedded resources. */
    private T mEmbedded;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public LinkWSModel getLink() {
        return mLink;
    }

    public void setLink(LinkWSModel link) {
        mLink = link;
    }

    public T getEmbedded() {
        return mEmbedded;
    }

    public void setEmbedded(T embedded) {
        mEmbedded = embedded;
    }
}
