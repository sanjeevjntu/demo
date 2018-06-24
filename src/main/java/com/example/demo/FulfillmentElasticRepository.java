package com.example.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import javax.annotation.Resource;

//@Resource
public interface FulfillmentElasticRepository extends ElasticsearchCrudRepository<Fulfillment, String> {
}
