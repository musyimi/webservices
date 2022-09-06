package com.musyimiworks.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId")Integer customerID) {
         boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);

         return new FraudCheckResponse(isFraudulentCustomer);
    }
}
