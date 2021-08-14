package com.company.bank.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.security.entity.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity(name = "bank_Sluzbenik")
@NamePattern("%s %s %s|ime,prezime,jmbg")
public class Sluzbenik extends User {
    private static final long serialVersionUID = 1361694135359549268L;

    @Column(name = "IME")
    private String ime;

    @Column(name = "PREZIME")
    private String prezime;

    @Column(name = "JMBG", unique = true, length = 13)
    @Length(message = "JMBG mora imati 13 karaktera!", min = 13, max = 13)
    private String jmbg;

    @Column(name = "TELEFON")
    private String telefon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANKA_ID")
    private Banka banka;

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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