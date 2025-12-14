package de.iu.ghostNetFishing.model.dto;

import java.time.LocalDateTime;

public class GeisternetzmeldungDto {

    // Dezimalgrad (DD)
    private Double breitengradDD;
    private Double laengengradDD;

    // Grad, Minuten, Sekunden (DMS)
    private Integer breitengradGrad;
    private Integer breitengradMinuten;
    private Double breitengradSekunden;
    private String breitengradRichtung; // "N" oder "S"

    private Integer laengengradGrad;
    private Integer laengengradMinuten;
    private Double laengengradSekunden;
    private String laengengradRichtung; // "E" oder "W"

    private int geschaetzteGroesse;

    private String meldendePersonVorname;
    private String meldendePersonNachname;
    private String meldendePersonTelefonnummer;

    private LocalDateTime sichtungszeitpunkt;

    public GeisternetzmeldungDto() {
    }

    // Getter & Setter

    public Double getBreitengradDD() {
        return breitengradDD;
    }

    public void setBreitengradDD(Double breitengradDD) {
        this.breitengradDD = breitengradDD;
    }

    public Double getLaengengradDD() {
        return laengengradDD;
    }

    public void setLaengengradDD(Double laengengradDD) {
        this.laengengradDD = laengengradDD;
    }

    public Integer getBreitengradGrad() {
        return breitengradGrad;
    }

    public void setBreitengradGrad(Integer breitengradGrad) {
        this.breitengradGrad = breitengradGrad;
    }

    public Integer getBreitengradMinuten() {
        return breitengradMinuten;
    }

    public void setBreitengradMinuten(Integer breitengradMinuten) {
        this.breitengradMinuten = breitengradMinuten;
    }

    public Double getBreitengradSekunden() {
        return breitengradSekunden;
    }

    public void setBreitengradSekunden(Double breitengradSekunden) {
        this.breitengradSekunden = breitengradSekunden;
    }

    public String getBreitengradRichtung() {
        return breitengradRichtung;
    }

    public void setBreitengradRichtung(String breitengradRichtung) {
        this.breitengradRichtung = breitengradRichtung;
    }

    public Integer getLaengengradGrad() {
        return laengengradGrad;
    }

    public void setLaengengradGrad(Integer laengengradGrad) {
        this.laengengradGrad = laengengradGrad;
    }

    public Integer getLaengengradMinuten() {
        return laengengradMinuten;
    }

    public void setLaengengradMinuten(Integer laengengradMinuten) {
        this.laengengradMinuten = laengengradMinuten;
    }

    public Double getLaengengradSekunden() {
        return laengengradSekunden;
    }

    public void setLaengengradSekunden(Double laengengradSekunden) {
        this.laengengradSekunden = laengengradSekunden;
    }

    public String getLaengengradRichtung() {
        return laengengradRichtung;
    }

    public void setLaengengradRichtung(String laengengradRichtung) {
        this.laengengradRichtung = laengengradRichtung;
    }

    public int getGeschaetzteGroesse() {
        return geschaetzteGroesse;
    }

    public void setGeschaetzteGroesse(int geschaetzteGroesse) {
        this.geschaetzteGroesse = geschaetzteGroesse;
    }

    public String getMeldendePersonVorname() {
        return meldendePersonVorname;
    }

    public void setMeldendePersonVorname(String meldendePersonVorname) {
        this.meldendePersonVorname = meldendePersonVorname;
    }

    public String getMeldendePersonNachname() {
        return meldendePersonNachname;
    }

    public void setMeldendePersonNachname(String meldendePersonNachname) {
        this.meldendePersonNachname = meldendePersonNachname;
    }

    public String getMeldendePersonTelefonnummer() {
        return meldendePersonTelefonnummer;
    }

    public void setMeldendePersonTelefonnummer(String meldendePersonTelefonnummer) {
        this.meldendePersonTelefonnummer = meldendePersonTelefonnummer;
    }

    public LocalDateTime getSichtungszeitpunkt() {
        return sichtungszeitpunkt;
    }

    public void setSichtungszeitpunkt(LocalDateTime sichtungszeitpunkt) {
        this.sichtungszeitpunkt = sichtungszeitpunkt;
    }
}