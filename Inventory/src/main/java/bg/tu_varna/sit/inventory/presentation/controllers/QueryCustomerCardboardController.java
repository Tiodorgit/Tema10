package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import bg.tu_varna.sit.inventory.business.services.CardboardService;
import bg.tu_varna.sit.inventory.business.services.CustomerService;
import bg.tu_varna.sit.inventory.data.entities.CustomersEntity;
import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;
import bg.tu_varna.sit.inventory.presentation.models.CardboardListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.CustomerListViewModel;
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
import java.time.LocalTime;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.inventory.common.Constants.View.ADMIN_VIEW;

public class QueryCustomerCardboardController implements Initializable {
        Stage s;
    private final CardboardService cardboardService = CardboardService.getInstance();
    private final CustomerService customerService = CustomerService.getInstance();
    public QueryCustomerCardboardController(Stage stage){
        s=stage;
    }
    @FXML
    private ComboBox<CustomerListViewModel> ClientIdChoiceBox;
    @FXML
    private TableView<CardboardListViewModel> cardBoardTableView;
    @FXML
    private TableColumn<CardboardListViewModel, CustomersEntity> customerTableColumn;
    @FXML
    private TableColumn<CardboardListViewModel, ProductsEntity> productTableColumn;
    @FXML
    private TableColumn<CardboardListViewModel, LocalTime> dateTakenTableColumn;
    @FXML
    private TableColumn<CardboardListViewModel, LocalTime> dateReturnTableColumn;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;

    @FXML
    public void OnQueryStart() {
        if(startDatePicker.getValue() == null || endDatePicker.getValue() == null || ClientIdChoiceBox.getValue() == null) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
            alert.show();
        }
        else {
            ObservableList<CardboardListViewModel> cardboardListViewModels = cardboardService.getProductsByCustomerDuringThePeriod(startDatePicker.getValue(), endDatePicker.getValue(), customerService.listViewToEntity(ClientIdChoiceBox.getValue()));
            cardBoardTableView.setItems(cardboardListViewModels);
        }
    }

    @FXML
    public void onGoBack() {
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
        customerTableColumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
        productTableColumn.setCellValueFactory(new PropertyValueFactory<>("product"));
        dateTakenTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateTaken"));
        dateReturnTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateReturn"));

        ObservableList<CustomerListViewModel> customers = customerService.getAllCustomers();
        ClientIdChoiceBox.setItems(customers);
    }
}
