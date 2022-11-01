package com.acme.model;

import lombok.Data;

import java.time.ZonedDateTime;
@Data
public class AuditInfo {

    private String createdBy;
    private String lastModifiedBy;
    private ZonedDateTime createdDate;
    private ZonedDateTime lastModifiedDate;
}
