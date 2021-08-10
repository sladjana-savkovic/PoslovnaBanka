package com.company.bank.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "BANK_DNEVNO_STANJE")
@Entity(name = "bank_DnevnoStanje")
public class DnevnoStanje extends StandardEntity {
    private static final long serialVersionUID = 8523548169200228983L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RACUN_ID")
    private Racun racun;

    @NotNull
    @Column(name = "DATUM_PROMETA", nullable = false)
    private LocalDateTime datumPrometa;

    @Column(name = "PRETHODNO_STANJE", nullable = false)
    @NotNull
    private Double prethodnoStanje;

    @NotNull
    @Column(name = "PROMET_NA_TERET", nullable = false)
    private Double prometNaTeret;

    @NotNull
    @Column(name = "PROMET_U_KORIST", nullable = false)
    private Double prometUKorist;

    @NotNull
    @Column(name = "NOVO_STANJE", nullable = false)
    private Double novoStanje;

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

    public LocalDateTime getDatumPrometa() {
        return datumPrometa;
    }

    public void setDatumPrometa(LocalDateTime datumPrometa) {
        this.datumPrometa = datumPrometa;
    }
}