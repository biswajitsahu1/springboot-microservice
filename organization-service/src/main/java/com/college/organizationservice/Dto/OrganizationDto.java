package com.college.organizationservice.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Schema(
        description = "Organization. model information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private long id;
    @Schema(
            description = "Organization Name"
    )
    private String organizationName;
    @Schema(
            description = "Organization Description"
    )
    private String organizationDescription;
    @Schema(
            description = "Organization Code"
    )
    private String organizationCode;
    @Schema(
            description = "Organization CreatedDate"
    )
    private LocalDateTime createdDate;
}
