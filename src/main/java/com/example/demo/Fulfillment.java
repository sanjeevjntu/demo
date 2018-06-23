package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document
public class Fulfillment implements Serializable {

    private static final long serialVersionUID = 2382101368014195289L;

    @Id
    private String fulfillmentId;
    private String vin;
    private String sku;
    private String rateplanid;
    private String email;
    private String country;
    private String state;
    private String customerType;
}
