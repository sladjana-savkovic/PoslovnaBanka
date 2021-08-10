package com.company.bank.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum VrstaKlijenta implements EnumClass<Integer> {

    FIZICKO_LICE(1),
    PRAVNO_LICE(2);

    private Integer id;

    VrstaKlijenta(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static VrstaKlijenta fromId(Integer id) {
        for (VrstaKlijenta at : VrstaKlijenta.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}