package me.sloowy.literalura.models.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(@JsonAlias("title") String title,
                      @JsonAlias("languages") List<String> languages,
                      @JsonAlias("download_count") Double downloadCount) {
}
