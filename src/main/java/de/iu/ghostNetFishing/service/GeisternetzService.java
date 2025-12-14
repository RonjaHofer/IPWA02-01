package de.iu.ghostNetFishing.service;

import de.iu.ghostNetFishing.model.Geisternetz;
import de.iu.ghostNetFishing.model.Person;
import de.iu.ghostNetFishing.model.dto.GeisternetzmeldungDto;
import de.iu.ghostNetFishing.model.enums.Netzstatus;
import de.iu.ghostNetFishing.model.enums.Personenrolle;
import de.iu.ghostNetFishing.repository.Geisternetzrepository;
import org.springframework.stereotype.Service;

@Service
public class GeisternetzService {

    private final Geisternetzrepository repository;

    public GeisternetzService(Geisternetzrepository repository) {
        this.repository = repository;
    }

    public Geisternetz createFromDto(GeisternetzmeldungDto dto) {

        // Meldende Person erstellen (noch keine bergende Person)
        Person meldendePerson = new Person();
        meldendePerson.setVorname(dto.getMeldendePersonVorname());
        meldendePerson.setNachname(dto.getMeldendePersonNachname());
        meldendePerson.setTelefonnummer(dto.getMeldendePersonTelefonnummer());
        meldendePerson.setTyp(Personenrolle.Meldende);

        // Geisternetz erzeugen
        Geisternetz geisternetz = new Geisternetz();

        // DD Koordinaten bevorzugt, wenn vorhanden
        if (dto.getBreitengradDD() != null && dto.getLaengengradDD() != null) {
            geisternetz.setBreitengrad(dto.getBreitengradDD());
            geisternetz.setLaengengrad(dto.getLaengengradDD());
        } else if (dto.getBreitengradGrad() != null && dto.getLaengengradGrad() != null) {
            // DMS → DD umrechnen
            geisternetz.setBreitengrad(dmsToDecimal(
                    dto.getBreitengradGrad(),
                    dto.getBreitengradMinuten(),
                    dto.getBreitengradSekunden(),
                    dto.getBreitengradRichtung()
            ));
            geisternetz.setLaengengrad(dmsToDecimal(
                    dto.getLaengengradGrad(),
                    dto.getLaengengradMinuten(),
                    dto.getLaengengradSekunden(),
                    dto.getLaengengradRichtung()
            ));
        }

        geisternetz.setGeschaetzteGroesse(dto.getGeschaetzteGroesse());
        geisternetz.setStatus(Netzstatus.GEMELDET);
        geisternetz.setMeldendePerson(meldendePerson);
        geisternetz.setBergendePerson(null);

        // Speichern
        return repository.save(geisternetz);
    }

    private double dmsToDecimal(int grad, int minuten, double sekunden, String richtung) {
        double decimal = grad + minuten / 60.0 + sekunden / 3600.0;
        if ("S".equalsIgnoreCase(richtung) || "W".equalsIgnoreCase(richtung)) {
            decimal = -decimal;
        }
        return decimal;
    }
}