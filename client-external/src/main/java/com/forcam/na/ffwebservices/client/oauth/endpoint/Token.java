package com.forcam.na.ffwebservices.client.oauth.endpoint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;

/**
 * Created: 16.01.2017
 *
 * @author David Albrecht
 */
public class Token {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The scope of the token. */
    private String scope;

    /** The access token. */
    @JsonProperty("access_token")
    private String accessToken;

    /** The type of the token. */
    @JsonProperty("token_type")
    private String tokenType;

    /** The time the token expires after. */
    @JsonProperty("expires_in")
    private Long expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    // ------------------------------------------------------------------------
    // method
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("scope", scope)
            .append("accessToken", accessToken)
            .append("tokenType", tokenType)
            .append("expiresIn", expiresIn)
            .append("refreshToken", refreshToken)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
