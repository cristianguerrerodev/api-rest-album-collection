package com.cristianguerrerodev.apirestalbumcollection.service;

import com.cristianguerrerodev.apirestalbumcollection.model.Artist;
import com.cristianguerrerodev.apirestalbumcollection.repository.ArtistRepository;
import com.cristianguerrerodev.apirestalbumcollection.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService extends BaseService<Artist, Long, ArtistRepository> {
}
