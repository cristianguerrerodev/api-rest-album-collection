package com.cristianguerrerodev.apirestalbumcollection.dto.songdto.converter;

import com.cristianguerrerodev.apirestalbumcollection.dto.songdto.SongDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SongDTOConverter {

    private final ModelMapper modelMapper;

//    public SongDTO convertToDto()

}
