package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.data.entities.DegreeOfDepricationEntity;
import bg.tu_varna.sit.inventory.data.repositories.DegreeOfDepricationRepository;
import bg.tu_varna.sit.inventory.presentation.models.AccountablePersonListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.DegreeOfDepricationListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class DegreeOfDepricationService {
    private final DegreeOfDepricationRepository repository = DegreeOfDepricationRepository.getInstance();
    private static final Logger log = Logger.getLogger(DegreeOfDepricationService.class);
    public static DegreeOfDepricationService getInstance() {
        return DegreeOfDepricationServiceHolder.INSTANCE;
    }
    private static class DegreeOfDepricationServiceHolder {
        public static final DegreeOfDepricationService INSTANCE = new DegreeOfDepricationService();
    }

    public ObservableList<DegreeOfDepricationListViewModel> getAllDegreeOfDeprication(){
        List<DegreeOfDepricationEntity> degree = repository.getAll();
        if(degree!= null) {
            return FXCollections.observableList(
                    degree.stream().map(m -> new DegreeOfDepricationListViewModel(m.getCategory()
                    )).collect(Collectors.toList()));
        }
        else
        {
            log.error("Cannot find any Degree Of Deprication in database!");
            return null;
        }
    }

    public DegreeOfDepricationEntity listViewToEntity(DegreeOfDepricationListViewModel a){
        DegreeOfDepricationEntity temp = new DegreeOfDepricationEntity(a.getCategory());
        List<DegreeOfDepricationEntity> degrees = repository.getAll();
        for (DegreeOfDepricationEntity degree: degrees) {
            if(degree.equals(temp))
                return degree;
        }
        return null;
    }
}
