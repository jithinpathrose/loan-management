package com.loan.management.service;

import com.loan.management.dto.LoanType;
import com.loan.management.loans.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Component;

@Component
public class ResolveLoan {

    @Autowired
    @Qualifier("housingLoan")
    private Loan housongLoan;

    @Autowired
    @Qualifier("carLoan")
    private Loan carLoan;

    public Loan loanCategory(LoanType loanType) {

        if (LoanType.HOUSING_LOAN == loanType) {
            return housongLoan;
        } else if (LoanType.CAR_LOAN == loanType) {
            return carLoan;
        } else {
            throw new ApplicationContextException("UnIdentified Loan type");
        }

    }
}
