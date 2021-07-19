package com.codecool.musicapi.service;

import com.codecool.musicapi.model.Album;
import com.codecool.musicapi.model.DTO.AlbumDTO;
import com.codecool.musicapi.model.DTO.DTFactory.AlbumDTFactory;
import com.codecool.musicapi.model.DTO.DTFactory.SongDTFactory;
import com.codecool.musicapi.model.DTO.SongDTO;
import com.codecool.musicapi.repository.AlbumRepository;
import com.codecool.musicapi.repository.SongRepository;
import com.codecool.musicapi.util.LoggerUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository repository;
    private final AlbumDTFactory dtFactory;
    private final SongDTFactory songDTFactory;
    private final SongRepository songRepository;

    public AlbumService(AlbumRepository repository, AlbumDTFactory dtFactory, SongDTFactory songDTFactory, SongRepository songRepository) {
        this.repository = repository;
        this.dtFactory = dtFactory;
        this.songDTFactory = songDTFactory;
        this.songRepository = songRepository;
    }

    public void addNew(AlbumDTO albumDTO) {
        LoggerUtil.log.info("Adding new album object to DB: " + albumDTO.toString());
        repository.save(dtFactory.POJOFromDTO(albumDTO));
    }

    public List<AlbumDTO> listAll() {
        LoggerUtil.log.info("Retrieving all album entries from DB");
        return dtFactory.ListDTOFromList(repository.findAll());
    }

    public AlbumDTO findById(Long id) {
        LoggerUtil.log.info("Retrieving album with id: " + id);

        Album album = repository.findById(id).orElse(null);
        if (album != null) {
            return dtFactory.DTOFromPOJO(album);
        } else {
            return null;
        }
    }

    public void update(AlbumDTO newData, Long id) {
        LoggerUtil.log.info("Updating album with id: " + id + "with data: " + newData.getName());

        Album pojoData = dtFactory.POJOFromDTO(newData);
        pojoData.setId(id);
        repository.save(pojoData);
        /*repository.findById(id).stream()
                .map(album -> {
                    album.setName(newData.getName());
                    return repository.save(album);
                });*/
    }

    public void delete(Long id) {
        LoggerUtil.log.info("Deleting album entry from database with id: " + id);
        repository.deleteById(id);
    }

    public List<SongDTO> getSongsFromAlbumWithId(Long id) {
        LoggerUtil.log.info("Retrieving all songs with album id: " + id);

        return songDTFactory.ListDTOFromList(songRepository.getSongsByAlbumId(id));
    }

    public SongDTO getSongWithIdFromAlbumWithId(Long genreId, Long id) {
        LoggerUtil.log.info("Retrieving song with id: " + id + "from album with id: " + genreId);

        return songDTFactory.DTOFromPOJO(songRepository.getSongByIdFromAlbum(genreId, id));
    }
}
