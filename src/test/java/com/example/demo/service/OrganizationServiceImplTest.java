package com.example.demo.service;

import com.example.demo.dto.mapper.OrganizationMapper;
import com.example.demo.dto.model.OrganizationDto;
import com.example.demo.entity.Organization;
import com.example.demo.repository.OrganizationRepository;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationServiceImplTest {

    @Mock
    private OrganizationRepository organizationRepository;

    @Mock
    private OrganizationMapper organizationMapper;

    @InjectMocks
    private OrganizationServiceImpl organizationService;

    @Test
    public void testFindByNameContaining() {
        String name = "test";
        List<Organization> organizations = new ArrayList<>();
        organizations.add(new Organization());
        List<OrganizationDto> organizationDtos = new ArrayList<>();
        organizationDtos.add(new OrganizationDto());

        when(organizationRepository.findByNameContaining(name)).thenReturn(organizations);
        when(organizationMapper.toListOrganizationDto(organizations)).thenReturn(organizationDtos);

        List<OrganizationDto> result = organizationService.findByNameContaining(name);

        assertNotNull(result);
        verify(organizationRepository, times(1)).findByNameContaining(name);
        verify(organizationMapper, times(1)).toListOrganizationDto(organizations);
    }

    @Test
    public void testFindById() throws NotFoundException {
        Integer id = 1;
        Organization organization = new Organization();

        when(organizationRepository.findById(id)).thenReturn(Optional.of(organization));
        when(organizationMapper.toOrganizationDto(organization)).thenReturn(new OrganizationDto());

        OrganizationDto result = organizationService.findById(id);

        assertNotNull(result);
        verify(organizationRepository, times(1)).findById(id);
        verify(organizationMapper, times(1)).toOrganizationDto(organization);
    }

    @Test(expected = NotFoundException.class)
    public void testFindByIdNotFound() throws NotFoundException {
        Integer id = 1;

        when(organizationRepository.findById(id)).thenReturn(Optional.empty());

        organizationService.findById(id);
        throw new NotFoundException("Organization not found");
    }
}