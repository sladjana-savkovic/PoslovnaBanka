package com.company.bank.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum StatusNaloga implements EnumClass<Integer> {

    KREIRAN(1),
    OBRADJEN(2),
    ODBIJEN(3);

    private Integer id;

    StatusNaloga(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static StatusNaloga fromId(Integer id) {
        for (StatusNaloga at : StatusNaloga.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}