package com.gba.myroutine.dto;

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
    private String email;
    private String password;
    private List<TaskDTO> tasks = new ArrayList<>();
}