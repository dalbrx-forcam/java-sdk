////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 15.08.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.definition;

/**
 * Defines the available operation phases in the API.
 */
public enum OperationPhase {

    RELEASED(1),

    COMPLETED(2),

    SETUP(3),

    PROCESSING(4),

    DISPATCHED(5),

    TRAINING(6),

    CLOSED(7),

    INTERRUPTED(8),

    WAITING_BEFORE_PROCESSING(9),

    WAITING_AFTER_PROCESSING(10);

    /** The code. */
    private long mCode;

    /**
     * Creates a new operation phase with a code.
     *
     * @param code The code.
     */
    OperationPhase(long code) {
        mCode = code;
    }

    /**
     * Returns the operation phase by code.
     *
     * @param code The code.
     * @return The operation phase.
     */
    public static OperationPhase getByCode(long code) {
        switch ((int) code) {
            case 1:
                return RELEASED;
            case 2:
                return COMPLETED;
            case 3:
                return SETUP;
            case 4:
                return PROCESSING;
            case 5:
                return DISPATCHED;
            case 6:
                return TRAINING;
            case 7:
                return CLOSED;
            case 8:
                return INTERRUPTED;
            case 9:
                return WAITING_BEFORE_PROCESSING;
            case 10:
                return WAITING_AFTER_PROCESSING;
        }

        throw new IllegalArgumentException();
    }

    public static String getNameByCode(long code) {
        return getByCode(code).name();
    }

    public static boolean isInProgress(OperationPhase phase) {
        switch (phase) {
            case PROCESSING:
            case SETUP:
            case TRAINING:
            case WAITING_BEFORE_PROCESSING:
            case WAITING_AFTER_PROCESSING:
                return true;
            default:
                return false;
        }
    }

    public static boolean isNotCompletedOrClosed(OperationPhase phase) {
        return !isCompleted(phase) && !isClosed(phase);
    }

    public static boolean isClosed(OperationPhase phase) {
        return phase == OperationPhase.CLOSED;
    }

    public static boolean isReleased(OperationPhase phase) {
        return phase == OperationPhase.RELEASED;
    }

    public static boolean isCompleted(OperationPhase phase) {
        return phase == OperationPhase.COMPLETED;
    }

    public static boolean hasBeenActive(OperationPhase phase) {
        return phase != OperationPhase.RELEASED && phase != OperationPhase.DISPATCHED;
    }

    /**
     * Returns the code.
     *
     * @return The code.
     */
    public long getCode() {
        return mCode;
    }
}
