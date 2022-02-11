package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.AdminsEntity;
import bg.tu_varna.sit.inventory.presentation.models.AdminListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        this.adminService = AdminService.getInstance();
    }

    @Test
    void getAllAdmin() {
        ObservableList<AdminListViewModel> adminListViewModels = adminService.getAllAdmin();
        assertEquals(adminListViewModels,adminService.getAllAdmin());
    }
}