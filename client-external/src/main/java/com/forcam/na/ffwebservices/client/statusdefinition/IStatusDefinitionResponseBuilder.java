////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;

/**
 * Contains methods for building responses for status definitions.
 */
public interface IStatusDefinitionResponseBuilder {

    /** Key for getting the machine states from a map. */
    String MACHINE_STATES_KEY = "machineStates";

    String OPERATION_PRODUCTION_STATES_KEY = "operationProductionStates";

    /** Key for getting the operation phases from a map. */
    String OPERATION_PHASES_KEY = "operationPhases";

    /** Key for getting the tool assembly states from a map. */
    String TOOL_ASSEMBLY_STATES_KEY = "toolAssemblyOrderStates";

    /** Key for getting the personnel states from a map. */
    String PERSONNEL_STATES_KEY = "personnelStates";

    /** Key for getting the operating state classes from a map. */
    String OPERATING_STATE_CLASSES_KEY = "operatingStateClasses";

    /** Key for getting the workplace states from a map. */
    String WORKPLACE_STATES_KEY = "workplaceStates";

    /**
     * Transforms a collection model to a status definition collection response.
     *
     * @param params              The request.
     * @param collectionModel     A collection model.
     * @param statusDefinitionKey Key for getting the status definitions in a map.
     * @return A status definition collection response.
     */
    CollectionResponse<StatusDefinitionResponse> getStatusDefinitionCollectionResponse(CollectionRequest params, HALCollectionWSModel collectionModel,
                                                                                       String statusDefinitionKey);

    /**
     * Converts HAL Model into a status definition model.
     *
     * @param serverModel The model received by the server.
     * @return A status definition model.
     */
    StatusDefinitionResponse getStatusDefinitionResponse(HALWSModel serverModel);
}