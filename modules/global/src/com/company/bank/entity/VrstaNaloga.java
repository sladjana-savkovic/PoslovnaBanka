package com.company.bank.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum VrstaNaloga implements EnumClass<Integer> {

    UPLATA(1),
    ISPLATA(2),
    PRENOS(3),
    NAPLATA(4);

    private Integer id;

    VrstaNaloga(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static VrstaNaloga fromId(Integer id) {
        for (VrstaNaloga at : VrstaNaloga.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}