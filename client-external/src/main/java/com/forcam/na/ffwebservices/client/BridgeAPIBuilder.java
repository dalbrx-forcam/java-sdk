////////////////////////////////////////////////////////////////////////////////
//
// Created by tim on 2020-02-11.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client;

import okhttp3.Interceptor;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

/**
 * Builder for {@link BridgeAPI}.
 */
public class BridgeAPIBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------
    private String mBaseUrl;
    private String mTokenBaseUrl;
    private String mClientId;
    private String mClientSecret;
    private Collection<Interceptor> mCollections = Collections.emptyList();
    private Locale mLocale = Locale.UK;
    private boolean mTrustAnySSL = false;

    private boolean mEncryptedSecret = false;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public BridgeAPIBuilder(String baseUrl, String tokenBaseUrl, String clientId, String clientSecret) {
        mBaseUrl = baseUrl;
        mTokenBaseUrl = tokenBaseUrl;
        mClientId = clientId;
        mClientSecret = clientSecret;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------
    public BridgeAPI build() {
        return new BridgeAPI(mBaseUrl, mTokenBaseUrl, mClientId, mClientSecret, mLocale, mCollections, mTrustAnySSL, mEncryptedSecret);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public BridgeAPIBuilder setCollections(Collection<Interceptor> collections) {
        mCollections = collections;
        return this;
    }

    public BridgeAPIBuilder setLocale(Locale locale) {
        mLocale = locale;
        return this;
    }

    public BridgeAPIBuilder setTrustAnySSL(boolean trustAnySSL) {
        mTrustAnySSL = trustAnySSL;
        return this;
    }

    public BridgeAPIBuilder setEncryptedSecret(boolean encryptedSecret) {
        mEncryptedSecret = encryptedSecret;
        return this;
    }

}
