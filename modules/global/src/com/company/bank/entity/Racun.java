package com.company.bank.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "BANK_RACUN")
@Entity(name = "bank_Racun")
public class Racun extends StandardEntity {
    private static final long serialVersionUID = 1557072343427410181L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BANKA_ID")
    private Banka banka;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "KLIJENT_ID")
    private Klijent klijent;

    @NotNull
    @Column(name = "TIP_RACUNA", nullable = false)
    private Integer tipRacuna;

    @Column(name = "NAMENA_RACUNA")
    private String namenaRacuna;

    @NotNull
    @Column(name = "VRSTA_RACUNA", nullable = false)
    private Integer vrstaRacuna;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "racunZaGasenje")
    private GasenjeRacuna gasenjeRacuna;

    public GasenjeRacuna getGasenjeRacuna() {
        return gasenjeRacuna;
    }

    public void setGasenjeRacuna(GasenjeRacuna gasenjeRacuna) {
        this.gasenjeRacuna = gasenjeRacuna;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    public VrstaRacuna getVrstaRacuna() {
        return vrstaRacuna == null ? null : VrstaRacuna.fromId(vrstaRacuna);
    }

    public void setVrstaRacuna(VrstaRacuna vrstaRacuna) {
        this.vrstaRacuna = vrstaRacuna == null ? null : vrstaRacuna.getId();
    }

    public String getNamenaRacuna() {
        return namenaRacuna;
    }

    public void setNamenaRacuna(String namenaRacuna) {
        this.namenaRacuna = namenaRacuna;
    }

    public TipRacuna getTipRacuna() {
        return tipRacuna == null ? null : TipRacuna.fromId(tipRacuna);
    }

    public void setTipRacuna(TipRacuna tipRacuna) {
        this.tipRacuna = tipRacuna == null ? null : tipRacuna.getId();
    }
}