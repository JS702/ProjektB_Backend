package com.example.ProjektB.domainobject;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;

public class DefaultObject {

    @Id
    private String id;

    @CreatedDate
    private ZonedDateTime dateCreated;

    @LastModifiedDate
    private ZonedDateTime dateUpdated;

    private boolean deleted;


    public boolean isDeleted() {
        return this.deleted;
    }

    public DefaultObject() {
        super();
        this.dateCreated = ZonedDateTime.now();
        this.deleted = false;
    }

    public DefaultObject( final String id ) {
        super();
        this.id = id;
        this.dateCreated = ZonedDateTime.now();
        this.deleted = false;
    }
}
