package com.example.deliveryapp.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class ProductRequest {

    Long id;
    @NotBlank(message = "Name of restaurant cannot be empty")
    String name;
    String description;
    @NotNull
    String weight;
    @NotNull
    @Min(0)
    Double price;
    String location;
    Boolean isAvailable;
    Integer salePercentage;

    public ProductRequest() {
    }

    public ProductRequest(Long id,@NotBlank(message = "Name of restaurant cannot be empty") String name, String description, @NotNull String weight, @NotNull @Min(0) Double price, String location, Boolean isAvailable, Integer salePercentage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.location = location;
        this.isAvailable = isAvailable;
        this.salePercentage = salePercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getSalePercentage() {
        return salePercentage;
    }

    public void setSalePercentage(Integer salePercentage) {
        this.salePercentage = salePercentage;
    }
}
