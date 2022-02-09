package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import bg.tu_varna.sit.inventory.business.services.CardboardService;
import bg.tu_varna.sit.inventory.business.services.CustomerService;
import bg.tu_varna.sit.inventory.business.services.ProductService;
import bg.tu_varna.sit.inventory.data.entities.CustomersEntity;
import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;
import bg.tu_varna.sit.inventory.presentation.models.CardboardListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.CustomerListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.ProductListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;


public class CustomerCardBoardInsertController implements Initializable {
    Stage s;
    private final CardboardService cardboardService = CardboardService.getInstance();
    private final CustomerService customerService = CustomerService.getInstance();
    private final ProductService productService = ProductService.getInstance();

    public CustomerCardBoardInsertController(Stage stage){
            s=stage;
        }
    @FXML
    private ComboBox<ProductListViewModel> InventoryNumberChoiceBox;
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
    private Button InsertIntoCardboardButton;
    @FXML
    private Button RemovesFromCardboardButton;
    @FXML
    private Button BackButtonCardboard;

    ObservableList<CardboardListViewModel> temp;
    CardboardListViewModel forRemove;
    int isExist;

    @FXML
    public void OnClickInsertsIntoCardboard(){
        if(InventoryNumberChoiceBox.getValue()==null || ClientIdChoiceBox.getValue()==null) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
                alert.show();
        }
        else{
                temp.clear();
                cardBoardTableView.setItems(temp);
                LocalDate localDate = LocalDate.now();
                CardboardListViewModel addToBoard = new CardboardListViewModel(customerService.listViewToEntity(ClientIdChoiceBox.getValue()),productService.listViewToEntity(InventoryNumberChoiceBox.getValue()),localDate);
                isExist= cardboardService.addCardboard(addToBoard);
            if(isExist==0) {
                Alert alert=new Alert(Alert.AlertType.ERROR,"The product is not available!",ButtonType.OK);
                alert.show();
            }
            else
            {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"The product has been added successfully!",ButtonType.OK);
                alert.show();
            }
            temp = cardboardService.getAllBoards();
            cardBoardTableView.setItems(temp);
        }
    }

    @FXML
    public void getTheRow() {
        forRemove = cardBoardTableView.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void OnClickRemovesFromCardboard(){
        LocalDate localDate = LocalDate.now();
        forRemove.setDateReturn(localDate);
        temp.clear();
        if(cardboardService.returnProduct(forRemove)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"The product has been returned successfully!",ButtonType.OK);
            alert.show();
        }
        else {
            Alert alert=new Alert(Alert.AlertType.WARNING,"The product is already returned!",ButtonType.OK);
            alert.show();
        }
        temp = cardboardService.getAllBoards();
        cardBoardTableView.setItems(temp);
    }
    @FXML
    public void OnClickBackFromCardboard(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerTableColumn.setCellValueFactory(new PropertyValueFactory<>("customer"));
        productTableColumn.setCellValueFactory(new PropertyValueFactory<>("product"));
        dateTakenTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateTaken"));
        dateReturnTableColumn.setCellValueFactory(new PropertyValueFactory<>("dateReturn"));

        temp = cardboardService.getAllBoards();
        cardBoardTableView.setItems(temp);
        fillCustomerID();
        fillProductID();
    }

    private void fillProductID() {
        ObservableList<ProductListViewModel> products = productService.getAllProducts();
        InventoryNumberChoiceBox.setItems(products);
    }

    private void fillCustomerID() {
        ObservableList<CustomerListViewModel> customers = customerService.getAllCustomers();
        ClientIdChoiceBox.setItems(customers);
    }
}

