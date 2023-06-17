package com.college.organizationservice.service;

import com.college.organizationservice.Dto.OrganizationDto;

public interface OrganizationService {


    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrgByCode(String code);
}
