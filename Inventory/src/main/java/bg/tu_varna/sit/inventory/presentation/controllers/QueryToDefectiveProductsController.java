package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.data.entities.DegreeOfDepricationEntity;
import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;
import bg.tu_varna.sit.inventory.presentation.models.DefectiveProductListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.ProductListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class QueryToDefectiveProductsController {
    Stage s;
    private final AdminService adminService = AdminService.getInstance();

    public QueryToDefectiveProductsController(Stage stage) {
        s = stage;
    }

    @FXML
    private Button getProductsButton;

    @FXML
    private Button backButton;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private ComboBox TypeEntity;

    @FXML
    private TableView<DefectiveProductListViewModel> allProdTable;

    @FXML
    private TableColumn<DefectiveProductListViewModel, Integer> InventoryNumber;

    @FXML
    private TableColumn<DefectiveProductListViewModel, String> Description;

    @FXML
    private TableColumn<DefectiveProductListViewModel, TypesEntity> typeID;

    @FXML
    private TableColumn<DefectiveProductListViewModel, LocalDate> dateOfRegistration;

    @FXML
    private TableColumn<DefectiveProductListViewModel, Integer> warranty;

    @FXML
    private TableColumn<DefectiveProductListViewModel, DegreeOfDepricationEntity> degreeOfDepreciation;

    @FXML
    private TableColumn<DefectiveProductListViewModel, StatesEntity> stateID;

    @FXML
    private TableColumn<DefectiveProductListViewModel, Boolean> status;

    @FXML
    private TableColumn<DefectiveProductListViewModel, AccountablePersonsEntity> accountablePersons;

    @FXML
    private TableColumn<DefectiveProductListViewModel, LocalDate> dateOfScrapping;

    boolean whatType;
    LocalDate myFromDate;
    LocalDate myToDate;


    @FXML
    public void getFromDate() {
        myFromDate = fromDate.getValue();
    }

    @FXML
    public void getToDate() {

        myToDate = toDate.getValue();
    }
}
