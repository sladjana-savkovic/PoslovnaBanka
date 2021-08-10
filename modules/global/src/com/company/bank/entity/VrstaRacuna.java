package com.company.bank.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum VrstaRacuna implements EnumClass<Integer> {

    DINARSKI(1),
    DEVIZNI(2);

    private Integer id;

    VrstaRacuna(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static VrstaRacuna fromId(Integer id) {
        for (VrstaRacuna at : VrstaRacuna.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}