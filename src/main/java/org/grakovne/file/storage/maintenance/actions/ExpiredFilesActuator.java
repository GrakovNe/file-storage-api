package org.grakovne.file.storage.maintenance.actions;

import org.grakovne.file.storage.service.FileAssetService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExpiredFilesActuator implements MaintenanceAction {

    private final FileAssetService fileAssetService;

    public ExpiredFilesActuator(FileAssetService fileAssetService) {
        this.fileAssetService = fileAssetService;
    }

    @Override
    public void execute() {

        fileAssetService.findExpiredFiles()
            .forEach(fileAsset -> fileAssetService.deleteFileAsset(fileAsset.getId()));
    }
}
