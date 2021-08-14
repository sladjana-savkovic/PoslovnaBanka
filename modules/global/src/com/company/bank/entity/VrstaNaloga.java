package com.company.bank.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum VrstaNaloga implements EnumClass<String> {

    UPLATA("uplata"),
    ISPLATA("isplata"),
    PRENOS("prenos"),
    NAPLATA("naplata");

    private String id;

    VrstaNaloga(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static VrstaNaloga fromId(String id) {
        for (VrstaNaloga at : VrstaNaloga.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}