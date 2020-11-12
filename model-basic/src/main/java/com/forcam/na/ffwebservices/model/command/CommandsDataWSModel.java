////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 07.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.command;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Model for an arbitrary amount of commands.
 */
@ApiModel("commands")
public class CommandsDataWSModel {
    
    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The commands. */
    private List<AbstractCommandDataWSModel> mCommands;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public List<AbstractCommandDataWSModel> getCommands() {
        return mCommands;
    }

    public void setCommands(List<AbstractCommandDataWSModel> commands) {
        mCommands = commands;
    }

}
