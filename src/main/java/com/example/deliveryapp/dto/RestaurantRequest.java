package com.example.deliveryapp.dto;
import javax.validation.constraints.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
//import static project_java.project.dto.PatternRequest.PHONENUMBER;

public class RestaurantRequest{

    @NotBlank(message = "Name of restaurant cannot be empty")
    private String name;
    @NotNull
    private int locationId;

    public RestaurantRequest(){ }
    public RestaurantRequest(String name, int locationId) {
        this.name = name;
        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
