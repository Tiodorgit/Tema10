package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.DefectiveProductsEntity;
import bg.tu_varna.sit.inventory.data.repositories.DefectiveProductRepository;
import bg.tu_varna.sit.inventory.presentation.models.DefectiveProductListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.ProductListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefectiveProductService {
    private final DefectiveProductRepository repository = DefectiveProductRepository.getInstance();
    private static final Logger log = Logger.getLogger(DefectiveProductService.class);
    public static DefectiveProductService getInstance() {
        return DefectiveProductServiceHolder.INSTANCE;
    }

    public void addDefectiveProduct(DefectiveProductListViewModel a) {
        DefectiveProductsEntity defectiveProducts = new DefectiveProductsEntity(a.getInventoryNumber(),a.getDescription(),a.getTypeID(),a.getDateOfRegistration(),a.getWarranty(),a.getDegreeOfDepreciation(),a.getStateID(),a.isStatus(),a.getAccountablePersons(),a.getDateOfScrapping());
        repository.save(defectiveProducts);
    }

    public List<DefectiveProductsEntity> getAllDefectiveProducts() {
        List<DefectiveProductsEntity> defectiveProductsEntities = repository.getAll();

        return defectiveProductsEntities;
    }

    public ObservableList<DefectiveProductListViewModel> getAllDefectiveProducts(LocalDate localDateStart, LocalDate localDateEnd) {
        List<DefectiveProductsEntity> defectiveProductsEntities = repository.getAll();
        List<DefectiveProductsEntity> allDefectiveProductsDuringThePeriod = new ArrayList<>();
        for(DefectiveProductsEntity d: defectiveProductsEntities) {
            if(d.getDateOfScrapping().isAfter(localDateStart) && d.getDateOfScrapping().isBefore(localDateEnd)) {
                allDefectiveProductsDuringThePeriod.add(d);
            }
        }

        return FXCollections.observableList(
                allDefectiveProductsDuringThePeriod.stream().map(p -> new DefectiveProductListViewModel(
                        p.getInventoryNumber(),p.getDescription(),p.getTypesByTypeId(),p.getDateOfRegistration(),p.getWaranty(),p.getDegreeOfDepricationByDegreeOfDeprication(),p.getStatesByStateId(),p.getStatus(),p.getAccountablePersonsByAcountablePersonId(),p.getDateOfScrapping()
                )).collect(Collectors.toList()));
    }

    private static class DefectiveProductServiceHolder {
        public static final DefectiveProductService INSTANCE = new DefectiveProductService();
    }


}
