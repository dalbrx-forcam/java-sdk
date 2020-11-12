////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.integration;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.client.api.tool.ToolClient;
import com.forcam.na.ffwebservices.client.api.tool.request.CreateToolEdgeRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.CreateToolRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.DeleteToolLocationRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.DeleteToolRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolCharacteristicsRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolEdgeCharacteristicsRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolEdgeRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolEdgesRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolLocationRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolsRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.PutToolCharacteristicsRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.PutToolEdgeCharacteristicsRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.PutToolLocationRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.SetToolStateRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.UpdateToolEdgeRequest;
import com.forcam.na.ffwebservices.client.api.tool.response.CharacteristicCollectionPage;
import com.forcam.na.ffwebservices.client.api.tool.response.CharacteristicCollectionResponse;
import com.forcam.na.ffwebservices.model.tool.CharacteristicGeneralDefinition;
import com.forcam.na.ffwebservices.model.tool.CreateToolEdgePropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.CreateToolLocationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.CreateToolPropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.GetToolEdgePropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.LifeTime;
import com.forcam.na.ffwebservices.model.tool.ToolEdgePropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolEdgeResponse;
import com.forcam.na.ffwebservices.model.tool.ToolIdentifierValueWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolLocationResponse;
import com.forcam.na.ffwebservices.model.tool.ToolResponse;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Integration tests for the class {@link ToolClient}.
 */
public class ToolClientIntegrationTest extends AbstractOpenAPIIntegrationTest {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    public ToolClientIntegrationTest() {
        final Pattern toolsPattern = Pattern.compile(PREFIX_GET_PATH + "/tools\\?.*limit=3.*");
        mFileNames.put(toolsPattern, "json/getTools.json");

        final Pattern createToolPattern = Pattern.compile(PREFIX_POST_PATH + "/tools");
        mFileNames.put(createToolPattern, "json/createTool.json");

        final Pattern toolPattern = Pattern.compile(PREFIX_GET_PATH + "/tools/.{32}\\?.*");
        mFileNames.put(toolPattern, "json/getTool.json");

        final Pattern characteristicsPattern = Pattern.compile(PREFIX_GET_PATH + "/tools/.{32}/characteristics\\?.*limit=3.*");
        mFileNames.put(characteristicsPattern, "json/getToolCharacteristics.json");

        final Pattern putCharacteristicsPattern = Pattern.compile("PUThttp://.*/ffwebservices/api/v1/tools/.{32}/characteristics");
        mFileNames.put(putCharacteristicsPattern, "json/putToolCharacteristics.json");

        final Pattern edgesPattern = Pattern.compile(PREFIX_GET_PATH + "/tools/.{32}/edges");
        mFileNames.put(edgesPattern, "json/getToolEdges.json");

        final Pattern createEdgePattern = Pattern.compile(PREFIX_POST_PATH + "/tools/.{32}/edges");
        mFileNames.put(createEdgePattern, "json/createToolEdge.json");

        final Pattern edgePattern = Pattern.compile(PREFIX_GET_PATH + "/tools/.{32}/edges/.{32}");
        mFileNames.put(edgePattern, "json/getToolEdge.json");

        final Pattern updateEdgePattern = Pattern.compile("PUThttp://.*/ffwebservices/api/v1/tools/.{32}/edges/.{32}");
        mFileNames.put(updateEdgePattern, "json/updateToolEdge.json");

        final Pattern edgeCharacteristicsPattern = Pattern.compile(PREFIX_GET_PATH + "/tools/.{32}/edges/.{32}/characteristics\\?.*limit=3.*");
        mFileNames.put(edgeCharacteristicsPattern, "json/getToolEdgeCharacteristics.json");

        final Pattern putEdgeCharacteristicsPattern = Pattern.compile("PUThttp://.*/ffwebservices/api/v1/tools/.{32}/edges/.{32}/characteristics");
        mFileNames.put(putEdgeCharacteristicsPattern, "json/putToolEdgeCharacteristics.json");

        final Pattern locationPattern = Pattern.compile(PREFIX_GET_PATH + "/tools/.{32}/location");
        mFileNames.put(locationPattern, "json/getToolLocation.json");

        final Pattern putLocationPattern = Pattern.compile("PUThttp://.*/ffwebservices/api/v1/tools/.{32}/location");
        mFileNames.put(putLocationPattern, "json/putToolLocation.json");

        final Pattern deleteLocationPattern = Pattern.compile("DELETEhttp://.*/ffwebservices/api/v1/tools/.{32}/location");
        mFileNames.put(deleteLocationPattern, "json/deleteToolLocation.json");

        final Pattern setToolStatePattern = Pattern.compile(PREFIX_POST_PATH + "/tools/.{32}/.{1}");
        mFileNames.put(setToolStatePattern, "json/setToolState.json");
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    /**
     * Test for the method {@link ToolClient#getTools(GetToolsRequest)}.
     *
     * @throws ForceAPIException When unable to get tools.
     */
    @Test
    public void testGetTools() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final GetToolsRequest request = new GetToolsRequest();
        request.setLimit(3);
        request
            .embed()
            .description(true)
            .workplace(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<ToolResponse> toolCollection = mToolClient.getTools(request);

        Assert.assertNotNull(toolCollection);
        Assert.assertFalse(toolCollection
                               .getElements()
                               .isEmpty());
    }

    /**
     * Test for the method {@link ToolClient#createTool(CreateToolRequest)}.
     *
     * @throws ForceAPIException When unable to create tool.
     */
    @Test
    public void testCreateTool() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolResponse toolModel = this.createNewTool();

        Assert.assertNotNull(toolModel);
        Assert.assertNotNull(toolModel.getProperties());
    }

    /**
     * Test for the method {@link ToolClient#getTool(GetToolRequest)}.
     *
     * @throws ForceAPIException When unable to get tool.
     */
    @Test
    public void testGetTool() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();

        final GetToolRequest request = new GetToolRequest(toolId);
        request
            .embed()
            .description(true)
            .workplace(true);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolResponse toolModel = mToolClient.getTool(request);

        Assert.assertNotNull(toolModel);
        Assert.assertNotNull(toolModel.getProperties());
    }

    /**
     * Test for the method {@link ToolClient#deleteTool(DeleteToolRequest)}.
     *
     * @throws ForceAPIException When unable to delete tool.
     */
    @Test
    public void testDeleteTool() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final ToolResponse toolModel = this.createNewTool();
        final DeleteToolRequest request = new DeleteToolRequest(toolModel
                                                                    .getProperties()
                                                                    .getId());

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.deleteTool(request);
    }

    /**
     * Test for the method {@link ToolClient#getCharacteristics(GetToolCharacteristicsRequest)}.
     *
     * @throws ForceAPIException When unable to get characteristics.
     */
    @Test
    public void testGetCharacteristics() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final GetToolCharacteristicsRequest request = new GetToolCharacteristicsRequest(toolId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final SpecificPage<CharacteristicGeneralDefinition, CharacteristicCollectionResponse> characteristicCollection = mToolClient.getCharacteristics(request);

        Assert.assertNotNull(characteristicCollection);
    }

    /**
     * Test for the method {@link ToolClient#putCharacteristics(PutToolCharacteristicsRequest)}.
     *
     * @throws ForceAPIException When unable to put characteristics.
     */
    @Test
    public void testPutCharacteristics() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final List characteristics = this.getCharacteristics();
        final PutToolCharacteristicsRequest request = new PutToolCharacteristicsRequest(toolId, characteristics);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CharacteristicCollectionPage characteristicCollection = mToolClient.putCharacteristics(request);

        Assert.assertNotNull(characteristicCollection);
    }

    /**
     * Test for the method {@link ToolClient#getEdges(GetToolEdgesRequest)}.
     *
     * @throws ForceAPIException When unable to get edges.
     */
    @Test
    public void testGetEdges() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final GetToolEdgesRequest request = new GetToolEdgesRequest(toolId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final Page<ToolEdgeResponse> edgeCollection = mToolClient.getEdges(request);

        Assert.assertNotNull(edgeCollection);
    }

    /**
     * Test for the method {@link ToolClient#createEdge(CreateToolEdgeRequest)}.
     *
     * @throws ForceAPIException When unable to create edge.
     */
    @Test
    public void testCreateEdge() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolEdgeResponse edgeModel = this.createNewEdge(toolId);

        Assert.assertNotNull(edgeModel);
        Assert.assertNotNull(edgeModel.getProperties());
    }

    /**
     * Test for the method {@link ToolClient#getEdge(GetToolEdgeRequest)}.
     *
     * @throws ForceAPIException When unable to get edge.
     */
    @Test
    public void testGetEdge() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final String edgeId = this.getEdgeId(toolId);
        final GetToolEdgeRequest request = new GetToolEdgeRequest(toolId, edgeId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolEdgeResponse edgeModel = mToolClient.getEdge(request);

        Assert.assertNotNull(edgeModel);
        Assert.assertNotNull(edgeModel.getProperties());
    }

    /**
     * Test for the method {@link ToolClient#updateEdge(UpdateToolEdgeRequest)}.
     *
     * @throws ForceAPIException When unable to update edge.
     */
    @Test
    public void testUpdateEdge() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final String edgeId = this.getEdgeId(toolId);
        final ToolEdgePropertiesWSModel toolEdge = new ToolEdgePropertiesWSModel();
        this.fillToolEdge(toolEdge);
        toolEdge.setId(edgeId);

        final UpdateToolEdgeRequest request = new UpdateToolEdgeRequest(toolId, edgeId, toolEdge);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolEdgeResponse edgeModel = mToolClient.updateEdge(request);

        Assert.assertNotNull(edgeModel);
        Assert.assertNotNull(edgeModel.getProperties());
    }

    /**
     * Test for the method {@link ToolClient#getEdgeCharacteristics(GetToolEdgeCharacteristicsRequest)}.
     *
     * @throws ForceAPIException When unable to get edge characteristics.
     */
    @Test
    public void testGetEdgeCharacteristics() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final String edgeId = this.getEdgeId(toolId);
        final GetToolEdgeCharacteristicsRequest request = new GetToolEdgeCharacteristicsRequest(toolId, edgeId);
        request.setLimit(3);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CharacteristicCollectionPage characteristicCollection = mToolClient.getEdgeCharacteristics(request);

        Assert.assertNotNull(characteristicCollection);
    }

    /**
     * Test for the method {@link ToolClient#putEdgeCharacteristics(PutToolEdgeCharacteristicsRequest)}.
     *
     * @throws ForceAPIException When unable to put edge characteristics.
     */
    @Test
    public void testPutEdgeCharacteristics() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final String edgeId = this.getEdgeId(toolId);
        final List characteristics = this.getEdgeCharacteristics();
        final PutToolEdgeCharacteristicsRequest request = new PutToolEdgeCharacteristicsRequest(toolId, edgeId, characteristics);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final CharacteristicCollectionPage characteristicCollection = mToolClient.putEdgeCharacteristics(request);

        Assert.assertNotNull(characteristicCollection);
    }

    /**
     * Test for the method {@link ToolClient#getLocation(GetToolLocationRequest)}.
     *
     * @throws ForceAPIException When unable to get location.
     */
    @Test
    public void testGetLocation() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final GetToolLocationRequest request = new GetToolLocationRequest(toolId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolLocationResponse locationModel = mToolClient.getLocation(request);

        Assert.assertNotNull(locationModel);
        Assert.assertNotNull(locationModel.getProperties());
    }

    /**
     * Test for the method {@link ToolClient#putLocation(PutToolLocationRequest)}.
     *
     * @throws ForceAPIException When unable to put location.
     */
    @Test
    public void testPutLocation() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final CreateToolLocationPropertiesWSModel location = this.getLocation();
        final PutToolLocationRequest request = new PutToolLocationRequest(toolId, location);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolLocationResponse locationModel = mToolClient.putLocation(request);

        Assert.assertNotNull(locationModel);
        Assert.assertNotNull(locationModel.getProperties());
    }

    /**
     * Test for the method {@link ToolClient#deleteLocation(DeleteToolLocationRequest)}.
     *
     * @throws ForceAPIException When unable to delete location.
     */
    @Test
    public void testDeleteLocation() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final DeleteToolLocationRequest request = new DeleteToolLocationRequest(toolId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        mToolClient.deleteLocation(request);
    }

    /**
     * Test for the method {@link ToolClient#setToolState(SetToolStateRequest)}.
     *
     * @throws ForceAPIException When unable to set tool state.
     */
    @Test
    public void testSetToolState() throws ForceAPIException {

        // ----------------------------------------------------------------------
        // test fixture
        // ----------------------------------------------------------------------

        final String toolId = this.getToolId();
        final String toolStateId = "A";
        final SetToolStateRequest request = new SetToolStateRequest(toolId, toolStateId);

        // ----------------------------------------------------------------------
        // test
        // ----------------------------------------------------------------------

        final ToolResponse toolModel = mToolClient.setToolState(request);

        Assert.assertNotNull(toolModel);
        Assert.assertNotNull(toolModel.getProperties());
    }

    /**
     * Returns the ID of an available tool.
     *
     * @return A tool ID.
     * @throws ForceAPIException When unable to get tools.
     */
    private String getToolId() throws ForceAPIException {
        final GetToolsRequest request = new GetToolsRequest();
        request.setLimit(1);
        final Page<ToolResponse> toolCollection = mToolClient.getTools(request);

        Assert.assertNotNull(toolCollection);
        Assert.assertFalse(toolCollection
                               .getElements()
                               .isEmpty());

        final ToolResponse tool = toolCollection
            .getElements()
            .get(0);
        Assert.assertNotNull(tool.getProperties());

        return tool
            .getProperties()
            .getId();
    }

    /**
     * Creates a new tool with random identifiers.
     *
     * @return The new tool.
     * @throws ForceAPIException When unable to create tool.
     */
    private ToolResponse createNewTool() throws ForceAPIException {
        final CreateToolPropertiesWSModel toolData = new CreateToolPropertiesWSModel();

        toolData.setCharacteristics(this.getCharacteristics());

        toolData.setLocation(this.getLocation());

        final ToolIdentifierValueWSModel toolGroupModel = new ToolIdentifierValueWSModel();
        toolGroupModel.setIdentifier("ToolTest GroupIdentifier");
        toolGroupModel.setName("ToolTest GroupName");
        toolData.setGroup(toolGroupModel);

        final ToolIdentifierValueWSModel toolClassModel = new ToolIdentifierValueWSModel();
        toolClassModel.setIdentifier("ToolTest ClassIdentifier");
        toolClassModel.setName("ToolTest ClassName");
        toolData.setToolClass(toolClassModel);

        toolData.setName("ToolTest Name");
        toolData.setDescription("ToolTest Description");
        toolData.setDocumentUrl("ToolTest DocumentURL");
        final Random random = new Random();
        toolData.setIdentifier1(Integer.toString(random.nextInt()));
        toolData.setIdentifier2(Integer.toString(random.nextInt()));
        toolData.setIdentifier3(Integer.toString(random.nextInt()));

        final CreateToolRequest request = new CreateToolRequest();
        request.setToolData(toolData);
        return mToolClient.createTool(request);
    }

    /**
     * Creates a new list of characteristics for a tool.
     *
     * @return A list of characteristics for a tool.
     */
    private List<CharacteristicGeneralDefinition> getCharacteristics() {
        final CharacteristicGeneralDefinition characteristic = new CharacteristicGeneralDefinition();
        characteristic.setIdentifier("ToolTest CharacteristicIdentifier");
        characteristic.setName("ToolTest CharacteristicName");
        characteristic.setUnit("MS");
        characteristic.setValue("ToolTest CharacteristicValue");

        return Collections.singletonList(characteristic);
    }

    /**
     * Returns the ID of a newly added cut edge from the specified tool.
     *
     * @param toolId A tool ID.
     * @return A tool cut edge ID.
     * @throws ForceAPIException When unable to get edge.
     */
    private String getEdgeId(String toolId) throws ForceAPIException {
        final ToolEdgeResponse edgeModel = this.createNewEdge(toolId);
        Assert.assertNotNull(edgeModel);
        return edgeModel
            .getProperties()
            .getId();
    }

    /**
     * Fills the properties model of tool cut edges.
     *
     * @param toolEdge The tool cut edge to fill.
     */
    private void fillToolEdge(GetToolEdgePropertiesWSModel toolEdge) {
        final LifeTime lifeTime = new LifeTime();
        lifeTime.setCurrent(1000);
        lifeTime.setWarningLimit(5000);
        lifeTime.setMaximum(10000);
        toolEdge.setLifeTime(lifeTime);

        final Random random = new Random();
        toolEdge.setIdentifier(Integer.toString(random.nextInt()));
    }

    /**
     * Creates a new cut edge for the specified tool.
     *
     * @param toolId A tool ID.
     * @return The new tool cut edge.
     * @throws ForceAPIException When unable to create edge.
     */
    private ToolEdgeResponse createNewEdge(String toolId) throws ForceAPIException {
        final CreateToolEdgePropertiesWSModel toolEdge = new CreateToolEdgePropertiesWSModel();
        this.fillToolEdge(toolEdge);
        toolEdge.setCharacteristics(this.getEdgeCharacteristics());
        final CreateToolEdgeRequest request = new CreateToolEdgeRequest(toolId, toolEdge);
        return mToolClient.createEdge(request);
    }

    /**
     * Creates a new list of characteristics for a tool cut edge.
     *
     * @return A list of characteristics for a tool cut edge.
     */
    private List<CharacteristicGeneralDefinition> getEdgeCharacteristics() {
        final CharacteristicGeneralDefinition characteristic = new CharacteristicGeneralDefinition();
        characteristic.setIdentifier("ToolEdgeTest CharacteristicIdentifier");
        characteristic.setName("ToolEdgeTest CharacteristicName");
        characteristic.setUnit("MS");
        characteristic.setValue("ToolEdgeTest CharacteristicValue");

        return Collections.singletonList(characteristic);
    }

    /**
     * Creates a new location model for a tool.
     *
     * @return A new location model for a tool.
     * @throws ForceAPIException When unable to get a workplace ID.
     */
    private CreateToolLocationPropertiesWSModel getLocation() throws ForceAPIException {
        final CreateToolLocationPropertiesWSModel toolLocationModel = new CreateToolLocationPropertiesWSModel();
        toolLocationModel.setMagazineNumber((short) 0);
        toolLocationModel.setMagazinePlace((short) 0);
        toolLocationModel.setWorkplaceId(this.getWorkplaceId());

        return toolLocationModel;
    }
}