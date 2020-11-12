////////////////////////////////////////////////////////////////////////////////
//
// Created by PBecker on 05.02.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.common.webserviceaccess.util;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Copy of ToStringBuilder to avoid dependencies on spring and hibernate.
 */
public final class ToStringUtility {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** This text is used, when a given value is {@code null}. */
    private static final String NULL_TEXT = "<null>";

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    /**
     * Avoid instantiating.
     */
    private ToStringUtility() {
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Create a new {@link ToStringBuilder} with the correct style. The used style is {@link ToStringStyle#SHORT_PREFIX_STYLE}.
     *
     * @param object Object to build a toString for.
     * @return New {@link ToStringBuilder}.
     */
    public static ToStringBuilder newToStringBuilder(Object object) {
        return new ToStringBuilder(object, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * Create a new {@link ToStringBuilder} with {@link ToStringStyle#MULTI_LINE_STYLE}.
     *
     * @param object Object to build a toString for.
     * @return New {@link ToStringBuilder}.
     */
    public static ToStringBuilder newToStringBuilderMulitLine(Object object) {
        return new ToStringBuilder(object, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * Builds a toString value through reflection. See {@link ToStringBuilder#reflectionToString(Object)}.
     * The used style is {@link ToStringStyle#SHORT_PREFIX_STYLE}.
     *
     * @param object The object to be output. Can be {@code null}. In this case the string {@code <null>} is used.
     * @return Result string.
     */
    public static String reflectionToString(Object object) {
        return (object == null ? ToStringUtility.NULL_TEXT : ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE));
    }

    /**
     * Create a new {@link ToStringBuilder} with the simple style. The used style is {@link ToStringStyle#SIMPLE_STYLE}.
     *
     * @param object Object to build a toString for.
     * @return New {@link ToStringBuilder}.
     */
    public static ToStringBuilder newToStringBuilderSimple(Object object) {
        return new ToStringBuilder(object, ToStringStyle.SIMPLE_STYLE);
    }
}
