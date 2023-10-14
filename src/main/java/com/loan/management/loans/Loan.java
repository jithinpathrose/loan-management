package com.loan.management.loans;

import com.loan.management.dto.LoanRequest;
import com.loan.management.dto.PayBackPlan;

public interface Loan {

    PayBackPlan plan(LoanRequest loanRequest);
}
