package com.company.bank.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "BANK_SIFARNIK_DELATNOSTI")
@Entity(name = "bank_SifarnikDelatnosti")
@NamePattern("%s|nazivDelatnosti")
public class SifarnikDelatnosti extends StandardEntity {
    private static final long serialVersionUID = -8935403753447542775L;

    @NotNull(message = "Sifra delatnosti je obavezna!")
    @Column(name = "SIFRA_DELATNOSTI", nullable = false, unique = true)
    private Integer sifraDelatnosti;

    @NotNull(message = "Naziv delatnosti je obavezan!")
    @Column(name = "NAZIV_DELATNOSTI", nullable = false)
    private String nazivDelatnosti;

    public String getNazivDelatnosti() {
        return nazivDelatnosti;
    }

    public void setNazivDelatnosti(String nazivDelatnosti) {
        this.nazivDelatnosti = nazivDelatnosti;
    }

    public Integer getSifraDelatnosti() {
        return sifraDelatnosti;
    }

    public void setSifraDelatnosti(Integer sifraDelatnosti) {
        this.sifraDelatnosti = sifraDelatnosti;
    }
}