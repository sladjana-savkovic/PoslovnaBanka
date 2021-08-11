package com.company.bank.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "BANK_DNEVNO_STANJE")
@Entity(name = "bank_DnevnoStanje")
@NamePattern("%s %s|racun,datumPrometa")
public class DnevnoStanje extends StandardEntity {
    private static final long serialVersionUID = 8523548169200228983L;

    @ManyToOne
    @JoinColumn(name = "RACUN_ID")
    private Racun racun;

    @Column(name = "DATUM_PROMETA")
    private LocalDateTime datumPrometa;

    @Column(name = "PRETHODNO_STANJE")
    private Double prethodnoStanje;

    @Column(name = "PROMET_NA_TERET")
    private Double prometNaTeret;

    @Column(name = "PROMET_U_KORIST")
    private Double prometUKorist;

    @Column(name = "NOVO_STANJE")
    private Double novoStanje;

    public void setDatumPrometa(LocalDateTime datumPrometa) {
        this.datumPrometa = datumPrometa;
    }

    public LocalDateTime getDatumPrometa() {
        return datumPrometa;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public Double getNovoStanje() {
        return novoStanje;
    }

    public void setNovoStanje(Double novoStanje) {
        this.novoStanje = novoStanje;
    }

    public Double getPrometUKorist() {
        return prometUKorist;
    }

    public void setPrometUKorist(Double prometUKorist) {
        this.prometUKorist = prometUKorist;
    }

    public Double getPrometNaTeret() {
        return prometNaTeret;
    }

    public void setPrometNaTeret(Double prometNaTeret) {
        this.prometNaTeret = prometNaTeret;
    }

    public Double getPrethodnoStanje() {
        return prethodnoStanje;
    }

    public void setPrethodnoStanje(Double prethodnoStanje) {
        this.prethodnoStanje = prethodnoStanje;
    }

}