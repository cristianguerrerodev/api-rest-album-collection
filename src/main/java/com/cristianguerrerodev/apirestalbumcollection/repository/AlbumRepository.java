package com.cristianguerrerodev.apirestalbumcollection.repository;

import com.cristianguerrerodev.apirestalbumcollection.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
