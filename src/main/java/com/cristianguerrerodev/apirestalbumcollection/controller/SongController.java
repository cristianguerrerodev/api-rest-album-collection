package com.cristianguerrerodev.apirestalbumcollection.controller;

import com.cristianguerrerodev.apirestalbumcollection.dto.CreateSongDTO;
import com.cristianguerrerodev.apirestalbumcollection.model.Album;
import com.cristianguerrerodev.apirestalbumcollection.model.Artist;
import com.cristianguerrerodev.apirestalbumcollection.model.Song;
import com.cristianguerrerodev.apirestalbumcollection.repository.AlbumRepository;
import com.cristianguerrerodev.apirestalbumcollection.repository.ArtistRepository;
import com.cristianguerrerodev.apirestalbumcollection.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SongController {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    @GetMapping("/song")
    public ResponseEntity<?> getAllSongs() {
        List<Song> songList = songRepository.findAll();

        if (!songList.isEmpty()){
            return ResponseEntity.ok(songList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<?> getSongById(@PathVariable long id) {
        Song song = songRepository.findById(id).orElse(null);

        if (song != null){
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/song")
//    public ResponseEntity<?> getAllSongsFromAnALbum(@RequestParam("album") long id){
//        Album album = albumRepository.findById(id).orElse(null);
//
//        if (album != null){
//            List<Song> songList = album.getSongList();
//            return ResponseEntity.ok(songList);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping("/song")
    public ResponseEntity<?> postSong(@RequestBody CreateSongDTO save){
        Song song = new Song();
        Album album = albumRepository.findById(save.getAlbum_id()).orElse(null);
        Artist artist = artistRepository.findById(save.getArtist_id()).orElse(null);

        song.setTitle(save.getTitle());
        song.setTrack(save.getTrack());
        song.setLength(save.getLength());
        song.setArtist(artist);
        song.setAlbum(album);
        return ResponseEntity.status(HttpStatus.CREATED).body(songRepository.save(song));
    }

    @PutMapping("/song/{id}")
    public ResponseEntity<?> putSong(@RequestBody CreateSongDTO edit, @PathVariable long id){
        return songRepository.findById(id).map( song -> {
            Album album = albumRepository.findById(edit.getArtist_id()).orElse(null);
            Artist artist = artistRepository.findById(edit.getAlbum_id()).orElse(null);

            song.setTitle(edit.getTitle());
            song.setTrack(edit.getTrack());
            song.setLength(edit.getLength());
            song.setArtist(artist);
            song.setAlbum(album);

            return ResponseEntity.status(HttpStatus.CREATED).body(songRepository.save(song));
        }).orElse(null);
    }

    @DeleteMapping("/song/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable long id){
        Song song = songRepository.findById(id).orElse(null);
        if (song != null)
            songRepository.delete(song);

        return ResponseEntity.noContent().build();
    }



}
