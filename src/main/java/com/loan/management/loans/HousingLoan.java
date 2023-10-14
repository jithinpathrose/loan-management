package com.loan.management.loans;

import com.loan.management.config.InterestSlab;
import com.loan.management.dto.Compound;
import com.loan.management.dto.LoanRequest;
import com.loan.management.dto.PayBackPlan;
import com.loan.management.service.LoanCalculator;
import com.loan.management.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HousingLoan implements Loan {

    @Autowired
    @Qualifier("housingLoanInterest")
    private InterestSlab interestSlab;

    @Autowired
    private LoanCalculator loanCalculator;

    @Override
    public PayBackPlan plan(LoanRequest loanRequest) {
        Compound compound = loanRequest.getCompound();
        return compound.wrap(loanCalculator.calculate(loanRequest, interestSlab));
    }
}
