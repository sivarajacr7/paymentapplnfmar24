package com.payitchi1.paymentserviceappmar24.services;

import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentServiceImpl implements PaymentService{
    @Override
    public String doPayment(String email, String phoneno, long amount, String orderId) {
        return null;
    }
}
