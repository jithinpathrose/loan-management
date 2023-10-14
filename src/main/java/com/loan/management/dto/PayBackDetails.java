package com.loan.management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayBackDetails {

    private Currency currency;

    /**
     * total amount
     */
    private double amount;

    /**
     * total interest
     */
    private double interest;

}
