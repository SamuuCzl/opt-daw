package com.actividad3.actividad3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controladorIdioma {

    @GetMapping("/elegir")

    public String elegirIdioma(@RequestParam(value = "idioma", required = false) String idioma) {

        if ("spanish".equals(idioma)) {
            return "redirect:/spanish.html";
        }

        if ("french".equals(idioma)) {
            return "redirect:/french.html";
        }

        if ("german".equals(idioma)) {
            return "redirect:/german.html";
        }

        return "redirect:/english.html";
    }
}