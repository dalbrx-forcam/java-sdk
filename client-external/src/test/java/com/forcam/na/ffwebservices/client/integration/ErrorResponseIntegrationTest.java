////////////////////////////////////////////////////////////////////////////////
//
// Created by PSeidl on 29.09.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRequest;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Integration tests to verify that an error response is returned.
 */
public class ErrorResponseIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    @Rule
    public ExpectedException mExpectedEx = ExpectedException.none();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for getting an error response from {@link com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceClient#getWorkplace(GetWorkplaceRequest)}.
     *
     * @throws ForceAPIException When unable to get the workplace.
     */
    @Test
    public void testGetErrorResponse() throws ForceAPIException {
        final String nonExistingWorkplaceId = "null";

        mExpectedEx.expect(ForceAPIException.class);
        mExpectedEx.expectMessage(this.getExpectedErrorMessage(nonExistingWorkplaceId));

        mWorkplaceClient.getWorkplace(this.createErrorRequest(nonExistingWorkplaceId));
    }

    /**
     * Returns the expected error message.
     *
     * @param nonExistingWorkplaceId The non existing workplace ID.
     * @return The expected error message.
     */
    private String getExpectedErrorMessage(String nonExistingWorkplaceId) {
        return "Workplace with id '" + nonExistingWorkplaceId + "' not found";
    }

    /**
     * Creates a {@link GetWorkplaceRequest} which leads to an error.
     *
     * @param nonExistingWorkplaceId The non existing workplace ID.
     * @return The get workplace request.
     */
    private GetWorkplaceRequest createErrorRequest(String nonExistingWorkplaceId) {
        return new GetWorkplaceRequest(nonExistingWorkplaceId);
    }

}
