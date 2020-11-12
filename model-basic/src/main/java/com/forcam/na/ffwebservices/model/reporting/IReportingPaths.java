////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 28.11.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.reporting;

/**
 * URL paths related to reporting.
 */
public interface IReportingPaths {

    String REPORTS = "reports";

    String OVERALL_EQUIPMENT_EFFICIENCY = "/overallEquipmentEfficiency";

    String OVERALL_PROCESS_EFFICIENCY = "/overallProcessEfficiency";

    String HITLIST_OPERATING_STATES_WORKPLACE = "/hitListOperatingStatesWorkplace";

    String HITLIST_OPERATING_STATES_MATERIAL = "/hitListOperatingStatesMaterial";

    String QUALITY_DETAILS_MATERIAL = "/qualityDetailsMaterial";

    String QUALITY_DETAILS_WORKPLACE = "/qualityDetailsWorkplace";

    String TOTAL_QUANTITY = "/totalQuantity";

    String PATH_REPORTS = "/" + REPORTS;

    String PATH_OVERALL_EQUIPMENT_EFFICIENCY = PATH_REPORTS + OVERALL_EQUIPMENT_EFFICIENCY;

    String PATH_OVERALL_PROCESS_EFFICIENCY = PATH_REPORTS + OVERALL_PROCESS_EFFICIENCY;

    String PATH_HITLIST_OPERATINGSTATES_WORKPLACE = PATH_REPORTS + HITLIST_OPERATING_STATES_WORKPLACE;

    String PATH_HITLIST_OPERATINGSTATES_MATERIAL = PATH_REPORTS + HITLIST_OPERATING_STATES_MATERIAL;

    String PATH_TOTAL_QUANTITY = PATH_REPORTS + TOTAL_QUANTITY;

    String PATH_QUALITY_DETAILS_MATERIAL = PATH_REPORTS + QUALITY_DETAILS_MATERIAL;

    String PATH_QUALITY_DETAILS_WORKPLACE = PATH_REPORTS + QUALITY_DETAILS_WORKPLACE;

}
