package com.codecool.musicapi.model.DTO.DTFactory;

import com.codecool.musicapi.model.DTO.SongDTO;
import com.codecool.musicapi.model.Song;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SongDTFactory {

    public SongDTO DTOFromPOJO(Song song) {
        return new SongDTO(song.getName(), song.getAlbum(), song.getArtist(), song.getPlaylist(), song.getGenre());
    }

    public Song POJOFromDTO(SongDTO songDTO) {
        return new Song(songDTO.getName(), songDTO.getAlbum(), songDTO.getArtist(), songDTO.getPlaylist(), songDTO.getGenre());
    }

    public List<SongDTO> ListDTOFromList(List<Song> songList) {
        return songList.stream()
                .map(song -> new SongDTO(song.getName(), song.getAlbum(), song.getArtist(), song.getPlaylist(), song.getGenre()))
                .collect(Collectors.toList());
    }

    public List<Song> ListPOJOFromListDTO(List<SongDTO> songDTOList) {
        return songDTOList.stream()
                .map(song -> new Song(song.getName(), song.getAlbum(), song.getArtist(), song.getPlaylist(), song.getGenre()))
                .collect(Collectors.toList());
    }
}
