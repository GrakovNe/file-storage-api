package org.grakovne.file.storage.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.config")
public class ConfigurationProvider {

    private String fileUploadDirectory;

    private Integer pageSize;

    private Integer expirationDays;

    private Integer maxExpirationDays;

    public String getFileUploadDirectory() {
        return fileUploadDirectory;
    }

    public void setFileUploadDirectory(String fileUploadDirectory) {
        this.fileUploadDirectory = fileUploadDirectory;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(Integer expirationDays) {
        this.expirationDays = expirationDays;
    }

    public Integer getMaxExpirationDays() {
        return maxExpirationDays;
    }

    public void setMaxExpirationDays(Integer maxExpirationDays) {
        this.maxExpirationDays = maxExpirationDays;
    }
}
