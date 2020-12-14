package com.gba.myroutine.domain;

import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String data;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
}