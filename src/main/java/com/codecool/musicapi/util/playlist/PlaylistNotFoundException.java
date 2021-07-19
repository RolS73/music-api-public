package com.codecool.musicapi.util.playlist;

public class PlaylistNotFoundException extends RuntimeException {

    public PlaylistNotFoundException(Long id) {
        super("Could not find playlist " + id);
    }
}
