package com.example.jswithspring.controller.hybrid;

import com.example.jswithspring.controller.hybrid.request.RequestHybridOrder;
import com.example.jswithspring.service.hybrid.HybridOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/ordertest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HybridOrderTestController {

    @Autowired
    HybridOrderService service;

    @PostMapping("/order")
    public Boolean hybridOrder(@RequestBody RequestHybridOrder order) throws Exception {
        log.info("hybridOrder(): " + order);

        Boolean registerSuccess = service.registerOrder(order);
        String check = service.notice(order);
        log.info("notice check: " + check);

        if (!registerSuccess) {
            return false;
        }

        return true;
    }
}
