package com.loan.management.config;


import com.loan.management.dto.LoanRequest;
import com.loan.management.dto.PayBackPlan;
import com.loan.management.loans.HousingLoan;
import com.loan.management.loans.Loan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.loan.management")
public class LoanConfiguration {

    @Bean("housingLoanInterest")
    public InterestSlab houseLoanInterest() {
        return new InterestSlab(3.5);
    }

    @Bean("carLoanInterest")
    public InterestSlab carLoanInterest() {
        return new InterestSlab(8.5);
    }

    @Bean("housingLoan")
    public Loan housingLoan(){
        return new HousingLoan();
    }

    @Bean("carLoan")
    public Loan carLoan(){
        // not implemented
        return new Loan() {
            @Override
            public PayBackPlan plan(LoanRequest loanRequest) {
                return null;
            }
        };
    }

}
