package com.udea.aerolinea.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    private String name;
    private int age;
    private String membershipLevel; // Basic, Gold, Platinum
    private boolean travelsWithChildren;
    private String seatPreference; // Any, Window, Aisle
}