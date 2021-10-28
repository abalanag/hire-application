package com.vacation_hire.hire_application.enums;

import lombok.Getter;

@Getter
/**
 * In this class are stored all the types of cars
 */
public enum CarTypes {
    TRUCKS("truck"), MINIVANS("minivan"), SEDANS("sedan");

    private final String value;

    CarTypes(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
