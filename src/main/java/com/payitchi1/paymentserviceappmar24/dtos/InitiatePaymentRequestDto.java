package com.payitchi1.paymentserviceappmar24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDto {
    private String email;
    private String phoneno;
    private long amount;
    private String orderId;

}
