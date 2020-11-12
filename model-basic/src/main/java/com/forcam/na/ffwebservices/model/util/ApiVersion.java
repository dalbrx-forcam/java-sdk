////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 04.05.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.util;

/**
 * The available API versions.
 */
public enum ApiVersion implements Comparable<ApiVersion> {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    V1(Versions.V1),

    V2(Versions.V2),

    V3(Versions.V3);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mVersionPath;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    ApiVersion(String versionPath) {
        if (!versionPath.equals(this
                                    .name()
                                    .toLowerCase())) {
            throw new IllegalArgumentException("version path does not match enum name");
        }
        mVersionPath = versionPath;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public int getVersion() {
        return Integer.parseInt(mVersionPath.substring(1));
    }

    public String getVersionPath() {
        return mVersionPath;
    }

    @Override
    public String toString() {
        return mVersionPath;
    }

    public static class Versions {
        public static final String V1 = "v1";
        public static final String V2 = "v2";
        public static final String V3 = "v3";
    }
}
