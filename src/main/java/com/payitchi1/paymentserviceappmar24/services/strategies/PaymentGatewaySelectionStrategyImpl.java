package com.payitchi1.paymentserviceappmar24.services.strategies;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelectionStrategyImpl implements PaymentGatewaySelectionStrategy{
    @Override
    public int paymentGatewaySelection() {
        return 0;
    }
}
