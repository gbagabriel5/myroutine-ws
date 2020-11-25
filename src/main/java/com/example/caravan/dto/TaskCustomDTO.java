package com.example.caravan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskCustomDTO {
    private Integer id;
    private String title;
    private String description;
    private String data;
    private Integer userId;
}
