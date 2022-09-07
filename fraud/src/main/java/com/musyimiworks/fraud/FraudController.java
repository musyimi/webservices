package com.musyimiworks.fraud;

import com.musyimiworks.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId")Integer customerID) {
         boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
         log.info("fraud check request for customer {}", customerID);

         return new FraudCheckResponse(isFraudulentCustomer);
    }
}
