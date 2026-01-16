package com.ArielMelo.notification_service.event;

import java.time.LocalDate;

public record EquipmentLoanCreatedEvent(Long loanId,
                                        Long equipmentId,
                                        String borrowerName,
                                        String borrowerEmail,
                                        LocalDate dueDate) {
}
