package com.ArielMelo.notification_service.listener;

import com.ArielMelo.notification_service.event.EquipmentLoanCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LoanEventListener {

    @RabbitListener(queues = "loan.created.queue")
    public void handleLoanCreated(EquipmentLoanCreatedEvent event) {

        System.out.println("📩 Novo empréstimo recebido:");
        System.out.println("Equipamento: " + event.equipmentId());
        System.out.println("Para: " + event.borrowerEmail());
        System.out.println("Devolver até: " + event.dueDate());

        // aqui entra o envio real de email depois
    }
}
