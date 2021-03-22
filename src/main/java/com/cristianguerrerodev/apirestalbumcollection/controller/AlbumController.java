package com.cristianguerrerodev.apirestalbumcollection.controller;

import com.cristianguerrerodev.apirestalbumcollection.dto.CreateAlbumDTO;
import com.cristianguerrerodev.apirestalbumcollection.error.AlbumNotFoundException;
import com.cristianguerrerodev.apirestalbumcollection.model.Album;
import com.cristianguerrerodev.apirestalbumcollection.model.Artist;
import com.cristianguerrerodev.apirestalbumcollection.model.Label;
import com.cristianguerrerodev.apirestalbumcollection.repository.ArtistRepository;
import com.cristianguerrerodev.apirestalbumcollection.repository.LabelRepository;
import com.cristianguerrerodev.apirestalbumcollection.service.AlbumService;
import com.cristianguerrerodev.apirestalbumcollection.utils.PaginationLinksUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;
    private final ArtistRepository artistRepository;
    private final LabelRepository labelRepository;
    private final PaginationLinksUtils paginationLinksUtils;

    @GetMapping("/album")
    public ResponseEntity<?> getAllAlbums(Pageable pageable, HttpServletRequest request) throws AlbumNotFoundException {
        Page<Album> result = albumService.findAll(pageable);

        if (result.isEmpty()){
            throw new AlbumNotFoundException();
        } else {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

            return ResponseEntity.ok()
                    .header("link", paginationLinksUtils.createLinkHeader(result, uriBuilder))
                    .body(result);
        }
    }

    @GetMapping("/album/{id}")
    public Album getAlbumById(@PathVariable long id) throws AlbumNotFoundException {
        return albumService.findById(id).orElseThrow(() -> new AlbumNotFoundException(id));
    }

    @PostMapping("/album")
    public ResponseEntity<?> postAlbum(@RequestBody CreateAlbumDTO albumDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(albumService.saveAlbum(albumDTO));
    }

    @PutMapping("/album/{id}")
    public ResponseEntity<?> putAlbum(@RequestBody CreateAlbumDTO edit, @PathVariable long id) throws AlbumNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(albumService.editAlbum(id, edit));
    }

    @DeleteMapping("album/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable long id){
        albumService.findById(id).ifPresent(albumService::delete);
        return ResponseEntity.noContent().build();
    }

}
