package de.iu.ghostNetFishing.controllers;

import de.iu.ghostNetFishing.model.dto.GeisternetzmeldungDto;
import de.iu.ghostNetFishing.service.GeisternetzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NetzmeldungController {

    @Autowired
    private GeisternetzService geisternetzService;

    @GetMapping("/netzmeldung")
    public String showNetzmeldungForm(Model model) {
        model.addAttribute("geisternetzmeldungDto", new GeisternetzmeldungDto());
        return "netzmeldung";
    }

    @PostMapping("/netzmeldung")
    public String erstelleMeldung(@ModelAttribute GeisternetzmeldungDto geisternetz) {
        geisternetzService.createFromDto(geisternetz);
        return "redirect:/datenbank";
    }

}