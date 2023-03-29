package com.example.customm.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponse {

    private Integer statusCode;
    private String error;
    private String message;
    private Date timeStamp;
    private String path;
}
