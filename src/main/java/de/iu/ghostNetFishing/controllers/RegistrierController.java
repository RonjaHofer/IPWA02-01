package de.iu.ghostNetFishing.controllers;

import de.iu.ghostNetFishing.model.Person;
import de.iu.ghostNetFishing.model.enums.Personenrolle;
import de.iu.ghostNetFishing.repository.Personenrepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrierController {

    private final Personenrepository repo;
    private final PasswordEncoder passwordEncoder;

    public RegistrierController(Personenrepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    //Registrieren
    @GetMapping("/registrieren")
    public String registerForm() {
        return "registrieren"; // Thymeleaf-Template
    }

    @PostMapping("/registrieren")
    public String register(@RequestParam String vorname,
                           @RequestParam String nachname,
                           @RequestParam String passwort,
                           @RequestParam String telefonnummer) {

        Person user = new Person();
        user.setVorname(vorname);
        user.setNachname(nachname);
        user.setTelefonnummer(telefonnummer);
        user.setPasswort(passwordEncoder.encode(passwort));
        user.setTyp(Personenrolle.Bergende);

        repo.save(user);

        return "redirect:/datenbank"; // Spring Datenbankseite zurück
    }

    //Login
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}