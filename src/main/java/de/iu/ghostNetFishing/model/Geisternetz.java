package de.iu.ghostNetFishing.model;

import de.iu.ghostNetFishing.model.enums.Netzstatus;
import jakarta.persistence.*;

@Entity
public class Geisternetz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double breitengrad;
    private double laengengrad;
    private int geschaetzteGroesse;
    @Enumerated(EnumType.STRING)
    private Netzstatus status;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Person meldendePerson;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Person bergendePerson;

    public double getBreitengrad() {
        return breitengrad;
    }

    public void setBreitengrad(double breitengrad) {
        this.breitengrad = breitengrad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLaengengrad() {
        return laengengrad;
    }

    public void setLaengengrad(double laengengrad) {
        this.laengengrad = laengengrad;
    }

    public int getGeschaetzteGroesse() {
        return geschaetzteGroesse;
    }

    public void setGeschaetzteGroesse(int geschaetzteGroesse) {
        this.geschaetzteGroesse = geschaetzteGroesse;
    }

    public Netzstatus getStatus() {
        return status;
    }

    public void setStatus(Netzstatus status) {
        this.status = status;
    }

    public Person getMeldendePerson() {
        return meldendePerson;
    }

    public void setMeldendePerson(Person meldendePerson) {
        this.meldendePerson = meldendePerson;
    }

    public Person getBergendePerson() {
        return bergendePerson;
    }

    public void setBergendePerson(Person bergendePerson) {
        this.bergendePerson = bergendePerson;
    }
}
