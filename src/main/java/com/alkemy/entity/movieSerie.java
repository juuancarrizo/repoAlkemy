package com.alkemy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "filmMovieSerie")
@Getter
@Setter
public class movieSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idMovieSerie;
    private String imageMovieserie;
    private String title;
    private LocalDate creationDate;
    private int rating;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idGenre", insertable = false, updatable = false)
    private genre genreFilm;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "characterMovieSerie",
            joinColumns = @JoinColumn(name= "idMovieSerie"),
            inverseJoinColumns = @JoinColumn(name="idCharacter"))

    private Set<character> characters = new HashSet<>();
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final movieSerie other = (movieSerie) obj;
        return other.idMovieSerie == this.idMovieSerie;
    }
}
