package com.company.bank.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum VrstaPoruke implements EnumClass<Integer> {

    MT102(1),
    MT103(2);

    private Integer id;

    VrstaPoruke(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static VrstaPoruke fromId(Integer id) {
        for (VrstaPoruke at : VrstaPoruke.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}