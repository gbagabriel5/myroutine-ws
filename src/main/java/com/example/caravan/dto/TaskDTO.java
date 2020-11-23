package com.example.caravan.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private Integer id;
    private String title;
    private String description;
    private String data;
    private UserDTO userDTO;
}