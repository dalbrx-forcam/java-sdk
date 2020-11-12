package com.forcam.na.ffwebservices.model.collection;

import com.forcam.na.ffwebservices.model.LinkWSModel;

public class PaginationLinksWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A link to this collection. */
    private LinkWSModel mSelf;

    /** A link to the next collection. */
    private LinkWSModel mNext;

    /** A link to the first collection. */
    private LinkWSModel mFirst;

    /** A link to the last collection. */
    private LinkWSModel mLast;

    /** A link to the previous collection. */
    private LinkWSModel mPrev;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public LinkWSModel getFirst() {
        return mFirst;
    }

    public void setFirst(LinkWSModel first) {
        mFirst = first;
    }

    public LinkWSModel getNext() {
        return mNext;
    }

    public void setNext(LinkWSModel next) {
        mNext = next;
    }

    public LinkWSModel getSelf() {
        return mSelf;
    }

    public void setSelf(LinkWSModel self) {
        mSelf = self;
    }

    public LinkWSModel getLast() {
        return mLast;
    }

    public void setLast(LinkWSModel last) {
        mLast = last;
    }

    public LinkWSModel getPrev() {
        return mPrev;
    }

    public void setPrev(LinkWSModel prev) {
        mPrev = prev;
    }
}