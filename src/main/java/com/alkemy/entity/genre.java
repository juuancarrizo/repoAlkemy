package com.alkemy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "filmGenre")
@Getter
@Setter
public class genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idGenre;
    private String nameGenre;
    private String imageGenre;
}
