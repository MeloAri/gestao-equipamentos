package com.ArielMelo.loan_service.repositories;

import com.ArielMelo.loan_service.entities.Loan;
import com.ArielMelo.loan_service.enums.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {


    List<Loan> findByEquipmentIdAndStatus(Long equipmentId, LoanStatus status);

    // Busca empréstimos em atraso
    List<Loan> findByDueDateBeforeAndStatus(LocalDate date, LoanStatus status);

    // Busca empréstimos de uma pessoa
    List<Loan> findByBorrowerEmail(String borrowerEmail);
}
