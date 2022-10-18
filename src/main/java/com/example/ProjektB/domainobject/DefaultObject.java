package com.example.ProjektB.domainobject;

import org.springframework.data.annotation.Id;

public class DefaultObject {

    @Id
    private String id;

    private boolean deleted;

    public boolean isDeleted() {
        return this.deleted;
    }

    public DefaultObject() {
        super();
        this.deleted = false;
    }

    public DefaultObject(final String id) {
        super();
        this.id = id;
        this.deleted = false;
    }
}
