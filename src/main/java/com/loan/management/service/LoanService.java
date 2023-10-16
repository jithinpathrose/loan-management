package com.loan.management.service;


import com.loan.management.dto.LoanRequest;
import com.loan.management.dto.PayBackPlan;
import com.loan.management.loans.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private ResolveLoan resolveLoan;

    public PayBackPlan getPayBackPlan(LoanRequest loanRequest) {
        Loan loan = resolveLoan.loanCategory(loanRequest.getLoanType());
        validateLoanRequest(loanRequest);
        return loan.plan(loanRequest);
    }

    private void validateLoanRequest(LoanRequest loanRequest) {
        if(loanRequest.getLoanAmount()==0 ||
        loanRequest.getDurationInYears()==0 ){
            throw new ApplicationContextException("Invalid Loan Amount / Loan duration");
        }
    }
}
