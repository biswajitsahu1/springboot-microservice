package com.college.organizationservice.controller;

import com.college.organizationservice.Dto.OrganizationDto;
import com.college.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name= "Organization service-OrganizationController",
        description = "Organization Controller exposes REST APIs for Organization-service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private OrganizationService organizationService;


    @Operation(
            summary = "Save Organization REST API",
            description = "save Organization object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> save(@RequestBody OrganizationDto organizationDto){
        OrganizationDto saveOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(saveOrganization, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization object in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
        OrganizationDto organization = organizationService.getOrgByCode(organizationCode);
        return ResponseEntity.ok(organization);
    }
}
