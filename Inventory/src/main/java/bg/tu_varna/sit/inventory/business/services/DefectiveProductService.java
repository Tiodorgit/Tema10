package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.DefectiveProductsEntity;
import bg.tu_varna.sit.inventory.data.repositories.DefectiveProductRepository;
import bg.tu_varna.sit.inventory.presentation.models.DefectiveProductListViewModel;
import org.apache.log4j.Logger;

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

    private static class DefectiveProductServiceHolder {
        public static final DefectiveProductService INSTANCE = new DefectiveProductService();
    }


}
