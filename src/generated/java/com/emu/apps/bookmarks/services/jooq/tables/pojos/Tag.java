/*
 * This file is generated by jOOQ.
*/
package com.emu.apps.bookmarks.services.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tag implements Serializable {

    private static final long serialVersionUID = 1128137570;

    private Long      id;
    private String    uuid;
    private String    libelle;
    private Long      version;
    private Timestamp dateCreation;
    private String    userCreation;
    private Timestamp dateModification;
    private String    userModification;

    public Tag() {}

    public Tag(Tag value) {
        this.id = value.id;
        this.uuid = value.uuid;
        this.libelle = value.libelle;
        this.version = value.version;
        this.dateCreation = value.dateCreation;
        this.userCreation = value.userCreation;
        this.dateModification = value.dateModification;
        this.userModification = value.userModification;
    }

    public Tag(
        Long      id,
        String    uuid,
        String    libelle,
        Long      version,
        Timestamp dateCreation,
        String    userCreation,
        Timestamp dateModification,
        String    userModification
    ) {
        this.id = id;
        this.uuid = uuid;
        this.libelle = libelle;
        this.version = version;
        this.dateCreation = dateCreation;
        this.userCreation = userCreation;
        this.dateModification = dateModification;
        this.userModification = userModification;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Timestamp getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getUserCreation() {
        return this.userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public Timestamp getDateModification() {
        return this.dateModification;
    }

    public void setDateModification(Timestamp dateModification) {
        this.dateModification = dateModification;
    }

    public String getUserModification() {
        return this.userModification;
    }

    public void setUserModification(String userModification) {
        this.userModification = userModification;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tag (");

        sb.append(id);
        sb.append(", ").append(uuid);
        sb.append(", ").append(libelle);
        sb.append(", ").append(version);
        sb.append(", ").append(dateCreation);
        sb.append(", ").append(userCreation);
        sb.append(", ").append(dateModification);
        sb.append(", ").append(userModification);

        sb.append(")");
        return sb.toString();
    }
}
