package com.company.bank.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "BANK_SLUZBENIK")
@Entity(name = "bank_Sluzbenik")
public class Sluzbenik extends StandardEntity {
    private static final long serialVersionUID = 1361694135359549268L;

    @NotNull
    @Column(name = "IME", nullable = false)
    private String ime;

    @NotNull
    @Column(name = "PREZIME", nullable = false)
    private String prezime;

    @NotNull
    @Column(name = "JMBG", nullable = false, unique = true, length = 13)
    @Length(message = "JMBG mora imati 13 karaktera!", min = 13, max = 13)
    private String jmbg;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "EMAIL")
    @Email
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BANKA_ID")
    private Banka banka;

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
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