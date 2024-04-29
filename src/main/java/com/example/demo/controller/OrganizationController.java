package com.example.demo.controller;

import com.example.demo.dto.model.OrganizationDto;
import com.example.demo.service.OrganisationService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrganizationController {

    private final OrganisationService organisationService;

    public OrganizationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    /**
     * Получение списка организаций по части его имени (либо всего списка, в случае пустой строки)
    */
    @GetMapping()
    public ResponseEntity<List<OrganizationDto>> findOrganizatinsByNameContaining(@RequestParam String name) {
       return new ResponseEntity<>(
               organisationService.findByNameContaining(name),
               HttpStatus.OK);
    }

    /**
     * Получение организации по ее ИД
    */
    @GetMapping( "/{id}")
    public ResponseEntity<OrganizationDto> findOrganizatinById(@PathVariable Integer id) throws NotFoundException {
       return new ResponseEntity<>(
               organisationService.findById(id),
               HttpStatus.OK);
    }
}
