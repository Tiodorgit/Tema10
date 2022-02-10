package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import bg.tu_varna.sit.inventory.business.services.DefectiveProductService;
import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.data.entities.DegreeOfDepricationEntity;
import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;
import bg.tu_varna.sit.inventory.presentation.models.DefectiveProductListViewModel;
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

public class QueryToDefectiveProductsController implements Initializable {
    Stage s;
    private final DefectiveProductService defectiveProductService = DefectiveProductService.getInstance();

    public QueryToDefectiveProductsController(Stage stage) {
        s = stage;
    }

    @FXML
    private Button defectiveProductsQueryButton;
    @FXML
    private Button goBackButton;
    @FXML
    private TableView<DefectiveProductListViewModel> allProductsTableView;
    @FXML
    private TableColumn<DefectiveProductListViewModel, Integer> inventoryNumberTableColumn;
    @FXML
    private TableColumn<DefectiveProductListViewModel, String> descriptionTableColumn;
    @FXML
    private TableColumn<DefectiveProductListViewModel, TypesEntity> typeTableColumn;
    @FXML
    private TableColumn<DefectiveProductListViewModel, LocalDate> dateOfRegistrationTableColumn;
    @FXML
    private TableColumn<DefectiveProductListViewModel, Integer> warrantyTableColumn;
    @FXML
    private TableColumn<DefectiveProductListViewModel, DegreeOfDepricationEntity> depreciationDegreeTableColumn;
    @FXML
    private TableColumn<DefectiveProductListViewModel, StatesEntity> StateTableColumn;
    @FXML
    private TableColumn<DefectiveProductListViewModel, Boolean> StatusTableColumn;
    @FXML
    private TableColumn<DefectiveProductListViewModel, AccountablePersonsEntity> acountablePersonTableColumn;
    @FXML
    private TableColumn<DefectiveProductListViewModel, LocalDate> dateOfScrappingTableColumn;
    @FXML
    DatePicker startDatePicker;
    @FXML
    DatePicker endDatePicker;

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
    public void onDefectiveProductQerry(){
        if(localDateStart == null || localDateEnd == null){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
            alert.show();
        }
        else {
            ObservableList<DefectiveProductListViewModel> defectiveProductListViewModels = defectiveProductService.getAllDefectiveProducts(localDateStart,localDateEnd);
            allProductsTableView.setItems(defectiveProductListViewModels);
        }
    }

    @FXML
    public void onGoBack(){
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
        dateOfScrappingTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfScrapping"));
    }
}
