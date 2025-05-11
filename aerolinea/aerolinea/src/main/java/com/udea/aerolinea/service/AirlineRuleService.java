package com.udea.aerolinea.service;

import com.udea.aerolinea.model.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineRuleService {

    @Autowired
    private KieContainer kieContainer;

    public FlightBenefits evaluate(Passenger passenger, Flight flight, Luggage luggage) {
        FlightBenefits benefits = new FlightBenefits();
        KieSession kieSession = kieContainer.newKieSession();

        try {
            kieSession.insert(passenger);
            kieSession.insert(flight);
            kieSession.insert(luggage);
            kieSession.insert(benefits);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }

        return benefits;
    }
}
