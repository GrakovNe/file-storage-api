package org.grakovne.file.storage.repository;

import org.grakovne.file.storage.domain.FileAsset;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FileAssetRepository extends FileStorageRepository<FileAsset> {
    Optional<FileAsset> findByHash(String hash);

    Optional<FileAsset> findById(Long id);

    Optional<FileAsset> findByFileName(String fileName);

    List<FileAsset> findByExpiringDateTimeBefore(LocalDateTime time);
}
