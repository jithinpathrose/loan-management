package com.loan.management.service;


import com.loan.management.dto.LoanRequest;
import com.loan.management.dto.PayBackPlan;
import com.loan.management.loans.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private ResolveLoan resolveLoan;

    public PayBackPlan getPayBackPlan(LoanRequest loanRequest) {
        Loan loan = resolveLoan.loanCategory(loanRequest.getLoanType());
        return loan.plan(loanRequest);
    }
}
