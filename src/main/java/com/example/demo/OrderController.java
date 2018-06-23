package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class OrderController {

    private final FulfillmentRepository fulfillmentRepository;

    @PostMapping(path = "/orders", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Fulfillment> createFulfillment(@RequestBody Fulfillment fulfillment) {

        Fulfillment fulfillment1 = fulfillmentRepository.save(fulfillment);
        return ResponseEntity.ok()
                .body(fulfillment1);
    }

    @GetMapping(path = "/orders")
    public ResponseEntity<List<Fulfillment>> getOrders() {
        return ResponseEntity.ok()
                .body(fulfillmentRepository.findAll());

    }

}

