package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import bg.tu_varna.sit.inventory.business.services.DefectiveProductService;
import bg.tu_varna.sit.inventory.business.services.ProductService;
import bg.tu_varna.sit.inventory.business.services.StateService;
import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;
import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.presentation.models.DefectiveProductListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.ProductListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.StateListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DefectiveProductInsertController implements Initializable {
        Stage s;
        private final DefectiveProductService defectiveProductService = DefectiveProductService.getInstance();
        private final ProductService productService = ProductService.getInstance();
    private final StateService stateService = StateService.getInstance();

        @FXML
        private Button DefectiveProductBackButton;
        @FXML
        private Button InsertIntoDefectiveProduct;
        @FXML
        private ComboBox<ProductListViewModel> selectProductComboBox;

        @FXML
        public void DefectiveProductBackButton(){

        }

        @FXML
        public void InsertIntoDefectiveProduct(){
            ProductListViewModel products = selectProductComboBox.getValue();
            DefectiveProductListViewModel defectiveProductListViewModel = new DefectiveProductListViewModel(
                    products.getInventoryNumber(),
                    products.getDescription(),
                    products.getTypeID(),
                    products.getDateOfRegistration(),
                    products.getWarranty(),
                    products.getDegreeOfDepreciation(),
                    stateService.listViewToEntity(new StateListViewModel("лошо")),
                    products.isStatus(),
                    products.getAccountablePersons(),
                    LocalDate.now()
            );
            defectiveProductService.addDefectiveProduct(defectiveProductListViewModel);
            productService.deleteProduct(products);
        }

        public DefectiveProductInsertController(Stage stage){
            s=stage;
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<ProductListViewModel> products = productService.getFullProducts();
        selectProductComboBox.setItems(products);
    }
}
