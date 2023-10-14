package com.loan.management.config;

import lombok.Getter;

@Getter
public class InterestSlab {

    public double slab1 = 0;
    public InterestSlab(double interest) {
        this.slab1 = interest;
    }
}
