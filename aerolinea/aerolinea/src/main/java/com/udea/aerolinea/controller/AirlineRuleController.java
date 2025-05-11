package com.udea.aerolinea.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.aerolinea.model.*;
import com.udea.aerolinea.service.AirlineRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/flight")
public class AirlineRuleController {

    @Autowired
    private AirlineRuleService airlineRuleService;

    @PostMapping("/evaluate")
    public FlightBenefits evaluate(@RequestBody Map<String, Object> data) {
        ObjectMapper mapper = new ObjectMapper();
        Passenger passenger = mapper.convertValue(data.get("passenger"), Passenger.class);
        Flight flight = mapper.convertValue(data.get("flight"), Flight.class);
        Luggage luggage = mapper.convertValue(data.get("luggage"), Luggage.class);

        return airlineRuleService.evaluate(passenger, flight, luggage);
    }
}
