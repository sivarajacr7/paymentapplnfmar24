package com.payitchi1.paymentserviceappmar24.controllers;

import com.payitchi1.paymentserviceappmar24.dtos.InitiatePaymentRequestDto;
import com.payitchi1.paymentserviceappmar24.services.PaymentService;
import com.payitchi1.paymentserviceappmar24.services.strategies.PaymentGatewaySelectionStrategy;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
private PaymentService razorPaymentService;
private PaymentService stripePaymentService;
private PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy;
public PaymentController(@Qualifier("razorpay") PaymentService razorPaymentService,
                         @Qualifier("stripe") PaymentService stripePaymentService,
                         PaymentGatewaySelectionStrategy paymentGatewaySelectionStrategy)
{
    this.razorPaymentService = razorPaymentService;
    this.stripePaymentService = stripePaymentService;
    this.paymentGatewaySelectionStrategy = paymentGatewaySelectionStrategy;
}
public String initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) throws RazorpayException {
    int paymentGatewayOption = choosePaymentGateway();
    switch (paymentGatewayOption){
    case 1:return razorPaymentService.doPayment(requestDto.getEmail(),
            requestDto.getPhoneno(), requestDto.getAmount(),requestDto.getOrderId());
    case 2:return stripePaymentService.doPayment(requestDto.getEmail(),
            requestDto.getPhoneno(), requestDto.getAmount(),requestDto.getOrderId());
    }
    return null;
}
private int choosePaymentGateway(){
    return paymentGatewaySelectionStrategy.paymentGatewaySelection();
}
}
