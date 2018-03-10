package org.grakovne.file.storage.exception;

import org.grakovne.file.storage.domain.FileStorageEntity;

public class InvalidEntityException extends FileStorageException {

    public InvalidEntityException(Class<? extends FileStorageEntity> entity) {
        this(entity, "");
    }

    public InvalidEntityException(Class<? extends FileStorageEntity> entity, String message) {
        super("Invalid entity: " + entity.getSimpleName() + " caused by: " + message);
    }
}
