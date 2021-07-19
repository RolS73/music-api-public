package com.codecool.musicapi.model.DTO.DTFactory;

import com.codecool.musicapi.model.Album;
import com.codecool.musicapi.model.DTO.AlbumDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlbumDTFactory {

    public Album POJOFromDTO(AlbumDTO albumDTO) {
        return new Album(albumDTO.getName());
    }

    public AlbumDTO DTOFromPOJO(Album album) {
        return new AlbumDTO(album.getName());
    }

    public List<AlbumDTO> ListDTOFromList(List<Album> albumList) {
        return albumList.stream().map(album -> new AlbumDTO(album.getName())).collect(Collectors.toList());
    }

    public List<Album> ListPOJOFromListDTO(List<AlbumDTO> albumDTOList) {
        return albumDTOList.stream().map(album -> new Album(album.getName())).collect(Collectors.toList());
    }
}
