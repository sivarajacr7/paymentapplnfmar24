package com.payitchi1.paymentserviceappmar24.services;

import com.razorpay.RazorpayException;

public interface PaymentService {
    String doPayment(String email,String phoneno,long amount,String orderId) throws RazorpayException;
}
