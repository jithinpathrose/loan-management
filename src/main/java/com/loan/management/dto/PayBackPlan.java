package com.loan.management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayBackPlan {

    public PayBackPlan(Compound period){this.periodicity = period;}

    private Compound periodicity;

    /**
     * payback amount for period
     */
    private double paybackAmount;

    /**
     * total interest for the period
     */
    private double interest;

    private Currency currency;


    public void wrap(PayBackDetails calculate, int denomination) {
        this.currency = calculate.getCurrency();
        this.paybackAmount =calculate.getAmount()/denomination;
        this.interest = calculate.getInterest()/denomination;
    }
}
