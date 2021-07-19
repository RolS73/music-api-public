package com.codecool.musicapi.service;

import com.codecool.musicapi.model.DTO.DTFactory.GenreDTFactory;
import com.codecool.musicapi.model.DTO.DTFactory.SongDTFactory;
import com.codecool.musicapi.model.DTO.GenreDTO;
import com.codecool.musicapi.model.DTO.SongDTO;
import com.codecool.musicapi.model.Genre;
import com.codecool.musicapi.repository.GenreRepository;
import com.codecool.musicapi.repository.SongRepository;
import com.codecool.musicapi.util.LoggerUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository repository;
    private final GenreDTFactory dtFactory;
    private final SongDTFactory songDTFactory;
    private final SongRepository songRepository;

    public GenreService(GenreRepository repository, GenreDTFactory dtFactory, SongDTFactory songDTFactory, SongRepository songRepository) {
        this.repository = repository;
        this.dtFactory = dtFactory;
        this.songDTFactory = songDTFactory;
        this.songRepository = songRepository;
    }

    public void addNew(GenreDTO genreDTO) {
        LoggerUtil.log.info("Adding new genre object to DB: " + genreDTO.toString());
        repository.save(dtFactory.POJOFromDTO(genreDTO));
    }

    public List<GenreDTO> listAll() {
        LoggerUtil.log.info("Retrieving all genre entries from DB");
        return dtFactory.ListDTOFromList(repository.findAll());
    }

    public GenreDTO findById(Long id) {
        LoggerUtil.log.info("Retrieving genre with id: " + id);

        Genre genre = repository.findById(id).orElse(null);
        if (genre != null) {
            return dtFactory.DTOFromPOJO(genre);
        } else {
            return null;
        }
    }

    public void update(GenreDTO newData, Long id) {
        LoggerUtil.log.info("Updating genre with id: " + id + "with data: " + newData.getName());

        Genre pojoData = dtFactory.POJOFromDTO(newData);
        pojoData.setId(id);
        repository.save(pojoData);
        /*repository.findById(id).stream()
                .map(playlist -> {
                    playlist.setName(newData.getName());
                    return repository.save(playlist);
                });*/
    }

    public void delete(Long id) {
        LoggerUtil.log.info("Deleting genre entry from database with id: " + id);

        repository.deleteById(id);
    }

    public List<SongDTO> getSongsFromGenreWithId(Long id) {
        LoggerUtil.log.info("Retrieving all songs with genre id: " + id);

        return songDTFactory.ListDTOFromList(songRepository.getSongsByGenreId(id));
    }

    public SongDTO getSongWithIdFromAlbumWithId(Long genreId, Long id) {
        LoggerUtil.log.info("Retrieving song with id: " + id + "from genre with id: " + genreId);

        return songDTFactory.DTOFromPOJO(songRepository.getSongByIdFromGenre(genreId, id));
    }
}
