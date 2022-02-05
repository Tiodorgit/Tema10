package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.presentation.models.AccountablePersonListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.AdminListViewModel;
import javafx.collections.ObservableList;

public class LoginService {
    private final AdminService adminService= AdminService.getInstance();
    private final AccountablePersonService accountablePersonService= AccountablePersonService.getInstance();

    public static LoginService getInstance(){
        return LoginService.LoginServiceHolder.INSTANCE;
    }

    private static class LoginServiceHolder {
        public static final LoginService INSTANCE = new LoginService();
    }

    public boolean isAdminExist(AdminListViewModel ad)
    {
        ObservableList<AdminListViewModel> allAdmins = adminService.getAllAdmin();
        for (AdminListViewModel admin : allAdmins) {
            if (admin.equals(ad)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAccountablePersonExist(AccountablePersonListViewModel m)
    {
        ObservableList<AccountablePersonListViewModel> allAccountablePersons = accountablePersonService.getAllAccountablePerson();
        for (AccountablePersonListViewModel mol : allAccountablePersons) {
            if (mol.equals(m)) {
                return true;
            }
        }
        return false;
    }
}
