package com.company.bank.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum TipRacuna implements EnumClass<Integer> {

    TEKUCI(1),
    OSTALI(2);

    private Integer id;

    TipRacuna(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static TipRacuna fromId(Integer id) {
        for (TipRacuna at : TipRacuna.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}