package com.exam.lashakandashvili.entities;

public enum RecordState {
    INACTIVE("INACTIVE"),ACTIVE("ACTIVE");
    public final String active;

    RecordState(String active) {
        this.active = active;
    }
}