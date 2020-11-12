package com.forcam.na.ffwebservices.model.literal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created: 27.02.2017
 *
 * @author David Albrecht
 */
@XmlRootElement(name = "createLiteralProperties")
@ApiModel(value = "createLiteralProperties")
@JsonPropertyOrder({ "translations" })
public class CreateLiteralPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A list of translation models. */
    private List<TranslationWSModel> mTranslations = new ArrayList<>();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Adds a translation.
     *
     * @param translationModel The translation model.
     */
    public void addTranslation(TranslationWSModel translationModel) {
        mTranslations.add(translationModel);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    @ApiModelProperty(value = "Array of translations", position = 1)
    public void setTranslations(List<TranslationWSModel> translations) {
        mTranslations = translations;
    }

    public List<TranslationWSModel> getTranslations() {
        return mTranslations;
    }
}