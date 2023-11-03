package com.example.labtestback.models;

import com.example.labtestback.entity.Type;
import com.example.labtestback.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {
    private long id;
    @NotBlank(message = "Name is required")
    @Size(max = 30, message = "Name must not exceed 30 characters")
    private String name;

    @NotBlank(message = "Model is required")
    @Size(max = 15, message = "Model must not exceed 15 characters")
    private String model;

    @NotNull(message = "Range from is required")
    @Min(value = 0, message = "Range from must be greater than or equal to 0")
    private Integer rangeFrom;

    @NotNull(message = "Range to is required")
    @Min(value = 0, message = "Range to must be greater than or equal to 0")
    private Integer rangeTo;
    @AssertTrue(message = "Range from must be less than Range to")
    private boolean isRangeValid() {
        return rangeFrom < rangeTo;
    }
    @Pattern(regexp = "Pressure|Voltage|Temperature|Humidity", message = "Invalid sensor type")
    private String type;



    @Pattern(regexp = "bar|voltage|°C|%", message = "Invalid unit")
    private String unit;

    @Size(max = 40, message = "Location must not exceed 40 characters")
    private String location;

    @Size(max = 200, message = "Description must not exceed 200 characters")
    private String description;


}
