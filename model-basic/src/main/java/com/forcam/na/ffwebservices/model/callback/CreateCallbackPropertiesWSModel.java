package com.forcam.na.ffwebservices.model.callback;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;
import com.forcam.na.ffwebservices.model.event.EventType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 */
@XmlRootElement(name = "createCallbackProperties")
@ApiModel(value = "createCallbackProperties")
@JsonPropertyOrder({ "objectFilter", "eventType", "eventName", "url", "maxRedeliverAttempts", "maxUnconfirmedMessages" })
public class CreateCallbackPropertiesWSModel {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** List of callback objects */
    private List<CallbackObjectFilterWSModel> mObjectFilter;

    /** Type of the event */
    private EventType mEventType;

    /** Name of the event */
    private String mEventName;

    /** Callback URL. */
    private String mUrl;

    /** Max number of redelivery attempts. */
    private Integer mMaxRedeliveryAttempts;

    /** Max number of unconfirmed messages. */
    private Integer mMaxUnconfirmedMessages;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility
            .newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("mObjectFilter", mObjectFilter)
            .append("mEventType", mEventType)
            .append("mEventName", mEventName)
            .append("mUrl", mUrl)
            .append("mMaxRedeliveryAttempts", mMaxRedeliveryAttempts)
            .append("mMaxUnconfirmedMessages", mMaxUnconfirmedMessages)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CreateCallbackPropertiesWSModel)) {
            return false;
        }

        CreateCallbackPropertiesWSModel that = (CreateCallbackPropertiesWSModel) o;

        return new EqualsBuilder()
            .append(getObjectFilter(), that.getObjectFilter())
            .append(getEventType(), that.getEventType())
            .append(getEventName(), that.getEventName())
            .append(getUrl(), that.getUrl())
            .append(getMaxRedeliveryAttempts(), that.getMaxRedeliveryAttempts())
            .append(getMaxUnconfirmedMessages(), that.getMaxUnconfirmedMessages())
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(getObjectFilter())
            .append(getEventType())
            .append(getEventName())
            .append(getUrl())
            .append(getMaxRedeliveryAttempts())
            .append(getMaxUnconfirmedMessages())
            .toHashCode();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Sets the objects filter.
     *
     * @param objectFilter Describes the objects which have to affected by the event.
     */
    @ApiModelProperty(value = "Array of filtering criteria provided by the corresponding domain object", position = 1)
    public void setObjectFilter(List<CallbackObjectFilterWSModel> objectFilter) {
        mObjectFilter = objectFilter;
    }

    @Valid
    public List<CallbackObjectFilterWSModel> getObjectFilter() {
        return mObjectFilter;
    }

    @ApiModelProperty(value = "Event type for which callbacks shall be sent", required = true, position = 2)
    public void setEventType(EventType eventType) {
        mEventType = eventType;
    }

    @NotNull
    public EventType getEventType() {
        return mEventType;
    }

    @ApiModelProperty(value = "Event name for which callbacks shall be sent", required = false, position = 3)
    public void setEventName(String eventName) {
        mEventName = eventName;
    }

    public String getEventName() {
        return mEventName;
    }

    /**
     * Sets callback URL.
     *
     * @param url Callback URL.
     */
    @ApiModelProperty(value = "URL to be called", required = true, position = 4)
    public void setUrl(String url) {
        mUrl = url;
    }

    /**
     * Retrieves callback URL.
     *
     * @return Callback URL.
     */
    @NotBlank
    public String getUrl() {
        return mUrl;
    }

    /**
     * Sets the max number of redeliver attempts.
     *
     * @param maxRedeliveryAttempts The max number of redeliver attempts.
     */
    @ApiModelProperty(value = "Maximum number of redeliver attempts", required = false, position = 6, example = "100")
    public void setMaxRedeliveryAttempts(Integer maxRedeliveryAttempts) {
        this.mMaxRedeliveryAttempts = maxRedeliveryAttempts;
    }

    /**
     * Provides the max number of redeliver attempts.
     *
     * @return The max number of redeliver attempts.
     */
    @Positive
    public Integer getMaxRedeliveryAttempts() {
        return mMaxRedeliveryAttempts;
    }

    /**
     * Sets the max number of unconfirmed messages.
     *
     * @param maxUnconfirmedMessages The max number of unconfirmed messages.
     */
    @ApiModelProperty(value = "Maximum number of unconfirmed messages", required = false, position = 7, example = "5000")
    public void setMaxUnconfirmedMessages(Integer maxUnconfirmedMessages) {
        this.mMaxUnconfirmedMessages = maxUnconfirmedMessages;
    }

    /**
     * Provides the max number of unconfirmed messages.
     *
     * @return The max number of unconfirmed messages.
     */
    @Positive
    public Integer getMaxUnconfirmedMessages() {
        return mMaxUnconfirmedMessages;
    }
}