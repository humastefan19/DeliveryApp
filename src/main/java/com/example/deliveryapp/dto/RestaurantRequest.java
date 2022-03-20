package com.example.deliveryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

//import static project_java.project.dto.PatternRequest.PHONENUMBER;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {

    private Long id;
    @NotBlank(message = "Name of restaurant cannot be empty")
    private String name;

    private String longi;
    private String lat;

}
