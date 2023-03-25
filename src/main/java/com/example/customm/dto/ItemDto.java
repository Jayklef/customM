package com.example.customm.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemDto {

    private Long id;
    private String name;
    private Long quantity;
    private BigDecimal price;
}
