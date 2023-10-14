package com.loan.management.config;


import com.loan.management.dto.LoanRequest;
import com.loan.management.dto.PayBackPlan;
import com.loan.management.loans.HousingLoan;
import com.loan.management.loans.Loan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.loan.management")
public class LoanConfiguration {

    @Bean("housingLoanInterest")
    public InterestSlab houseLoanInterest(@Value("${loan.management.houseloan.interest}") double interest){
        return new InterestSlab(interest);
    }

    @Bean("carLoanInterest")
    public InterestSlab carLoanInterest(@Value("${loan.management.carloan.interest}") double interest) {
        return new InterestSlab(interest);
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
