package com.payitchi1.paymentserviceappmar24.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/razorpayWebHook")
public class RazorpayWebHookController {
    @PutMapping("/")
    public ResponseEntity acceptWeHookRequest(){
        return null;
    }
}
