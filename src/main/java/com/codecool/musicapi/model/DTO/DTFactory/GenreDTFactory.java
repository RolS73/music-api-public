package com.codecool.musicapi.model.DTO.DTFactory;

import com.codecool.musicapi.model.DTO.GenreDTO;
import com.codecool.musicapi.model.Genre;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreDTFactory {

    public GenreDTO DTOFromPOJO(Genre genre) {
        return new GenreDTO(genre.getName());
    }

    public Genre POJOFromDTO(GenreDTO genreDTO) {
        return new Genre(genreDTO.getName());
    }

    public List<GenreDTO> ListDTOFromList(List<Genre> genreList) {
        return genreList.stream().map(genre -> new GenreDTO(genre.getName())).collect(Collectors.toList());
    }

    public List<Genre> ListPOJOFromListDTO(List<GenreDTO> genreDTOList) {
        return genreDTOList.stream().map(genre -> new Genre(genre.getName())).collect(Collectors.toList());
    }
}
