package com.example.customm.dto;

import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.util.Date;

@Data
public class ClientDto {
    private Long id;
    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String email;
    private Date birthDate;
    private String address;
    private String nin;
    private String bvn;
}
