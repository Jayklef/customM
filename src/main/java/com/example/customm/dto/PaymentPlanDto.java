package com.example.customm.dto;

import lombok.Data;

@Data
public class PaymentPlanDto {
    private Long id;
    private String name;
    private String duration;
    private float interest;
}
