package com.codecool.musicapi.repository;

import com.codecool.musicapi.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = "SELECT * FROM song s WHERE s.genre_id = :id", nativeQuery = true)
    List<Song> getSongsByGenreId(@Param("id") Long id);

    @Query(value = "SELECT * FROM song s WHERE s.genre_id = :genreId AND ID = :id", nativeQuery = true)
    Song getSongByIdFromGenre(@Param("genreId") Long albumId, @Param("id") Long id);

    @Query(value = "SELECT * FROM song s WHERE s.playlist_id = :id", nativeQuery = true)
    List<Song> getSongsByPlaylistId(@Param("id") Long id);

    @Query(value = "SELECT * FROM song s WHERE s.playlist_id = :playlistId AND ID = :id", nativeQuery = true)
    Song getSongByIdFromPlaylist(@Param("playlistId") Long albumId, @Param("id") Long id);

    @Query(value = "SELECT * FROM song s WHERE s.album_id = :id", nativeQuery = true)
    List<Song> getSongsByAlbumId(@Param("id") Long id);

    @Query(value = "SELECT * FROM song s WHERE s.album_id = :albumId AND ID = :id", nativeQuery = true)
    Song getSongByIdFromAlbum(@Param("albumId") Long albumId, @Param("id") Long id);
}
