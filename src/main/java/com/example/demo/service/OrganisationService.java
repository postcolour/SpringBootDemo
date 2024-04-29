package com.example.demo.service;

import com.example.demo.dto.model.OrganizationDto;
import javassist.NotFoundException;

import java.util.List;

public interface OrganisationService {
    OrganizationDto findById(Integer id) throws NotFoundException;
    List<OrganizationDto> findByNameContaining(String name);
}
