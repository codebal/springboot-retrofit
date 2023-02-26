package com.example.retrofit.main.external.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDataDto {
    private Long id;
    private Long userId;
    private String title;
    private String body;

}
