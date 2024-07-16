package me.sloowy.literalura.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AuthorDTO(@JsonAlias("name") String name,
                        @JsonAlias("birth_year") Integer birthYear,
                        @JsonAlias("death_year") Integer deathYear) {
}
