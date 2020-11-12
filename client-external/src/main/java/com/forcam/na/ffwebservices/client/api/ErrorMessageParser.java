////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 12.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forcam.na.common.webservices.model.ErrorMessageWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static com.forcam.na.ffwebservices.client.api.exception.OkHttpRequestDescriptor.OkHttpRequestDescriptorBuilder;

/**
 *
 */
public class ErrorMessageParser {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger of class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorMessageParser.class);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private ObjectMapper mMapper = new ObjectMapper();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Handles a failed response.
     *
     * @param resp A response,
     * @param <T>  The type of the response body.
     * @param call The call describing the request.
     * @return An error message model.
     * @throws ForceAPIException When unable to parse error message.
     */
    public <T> ErrorMessageWSModel handleFailedResponse(Call<T> call, Response<T> resp) throws ForceAPIException {
        try {
            return this.parseError(resp);
        } catch (IOException e) {
            throw new ForceAPIException(OkHttpRequestDescriptorBuilder.build(call.request()),
                                        "Unable to parse ErrorMessage of response with status: " + resp.code(),
                                        e);
        }
    }

    /**
     * Parses the error message.
     *
     * @param response Response.
     * @return Error message ws model.
     * @throws IOException ex.
     */
    public ErrorMessageWSModel parseError(Response<?> response) throws IOException {

        String errorBodyString = StringUtils.EMPTY;

        if (response.errorBody() != null) {
            try {
                errorBodyString = response
                    .errorBody()
                    .string();
            } catch (IOException ex) {
                LOGGER.warn("Unable to parse error response as string." + ex.getMessage());
                throw ex;
            }
        }

        if (StringUtils.isEmpty(errorBodyString)) {
            final ErrorMessageWSModel errorMessage = new ErrorMessageWSModel();
            errorMessage.setCode("" + response.code());
            errorMessage.setMessage(response.message());
            errorMessage.setStatus(response.code());
            return errorMessage;
        }

        try {
            return mMapper.readValue(errorBodyString, ErrorMessageWSModel.class);
        } catch (IOException ex) {
            LOGGER.warn("Unable to parse ErrorMessage. Got: " + errorBodyString);
            throw ex;
        }
    }
}
