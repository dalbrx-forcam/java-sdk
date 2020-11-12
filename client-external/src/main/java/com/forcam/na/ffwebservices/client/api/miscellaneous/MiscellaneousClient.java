////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 11.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.miscellaneous;

import com.forcam.na.common.webserviceaccess.requestparams.RequestParams;
import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.entrypoint.EntryPointEndpoint;
import com.forcam.na.ffwebservices.client.api.entrypoint.IEntryPointResponseBuilder;
import com.forcam.na.ffwebservices.client.api.erpcontext.ErpContextEndpoint;
import com.forcam.na.ffwebservices.client.api.erpcontext.IErpContextResponseBuilder;
import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextRequest;
import com.forcam.na.ffwebservices.client.api.erpcontext.request.GetErpContextsRequest;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.literal.ILiteralResponseBuilder;
import com.forcam.na.ffwebservices.client.api.literal.LiteralEndpoint;
import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralRequest;
import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralsRequest;
import com.forcam.na.ffwebservices.client.api.material.IMaterialResponseBuilder;
import com.forcam.na.ffwebservices.client.api.material.MaterialEndpoint;
import com.forcam.na.ffwebservices.client.api.material.request.GetMaterialRequest;
import com.forcam.na.ffwebservices.client.api.material.request.GetMaterialsRequest;
import com.forcam.na.ffwebservices.client.api.material.response.MaterialResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.entrypoint.EntryPointResponse;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextResponse;
import com.forcam.na.ffwebservices.model.literal.LiteralResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests miscellaneous.
 */
public class MiscellaneousClient extends AbstractClient implements IMiscellaneousClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The ERP context endpoint. */
    private final ErpContextEndpoint mErpContextEndpoint;

    /** The ERP context response builder. */
    private final IErpContextResponseBuilder mErpContextResponseBuilder;

    /** The literal endpoint. */
    private final LiteralEndpoint mLiteralEndpoint;

    /** The literal response builder. */
    private final ILiteralResponseBuilder mLiteralResponseBuilder;

    /** The entry point endpoint. */
    private final EntryPointEndpoint mEntryPointEndpoint;

    private final MaterialEndpoint mMaterialEndpoint;

    private final IMaterialResponseBuilder mMaterialResponseBuilder;

    /** The entry point response builder. */
    private final IEntryPointResponseBuilder mEntryPointResponseBuilder;

    // ------------------------------------------------------------------------
    // constructor
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param entryPointEndpoint        Entry point endpoint.
     * @param entryPointResponseBuilder Entry point response builder.
     * @param erpContextEndpoint        ERP context endpoint.
     * @param erpContextResponseBuilder ERP context response builder.
     * @param literalEndpoint           Literal endpoint.
     * @param materialEndpoint          Material endpoint.
     * @param literalResponseBuilder    Literal response builder.
     * @param materialResponseBuilder   Material response builder.
     */
    @Inject
    public MiscellaneousClient(ErpContextEndpoint erpContextEndpoint, IErpContextResponseBuilder erpContextResponseBuilder, LiteralEndpoint literalEndpoint,
                               ILiteralResponseBuilder literalResponseBuilder, EntryPointEndpoint entryPointEndpoint,
                               IEntryPointResponseBuilder entryPointResponseBuilder, MaterialEndpoint materialEndpoint,
                               IMaterialResponseBuilder materialResponseBuilder) {
        mErpContextEndpoint = erpContextEndpoint;
        mErpContextResponseBuilder = erpContextResponseBuilder;
        mLiteralEndpoint = literalEndpoint;
        mLiteralResponseBuilder = literalResponseBuilder;
        mEntryPointEndpoint = entryPointEndpoint;
        mMaterialEndpoint = materialEndpoint;
        mEntryPointResponseBuilder = entryPointResponseBuilder;
        mMaterialResponseBuilder = materialResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<ErpContextResponse> getErpContexts(GetErpContextsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mErpContextEndpoint.getErpContexts(request.getIdentifier1(),
                                                                                   request.getIdentifier2(),
                                                                                   request.getIdentifier3(),
                                                                                   request.getSystem(),
                                                                                   request.getType(),
                                                                                   request.getLimit(),
                                                                                   request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<ErpContextResponse> response = mErpContextResponseBuilder.getErpContextCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);

    }

    @Override
    public ErpContextResponse getErpContext(GetErpContextRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mErpContextEndpoint.getErpContext(request.getId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mErpContextResponseBuilder.getErpContextResponse(responseModel);
    }

    @Override
    public Page<LiteralResponse> getLiterals(GetLiteralsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mLiteralEndpoint.getLiterals(request.getType(),
                                                                             request.getIdentifier1(),
                                                                             request.getIdentifier2(),
                                                                             request.getIdentifier3(),
                                                                             request.getLimit(),
                                                                             request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<LiteralResponse> response = mLiteralResponseBuilder.getLiteralCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public LiteralResponse getLiteral(GetLiteralRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mLiteralEndpoint.getLiteral(request.getId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mLiteralResponseBuilder.getLiteralResponse(responseModel);
    }

    @Override
    public EntryPointResponse getEntryPoint(RequestParams request) throws ForceAPIException {
        final Call<HALWSModel> call = mEntryPointEndpoint.getEntryPoint();
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mEntryPointResponseBuilder.getEntryPointResponse(responseModel);
    }

    @Override
    public Page<MaterialResponse> getMaterials(GetMaterialsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mMaterialEndpoint.getMaterials(request.getLimit(),
                                                                               request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<MaterialResponse> response = mMaterialResponseBuilder.getMaterialCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public MaterialResponse getMaterial(GetMaterialRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mMaterialEndpoint.getMaterial(request.getId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mMaterialResponseBuilder.getMaterialResponse(responseModel);
    }
}