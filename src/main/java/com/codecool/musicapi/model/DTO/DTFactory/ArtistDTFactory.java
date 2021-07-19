package com.codecool.musicapi.model.DTO.DTFactory;

import com.codecool.musicapi.model.Artist;
import com.codecool.musicapi.model.DTO.ArtistDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistDTFactory {

    public ArtistDTO DTOFromPOJO(Artist artist) {
        return new ArtistDTO(artist.getName());
    }

    public Artist POJOFromDTO(ArtistDTO artistDTO) {
        return new Artist(artistDTO.getName());
    }

    public List<ArtistDTO> ListDTOFromList(List<Artist> artistList) {
        return artistList.stream().map(artist -> new ArtistDTO(artist.getName())).collect(Collectors.toList());
    }

    public List<Artist> ListPOJOFromListDTO(List<ArtistDTO> artistDTOList) {
        return artistDTOList.stream().map(artist -> new Artist(artist.getName())).collect(Collectors.toList());
    }
}
