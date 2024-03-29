package com.payitchi1.paymentserviceappmar24.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpay")
public class RazorpayPaymentServiceImpl implements PaymentService {
    private RazorpayClient razorpayClient;
    RazorpayPaymentServiceImpl(RazorpayClient razorpayClient)
    {
        this.razorpayClient = razorpayClient;
    }
    @Override
    public String doPayment(String email, String phoneno, long amount, String orderId) throws RazorpayException {
        try {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount); // amount in the smallest currency unit
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("receipt", orderId);
            JSONObject customer = new JSONObject();
            customer.put("phoneno", phoneno);
            customer.put("email", email);
            paymentLinkRequest.put("customer", customer);
            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);
            paymentLinkRequest.put("callbackurl", "https://api.razorpay.com/v1/orders");
            paymentLinkRequest.put("callback_method", "get");
            PaymentLink response = razorpayClient.paymentLink.create(paymentLinkRequest);
            return response.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
