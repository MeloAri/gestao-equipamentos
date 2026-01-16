package com.ArielMelo.loan_service.CLIENT;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "equipment-service", url = "http://localhost:8081")
public interface EquipmentClient {

    @GetMapping("/equipments/{id}/available")
    AvailabilityResponse isAvailable(@PathVariable Long id);
}