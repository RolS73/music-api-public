package com.codecool.musicapi.model.DTO.DTFactory;

import com.codecool.musicapi.model.DTO.PlaylistDTO;
import com.codecool.musicapi.model.Playlist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaylistDTFactory {

    public PlaylistDTO DTOFromPOJO(Playlist playlist) {
        return new PlaylistDTO(playlist.getPlaylistName());
    }

    public Playlist POJOFromDTO(PlaylistDTO playlistDTO) {
        return new Playlist(playlistDTO.getPlaylistName());
    }

    public List<PlaylistDTO> ListDTOFromList(List<Playlist> playlistList) {
        return playlistList.stream().map(playlist -> new PlaylistDTO(playlist.getPlaylistName())).collect(Collectors.toList());
    }

    public List<Playlist> ListPOJOFromListDTO(List<PlaylistDTO> playlistDTOList) {
        return playlistDTOList.stream().map(playlist -> new Playlist(playlist.getPlaylistName())).collect(Collectors.toList());
    }
}

