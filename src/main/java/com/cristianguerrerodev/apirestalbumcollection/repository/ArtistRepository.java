package com.cristianguerrerodev.apirestalbumcollection.repository;

import com.cristianguerrerodev.apirestalbumcollection.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
