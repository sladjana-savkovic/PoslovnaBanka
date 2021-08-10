package com.company.bank.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "BANK_PORUKA")
@Entity(name = "bank_Poruka")
public class Poruka extends StandardEntity {
    private static final long serialVersionUID = -5776741832601267672L;

    @NotNull
    @Column(name = "ID_PORUKE", nullable = false)
    private Integer idPoruke;

    @NotNull
    @Column(name = "VRSTA_PORUKE", nullable = false)
    private Integer vrstaPoruke;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BANKA_POVERIOCA_ID")
    private Banka bankaPoverioca;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BANKA_DUZNIKA_ID")
    private Banka bankaDuznika;

    @OneToMany(mappedBy = "poruka")
    @NotNull
    private List<Nalog> nalozi;

    public List<Nalog> getNalozi() {
        return nalozi;
    }

    public void setNalozi(List<Nalog> nalozi) {
        this.nalozi = nalozi;
    }

    public Banka getBankaDuznika() {
        return bankaDuznika;
    }

    public void setBankaDuznika(Banka bankaDuznika) {
        this.bankaDuznika = bankaDuznika;
    }

    public Banka getBankaPoverioca() {
        return bankaPoverioca;
    }

    public void setBankaPoverioca(Banka bankaPoverioca) {
        this.bankaPoverioca = bankaPoverioca;
    }

    public VrstaPoruke getVrstaPoruke() {
        return vrstaPoruke == null ? null : VrstaPoruke.fromId(vrstaPoruke);
    }

    public void setVrstaPoruke(VrstaPoruke vrstaPoruke) {
        this.vrstaPoruke = vrstaPoruke == null ? null : vrstaPoruke.getId();
    }

    public Integer getIdPoruke() {
        return idPoruke;
    }

    public void setIdPoruke(Integer idPoruke) {
        this.idPoruke = idPoruke;
    }
}