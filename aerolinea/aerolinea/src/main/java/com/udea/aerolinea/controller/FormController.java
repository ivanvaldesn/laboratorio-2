package com.udea.aerolinea.controller;

import com.udea.aerolinea.model.*;
import com.udea.aerolinea.service.AirlineRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @Autowired
    private AirlineRuleService service;

    @GetMapping("/formulario")
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping("/formulario")
    public String procesarFormulario(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String membershipLevel,
            @RequestParam(required = false) boolean travelsWithChildren,
            @RequestParam String seatPreference,
            @RequestParam int delayMinutes,
            @RequestParam double durationHours,
            @RequestParam(required = false) boolean emergencyExitAvailable,
            @RequestParam double weightKg,
            Model model) {

        Passenger passenger = new Passenger(name, age, membershipLevel, travelsWithChildren, seatPreference);
        Flight flight = new Flight(delayMinutes, durationHours, emergencyExitAvailable);
        Luggage luggage = new Luggage(weightKg);

        FlightBenefits benefits = service.evaluate(passenger, flight, luggage);
        model.addAttribute("benefits", benefits);
        return "formulario";
    }
}
