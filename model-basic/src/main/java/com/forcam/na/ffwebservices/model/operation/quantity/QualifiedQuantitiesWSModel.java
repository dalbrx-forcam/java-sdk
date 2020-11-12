////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 06.02.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation.quantity;

import io.swagger.annotations.ApiModel;

/**
 * Model for qualified quantities.
 */
@ApiModel("qualifiedQuantities")
public class QualifiedQuantitiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private QualifiedQuantityWSModel mYield = new QualifiedQuantityWSModel();

    private QualifiedQuantityWSModel mScrap = new QualifiedQuantityWSModel();

    private QualifiedQuantityWSModel mRework = new QualifiedQuantityWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public QualifiedQuantityWSModel getYield() {
        return mYield;
    }

    public void setYield(QualifiedQuantityWSModel yield) {
        mYield = yield;
    }

    public QualifiedQuantityWSModel getScrap() {
        return mScrap;
    }

    public void setScrap(QualifiedQuantityWSModel scrap) {
        mScrap = scrap;
    }

    public QualifiedQuantityWSModel getRework() {
        return mRework;
    }

    public void setRework(QualifiedQuantityWSModel rework) {
        mRework = rework;
    }

}
