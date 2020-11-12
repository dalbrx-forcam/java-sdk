////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.qualitytype;

import com.forcam.na.ffwebservices.client.api.AbstractLinkModelBuilder;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypePropertiesWSModel;

import javax.inject.Inject;

/**
 * Creates a quality type link model.
 */
public class QualityTypeLinkModelBuilder extends AbstractLinkModelBuilder<QualityTypePropertiesWSModel> {

    // ----------------------------------------------------------------------
    // constructors
    // ----------------------------------------------------------------------

    @Inject
    public QualityTypeLinkModelBuilder() {
        super(QualityTypePropertiesWSModel.class);
    }
}