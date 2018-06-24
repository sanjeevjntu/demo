package com.example.demo;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
public class OrderController {

    //private final FulfillmentRepository fulfillmentRepository;
    private final FulfillmentElasticRepository fulfillmentElasticRepository;

  /*  @PostMapping(path = "/orders1", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Fulfillment> createFulfillment(@RequestBody Fulfillment fulfillment) {

        Fulfillment fulfillment1 = fulfillmentRepository.save(fulfillment);
        return ok()
                .body(fulfillment1);
    }

    @GetMapping(path = "/orders1")
    public ResponseEntity<List<Fulfillment>> getOrders() {
        return ok()
                .body(fulfillmentRepository.findAll());

    }*/


    @PostMapping(path = "/orders", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Fulfillment> createFulfillmentES(@RequestBody Fulfillment fulfillment) {

        Fulfillment fulfillment1 = fulfillmentElasticRepository.save(fulfillment);
        return ok()
                .body(fulfillment1);
    }

    @GetMapping(path = "/orders")
    public ResponseEntity<List<Fulfillment>> getOrdersES() {

        List<Fulfillment> fulfillments = Lists.newArrayList();
        fulfillmentElasticRepository.findAll()
                .forEach(fulfillments::add);
        return ok(fulfillments);

    }

}

