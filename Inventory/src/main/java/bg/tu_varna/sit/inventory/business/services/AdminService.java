package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.AdminsEntity;
import bg.tu_varna.sit.inventory.data.repositories.AdminRepository;
import bg.tu_varna.sit.inventory.presentation.models.AdminListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class AdminService {
    private final AdminService adminService= AdminService.getInstance();
    private static final Logger log = Logger.getLogger(AdminService.class);
    private final AdminRepository repository = AdminRepository.getInstance();
    public static AdminService getInstance() {
        return AdminServiceHolder.INSTANCE;
    }
    public static class AdminServiceHolder {
        public static final AdminService INSTANCE = new AdminService();
    }


    public ObservableList<AdminListViewModel> getAllAdmin() {
        List<AdminsEntity> admins=repository.getAll();

        return FXCollections.observableList(
                admins.stream().map(a -> new AdminListViewModel(
                        a.getUsername(),
                        a.getPassword()
                )).collect(Collectors.toList()));
    }

    public boolean checkIfAdminExists(AdminListViewModel a){
        ObservableList<AdminListViewModel> allAdmins = adminService.getAllAdmin();
        for (AdminListViewModel admin : allAdmins) {
            if (admin.equals(a)) {
                return true;
            }
        }
        return false;
    }
}
