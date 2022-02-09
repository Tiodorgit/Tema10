package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.data.entities.DegreeOfDepricationEntity;
import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;
import bg.tu_varna.sit.inventory.presentation.models.ProductListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class QueryToStatusOfProductsController {
    Stage s;
    private final AdminService adminService = AdminService.getInstance();
    public QueryToStatusOfProductsController(Stage stage){
        s=stage;
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
    private TableView<ProductListViewModel> allProdTable;

    @FXML
    private TableColumn<ProductListViewModel, Integer> InventoryNumber;

    @FXML
    private TableColumn<ProductListViewModel, String> Description;

    @FXML
    private TableColumn<ProductListViewModel, TypesEntity> typeID;

    @FXML
    private TableColumn<ProductListViewModel, LocalDate> dateOfRegistration;

    @FXML
    private TableColumn<ProductListViewModel, Integer> warranty;

    @FXML
    private TableColumn<ProductListViewModel, DegreeOfDepricationEntity> degreeOfDepreciation;

    @FXML
    private TableColumn<ProductListViewModel, StatesEntity> stateID;

    @FXML
    private TableColumn<ProductListViewModel, Boolean> status;

    @FXML
    private TableColumn<ProductListViewModel, AccountablePersonsEntity> accountablePersons;

    boolean whatType;
    LocalDate myFromDate;
    LocalDate myToDate;



    @FXML
    public void getFromDate()
    {
        myFromDate=fromDate.getValue();
    }

    @FXML
    public void getToDate(){

        myToDate=toDate.getValue();
    }

    }





