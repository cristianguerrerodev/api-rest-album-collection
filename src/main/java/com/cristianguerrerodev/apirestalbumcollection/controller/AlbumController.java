package com.cristianguerrerodev.apirestalbumcollection.controller;

import com.cristianguerrerodev.apirestalbumcollection.dto.AlbumDTO;
import com.cristianguerrerodev.apirestalbumcollection.dto.CreateAlbumDTO;
import com.cristianguerrerodev.apirestalbumcollection.model.Album;
import com.cristianguerrerodev.apirestalbumcollection.model.Artist;
import com.cristianguerrerodev.apirestalbumcollection.model.Label;
import com.cristianguerrerodev.apirestalbumcollection.repository.AlbumRepository;
import com.cristianguerrerodev.apirestalbumcollection.repository.ArtistRepository;
import com.cristianguerrerodev.apirestalbumcollection.repository.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final LabelRepository labelRepository;

    @GetMapping("/album")
    public ResponseEntity<?> getAllAlbums(){
        List<Album> albumList = albumRepository.findAll();

        if (!albumList.isEmpty()){
            return ResponseEntity.ok(albumList);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<?> getAlbumById(@PathVariable long id){
        Album album = albumRepository.findById(id).orElse(null);

        if (album != null){
            return ResponseEntity.ok(album);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/album")
    public ResponseEntity<?> postAlbum(@RequestBody CreateAlbumDTO albumDTO){
//        Album newAlbum = album;
//        Artist artist = artistRepository.findById(album.get)
//        newAlbum.setTitle(album.getTitle());
//        newAlbum.setGenre(album.getGenre());
//        newAlbum.setYear(album.getYear());
//        return ResponseEntity.status(HttpStatus.CREATED).body(albumRepository.save(album));

        Album album = new Album();
        Artist artist = artistRepository.findById(albumDTO.getArtist_id()).orElse(null);
        Label label = labelRepository.findById(albumDTO.getLabel_id()).orElse(null);

        album.setTitle(albumDTO.getTitle());
        album.setGenre(albumDTO.getGenre());
        album.setYear(albumDTO.getYear());
        album.setArtist(artist);
        album.setLabel(label);

        return ResponseEntity.status(HttpStatus.CREATED).body(albumRepository.save(album));
    }

    @PutMapping("/album/{id}")
    public ResponseEntity<?> putAlbum(@RequestBody CreateAlbumDTO edit, @PathVariable long id){
        return albumRepository.findById(id).map( album -> {
            Artist artist = artistRepository.findById(edit.getArtist_id()).orElse(null);
            Label label = labelRepository.findById(edit.getLabel_id()).orElse(null);

            album.setTitle(edit.getTitle());
            album.setGenre(edit.getGenre());
            album.setYear(edit.getYear());
            album.setArtist(artist);
            album.setLabel(label);
            return ResponseEntity.status(HttpStatus.CREATED).body(albumRepository.save(album));
        }).orElse(null);
    }

    @DeleteMapping("album/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable long id){

        albumRepository.findById(id).ifPresent(albumRepository::delete);

        return ResponseEntity.noContent().build();
    }

}
