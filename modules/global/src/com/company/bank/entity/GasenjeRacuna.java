package com.company.bank.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "BANK_GASENJE_RACUNA")
@Entity(name = "bank_GasenjeRacuna")
public class GasenjeRacuna extends StandardEntity {
    private static final long serialVersionUID = -8598606725370846176L;

    @NotNull(message = "Racun za gasenje je obavezan!")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RACUN_ZA_GASENJE_ID")
    private Racun racunZaGasenje;

    @Column(name = "RAZLOG_GASENJA", nullable = false)
    @NotNull(message = "Razlog gasenja je obavezan!")
    private String razlogGasenja;

    @NotNull(message = "Racun za prenos je obavezan!")
    @Column(name = "RACUN_ZA_PRENOS", nullable = false, length = 18)
    @Length(message = "Racun za prenos mora imati 18 karaktera!", min = 18, max = 18)
    private String racunZaPrenos;

    public Racun getRacunZaGasenje() {
        return racunZaGasenje;
    }

    public void setRacunZaGasenje(Racun racunZaGasenje) {
        this.racunZaGasenje = racunZaGasenje;
    }

    public String getRacunZaPrenos() {
        return racunZaPrenos;
    }

    public void setRacunZaPrenos(String racunZaPrenos) {
        this.racunZaPrenos = racunZaPrenos;
    }

    public String getRazlogGasenja() {
        return razlogGasenja;
    }

    public void setRazlogGasenja(String razlogGasenja) {
        this.razlogGasenja = razlogGasenja;
    }
}