package com.loan.management.dto;

public enum Compound {

    MONTHLY {
        @Override
        public PayBackPlan wrap(PayBackDetails calculate) {
            PayBackPlan payBackPlan = new PayBackPlan(Compound.MONTHLY);
            payBackPlan.wrap(calculate, 12);
            return payBackPlan;
        }
    },

    YEARLY {
        @Override
        public PayBackPlan wrap(PayBackDetails calculate) {
            return null;
        }
    },

    QUATERLY {
        @Override
        public PayBackPlan wrap(PayBackDetails calculate) {
            return null;
        }
    };

    public abstract PayBackPlan wrap(PayBackDetails calculate) ;
}
