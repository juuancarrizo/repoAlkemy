package com.alkemy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filmCharacter")
@Getter
@Setter
public class character {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCharacter;
    private String imageCharacter;
    private String nameCharacter;
    private int age;
    private String weight;
    private String history;
    @ManyToMany(mappedBy = "filmCharacters", cascade = CascadeType.ALL)
    private List<movieSerie> movieseries = new ArrayList<>();


}
