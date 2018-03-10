package org.grakovne.file.storage.maintenance.actions;

import org.grakovne.file.storage.provider.FileStorageProvider;
import org.grakovne.file.storage.service.FileAssetService;
import org.springframework.stereotype.Service;

@Service
public class FileStorageActuator implements MaintenanceAction {

    private final FileAssetService fileAssetService;
    private final FileStorageProvider fileStorageProvider;

    public FileStorageActuator(FileAssetService fileAssetService, FileStorageProvider fileStorageProvider) {
        this.fileAssetService = fileAssetService;
        this.fileStorageProvider = fileStorageProvider;
    }

    @Override
    public void execute() {
        fileStorageProvider
            .getFiles()
            .stream()
            .filter(file -> fileAssetService.findByFileName(file.getName()) == null)
            .forEach(fileStorageProvider::deleteFile);
    }
}
