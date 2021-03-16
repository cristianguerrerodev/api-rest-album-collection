package com.cristianguerrerodev.apirestalbumcollection.repository;

import com.cristianguerrerodev.apirestalbumcollection.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {
}
