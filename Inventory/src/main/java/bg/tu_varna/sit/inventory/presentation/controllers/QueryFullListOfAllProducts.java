package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import bg.tu_varna.sit.inventory.business.services.ProductService;
import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.data.entities.DegreeOfDepricationEntity;
import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;
import bg.tu_varna.sit.inventory.presentation.models.ProductListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class QueryFullListOfAllProducts {
    Stage s;
    private final AdminService adminService = AdminService.getInstance();

    public QueryFullListOfAllProducts(Stage stage) {
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
    @FXML
    public void getAllProducts(){
        if(myFromDate==null || myToDate==null)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
            alert.show();
        }
      /*  else {
            ObservableList<ProductListViewModel> productsInPeriod = ProductService.getAllProductsList(myFromDate, myToDate);
            allProdTable.setItems(productsInPeriod);
        }*/
    }
/*    *//*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inventoryCol.setCellValueFactory(new PropertyValueFactory<>("idInventoryNumber"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("prodType"));
        statCol.setCellValueFactory(new PropertyValueFactory<>("prodStatus"));
        expCol.setCellValueFactory(new PropertyValueFactory<>("exploatationStart"));
        valueCol.setCellValueFactory(new PropertyValueFactory<>("productValue"));
        molCol.setCellValueFactory(new PropertyValueFactory<>("byMol"));
        amortCol.setCellValueFactory(new PropertyValueFactory<>("byAmortization"));
        disCol.setCellValueFactory(new PropertyValueFactory<>("discardDate"));
        allProdTable.getStyleClass().add("bg-1");
        allProdTable.setPadding(new Insets(5));
        *//*

    }*/



}