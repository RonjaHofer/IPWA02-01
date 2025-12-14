package de.iu.ghostNetFishing.controllers;

import de.iu.ghostNetFishing.model.Geisternetz;
import de.iu.ghostNetFishing.model.Person;
import de.iu.ghostNetFishing.model.enums.Netzstatus;
import de.iu.ghostNetFishing.repository.Geisternetzrepository;
import de.iu.ghostNetFishing.repository.Personenrepository;
import de.iu.ghostNetFishing.security.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DatenbankController {
    private final Geisternetzrepository geisternetzrepository;
    private final Personenrepository personenrepository;

    public DatenbankController(Geisternetzrepository geisternetzrepository, Personenrepository personenrepository) {
        this.geisternetzrepository = geisternetzrepository;
        this.personenrepository = personenrepository;
    }

    @GetMapping("/datenbank")
    public String listeAnzeigen(
            @RequestParam(required = false) Double breitengrad,
            @RequestParam(required = false) Double laengengrad,
            @RequestParam(required = false) Integer groesse,
            @RequestParam(required = false) String status,
            Model model) {

        List<Geisternetz> geisternetze = geisternetzrepository.findAll();

        // Filter anwenden, falls Parameter übergeben wurden
        if (breitengrad != null) {
            geisternetze = geisternetze.stream()
                    .filter(n -> Math.abs(n.getBreitengrad() - breitengrad) < 0.000001)
                    .toList();
        }
        if (laengengrad != null) {
            geisternetze = geisternetze.stream()
                    .filter(n -> Math.abs(n.getLaengengrad() - laengengrad) < 0.000001)
                    .toList();
        }
        if (groesse != null) {
            geisternetze = geisternetze.stream()
                    .filter(n -> n.getGeschaetzteGroesse() == groesse)
                    .toList();
        }
        if (status != null) {
            geisternetze = geisternetze.stream()
                    .filter(n -> n.getStatus().toString().equalsIgnoreCase(status))
                    .toList();
        }

        model.addAttribute("geisternetze", geisternetze);
        return "datenbank";
    }

    @PostMapping("/datenbank/{id}/status")
    public String updateStatus(@PathVariable Integer id,
                               @RequestParam Netzstatus status) {

        Geisternetz geisternetz = geisternetzrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Netz nicht gefunden"));

        geisternetz.setStatus(status);
        geisternetzrepository.save(geisternetz);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails user = (MyUserDetails) auth.getPrincipal();
        Person bergend = personenrepository.findById(user.getPerson().getId())
                .orElseThrow(() -> new RuntimeException("User nicht gefunden"));

        geisternetz.setBergendePerson(bergend);

        geisternetzrepository.save(geisternetz);


        return "redirect:/datenbank";
    }

}

