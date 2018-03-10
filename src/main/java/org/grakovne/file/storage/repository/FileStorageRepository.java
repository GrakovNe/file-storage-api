package org.grakovne.file.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FileStorageRepository<T> extends JpaRepository<T, Long> {

}
