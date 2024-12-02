package com.TechConnecGrupo3.TechConnecapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "loan_type_id")
    private LoanType loanType;

    private double amount;
    private LocalDate loanDate;
    private LocalDate startDate;
    private int durationMonths;
    private double interestRate;

    // Getters and Setters
}