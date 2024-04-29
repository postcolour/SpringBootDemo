package com.example.demo.dto.mapper;

import com.example.demo.dto.model.OrganizationDto;
import com.example.demo.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationMapper {

    OrganizationDto toOrganizationDto(Organization organization);

    List<OrganizationDto> toListOrganizationDto(List<Organization> organizations);
}
