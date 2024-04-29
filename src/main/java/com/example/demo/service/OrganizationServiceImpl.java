package com.example.demo.service;

import com.example.demo.dto.mapper.OrganizationMapper;
import com.example.demo.dto.model.OrganizationDto;
import com.example.demo.entity.Organization;
import com.example.demo.repository.OrganizationRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganisationService{

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository,
                                   OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    }

    /**
     * Получение списка организаций по части его имени (либо всего списка, в случае пустой строки)
     * @param name - часть имени организации
     * @return Список представлений организаций
     */
    @Override
    public List<OrganizationDto> findByNameContaining(String name) {
        List<Organization> organizations = organizationRepository.findByNameContaining(name);
        return organizationMapper.toListOrganizationDto(organizations);
    }

    /**
     * Получение организации по ее ИД
     * @param id - ИД организации
     * @return Представление организации
     * @throws NotFoundException Организация не найдена
    */
    @Override
    public OrganizationDto findById(Integer id) throws NotFoundException {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Организация с ИД: %s не найдена", id)));
        return organizationMapper.toOrganizationDto(organization);
    }
}
