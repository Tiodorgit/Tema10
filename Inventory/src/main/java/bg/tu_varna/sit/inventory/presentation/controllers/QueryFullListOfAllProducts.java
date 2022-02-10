package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.ProductService;
import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.data.entities.DegreeOfDepricationEntity;
import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;
import bg.tu_varna.sit.inventory.presentation.models.ProductListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.inventory.common.Constants.View.ADMIN_VIEW;

public class QueryFullListOfAllProducts implements Initializable {
    Stage s;
    private final ProductService productService = ProductService.getInstance();

    @FXML
    private Button ShowFullListOfProducts;
    @FXML
    private Button goBackButton;
    @FXML
    private TableView<ProductListViewModel> allProductsTableView;
    @FXML
    private TableColumn<ProductListViewModel, Integer> inventoryNumberTableColumn;
    @FXML
    private TableColumn<ProductListViewModel, String> descriptionTableColumn;
    @FXML
    private TableColumn<ProductListViewModel, TypesEntity> typeTableColumn;
    @FXML
    private TableColumn<ProductListViewModel, LocalDate> dateOfRegistrationTableColumn;
    @FXML
    private TableColumn<ProductListViewModel, Integer> warrantyTableColumn;
    @FXML
    private TableColumn<ProductListViewModel, DegreeOfDepricationEntity> depreciationDegreeTableColumn;
    @FXML
    private TableColumn<ProductListViewModel, StatesEntity> StateTableColumn;
    @FXML
    private TableColumn<ProductListViewModel, Boolean> StatusTableColumn;
    @FXML
    private TableColumn<ProductListViewModel, AccountablePersonsEntity> acountablePersonTableColumn;
    @FXML
    DatePicker startDatePicker;
    @FXML
    DatePicker endDatePicker;

    public QueryFullListOfAllProducts(Stage stage) {
        this.s = stage;
    }

    public QueryFullListOfAllProducts() {
    }

    LocalDate localDateStart;
    @FXML
    public void getStartDate(){
        localDateStart = startDatePicker.getValue();
    }

    LocalDate localDateEnd;
    @FXML
    public void getEndDate(){
        localDateEnd = endDatePicker.getValue();
    }

    @FXML
    public void OnClickShowFullListOfProducts(){
        if(localDateStart == null || localDateEnd == null){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
            alert.show();
        }
        else {
            ObservableList<ProductListViewModel> productListViewModels = productService.getAllProductsDuringThePeriod(localDateStart,localDateEnd);
            allProductsTableView.setItems(productListViewModels);
        }
    }

    @FXML
    public void OnClickBackFromFullListOfAllProducts(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new AdminController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inventoryNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("inventoryNumber"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        typeTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeID"));
        dateOfRegistrationTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfRegistration"));
        warrantyTableColumn.setCellValueFactory(new PropertyValueFactory<>("warranty"));
        depreciationDegreeTableColumn.setCellValueFactory(new PropertyValueFactory<>("degreeOfDepreciation"));
        StateTableColumn.setCellValueFactory(new PropertyValueFactory<>("stateID"));
        StatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        acountablePersonTableColumn.setCellValueFactory(new PropertyValueFactory<>("accountablePersons"));
    }
}
