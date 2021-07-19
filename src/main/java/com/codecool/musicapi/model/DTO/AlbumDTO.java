package com.codecool.musicapi.model.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class AlbumDTO {

    @JsonIgnore
    private Long id;
    private String name;

    public AlbumDTO(String name) {
        this.name = name;
    }

    public AlbumDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
