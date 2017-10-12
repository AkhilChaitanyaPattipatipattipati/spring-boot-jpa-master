package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.io.Serializable;

/**
 * Created by ARUN on 10/12/2017.
 */
@JsonDeserialize(builder = Product.Builder.class)
public class Product implements Serializable {
    @JsonProperty
    private Integer productId;
    @JsonProperty
    private String productName;
    @JsonProperty
    private String productDescription;
    @JsonProperty
    private Department department;

    private Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.department = builder.department;
        this.productDescription = builder.productDescription;
    }

    public Integer productId() {
        return productId;
    }

    public String productName() {
        return productName;
    }

    public String productDescription() {
        return productDescription;
    }

    public Department department() {
        return department;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder {
        private Integer productId;

        private String productName;

        private String productDescription;

        private Department department;

        public Builder productId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }
}
