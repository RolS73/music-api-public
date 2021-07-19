package com.codecool.musicapi.util.album;

public class AlbumNotFoundException extends RuntimeException {

    public AlbumNotFoundException(Long id) {
        super("Could not find album " + id);
    }
}
