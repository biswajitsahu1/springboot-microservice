package com.college.organizationservice.service;

import com.college.organizationservice.Dto.OrganizationDto;
import com.college.organizationservice.entities.Organization;
import com.college.organizationservice.rapository.OrganizationRapo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private OrganizationRapo organizationRapo;
    private ModelMapper modelMapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        return modelMapper.map(organizationRapo.save(modelMapper.map(organizationDto, Organization.class)), OrganizationDto.class);
    }
    @Override
    public OrganizationDto getOrgByCode(String organizationCode) {
        Organization organization = organizationRapo.findByOrganizationCode(organizationCode);
        return modelMapper.map(organization, OrganizationDto.class);
    }
}
