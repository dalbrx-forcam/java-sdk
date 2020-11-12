////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 05.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.collection.PaginationPropertiesWSModel;
import com.google.common.collect.Lists;
import org.hamcrest.*;
import org.junit.*;
import org.mockito.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tests SpecificPage.
 */
public class SpecificPageTest {

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test of {@link SpecificPage#streamForward()} and {@link SpecificPage#streamBackward()} in case of empty page.
     */
    @Test
    public void testStreamWithEmptyPage() throws NoSuchMethodException {
        //----------------------------------------------------------------------
        // test fixture
        //----------------------------------------------------------------------

        final TestCollectionResponse response = new TestCollectionResponse(Collections.emptyList());
        final PaginationPropertiesWSModel pagination = new PaginationPropertiesWSModel();
        pagination.setCount(0);
        pagination.setLimit(1);
        pagination.setTotal(0);
        pagination.setOffset(0);
        response.setPagination(pagination);

        final Method testMethod = this
            .getClass()
            .getMethod("testStreamWithEmptyPage");

        final SpecificPage<String, TestCollectionResponse> page = new SpecificPage<>(Mockito.mock(Object.class), testMethod, response);

        //----------------------------------------------------------------------
        // test
        //----------------------------------------------------------------------

        List<String> collectedStream = page
            .streamForward()
            .collect(Collectors.toList());
        Assert.assertTrue(collectedStream.isEmpty());

        collectedStream = page
            .streamBackward()
            .collect(Collectors.toList());
        Assert.assertTrue(collectedStream.isEmpty());
    }

    /**
     * Test of {@link SpecificPage#streamForward()} and {@link SpecificPage#streamBackward()} in case of non empty page.
     */
    @Test
    public void testStreamWithNonEmptyPage() throws NoSuchMethodException {
        //----------------------------------------------------------------------
        // test fixture
        //----------------------------------------------------------------------

        final List<String> result = Arrays.asList("A", "B", "C");
        final TestCollectionResponse response = new TestCollectionResponse(result);
        final PaginationPropertiesWSModel pagination = new PaginationPropertiesWSModel();
        pagination.setCount(result.size());
        pagination.setLimit(result.size());
        pagination.setTotal(result.size());
        pagination.setOffset(0);
        response.setPagination(pagination);

        final Method testMethod = this
            .getClass()
            .getMethod("testStreamWithNonEmptyPage");

        final SpecificPage<String, TestCollectionResponse> page = new SpecificPage<>(Mockito.mock(Object.class), testMethod, response);

        //----------------------------------------------------------------------
        // test
        //----------------------------------------------------------------------

        List<String> collectedStream = page
            .streamForward()
            .collect(Collectors.toList());
        Assert.assertThat(collectedStream, CoreMatchers.is(result));

        collectedStream = page
            .streamBackward()
            .collect(Collectors.toList());
        Assert.assertThat(collectedStream, CoreMatchers.is(Lists.reverse(result)));
    }

    /**
     * {@link AbstractCollectionResponse} which can be used for tests.
     */
    static class TestCollectionResponse extends AbstractCollectionResponse<String> {

        /** The result list. */
        private List<String> mResult;

        /**
         * Creates a new instance.
         *
         * @param result The result list.
         */
        TestCollectionResponse(List<String> result) {
            super(new CollectionRequest());
            mResult = result;
        }

        @Override
        public List<String> getElements() {
            return mResult;
        }
    }

}
