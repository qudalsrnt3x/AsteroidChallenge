package com.example.shortform.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Level extends Timestamped{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level_icon", nullable = false)
    private String levelIcon;

    @Column(name = "experience_point", nullable = false)
    private int experiencePoint;

    @OneToMany(mappedBy = "level", orphanRemoval = true)
    private List<User> users = new ArrayList<>();
}