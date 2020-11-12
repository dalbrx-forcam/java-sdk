package com.forcam.na.ffwebservices.client.api;

import com.forcam.na.common.webservices.model.ErrorMessageWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIErrorMessageException;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.exception.OkHttpRequestDescriptor.OkHttpRequestDescriptorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Abstract super class for clients.
 */
public abstract class AbstractClient {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger of class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractClient.class);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** ErrorMessage parser. */
    private final ErrorMessageParser mErrorMessageParser = new ErrorMessageParser();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Returns a HAL model.
     *
     * @param request The request.
     * @param call    The call to execute.
     * @param <T>     The type of the request.
     * @param <S>     The type of the response.
     * @return The response of the server.
     * @throws ForceAPIException When the response is empty.
     */
    protected <T, S> S getResponseModel(T request, Call<S> call) throws ForceAPIException {
        final S serverModel = this.executeCall(request, call);

        if (serverModel != null) {
            return serverModel;
        }

        throw new ForceAPIException(OkHttpRequestDescriptorBuilder.build(call.request()), "Empty response");
    }

    /**
     * Returns a HAL model.
     *
     * @param url  The request url.
     * @param call The call to execute.
     * @param <T>  The type of the request.
     * @param <S>  The type of the response.
     * @return The response of the server.
     * @throws ForceAPIException When the response is empty.
     */
    protected <T, S> S getResponseModel(String url, Call<S> call) throws ForceAPIException {
        final S serverModel = this.executeCall(url, call);

        if (serverModel != null) {
            return serverModel;
        }

        throw new ForceAPIException(OkHttpRequestDescriptorBuilder.build(call.request()), "Empty response");
    }

    /**
     * Returns the response model.
     *
     * @param url  The request url.
     * @param call The call to execute.
     * @param <T>  The type of the request.
     * @param <S>  The type of the response.
     * @return The response of the server.
     * @throws ForceAPIException When unable to execute the call.
     */
    protected <T, S> S executeCall(String url, Call<S> call) throws ForceAPIException {
        try {
            return this.executeCall(call);
        } catch (IOException e) {
            LOGGER.warn("Unable to execute call using request url: " + url, e);
            throw new ForceAPIException(OkHttpRequestDescriptorBuilder.build(call.request()), "Unable to execute call using request url: " + url, e);
        }
    }

    /**
     * Returns the response model.
     *
     * @param request The request.
     * @param call    The call to execute.
     * @param <T>     The type of the request.
     * @param <S>     The type of the response.
     * @return The response of the server.
     * @throws ForceAPIException When unable to execute the call.
     */
    protected <T, S> S executeCall(T request, Call<S> call) throws ForceAPIException {
        try {
            return this.executeCall(call);
        } catch (IOException e) {
            LOGGER.warn("Unable to execute call using request: " + request, e);
            throw new ForceAPIException(OkHttpRequestDescriptorBuilder.build(call.request()), "Unable to execute call using request: " + request);
        }
    }

    private <S> S executeCall(Call<S> call) throws IOException, ForceAPIException {
        final Response<S> response = call.execute();
        if (!response.isSuccessful()) {
            final ErrorMessageWSModel error = mErrorMessageParser.handleFailedResponse(call, response);
            throw new ForceAPIErrorMessageException(OkHttpRequestDescriptorBuilder.build(call.request()), error);
        }

        return response.body();
    }
}