package com.cristianguerrerodev.apirestalbumcollection.repository;

import com.cristianguerrerodev.apirestalbumcollection.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
