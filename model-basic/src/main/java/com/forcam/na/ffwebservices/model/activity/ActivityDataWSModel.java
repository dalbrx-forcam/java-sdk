////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 24.04.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.activity;

import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.Map;

/**
 * The activity webservice model.
 */
@ApiModel(value = "activity")
public class ActivityDataWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mActivityIdentifier;

    private String mRelationIdentifier;

    private RELATION_TYPE mRelationType;

    private Map<String, String> mData = new HashMap<>();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public Map<String, String> getData() {
        return mData;
    }

    public void setData(Map<String, String> data) {
        mData = data;
    }

    public RELATION_TYPE getRelationType() {
        return mRelationType;
    }

    public void setRelationType(RELATION_TYPE relationType) {
        mRelationType = relationType;
    }

    public String getActivityIdentifier() {
        return mActivityIdentifier;
    }

    public void setActivityIdentifier(String identifier) {
        mActivityIdentifier = identifier;
    }

    public String getRelationIdentifier() {
        return mRelationIdentifier;
    }

    public void setRelationIdentifier(String relationIdentifier) {
        mRelationIdentifier = relationIdentifier;
    }
}
