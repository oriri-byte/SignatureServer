package com.example.eth.demo.usecase.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignRequestDto {
    private String address;
    private String domain;
}
