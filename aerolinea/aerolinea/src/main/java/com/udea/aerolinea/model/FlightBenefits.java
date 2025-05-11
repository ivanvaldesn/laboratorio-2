package com.udea.aerolinea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBenefits {
    private boolean upgradedToBusiness = false;
    private boolean priorityCheckIn = false;
    private boolean vipLoungeAccess = false;
    private boolean emergencyExitAssigned = false;
    private boolean familyPreferentialSeat = false;
    private boolean luggageAccepted = true;
    private boolean upgradeEligible = true;
    private double discount = 0.0;
    private int extraLoyaltyPoints = 0;
    private double compensation = 0.0;
}