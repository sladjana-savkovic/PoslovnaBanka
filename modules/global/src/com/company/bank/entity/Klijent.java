package com.company.bank.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "BANK_KLIJENT")
@Entity(name = "bank_Klijent")
@NamePattern("%s %s %s|ime,prezime,jmbg")
public class Klijent extends StandardEntity {
    private static final long serialVersionUID = 2256731550253568336L;

    @NotNull(message = "Ime je obavezno!")
    @Column(name = "IME", nullable = false)
    private String ime;

    @NotNull(message = "Prezime je obavezno!")
    @Column(name = "PREZIME", nullable = false)
    private String prezime;

    @NotNull(message = "JMBG je obavezan!")
    @Column(name = "JMBG", nullable = false, unique = true, length = 13)
    @Length(message = "JMBG mora imati 13 karaktera!", min = 13, max = 13)
    private String jmbg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESTO_ID")
    private Mesto mesto;

    @Column(name = "ADRESA")
    private String adresa;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "EMAIL")
    @Email(message = "Pogresan format emaila!")
    private String email;

    @Column(name = "PIB", length = 9)
    @Length(message = "Pib mora imati 9 karaktera!", min = 9, max = 9)
    private String pib;

    @Column(name = "MIB", length = 8)
    @Length(message = "Mib mora imati 8 karaktera!", min = 8, max = 8)
    private String mib;

    @Column(name = "NAZIV_NADLEZNOG_ORGANA")
    private String nazivNadleznogOrgana;

    @NotNull(message = "Vrsta klijenta je obavezna!")
    @Column(name = "VRSTA_KLIJENTA", nullable = false)
    private Integer vrstaKlijenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELATNOST_ID")
    private SifarnikDelatnosti delatnost;

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public SifarnikDelatnosti getDelatnost() {
        return delatnost;
    }

    public void setDelatnost(SifarnikDelatnosti delatnost) {
        this.delatnost = delatnost;
    }

    public VrstaKlijenta getVrstaKlijenta() {
        return vrstaKlijenta == null ? null : VrstaKlijenta.fromId(vrstaKlijenta);
    }

    public void setVrstaKlijenta(VrstaKlijenta vrstaKlijenta) {
        this.vrstaKlijenta = vrstaKlijenta == null ? null : vrstaKlijenta.getId();
    }

    public String getNazivNadleznogOrgana() {
        return nazivNadleznogOrgana;
    }

    public void setNazivNadleznogOrgana(String nazivNadleznogOrgana) {
        this.nazivNadleznogOrgana = nazivNadleznogOrgana;
    }

    public String getMib() {
        return mib;
    }

    public void setMib(String mib) {
        this.mib = mib;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}