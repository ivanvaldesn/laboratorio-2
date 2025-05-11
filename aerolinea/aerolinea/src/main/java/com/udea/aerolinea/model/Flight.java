package com.udea.aerolinea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    private int delayMinutes;
    private double durationHours;
    private boolean emergencyExitAvailable;
}