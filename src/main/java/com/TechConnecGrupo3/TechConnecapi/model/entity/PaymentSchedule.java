package com.TechConnecGrupo3.TechConnecapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class PaymentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    private LocalDate paymentDate;
    private int installmentNumber;
    private double installmentAmount;
    private double interestAmount;
    private String installmentStatus; // Pending, Paid

    // Getters and Setters
}