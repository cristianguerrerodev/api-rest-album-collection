package com.cristianguerrerodev.apirestalbumcollection.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {

    @Autowired
    protected R repository;

    public T save(T t){
        return repository.save(t);
    }

    public Optional<T> findById(ID id){
        return repository.findById(id);
    }

    public Page<T> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public T edit(T t) {
        return repository.save(t);
    }


    public void delete(T t){
        repository.delete(t);
    }

    public void deleteById(ID id){
        repository.deleteById(id);
    }

}
