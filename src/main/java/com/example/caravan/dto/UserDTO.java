package com.example.caravan.dto;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private List<TaskDTO> tasks = new ArrayList<>();
}