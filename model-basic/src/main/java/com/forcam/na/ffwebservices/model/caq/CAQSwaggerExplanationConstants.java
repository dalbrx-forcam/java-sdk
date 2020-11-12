////////////////////////////////////////////////////////////////////////////////
//
// Created by DSchulz on 25.02.2020.
//
// Copyright (c) 2006 - 2020 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.caq;

/**
 * CAQ swagger explanation constants.
 */
public final class CAQSwaggerExplanationConstants {

    /** The constant PATH_SEPARATOR. */
    public static final String PATH_SEPARATOR = "/";
    /** The constant INSPECTION_ID. */
    public static final String INSPECTION_ID = "inspectionId";
    /** The constant INSPECTION_READY. */
    public static final String INSPECTION_READY = "inspectionReady";
    /** The constant INSPECTION_DATA. */
    public static final String INSPECTION_DATA = "inspectionData";

    /** The constant PATH_INFORM_CAQ. */
    public static final String PATH_INFORM_CAQ = PATH_SEPARATOR + "informCAQ";

    /** The constant PATH_INSPECTIONS. */
    public static final String PATH_INSPECTIONS = PATH_SEPARATOR + "inspections";
    /** The constant PATH_CAQ_INSPECTIONS. */
    public static final String PATH_CAQ_INSPECTIONS = "caq" + PATH_INSPECTIONS;
    /** The constant PATH_INSPECTION_PLANS_ACTIONS. */
    public static final String PATH_INSPECTION_PLANS_ACTIONS = "inspectionPlans" + PATH_SEPARATOR + "actions";

    /** The constant PATH_INSPECTION_ID. */
    public static final String PATH_INSPECTION_ID = PATH_SEPARATOR + "{" + INSPECTION_ID + "}";
    /** The constant PATH_INSPECTION_READY. */
    public static final String PATH_INSPECTION_READY = PATH_INSPECTION_ID + PATH_SEPARATOR + INSPECTION_READY;
    /** The constant PATH_INSPECTION_DATA. */
    public static final String PATH_INSPECTION_DATA = PATH_INSPECTIONS + PATH_INSPECTION_ID + PATH_SEPARATOR + INSPECTION_DATA;

    /** The constant PATH_CAQ_CYCLE_DATA. */
    public static final String PATH_CAQ_CYCLE_DATA = PATH_INFORM_CAQ + PATH_SEPARATOR + "caqCycleData";

    /** The constant COMPLETE_PATH_INSPECTION_READY. */
    public static final String COMPLETE_PATH_INSPECTION_READY = PATH_CAQ_INSPECTIONS + PATH_INSPECTION_READY;
    /** The constant COMPLETE_PATH_INSPECTION_DATA. */
    public static final String COMPLETE_PATH_INSPECTION_DATA = PATH_INSPECTION_PLANS_ACTIONS + PATH_INSPECTION_DATA;

    /** The constant COMPLETE_PATH_CAQ_CYCLE_DATA. */
    public static final String COMPLETE_PATH_CAQ_CYCLE_DATA = PATH_INSPECTION_PLANS_ACTIONS + PATH_CAQ_CYCLE_DATA;

    /** The constant PATH_PARAM_DESC_INSPECTION_ID. */
    public static final String PATH_PARAM_DESC_INSPECTION_ID = "ID of a inspection";
    /** The constant PATH_PARAM_DESC_INSPECTION_REQUEST_MODEL. */
    public static final String PATH_PARAM_DESC_INSPECTION_REQUEST_MODEL = "Request model";

    /** The constant NO_CONTENT. */
    public static final String NO_CONTENT = "No content";
    /** The constant RESPONSE_BAD_GATEWAY. */
    public static final String RESPONSE_BAD_GATEWAY = "Received subservice error.";
    /** The constant RESPONCE_INTERNAL_ERROR. */
    public static final String RESPONCE_INTERNAL_ERROR = "Internal server error";

    /** The constant BAD_REQUEST_OPERATION_NOT_FOUND. */
    public static final String BAD_REQUEST_OPERATION_NOT_FOUND = "Operation not found.";
    /** The constant BAD_REQUEST_WORKPLACE_NOT_FOUND. */
    public static final String BAD_REQUEST_WORKPLACE_NOT_FOUND = "Workplace not found.";
    /** The constant BAD_REQUEST_OPERATION_CONTEXT_NOT_FOUND. */
    public static final String BAD_REQUEST_OPERATION_CONTEXT_NOT_FOUND = "Operation context not found.";
    /** The constant BAD_REQUEST_MATERIAL_NOT_FOUND. */
    public static final String BAD_REQUEST_MATERIAL_NOT_FOUND = "Material not found.";
    /** The constant BAD_REQUEST_BAD_JSON_PAYLOAD. */
    public static final String BAD_REQUEST_BAD_JSON_PAYLOAD = "Bad input received for JSON payload";

    /** The constant BAD_REQUEST_NO_BATCH_TYPE_IN_EXTERNAL_RESPONSE_FOUND. */
    public static final String BAD_REQUEST_NO_BATCH_TYPE_IN_EXTERNAL_RESPONSE_FOUND = "No batch-type in the external response found";

    /** The constant CAQ_INSPECTION_READY_DESC. */
    public static final String CAQ_INSPECTION_READY_DESC = "Send id of inspection which is ready.";
    /** The constant CAQ_INSPECTION_READY_NOTES. */
    public static final String CAQ_INSPECTION_READY_NOTES = "Send id of inspection which is ready.";

    /** The constant CAQ_INSPECTION_RESPONSE_NOT_FOUND. */
    public static final String CAQ_INSPECTION_RESPONSE_NOT_FOUND = "Unable to find the inspection for the given id parameter.";
    /** The constant CAQ_INSPECTION_READY_BAD_REQUEST. */
    public static final String CAQ_INSPECTION_READY_BAD_REQUEST = "Inspection already finished.";
    /** The constant CAQ_INSPECTION_DATA_BAD_REQUEST. */
    public static final String CAQ_INSPECTION_DATA_BAD_REQUEST =
        "Inspection already finished. | " + BAD_REQUEST_BAD_JSON_PAYLOAD + " | " + BAD_REQUEST_OPERATION_NOT_FOUND + " | " + BAD_REQUEST_MATERIAL_NOT_FOUND +
        " | " + BAD_REQUEST_WORKPLACE_NOT_FOUND + " | " + BAD_REQUEST_NO_BATCH_TYPE_IN_EXTERNAL_RESPONSE_FOUND;

    /** The constant CAQ_ACTIONS_UPDATE_CYCLE_DESC. */
    public static final String CAQ_ACTIONS_UPDATE_CYCLE_DESC = "Send the request of an caq cycle.";
    /** The constant CAQ_ACTIONS_UPDATE_CYCLE_NOTES. */
    public static final String CAQ_ACTIONS_UPDATE_CYCLE_NOTES = "Send request to TRACE to update CAQ cycle.";
    /** The constant CAQ_ACTIONS_UPDATE_CYCLE_RESPONSE_RESPONSE_NO_CONTENT. */
    public static final String CAQ_ACTIONS_UPDATE_CYCLE_RESPONSE_RESPONSE_NO_CONTENT = "CAQ cycle update successfully processed.";
    /** The constant CAQ_ACTIONS_UPDATE_CYCLE_RESPONSE_RESPONSE_BAD_REQUEST. */
    public static final String CAQ_ACTIONS_UPDATE_CYCLE_RESPONSE_RESPONSE_BAD_REQUEST =
        BAD_REQUEST_BAD_JSON_PAYLOAD + " | " + BAD_REQUEST_OPERATION_CONTEXT_NOT_FOUND + " | " + BAD_REQUEST_MATERIAL_NOT_FOUND;

    /** The constant CAQ_INSPECTION_DATA_DESC. */
    public static final String CAQ_INSPECTION_DATA_DESC = "Send request to get inspection data by provided id.";
    /** The constant CAQ_INSPECTION_DATA_NOTES. */
    public static final String CAQ_INSPECTION_DATA_NOTES = "Request from TRACE to get inspection data by provided id.";
    /** The constant CAQ_INSPECTION_DATA_RESPONSE. */
    public static final String CAQ_INSPECTION_DATA_RESPONSE = "Requested inspection plan data.";

    /** The constant CAQ_CYCLE_DATA_RESPONSE. */
    public static final String CAQ_CYCLE_DATA_RESPONSE = "Requested caq cycle data.";
    /** The constant CAQ_CYCLE_DATA_BAD_REQUEST. */
    public static final String CAQ_CYCLE_DATA_BAD_REQUEST =
        "CAQ cycle data not found. | " + BAD_REQUEST_BAD_JSON_PAYLOAD + " | " + BAD_REQUEST_OPERATION_NOT_FOUND;

    /**
     * Instantiates a new Caq swagger explanation constants.
     */
    private CAQSwaggerExplanationConstants() {}
}