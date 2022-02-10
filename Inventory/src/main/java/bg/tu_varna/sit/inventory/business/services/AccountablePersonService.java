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
    private static final Logger log= Logger.getLogger(AccountablePersonService.class);

    public static AccountablePersonService getInstance(){
        return AccountablePersonService.AccountablePersonServiceHolder.INSTANCE;
    }

    public boolean createAccountablePerson(AccountablePersonListViewModel u) {
        AccountablePersonsEntity user = new AccountablePersonsEntity(u.getUsername(), u.getPassword());
        if(checkIfAccountablePersonExist(user)){
            log.info("Accountable person " + u + "already exists!");
            return false;
        }
        else {
            try {
                repositoryAccountablePerson.save(user);
                log.info("Accountable person " + user.getUsername() + " created!");
            }
            catch (Exception e) {
                log.error("Create admin error!");
            }
            return true;
        }
    }

    private boolean checkIfAccountablePersonExist(AccountablePersonsEntity user) {
        List<AccountablePersonsEntity> accountablePersonsEntityList = repositoryAccountablePerson.getAll();
        for(AccountablePersonsEntity accountablePersons:accountablePersonsEntityList) {
            if(accountablePersons.equals(user)){
                log.info("Accountable Person: " + user.getUsername() + " already exists!");
                return true;
            }
        }
        return false;
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
