package com.cristianguerrerodev.apirestalbumcollection.error;

import java.util.function.Supplier;

public class AlbumNotFoundException extends Exception {

    public AlbumNotFoundException(){
        super("No album could be found");
    }

    public AlbumNotFoundException(Long id){
        super("Could not find album with id " + id);
    }
}
