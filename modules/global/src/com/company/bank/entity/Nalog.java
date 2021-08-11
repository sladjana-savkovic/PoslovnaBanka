package com.company.bank.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name = "BANK_NALOG")
@Entity(name = "bank_Nalog")
public class Nalog extends StandardEntity {
    private static final long serialVersionUID = 4273708743362616260L;

    @NotNull(message = "Vrsta naloga je obavezna!")
    @Column(name = "VRSTA_NALOGA", nullable = false)
    private Integer vrstaNaloga;

    @Column(name = "DUZNIK")
    private String duznik;

    @Column(name = "SVRHA_PLACANJA")
    @NotNull(message = "Svrha placanja je obavezna!")
    private String svrhaPlacanja;

    @Column(name = "POVERILAC")
    private String poverilac;

    @Column(name = "SIFRA_PLACANJA", length = 3)
    @NotNull(message = "Sifra placanja je obavezna!")
    private String sifraPlacanja;

    @Column(name = "SIFRA_VALUTE", length = 3)
    @NotNull(message = "Sifra valute je obavezna!")
    private String sifraValute;

    @NotNull(message = "Iznos je obavezan!")
    @Column(name = "IZNOS", nullable = false)
    private Double iznos;

    @Column(name = "RACUN_DUZNIKA", length = 18)
    private String racunDuznika;

    @Column(name = "MODEL_ZADUZENJE", length = 2)
    private String modelZaduzenje;

    @Column(name = "POZIV_NA_BROJ_ZADUZENJE", length = 20)
    private String pozivNaBrojZaduzenje;

    @Column(name = "RACUN_POVERIOCA", length = 18)
    private String racunPoverioca;

    @Column(name = "MODEL_ODOBRENJE", length = 2)
    private String modelOdobrenje;

    @Column(name = "POZIV_NA_BROJ_ODOBRENJE", length = 20)
    private String pozivNaBrojOdobrenje;

    @Column(name = "DATUM_PLACANJA", nullable = false)
    @NotNull
    private LocalDateTime datumPlacanja;

    @Column(name = "HITNO")
    private Boolean hitno;

    @Column(name = "STATUS_NALOGA")
    private Integer statusNaloga;

    @Column(name = "DATUM_VALUTE")
    private LocalDateTime datumValute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DNEVNO_STANJE_ID")
    private DnevnoStanje dnevnoStanje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PORUKA_ID")
    private Poruka poruka;

    public void setDatumPlacanja(LocalDateTime datumPlacanja) {
        this.datumPlacanja = datumPlacanja;
    }

    public LocalDateTime getDatumPlacanja() {
        return datumPlacanja;
    }

    public void setDatumValute(LocalDateTime datumValute) {
        this.datumValute = datumValute;
    }

    public LocalDateTime getDatumValute() {
        return datumValute;
    }

    public Poruka getPoruka() {
        return poruka;
    }

    public void setPoruka(Poruka poruka) {
        this.poruka = poruka;
    }

    public DnevnoStanje getDnevnoStanje() {
        return dnevnoStanje;
    }

    public void setDnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.dnevnoStanje = dnevnoStanje;
    }

    public String getSifraValute() {
        return sifraValute;
    }

    public void setSifraValute(String sifraValute) {
        this.sifraValute = sifraValute;
    }

    public String getSifraPlacanja() {
        return sifraPlacanja;
    }

    public void setSifraPlacanja(String sifraPlacanja) {
        this.sifraPlacanja = sifraPlacanja;
    }

    public StatusNaloga getStatusNaloga() {
        return statusNaloga == null ? null : StatusNaloga.fromId(statusNaloga);
    }

    public void setStatusNaloga(StatusNaloga statusNaloga) {
        this.statusNaloga = statusNaloga == null ? null : statusNaloga.getId();
    }

    public VrstaNaloga getVrstaNaloga() {
        return vrstaNaloga == null ? null : VrstaNaloga.fromId(vrstaNaloga);
    }

    public void setVrstaNaloga(VrstaNaloga vrstaNaloga) {
        this.vrstaNaloga = vrstaNaloga == null ? null : vrstaNaloga.getId();
    }

    public String getPozivNaBrojOdobrenje() {
        return pozivNaBrojOdobrenje;
    }

    public void setPozivNaBrojOdobrenje(String pozivNaBrojOdobrenje) {
        this.pozivNaBrojOdobrenje = pozivNaBrojOdobrenje;
    }

    public String getSvrhaPlacanja() {
        return svrhaPlacanja;
    }

    public void setSvrhaPlacanja(String svrhaPlacanja) {
        this.svrhaPlacanja = svrhaPlacanja;
    }

    public String getPozivNaBrojZaduzenje() {
        return pozivNaBrojZaduzenje;
    }

    public void setPozivNaBrojZaduzenje(String pozivNaBrojZaduzenje) {
        this.pozivNaBrojZaduzenje = pozivNaBrojZaduzenje;
    }

    public String getModelOdobrenje() {
        return modelOdobrenje;
    }

    public void setModelOdobrenje(String modelOdobrenje) {
        this.modelOdobrenje = modelOdobrenje;
    }

    public String getModelZaduzenje() {
        return modelZaduzenje;
    }

    public void setModelZaduzenje(String modelZaduzenje) {
        this.modelZaduzenje = modelZaduzenje;
    }

    public Boolean getHitno() {
        return hitno;
    }

    public void setHitno(Boolean hitno) {
        this.hitno = hitno;
    }

    public String getRacunPoverioca() {
        return racunPoverioca;
    }

    public void setRacunPoverioca(String racunPoverioca) {
        this.racunPoverioca = racunPoverioca;
    }

    public String getRacunDuznika() {
        return racunDuznika;
    }

    public void setRacunDuznika(String racunDuznika) {
        this.racunDuznika = racunDuznika;
    }

    public String getPoverilac() {
        return poverilac;
    }

    public void setPoverilac(String poverilac) {
        this.poverilac = poverilac;
    }

    public String getDuznik() {
        return duznik;
    }

    public void setDuznik(String duznik) {
        this.duznik = duznik;
    }

    public Double getIznos() {
        return iznos;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }
}