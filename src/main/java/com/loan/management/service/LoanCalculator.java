package com.loan.management.service;

import com.loan.management.config.InterestSlab;
import com.loan.management.dto.LoanRequest;
import com.loan.management.dto.PayBackDetails;
import org.springframework.stereotype.Service;

@Service
public class LoanCalculator {
    public PayBackDetails calculate(LoanRequest loanRequest, InterestSlab interestSlab) {
        PayBackDetails payBackDetails = new PayBackDetails();
        double interest = calculateSI(loanRequest.getLoanAmount(), interestSlab.getSlab1(), loanRequest.getDurationInYears());
        payBackDetails.setInterest(interest);
        payBackDetails.setAmount(calculateAmount(loanRequest.getLoanAmount(),interest));
        payBackDetails.setCurrency(loanRequest.getCurrancy());
        return payBackDetails;
    }

    private double calculateAmount(double loanAmount, double interest) {
        return interest+loanAmount;
    }

    private double calculateSI(double loanAmount, double slab1, int loanDurationInYears) {
        return (loanAmount*slab1*loanDurationInYears)/100;
    }
}
