package com.college.organizationservice.rapository;

import com.college.organizationservice.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrganizationRapo extends JpaRepository<Organization, Long> {
    Organization findByOrganizationCode(String organizationCode);

}
