package com.forcam.na.ffwebservices.client.api.exception;

import java.util.Optional;

/**
 * Created: 03.01.2017
 *
 * @author David Albrecht
 */
public class ForceAPIException extends Exception {

    /**
     * The URL and the method how the URL was requested.
     */
    private IRequestDescriptor mRequestDescription;

    /**
     * Http code.
     */
    private Integer mHttpCode;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param message The exception message.
     */
    public ForceAPIException(String message) {
        super(message);
    }

    /**
     * Creates a new instance.
     *
     * @param requestDescription The request description.
     * @param message            The exception message.
     */
    public ForceAPIException(IRequestDescriptor requestDescription, String message) {
        super(message);
        mRequestDescription = requestDescription;
    }

    /**
     * Creates a new instance.
     *
     * @param requestDescription The request description.
     * @param message            The exception message.
     * @param httpCode           The http code.
     */
    public ForceAPIException(IRequestDescriptor requestDescription, String message, int httpCode) {
        this(requestDescription, message);
        mHttpCode = httpCode;
    }

    /**
     * Creates a new instance.
     *
     * @param requestDescription The request description.
     * @param cause              The cause for the exception.
     */
    public ForceAPIException(IRequestDescriptor requestDescription, Throwable cause) {
        super(cause);
        mRequestDescription = requestDescription;
    }

    /**
     * Creates a new instance.
     *
     * @param requestDescription The request description.
     * @param message            The exception message.
     * @param cause              The cause for th exception.
     */
    public ForceAPIException(IRequestDescriptor requestDescription, String message, Throwable cause) {
        super(message, cause);
        mRequestDescription = requestDescription;
    }

    /**
     * Creates a new instance.
     *
     * @param requestDescription The request description.
     * @param message            The exception message.
     * @param httpCode           The http code.
     * @param cause              The cause for the exception.
     */
    public ForceAPIException(IRequestDescriptor requestDescription, String message, int httpCode, Throwable cause) {
        this(requestDescription, message, cause);
        mHttpCode = httpCode;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * @return Http code.
     */
    public Optional<Integer> getHttpCode() {
        return Optional.ofNullable(mHttpCode);
    }

    /**
     * @return Request description.
     */
    public String getRequestDescription() {
        return Optional
            .ofNullable(mRequestDescription)
            .map(r -> r.getMethod() + " " + r.getURL())
            .orElse("Unknown");
    }

}