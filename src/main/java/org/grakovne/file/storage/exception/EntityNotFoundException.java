package org.grakovne.file.storage.exception;

import org.grakovne.file.storage.domain.FileStorageEntity;

public class EntityNotFoundException extends FileStorageException {

    public EntityNotFoundException(Class<? extends FileStorageEntity> entity) {
        super("Entity not found: " + entity.getSimpleName());
    }
}
