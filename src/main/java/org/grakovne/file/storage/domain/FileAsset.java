package org.grakovne.file.storage.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class FileAsset implements FileStorageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private Long id;
    private String name;
    private String fileName;
    private String hash;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime createdDateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime expiringDateTime;

    public FileAsset() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getExpiringDateTime() {
        return expiringDateTime;
    }

    public void setExpiringDateTime(LocalDateTime expiringDateTime) {
        this.expiringDateTime = expiringDateTime;
    }

    @Override
    public String toString() {
        return "FileAsset{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", fileName='" + fileName + '\'' +
            ", hash='" + hash + '\'' +
            ", createdDateTime=" + createdDateTime +
            ", expiringDateTime=" + expiringDateTime +
            '}';
    }
}
