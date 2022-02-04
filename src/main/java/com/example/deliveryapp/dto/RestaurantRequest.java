package com.example.deliveryapp.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
//import static project_java.project.dto.PatternRequest.PHONENUMBER;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest{

    @NotBlank(message = "Name of restaurant cannot be empty")
    private String name;

    private String longi;
    private String lat;






}
