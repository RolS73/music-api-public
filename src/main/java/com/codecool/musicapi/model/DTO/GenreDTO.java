package com.codecool.musicapi.model.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class GenreDTO {

    @JsonIgnore
    private Long id;
    private String name;

    public GenreDTO(String genreName) {
        this.name = genreName;
    }

    public GenreDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
