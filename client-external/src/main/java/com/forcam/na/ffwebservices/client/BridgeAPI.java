package com.forcam.na.ffwebservices.client;

import com.forcam.na.ffwebservices.client.api.callback.ICallbackClient;
import com.forcam.na.ffwebservices.client.api.command.ICommandClient;
import com.forcam.na.ffwebservices.client.api.command.ICommandClientAsync;
import com.forcam.na.ffwebservices.client.api.device.IDeviceClient;
import com.forcam.na.ffwebservices.client.api.erp.IERPClient;
import com.forcam.na.ffwebservices.client.api.event.IEventClient;
import com.forcam.na.ffwebservices.client.api.machine.IMachineClient;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.IMachineStateDetailClient;
import com.forcam.na.ffwebservices.client.api.masterdata.IMasterDataClient;
import com.forcam.na.ffwebservices.client.api.miscellaneous.IMiscellaneousClient;
import com.forcam.na.ffwebservices.client.api.operation.IOperationClient;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.IOperationPlanningClient;
import com.forcam.na.ffwebservices.client.api.order.IProductionOrderClient;
import com.forcam.na.ffwebservices.client.api.pdm.IFileRepositoryClient;
import com.forcam.na.ffwebservices.client.api.reporting.IReportingClient;
import com.forcam.na.ffwebservices.client.api.staffmember.IStaffMemberClient;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.IStaffMemberPlanningClient;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketActivityClient;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketClient;
import com.forcam.na.ffwebservices.client.api.tool.IToolClient;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceClient;
import com.forcam.na.ffwebservices.client.api.workplacegroup.IWorkplaceGroupClient;
import com.forcam.na.ffwebservices.client.config.BridgeAPIComponent;
import com.forcam.na.ffwebservices.client.config.DaggerBridgeAPIComponent;
import com.forcam.na.ffwebservices.client.config.ForceAPIModule;
import com.forcam.na.ffwebservices.client.config.InterceptorModule;
import com.forcam.na.ffwebservices.client.statusdefinition.IStatusDefinitionClient;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

/**
 * The Force API.
 */
public class BridgeAPI {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger for class. */
    public static final Logger LOGGER = LoggerFactory.getLogger(BridgeAPI.class);

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The injector. */
    private BridgeAPIComponent mBridgeAPIComponent;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Initialises the force API and its members.
     *
     * @param baseUrl      The base URL of the API. e.g. https://host:24443/ffwebservices/
     * @param tokenBaseUrl The base URL of the token endpoint. e.g. https://host:25443/ffauth/
     * @param clientId     The client id.
     * @param clientSecret The client secret.
     */
    public BridgeAPI(String baseUrl, String tokenBaseUrl, String clientId, String clientSecret) {
        this(baseUrl, tokenBaseUrl, clientId, clientSecret, Locale.UK);
    }

    /**
     * Initialises the force API and its members.
     *
     * @param baseUrl      The base URL of the API. e.g. https://host:24443/ffwebservices/
     * @param tokenBaseUrl The base URL of the token endpoint. e.g. https://host:25443/ffauth/
     * @param clientId     The client id.
     * @param clientSecret The client secret.
     * @param locale       The locale which the client should use for all requests.
     */
    public BridgeAPI(String baseUrl, String tokenBaseUrl, String clientId, String clientSecret, Locale locale) {
        this(baseUrl, tokenBaseUrl, clientId, clientSecret, locale, Collections.emptyList(), false, false);
    }

    /**
     * Initialises the force API and its members.
     *
     * @param baseUrl         The base URL of the API. e.g. https://host:24443/ffwebservices/
     * @param tokenBaseUrl    The base URL of the token endpoint. e.g. https://host:25443/ffauth/
     * @param clientId        The client id.
     * @param clientSecret    The client secret.
     * @param locale          The locale which the client should use for all requests.
     * @param interceptors    Collection of {@link Interceptor}s which are called for every api request.
     * @param trustAnySSL     The setting to trust any unverified certificates
     * @param encryptedSecret Specifies if the client secret is encrypted
     */
    public BridgeAPI(String baseUrl, String tokenBaseUrl, String clientId, String clientSecret, Locale locale, Collection<Interceptor> interceptors,
                     boolean trustAnySSL, boolean encryptedSecret) {
        final InterceptorModule interceptorModule = new InterceptorModule(interceptors);
        final ForceAPIModule forceAPIModule = new ForceAPIModule(baseUrl, locale, clientId, clientSecret, trustAnySSL, encryptedSecret, tokenBaseUrl);

        mBridgeAPIComponent = DaggerBridgeAPIComponent
            .builder()
            .forceAPIModule(forceAPIModule)
            .interceptorModule(interceptorModule)
            .build();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Returns a command client.
     *
     * @return The command client.
     */
    public ICommandClient getCommandClient() {
        return mBridgeAPIComponent.commandClient();
    }

    /**
     * Returns a workplace client.
     *
     * @return The workplace client.
     */
    public IWorkplaceClient getWorkplaceClient() {
        return mBridgeAPIComponent.workplaceClient();
    }

    /**
     * Returns an operation client.
     *
     * @return The operation client.
     */
    public IOperationClient getOperationClient() {
        return mBridgeAPIComponent.operationClient();
    }

    /**
     * Returns a status definition client.
     *
     * @return The status definition client.
     */
    public IStatusDefinitionClient getStatusDefinitionClient() {
        return mBridgeAPIComponent.statusDefinitionClient();
    }

    /**
     * Returns a machine state detail client.
     *
     * @return The machine state detail client.
     */
    public IMachineStateDetailClient getMachineStateDetailClient() {
        return mBridgeAPIComponent.machineStateDetailClient();
    }

    /**
     * Returns an asynchronous command client.
     *
     * @return The asynchronous command client.
     */
    public ICommandClientAsync getCommandClientAsync() {
        return mBridgeAPIComponent.commandClientAsync();
    }

    /**
     * Returns a machine client.
     *
     * @return The machine client.
     */
    public IMachineClient getMachineClient() {
        return mBridgeAPIComponent.machineClient();
    }

    /**
     * Returns a planning scenario client.
     *
     * @return The planning scenario client.
     */
    public IOperationPlanningClient getPlanningScenarioClient() {
        return mBridgeAPIComponent.planningScenarioClient();
    }

    /**
     * Returns a production order client.
     *
     * @return The production order client.
     */
    public IProductionOrderClient getProductionOrderClient() {
        return mBridgeAPIComponent.productionOrderClient();
    }

    /**
     * Returns a staff member client.
     *
     * @return The staff member client.
     */
    public IStaffMemberClient getStaffMemberClient() {
        return mBridgeAPIComponent.staffMemberClient();
    }

    /**
     * Returns a tool client.
     *
     * @return The tool client.
     */
    public IToolClient getToolClient() {
        return mBridgeAPIComponent.toolClient();
    }

    /**
     * Returns a master data client.
     *
     * @return The master data client.
     */
    public IMasterDataClient getMasterDataClient() {
        return mBridgeAPIComponent.masterDataClient();
    }

    /**
     * Returns a miscellaneous client.
     *
     * @return The miscellaneous client.
     */
    public IMiscellaneousClient getMiscellaneousClient() {
        return mBridgeAPIComponent.miscellaneousClient();
    }

    /**
     * Returns a workplace group client.
     *
     * @return The workplace group client.
     */
    public IWorkplaceGroupClient getWorkplaceGroupClient() {
        return mBridgeAPIComponent.workplaceGroupClient();
    }

    /**
     * Returns a callback client.
     *
     * @return The callback client.
     */
    public ICallbackClient getCallbackClient() {
        return mBridgeAPIComponent.callbackClient();
    }

    /**
     * Returns an event client.
     *
     * @return The event client.
     */
    public IEventClient getEventClient() {
        return mBridgeAPIComponent.eventClient();
    }

    /**
     * Return a device client.
     *
     * @return The device client.
     */
    public IDeviceClient getDeviceClient() {
        return mBridgeAPIComponent.deviceClient();
    }

    /**
     * Return a file repository client.
     *
     * @return The file repository client.
     */
    public IFileRepositoryClient getFileRepositoryClient() {
        return mBridgeAPIComponent.fileRepositoryClient();
    }

    /**
     * Return a staff member planning client.
     *
     * @return The staff member planning client.
     */
    public IStaffMemberPlanningClient getStaffMemberPlanningClient() {
        return mBridgeAPIComponent.staffMemberPlanningClient();
    }

    /**
     * Return a reporting client.
     *
     * @return The reporting client.
     */
    public IReportingClient getReportingClient() { return mBridgeAPIComponent.reportingClient();}

    /**
     * Get a ticket client.
     *
     * @return The ticket client.
     */
    public ITicketClient getTicketClient() {
        return mBridgeAPIComponent.ticketClient();
    }

    /**
     * Get a ticket activity client.
     *
     * @return The ticket activity client.
     */
    public ITicketActivityClient getTicketActivityClient() {
        return mBridgeAPIComponent.ticketActivityClient();
    }

    /**
     * Get a erp client.
     *
     * @return The erp client.
     */
    public IERPClient getERPClient() {
        return mBridgeAPIComponent.erpClient();
    }

    /**
     * Causes a shutdown.
     */
    public void shutdown() {
        final OkHttpClient httpClient = mBridgeAPIComponent.okHttpClient();
        httpClient
            .dispatcher()
            .executorService()
            .shutdown();
    }
}