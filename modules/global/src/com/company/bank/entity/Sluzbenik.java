package com.company.bank.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "BANK_SLUZBENIK")
@Entity(name = "bank_Sluzbenik")
@NamePattern("%s %s %s|ime,prezime,jmbg")
public class Sluzbenik extends StandardEntity {
    private static final long serialVersionUID = 1361694135359549268L;

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

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Email(message = "Pogresan format emaila!")
    @NotNull(message = "Email je obavezan!")
    private String email;

    @NotNull(message = "Odabir banke je obavezan!")
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