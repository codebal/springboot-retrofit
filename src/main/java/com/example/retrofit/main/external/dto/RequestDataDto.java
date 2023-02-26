package com.example.retrofit.main.external.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestDataDto {
    private Long userId;
    private String title;
    private String body;
}
