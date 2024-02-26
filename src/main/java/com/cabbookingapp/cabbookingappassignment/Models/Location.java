package com.cabbookingapp.cabbookingappassignment.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private int x;
    private int y;

    public double calculateDistance(Location otherLocation) {
        return Math.sqrt(Math.pow(x - otherLocation.getX(), 2) + Math.pow(y - otherLocation.getY(), 2));
    }

}
