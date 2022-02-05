package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminController {
    Stage s;
    private final AdminService adminService = AdminService.getInstance();

    @FXML
    private Button logOut;
    @FXML
    private Button insertAccountablePersonButton;
    @FXML
    private Button insertCustomerButton;
    @FXML
    private Button insertProductButton;
    @FXML
    private Button insertCustomerCardboardButton;
    @FXML
    private Button insertDefectiveProductButton;
    @FXML
    private Button queryCustomerCardboardButton;
    @FXML
    private Button queryAllProductsButton;
    @FXML
    private Button queryByDMAOrDAButton;
    @FXML
    private Button queryDefectiveProductsButton;
    @FXML
    private Button queryStatosOfProductButton;
    @FXML
    private Button logOutButton;

    public AdminController(Stage stage){
        s=stage;
    }
}
