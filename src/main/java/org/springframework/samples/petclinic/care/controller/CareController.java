package org.springframework.samples.petclinic.care.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.care.service.CareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
public class CareController {

    CareService careService;

    @Autowired
    public CareController(CareService careService) {
        this.careService = careService;
    }

    @GetMapping("/care")
    public String careList(Model model) throws IOException {
        model.addAttribute("facility", careService.careList());
        return "care/animalCareFacilities";
    }
}
