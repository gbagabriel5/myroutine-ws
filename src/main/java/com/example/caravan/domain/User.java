package com.example.caravan.domain;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
