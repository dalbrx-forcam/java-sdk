////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.erpcontext;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for ERP contexts.
 */
public class ErpContextResponseBuilder extends AbstractResponseBuilder implements IErpContextResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public ErpContextResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<ErpContextResponse> getErpContextCollectionResponse(GetErpContextsRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<ErpContextResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> erpContexts = embedded.get("erpContexts");

        final List<ErpContextResponse> erpContextModels = erpContexts
            .stream()
            .map(this::getErpContextResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(erpContextModels);
        return collectionResponse;
    }

    @Override
    public ErpContextResponse getErpContextResponse(HALWSModel serverModel) {
        final ErpContextResponse erpContextModel = new ErpContextResponse();
        final ErpContextPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), ErpContextPropertiesWSModel.class);
        erpContextModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        erpContextModel.setSelf(selfLink);

        return erpContextModel;
    }
}