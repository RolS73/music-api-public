package com.codecool.musicapi.util.artist;

public class ArtistNotFoundException extends RuntimeException {

    public ArtistNotFoundException(Long id) {
        super("Could not find artist " + id);
    }
}
