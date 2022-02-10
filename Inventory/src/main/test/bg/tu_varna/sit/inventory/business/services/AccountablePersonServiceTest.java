package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.presentation.models.AccountablePersonListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountablePersonServiceTest {
    private AccountablePersonService accountablePersonService;

    @BeforeEach
    void setUp() {
        this.accountablePersonService = AccountablePersonService.getInstance();
    }

    @Test
    void createAccountablePerson() {
    }

    @Test
    void getAllAccountablePerson() {
        ObservableList<AccountablePersonListViewModel> accountablePersonListViewModels = accountablePersonService.getAllAccountablePerson();
        assertEquals(accountablePersonListViewModels, accountablePersonService.getAllAccountablePerson());
    }

    @Test
    void listViewToEntity() {
    }
}