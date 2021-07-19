package com.codecool.musicapi.util.genre;

public class GenreNotFoundException extends RuntimeException {

    public GenreNotFoundException(Long id) {
        super("Could not find genre " + id);
    }
}
