package com.ArielMelo.notification_service.service;

import com.ArielMelo.notification_service.event.EquipmentLoanCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendLoanConfirmation(EquipmentLoanCreatedEvent event) {

        // por enquanto só simula
        System.out.println("📨 Enviando e-mail para " + event.borrowerEmail());
        System.out.println("Seu empréstimo foi registrado com sucesso!");
    }
}
