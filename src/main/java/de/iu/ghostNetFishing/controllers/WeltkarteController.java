package de.iu.ghostNetFishing.controllers;

import de.iu.ghostNetFishing.model.Geisternetz;
import de.iu.ghostNetFishing.repository.Geisternetzrepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WeltkarteController {
    private final Geisternetzrepository geisternetzrepository;

    public WeltkarteController(Geisternetzrepository geisternetzrepository) {
        this.geisternetzrepository = geisternetzrepository;
    }

    @GetMapping("/weltkarte")
    public String weltkarte(Model model) {
        List<Geisternetz> geisternetze = geisternetzrepository.findAll(); // Repository muss injected werden
        model.addAttribute("geisternetze", geisternetze);
        return "weltkarte";
    }
}

