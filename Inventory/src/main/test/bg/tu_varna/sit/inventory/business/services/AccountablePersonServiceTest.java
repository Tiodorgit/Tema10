package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.presentation.models.AccountablePersonListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountablePersonServiceTest {
    private AccountablePersonService accountablePersonService;
    private AccountablePersonListViewModel accountablePersonListViewModel;

    @BeforeEach
    void setUp() {
        this.accountablePersonService = AccountablePersonService.getInstance();
        accountablePersonListViewModel = new AccountablePersonListViewModel("mol", "mol1");
    }

    @Test
    void createAccountablePerson() {
        assertEquals(false,accountablePersonService.createAccountablePerson(accountablePersonListViewModel));
    }

    @Test
    void getAllAccountablePerson() {
        ObservableList<AccountablePersonListViewModel> accountablePersonListViewModels = accountablePersonService.getAllAccountablePerson();
        assertEquals(accountablePersonListViewModels, accountablePersonService.getAllAccountablePerson());
    }

    @Test
    void listViewToEntity() {
        AccountablePersonListViewModel accountablePersonListViewModel1 = new AccountablePersonListViewModel("m","m");
        Assertions.assertNull(accountablePersonService.listViewToEntity(accountablePersonListViewModel1));
    }
}