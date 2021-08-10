package com.company.bank.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "BANK_BANKA")
@Entity(name = "bank_Banka")
@NamePattern("%s|nazivBanke")
public class Banka extends StandardEntity {
    private static final long serialVersionUID = 6433856846086219235L;

    @Column(name = "SIFRA_BANKE", nullable = false, unique = true, length = 3)
    @NotNull(message = "Sifra banke je obavezna!")
    @Length(message = "Sifra banke mora imati 3 karaktera!", min = 3, max = 3)
    private String sifraBanke;

    @NotNull(message = "Naziv banke je obavezan!")
    @Column(name = "NAZIV_BANKE", nullable = false)
    private String nazivBanke;

    @NotNull(message = "Swift kod je obavezan!")
    @Column(name = "SWIFT_KOD", nullable = false, unique = true, length = 8)
    @Length(message = "Swift kod mora imati 8 karaktera!", min = 8, max = 8)
    private String swiftKod;

    @NotNull(message = "Obracunski racun je obavezan!")
    @Column(name = "OBRACUNSKI_RACUN", nullable = false, unique = true, length = 18)
    @Length(message = "Obracunski racun mora imati 18 karaktera!", min = 18, max = 18)
    private String obracunskiRacun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESTO_ID")
    private Mesto mesto;

    @Column(name = "ADRESA")
    private String adresa;

    @Column(name = "TELEFON")
    private String telefon;

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
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

    public String getObracunskiRacun() {
        return obracunskiRacun;
    }

    public void setObracunskiRacun(String obracunskiRacun) {
        this.obracunskiRacun = obracunskiRacun;
    }

    public String getSwiftKod() {
        return swiftKod;
    }

    public void setSwiftKod(String swiftKod) {
        this.swiftKod = swiftKod;
    }

    public String getNazivBanke() {
        return nazivBanke;
    }

    public void setNazivBanke(String nazivBanke) {
        this.nazivBanke = nazivBanke;
    }

    public String getSifraBanke() {
        return sifraBanke;
    }

    public void setSifraBanke(String sifraBanke) {
        this.sifraBanke = sifraBanke;
    }
}