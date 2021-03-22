package com.cristianguerrerodev.apirestalbumcollection.service;

import com.cristianguerrerodev.apirestalbumcollection.model.Label;
import com.cristianguerrerodev.apirestalbumcollection.repository.LabelRepository;
import com.cristianguerrerodev.apirestalbumcollection.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LabelService extends BaseService<Label, Long, LabelRepository> {
}
