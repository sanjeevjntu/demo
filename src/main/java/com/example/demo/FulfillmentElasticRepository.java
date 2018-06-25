package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

//@Resource
public interface FulfillmentElasticRepository extends ElasticsearchCrudRepository<Fulfillment, String> {


    //@Query("{\"bool\": {\"must\": [{\"field\": {\"vin\": \"VIN11\"}}}}")
   // @Query("{\"query\": {\"match\": {\"vin\": \"VIN111\"}}}")
    @Query("{\"query\": {\"bool\": {\"must\": {\"match\": {\"vin\": \"?0\"}}}}}")
    Page<Fulfillment> findALLByyVins(String vin, Pageable pageable);

    @Query("{\"query\": {\"bool\": {\"must\": {\"match\": {\"vin\": \"VIN11\"}}}}}")
    List<Fulfillment> getByVin(String vin);

}
