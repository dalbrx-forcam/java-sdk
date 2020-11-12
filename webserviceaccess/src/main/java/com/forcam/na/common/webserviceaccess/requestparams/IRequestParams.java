////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 17.12.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.common.webserviceaccess.requestparams;

import java.util.Locale;
import java.util.Set;

/**
 * Common request param values.
 */
public interface IRequestParams {
    Locale getLocale();

    Set<String> getEmbed();
}
