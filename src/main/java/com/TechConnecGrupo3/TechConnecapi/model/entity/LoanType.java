package com.TechConnecGrupo3.TechConnecapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanTypeId;

    private String loanName;
    private int durationMonths;
    private double interestRate;

    // Getters and Setters
}