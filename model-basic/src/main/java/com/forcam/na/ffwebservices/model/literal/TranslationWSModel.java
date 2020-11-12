package com.forcam.na.ffwebservices.model.literal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * Created: 27.02.2017
 *
 * @author David Albrecht
 */
@ApiModel(value = "translation")
@JsonPropertyOrder({ "language", "translation"})
public class TranslationWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The language. */
    private String mLanguage;

    /** The translation. */
    private String mTranslation;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Language tag containing the language code (ISO 639) and the country code (ISO 3166)", required = true, position = 0)
    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getLanguage() {
        return mLanguage;
    }

    @ApiModelProperty(value = "Term translated into the corresponding language", position = 1)
    public void setTranslation(String translation) {
        mTranslation = translation;
    }

    public String getTranslation() {
        return mTranslation;
    }
}