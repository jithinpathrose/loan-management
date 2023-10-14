package com.loan.management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoanRequest {

    private double loanAmount;

    private int durationInYears;

    private LoanType loanType;

    private Currency currancy;

    private Compound compound;


}
