package com.company.bank.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "BANK_MESTO")
@Entity(name = "bank_Mesto")
@NamePattern("%s|nazivMesta")
public class Mesto extends StandardEntity {
    private static final long serialVersionUID = 3158750425582330396L;

    @NotNull(message = "Naziv mesta je obavezan!")
    @Column(name = "NAZIV_MESTA", nullable = false)
    private String nazivMesta;

    @NotNull(message = "Postanski broj je obavezan!")
    @Column(name = "POSTANSKI_BROJ", nullable = false, unique = true)
    private Integer postanskiBroj;

    public Integer getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(Integer postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getNazivMesta() {
        return nazivMesta;
    }

    public void setNazivMesta(String nazivMesta) {
        this.nazivMesta = nazivMesta;
    }
}