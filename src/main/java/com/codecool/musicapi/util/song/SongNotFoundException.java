package com.codecool.musicapi.util.song;

public class SongNotFoundException extends RuntimeException {

    public SongNotFoundException(Long id) {
        super("Could not find song " + id);
    }
}
