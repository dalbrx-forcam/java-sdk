////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 01.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.event;

/**
 * The event object types.
 */
public enum EventObjectType {

    // ------------------------------------------------------------------------
    // enums
    // ------------------------------------------------------------------------

    OPERATION,

    PRODUCTION_ORDER,

    WORKPLACE,

    WORKPLACE_GROUP,

    STAFF_MEMBER,

    TOOL,

    MACHINE,

    PREDICTED_MALFUNCTION_SCENARIO,

    OPERATION_PLANNING_SCENARIO,

    STAFF_MEMBER_PLANNING_SCENARIO,

    PLANNED_MAINTENANCE,

    SHIFTS,

    DOCUMENT,

    TOOL_ASSEMBLY_ORDER,

    TICKET,

    TICKET_ATTACHMENT,

    TICKET_ACTIVITY,

    TICKET_ACTIVITY_ATTACHMENT,

    TICKET_ACTIVITY_REMARK,

    NONE
}