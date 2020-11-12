package com.forcam.na.common.webserviceaccess.requestparams;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created: 17.05.2017
 *
 * @author David Albrecht
 */
public class RequestParams implements IRequestParams {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Url parameter for embeds. */
    public final static String PARAM_EMBED = "embed";

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The locale. */
    private Locale mLocale = Locale.US;

    /** A set of resources which shall be embedded. */
    private Set<String> mEmbed = new HashSet<>();

    /** Responsible to identify whether "Prefer" attribute is set to minimal or not. */
    private boolean mMinimal;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .append("locale", mLocale)
            .append("embed", mEmbed)
            .append("minimal", mMinimal)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @Override
    public Locale getLocale() {
        return mLocale;
    }

    public void setLocale(Locale locale) {
        if (locale != null) {
            mLocale = locale;
        }
    }

    @Override
    public Set<String> getEmbed() {
        return mEmbed;
    }

    public void setEmbed(Set<String> embed) {
        mEmbed = embed == null ? Collections.emptySet() : embed;
    }

    public boolean isMinimal() { return mMinimal; }

    public void setMinimal(boolean minimal) { mMinimal = minimal; }
}
