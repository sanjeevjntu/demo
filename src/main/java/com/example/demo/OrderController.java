package com.example.demo;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/orders/{vin}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Fulfillment>> getOrdersByVins(@PathVariable String vin) {

        Page<Fulfillment> fulfillmentPage = fulfillmentElasticRepository.findALLByyVins(vin , PageRequest.of(5,10));

        return ok(fulfillmentPage.getContent());
    }

    @GetMapping(path = "/orders", params = {"vin"}, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Fulfillment>> getOrdersByVin(@RequestParam String vin) {
        return ok(fulfillmentElasticRepository.getByVin(vin));
    }

}

