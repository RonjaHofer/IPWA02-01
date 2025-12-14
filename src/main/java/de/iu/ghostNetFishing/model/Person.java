package de.iu.ghostNetFishing.model;

import de.iu.ghostNetFishing.model.enums.Personenrolle;
import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vorname;
    private String nachname;
    private String telefonnummer;
    private String passwort;
    @Enumerated(EnumType.STRING)
    private Personenrolle typ;


    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getPasswort() {
        return passwort;

    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public Personenrolle getTyp() {
        return typ;
    }

    public void setTyp(Personenrolle typ) {
        this.typ = typ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
