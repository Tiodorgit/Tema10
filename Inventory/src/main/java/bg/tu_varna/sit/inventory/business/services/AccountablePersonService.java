package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.data.repositories.AccountablePersonRepository;
import bg.tu_varna.sit.inventory.presentation.models.AccountablePersonListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class AccountablePersonService {
    private final AccountablePersonRepository repositoryAccountablePerson = AccountablePersonRepository.getInstance();
    private static final Logger log= Logger.getLogger(AdminService.class);

    public static AccountablePersonService getInstance(){
        return AccountablePersonService.AccountablePersonServiceHolder.INSTANCE;
    }

    private static class AccountablePersonServiceHolder {
        public static final AccountablePersonService INSTANCE = new AccountablePersonService();
    }

    public ObservableList<AccountablePersonListViewModel> getAllAccountablePerson(){
        List<AccountablePersonsEntity> mols = repositoryAccountablePerson.getAll();
        if(mols!= null) {
            return FXCollections.observableList(
                    mols.stream().map(m -> new AccountablePersonListViewModel(m.getUsername(), m.getPassword()
                    )).collect(Collectors.toList()));
        }
        else
        {
            log.error("Cannot find any mols in database!");
            return null;
        }
    }

    public AccountablePersonsEntity listViewToEntity(AccountablePersonListViewModel m){
        AccountablePersonsEntity temp = new AccountablePersonsEntity(m.getUsername(),m.getPassword());
        List<AccountablePersonsEntity> mols = repositoryAccountablePerson.getAll();
        for (AccountablePersonsEntity mol: mols) {
            if(mol.equals(temp))
                return mol;
        }
        return null;
    }
}
