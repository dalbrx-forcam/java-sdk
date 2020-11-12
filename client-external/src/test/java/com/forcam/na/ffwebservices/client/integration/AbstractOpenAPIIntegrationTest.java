////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.forcam.na.ffwebservices.client.BridgeAPI;
import com.forcam.na.ffwebservices.client.api.callback.ICallbackClient;
import com.forcam.na.ffwebservices.client.api.command.ICommandClient;
import com.forcam.na.ffwebservices.client.api.command.ICommandClientAsync;
import com.forcam.na.ffwebservices.client.api.device.IDeviceClient;
import com.forcam.na.ffwebservices.client.api.event.IEventClient;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.machine.IMachineClient;
import com.forcam.na.ffwebservices.client.api.machinestatedetail.IMachineStateDetailClient;
import com.forcam.na.ffwebservices.client.api.masterdata.IMasterDataClient;
import com.forcam.na.ffwebservices.client.api.miscellaneous.IMiscellaneousClient;
import com.forcam.na.ffwebservices.client.api.operation.IOperationClient;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.IOperationPlanningClient;
import com.forcam.na.ffwebservices.client.api.operation.request.SearchOperationsRequest;
import com.forcam.na.ffwebservices.client.api.order.IProductionOrderClient;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.pdm.IFileRepositoryClient;
import com.forcam.na.ffwebservices.client.api.reporting.IReportingClient;
import com.forcam.na.ffwebservices.client.api.staffmember.IStaffMemberClient;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersShiftsRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.IStaffMemberPlanningClient;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketActivityClient;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketClient;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityRemarksRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketAttachmentsRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketsRequest;
import com.forcam.na.ffwebservices.client.api.tool.IToolClient;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceClient;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacesRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.IWorkplaceGroupClient;
import com.forcam.na.ffwebservices.client.statusdefinition.IStatusDefinitionClient;
import com.forcam.na.ffwebservices.model.operation.OperationResponse;
import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityRemarkResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketAttachmentResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketPriority;
import com.forcam.na.ffwebservices.model.ticket.TicketResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketState;
import com.forcam.na.ffwebservices.model.ticket.WriteTicketPropertiesWSModel;
import com.forcam.na.ffwebservices.model.util.ApiVersion;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains the different clients for integration tests.
 */
public abstract class AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constants
    // ------------------------------------------------------------------------

    /** Logger for class. */
    final static Logger LOGGER = LoggerFactory.getLogger(AbstractOpenAPIIntegrationTest.class);

    protected static final String PREFIX_GET_PATH = "GEThttp://.*/ffwebservices/api/" + ApiVersion.Versions.V3;

    protected static final String PREFIX_POST_PATH = "GEThttp://.*/ffwebservices/api/" + ApiVersion.Versions.V3;

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace client. */
    final IWorkplaceClient mWorkplaceClient;

    /** The operation client. */
    final IOperationClient mOperationClient;

    /** The command client. */
    final ICommandClient mCommandClient;

    /** The status definition client. */
    final IStatusDefinitionClient mStatusDefinitionClient;

    /** The machine state detail client. */
    final IMachineStateDetailClient mMachineStateDetailClient;

    /** The asynchronous command client. */
    final ICommandClientAsync mCommandClientAsync;

    /** The machine client. */
    final IMachineClient mMachineClient;

    /** The production order client. */
    final IProductionOrderClient mProductionOrderClient;

    /** The staff member client. */
    final IStaffMemberClient mStaffMemberClient;

    /** The staff member planning client. */
    final IStaffMemberPlanningClient mStaffMemberPlanningClient;

    /** The tool client. */
    final IToolClient mToolClient;

    /** The master data client. */
    final IMasterDataClient mMasterDataClient;

    /** The miscellaneous client. */
    final IMiscellaneousClient mMiscellaneousClient;

    /** The workplace group client. */
    final IWorkplaceGroupClient mWorkplaceGroupClient;

    /** The planning scenario client. */
    final IOperationPlanningClient mOperationPlanningClient;

    /** The callback client. */
    final ICallbackClient mCallbackClient;

    /** The event client. */
    final IEventClient mEventClient;

    /** Jackson's objectmapper. */
    private final ObjectMapper mMapper;

    /** The device client */
    final IDeviceClient mDeviceClient;

    /** The file repository client. */
    final IFileRepositoryClient mFileRepositoryClient;

    final IReportingClient mReportingClient;

    final ITicketClient mTicketClient;

    final ITicketActivityClient mTicketActivityClient;

    /** The names of the test files. */
    Map<Pattern, String> mFileNames = new HashMap<>();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public AbstractOpenAPIIntegrationTest() {

        mMapper = new ObjectMapper();
        mMapper.registerModule(new JavaTimeModule());

        try {
            final BridgeAPI openAPI = this.createForceAPI();

            mWorkplaceClient = openAPI.getWorkplaceClient();
            mOperationClient = openAPI.getOperationClient();
            mCommandClient = openAPI.getCommandClient();
            mStatusDefinitionClient = openAPI.getStatusDefinitionClient();
            mMachineStateDetailClient = openAPI.getMachineStateDetailClient();
            mCommandClientAsync = openAPI.getCommandClientAsync();
            mMachineClient = openAPI.getMachineClient();
            mProductionOrderClient = openAPI.getProductionOrderClient();
            mStaffMemberClient = openAPI.getStaffMemberClient();
            mStaffMemberPlanningClient = openAPI.getStaffMemberPlanningClient();
            mToolClient = openAPI.getToolClient();
            mMasterDataClient = openAPI.getMasterDataClient();
            mMiscellaneousClient = openAPI.getMiscellaneousClient();
            mWorkplaceGroupClient = openAPI.getWorkplaceGroupClient();
            mOperationPlanningClient = openAPI.getPlanningScenarioClient();
            mCallbackClient = openAPI.getCallbackClient();
            mEventClient = openAPI.getEventClient();
            mDeviceClient = openAPI.getDeviceClient();
            mFileRepositoryClient = openAPI.getFileRepositoryClient();
            mReportingClient = openAPI.getReportingClient();
            mTicketClient = openAPI.getTicketClient();
            mTicketActivityClient = openAPI.getTicketActivityClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Creates a Force API.
     *
     * @return The Force API.
     * @throws IOException When unable to register interceptors.
     */
    private BridgeAPI createForceAPI() throws IOException {
        final List<Interceptor> interceptors = new ArrayList<>();
        final Interceptor fileWriterInterceptor = chain -> {
            final Request request = chain.request();
            final HttpUrl url = request.url();
            final String method = request.method();
            final Response response = chain.proceed(request);
            final ResponseBody body = response.body();
            if (body != null && body.contentLength() != 0) {
                final String bodyAsString = body.string();

                final Object json = mMapper.readValue(bodyAsString, Object.class);
                final String prettyJsonString = mMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(json);

                try {
                    Path path = this.createFile(url, method);
                    if (path != null) {
                        Files.write(path, prettyJsonString.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    }
                } catch (IOException | URISyntaxException e) {
                    LOGGER.warn("Unable to write response to file", e);
                }

                return response
                    .newBuilder()
                    .body(ResponseBody.create(body.contentType(), bodyAsString))
                    .headers(response.headers())
                    .build();
            }
            return response;
        };
        interceptors.add(fileWriterInterceptor);

        final Properties testProps = new Properties();
        final ClassLoader classLoader = this
            .getClass()
            .getClassLoader();
        final InputStream testPropsStream = classLoader.getResourceAsStream("test.properties");
        testProps.load(testPropsStream);

        return new BridgeAPI(testProps.getProperty("baseUrl", "http://localhost:24080/ffwebservices/"),
                             testProps.getProperty("tokenBaseUrl", "https://localhost:25443/ffauth/"),
                             testProps.getProperty("clientId"),
                             testProps.getProperty("clientSecret"),
                             Locale.forLanguageTag(testProps.getProperty("locale", Locale.US.toLanguageTag())),
                             interceptors,
                             Boolean.parseBoolean(testProps.getProperty("trustAnySSL", "false")),
                             Boolean.parseBoolean(testProps.getProperty("enryptedSecret", "false")));
    }

    /**
     * Creates a file.
     *
     * @param url    The URL.
     * @param method The HTTP method.
     * @return The path of the new file.
     * @throws IOException        When unable to create a file.
     * @throws URISyntaxException When the file URL cannot be converted to a URI.
     */
    public Path createFile(HttpUrl url, String method) throws IOException, URISyntaxException {
        ClassLoader classLoader = this
            .getClass()
            .getClassLoader();
        final String responseFileName = this.getFileName(url, method);
        if (responseFileName == null) {
            return null;
        }
        final URL resource = classLoader.getResource("json");
        return Paths.get(new URL(resource, responseFileName).toURI());
    }

    /**
     * Returns the name for a test file.
     *
     * @param url    The URL.
     * @param method The HTTP method.
     * @return A file name.
     */
    String getFileName(HttpUrl url, String method) {
        for (Map.Entry<Pattern, String> fileName : mFileNames.entrySet()) {
            final Matcher matcher = fileName
                .getKey()
                .matcher(method + url.toString());
            if (matcher.matches()) {
                return fileName.getValue();
            }
        }
        return null;
    }

    /**
     * Returns the id of an available workplace.
     *
     * @return A workplace id.
     * @throws ForceAPIException When unable to get workplaces.
     */
    protected String getWorkplaceId() throws ForceAPIException {
        final GetWorkplacesRequest request = new GetWorkplacesRequest();
        request.setLimit(1);
        final Page<WorkplaceResponse> workplaceCollection = mWorkplaceClient.getWorkplaces(request);

        Assert.assertNotNull(workplaceCollection);
        Assert.assertFalse(workplaceCollection
                               .getElements()
                               .isEmpty());

        final WorkplaceResponse workplace = workplaceCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(workplace.getProperties());

        return workplace
            .getProperties()
            .getId();
    }

    /**
     * Returns the id of an available operation.
     *
     * @return An operation id.
     */
    protected String getOperationId() throws ForceAPIException {
        final SearchOperationsRequest operationsRequest = new SearchOperationsRequest();
        operationsRequest.setLimit(1);
        final Page<OperationResponse> operationCollection = mOperationClient.searchOperations(operationsRequest);
        Assert.assertNotNull(operationCollection);
        Assert.assertFalse(operationCollection
                               .getElements()
                               .isEmpty());

        final OperationResponse operation = operationCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(operation.getProperties());

        return operation
            .getProperties()
            .getId();
    }

    /**
     * Gets staff member ID.
     *
     * @return The staff member ID.
     */
    protected String getStaffMemberId() throws ForceAPIException {
        final GetStaffMembersRequest staffMembersRequest = new GetStaffMembersRequest();
        staffMembersRequest.setLimit(1);
        final Page<StaffMemberResponse> staffMemberCollection = mStaffMemberClient.getStaffMembers(staffMembersRequest);

        Assert.assertNotNull(staffMemberCollection);
        Assert.assertFalse(staffMemberCollection
                               .getElements()
                               .isEmpty());

        final StaffMemberResponse staffMember = staffMemberCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(staffMember.getProperties());

        return staffMember
            .getProperties()
            .getId();
    }

    /**
     * Gets staff member ID.
     *
     * @return The staff member ID.
     */
    protected String getTicketId() throws ForceAPIException {
        final GetTicketsRequest ticketRequest = new GetTicketsRequest();
        ticketRequest.setLimit(1);
        final Page<TicketResponse> ticketCollection = mTicketClient.getTickets(ticketRequest);

        Assert.assertNotNull(ticketCollection);
        Assert.assertFalse(ticketCollection
                               .getElements()
                               .isEmpty());

        final TicketResponse ticket = ticketCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(ticket.getProperties());

        return ticket
            .getProperties()
            .getId();
    }

    /**
     * Gets ticket state id.
     *
     * @return The ticket state id.
     */
    protected TicketState getTicketStateId() throws ForceAPIException {
        final GetTicketsRequest ticketRequest = new GetTicketsRequest();
        ticketRequest.setLimit(1);
        final Page<TicketResponse> ticketCollection = mTicketClient.getTickets(ticketRequest);

        Assert.assertNotNull(ticketCollection);
        Assert.assertFalse(ticketCollection
                               .getElements()
                               .isEmpty());

        final TicketResponse ticket = ticketCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(ticket.getProperties());

        return ticket
            .getProperties()
            .getTicketStateId();
    }

    /**
     * Gets ticket attachment id.
     *
     * @return The ticket attachment id.
     * @throws ForceAPIException
     */
    protected String getTicketAttachmentId(String ticketId) throws ForceAPIException {
        final GetTicketAttachmentsRequest request = new GetTicketAttachmentsRequest(ticketId);
        Page<TicketAttachmentResponse> response = mTicketClient.getTicketAttachments(request);
        Assert.assertNotNull(response);
        return response
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }

    /**
     * Gets the ticket activity id.
     *
     * @return The ticket activity id.
     * @throws ForceAPIException
     */
    protected String getTicketActivityId(String ticketId) throws ForceAPIException {
        final GetTicketActivitiesRequest request = new GetTicketActivitiesRequest(ticketId);
        Page<TicketActivityResponse> response = mTicketActivityClient.getTicketActivities(request);

        return response
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }

    protected String getTicketActivityAttachmentId(String ticketId, String activityId) throws ForceAPIException {
        final GetTicketActivityAttachmentsRequest request = new GetTicketActivityAttachmentsRequest(ticketId, activityId);
        Page<TicketActivityAttachmentResponse> response = mTicketActivityClient.getTicketActivityAttachments(request);
        Assert.assertNotNull(response);
        return response
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }

    protected String getTicketActivityRemarkId(String ticketId, String activityId) throws ForceAPIException {
        final GetTicketActivityRemarksRequest request = new GetTicketActivityRemarksRequest(ticketId, activityId);
        Page<TicketActivityRemarkResponse> response = mTicketActivityClient.getTicketActivityRemarks(request);
        Assert.assertNotNull(response);
        return response
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }

    /**
     * Gets ticket Data
     *
     * @return The ticket data
     */
    protected WriteTicketPropertiesWSModel getTicketData() {
        WriteTicketPropertiesWSModel ticketData = new WriteTicketPropertiesWSModel();
        ticketData.setTitle("Test title");
        ticketData.setDescription("Test description");
        ticketData.setRootCause("test rootClause");
        ticketData.setPriority(TicketPriority.LOW);
        ticketData.setTicketStateId(TicketState.NEW);
        ticketData.setOperationId("E3C39A230B3C4DFAB3E20309B7452B51");
        ticketData.setMaterialNumber("M-15223675");
        ticketData.setWorkplaceId("75DE708E3215456A8829146FED901BA8");
        ticketData.setShiftId("2A1644DC41264EC7A33277735C17E9D3");
        return ticketData;
    }

    /**
     * Gets staff member shift ID.
     *
     * @return The staff member shift ID.
     * @throws ForceAPIException When unable to get staff member shift.
     */
    protected String getStaffMemberShiftId() throws ForceAPIException {
        final GetStaffMembersShiftsRequest shiftsRequest = new GetStaffMembersShiftsRequest();
        shiftsRequest.setLimit(1);
        shiftsRequest.setStartDate(new Date(0));

        final Page<StaffMemberShiftResponse> staffMembersShifts = mStaffMemberClient.getStaffMembersShifts(shiftsRequest);
        Assert.assertNotNull(staffMembersShifts
                                 .getElements()
                                 .get(0)
                                 .getProperties()
                                 .getId());

        return staffMembersShifts
            .getElements()
            .get(0)
            .getProperties()
            .getId();
    }
}