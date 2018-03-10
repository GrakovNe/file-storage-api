package org.grakovne.file.storage.maintenance;

import org.grakovne.file.storage.maintenance.actions.MaintenanceAction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    private final List<MaintenanceAction> actions;

    public MaintenanceService(List<MaintenanceAction> actions) {
        this.actions = actions;
    }

    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void maintenanceConfigure() {
        try {
            actions.forEach(MaintenanceAction::execute);
        } catch (Exception ignored) {

        }
    }
}