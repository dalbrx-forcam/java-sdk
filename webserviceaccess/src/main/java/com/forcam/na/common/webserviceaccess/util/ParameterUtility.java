package com.forcam.na.common.webserviceaccess.util;

/**
 * Utility class to provide the URL parameters.
 * <p/>
 * Created: 30.06.2017
 *
 * @author Nadine Uebele <nadine.uebele@forcam.com>
 */
public final class ParameterUtility {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Private constructor to prevent instantiating the utility class.
     */
    private ParameterUtility() {
        //utility class
    }

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Parameter name for the workplace filter with workplace IDs. */
    public static final String WORKPLACE_ID = "workplaceId";

    /** Parameter name for the material filter. */
    public static final String MATERIAL_ID = "materialId";

    /** Parameter name for the product filter. */
    public static final String PRODUCT_ID = "productId";

    /** Parameter name for the operation filter. */
    public static final String OPERATION_ID = "operationId";

    /** Parameter name for the order filter. */
    public static final String ORDER_ID = "orderId";

    /** Parameter name for the start date of the date time filter . */
    public static final String FROM_DATE = "startDate";

    /** Parameter name for the end date of the date time filter . */
    public static final String TO_DATE = "endDate";

    /** Parameter name for the time range of the date time filter . */
    public static final String PAST = "past";

    /** Parameter name for the time type of the date time filter . */
    public static final String TIME_TYPE = "timeType";

    /** Parameter name for the range type of the date time filter . */
    public static final String RANGE_TYPE = "rangeType";

    /** Parameter name for the string filter . */
    public static final String STRING = "description";

    /** Parameter name for the value list filter . */
    public static final String VALUE_LIST = "values";

    /** Parameter name for the boolean filter . */
    public static final String BOOLEAN = "phaseActive";

    /** Parameter name for the number filter . */
    public static final String NUMBER = "number";

    /** Parameter name for the multi selection filter . */
    public static final String MULTI_SELECTION = "phaseCode";

    /** Parameter name for the timebase filter . */
    public static final String TIMEBASED = "workplacePhaseId";

    /** Parameter name for the duration filter . */
    public static final String DURATION = "duration";

    /** Parameter name for the operation operating status filter . */
    public static final String OP_OPERATING_STATUS = "operationStatusId";

    /** Parameter name for the workplace operating status filter . */
    public static final String WP_OPERATING_STATUS = "operatingStateId";

    /** Parameter name for the operation phase filter . */
    public static final String OPERATION_PHASE = "operationPhaseCode";

    /** Parameter name for the status class filter . */
    public static final String STATUS_CLASS = "statusClassId";

    /** Filter identifier for the time filter. */
    public static final String TIME_FILTER = "TIME_FILTER";

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Converts upper case words into camel case.
     *
     * @param upperCase Word to convert.
     * @return Converted word in camel case.
     */
    public static String convertToCamelCase(String upperCase) {
        upperCase = upperCase.toLowerCase();
        final StringBuilder stringBuilder = new StringBuilder();
        final String[] words = upperCase.split("_");
        stringBuilder.append(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!words[i].equals("filter")) {
                stringBuilder.append(words[i].substring(0, 1).toUpperCase());
                stringBuilder.append(words[i].substring(1));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Creates the parameter name with the prefix and the parameter name.
     *
     * @param parameterPrefix The parameter prefix.
     * @param parameterName   The parameter name.
     * @return The created API parameter name.
     */
    public static String createParamName(String parameterPrefix, String parameterName) {
        if (parameterPrefix == null) {
            return parameterName;
        }
        return parameterPrefix + parameterName.substring(0, 1).toUpperCase() + parameterName.substring(1);
    }
}
