////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 08.09.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command.domain;

import com.forcam.na.ffwebservices.model.command.AbstractCommandDataWSModel;
import io.swagger.annotations.ApiModel;

/**
 * JSON model for DomainAttributeChangeEvents.
 */
@ApiModel(value = "domainAttributeChangeCommand", parent = AbstractCommandDataWSModel.class)
public class DomainAttributeChangeCommandWSModel extends AbstractCommandDataWSModel {


    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    public static final String NAME = "DOMAIN_ATTRIBUTE_CHANGE";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------


    private DomainEventDomain mDomain;

    private String mObjectId;

    private String mAttributeName;

    private AbstractJavaValue mAttributeValue;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public DomainAttributeChangeCommandWSModel() {
        super(NAME);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getObjectId() {
        return mObjectId;
    }

    public void setObjectId(String objectId) {
        mObjectId = objectId;
    }

    public String getAttributeName() {
        return mAttributeName;
    }

    public void setAttributeName(String attributeName) {
        mAttributeName = attributeName;
    }

    public AbstractJavaValue getAttributeValue() {
        return mAttributeValue;
    }

    public void setAttributeValue(AbstractJavaValue attributeValue) {
        mAttributeValue = attributeValue;
    }

    public DomainEventDomain getDomain() {
        return mDomain;
    }

    public void setDomain(DomainEventDomain domain) {
        mDomain = domain;
    }
}
