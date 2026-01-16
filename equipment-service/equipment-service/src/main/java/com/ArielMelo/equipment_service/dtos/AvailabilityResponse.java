package com.ArielMelo.equipment_service.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailabilityResponse {

    private boolean available;

    public AvailabilityResponse(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}
