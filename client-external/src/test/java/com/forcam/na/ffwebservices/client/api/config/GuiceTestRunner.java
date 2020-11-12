////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 24.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.config;

import org.junit.runners.*;
import org.junit.runners.model.*;

/**
 * The Guice test runner.
 */
public class GuiceTestRunner extends BlockJUnit4ClassRunner {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public GuiceTestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Object createTest() throws Exception {
        final Object object = super.createTest();
        return object;
    }
}