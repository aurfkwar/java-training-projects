package com.acme.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.ZonedDateTime;

@Data
@Embeddable
public class AuditInfo {

    private String createdBy;
    private String lastModifiedBy;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;

}
