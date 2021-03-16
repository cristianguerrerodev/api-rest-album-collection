package com.cristianguerrerodev.apirestalbumcollection.controller;

import com.cristianguerrerodev.apirestalbumcollection.model.Artist;
import com.cristianguerrerodev.apirestalbumcollection.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistRepository artistRepository;

    @GetMapping("/artist")
    public ResponseEntity<?> getAllArtist(){
        List<Artist> artistList = artistRepository.findAll();

        if (!artistList.isEmpty()){
            return ResponseEntity.ok(artistList);
        }{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/artist/{id}")
    public ResponseEntity<?> getArtistById(@PathVariable long id){
        Artist artist = artistRepository.findById(id).orElse(null);

        if (artist != null){
            return ResponseEntity.ok(artist);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/artist")
    public ResponseEntity<?> postArtist(@RequestBody Artist artist){
        return ResponseEntity.status(HttpStatus.CREATED).body(artistRepository.save(artist));
    }

    @PutMapping("/artist/{id}")
    public ResponseEntity<?> putArtist(@RequestBody Artist edit, @PathVariable long id){
        Artist artist = artistRepository.findById(id).orElse(null);
        if (artist != null){
            artist.setName(edit.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(artist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
