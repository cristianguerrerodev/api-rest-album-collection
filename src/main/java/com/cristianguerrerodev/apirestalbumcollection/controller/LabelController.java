package com.cristianguerrerodev.apirestalbumcollection.controller;

import com.cristianguerrerodev.apirestalbumcollection.model.Label;
import com.cristianguerrerodev.apirestalbumcollection.repository.LabelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LabelController {
    private final LabelRepository labelRepository;

    @GetMapping("/label")
    public ResponseEntity<?> getAllArtist(){
        List<Label> labeltList = labelRepository.findAll();

        if (!labeltList.isEmpty()){
            return ResponseEntity.ok(labeltList);
        }{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/label/{id}")
    public ResponseEntity<?> getArtistById(@PathVariable long id){
        Label label = labelRepository.findById(id).orElse(null);

        if (label != null){
            return ResponseEntity.ok(label);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/label")
    public ResponseEntity<?> postArtist(@RequestBody Label label){
        return ResponseEntity.status(HttpStatus.CREATED).body(labelRepository.save(label));
    }

    @PutMapping("/label/{id}")
    public ResponseEntity<?> putArtist(@RequestBody Label edit, @PathVariable long id){
        return labelRepository.findById(id).map(l -> {
            l.setName(edit.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(labelRepository.save(l));
        }).orElse(null);
    }

    @DeleteMapping("label/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable long id){

        labelRepository.findById(id).ifPresent(labelRepository::delete);

        return ResponseEntity.noContent().build();
    }
}
