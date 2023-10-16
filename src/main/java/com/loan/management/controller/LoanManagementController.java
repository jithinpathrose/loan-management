package com.loan.management.controller;

import com.loan.management.config.InterestSlab;
import com.loan.management.dto.*;
import com.loan.management.logger.Console;
import com.loan.management.service.LoanCalculator;
import com.loan.management.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan-management")
public class LoanManagementController {

    @Autowired
    private LoanService loanService;

    @Autowired
    private LoanCalculator loanCalculator;

    @Autowired
    @Qualifier("housingLoanInterest")
    private InterestSlab interestSlab;


    @GetMapping(value = "/myLoanPlan",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public PayBackPlan payBackPlan(@RequestParam Float loanAmount,
                                       @RequestParam Integer payBackDurationInYears,
                                       @RequestParam String loanType){
            Console.logDebug("myLoanPlan hit");
            return loanService.getPayBackPlan(new LoanRequest(loanAmount, payBackDurationInYears,
                    LoanType.valueOf(loanType.toUpperCase()), Currency.EUR, Compound.MONTHLY));
        }
}
