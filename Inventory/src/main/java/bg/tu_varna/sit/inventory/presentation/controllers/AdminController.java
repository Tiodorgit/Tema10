package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.inventory.common.Constants.View.*;
import static bg.tu_varna.sit.inventory.presentation.controllers.LoginScreenController.user;

public class AdminController implements Initializable {
    Stage s;
    private final AdminService adminService = AdminService.getInstance();

    @FXML
    private Button logOutButton;
    @FXML
    private MenuItem insertCustomerMenuItem;
    @FXML
    private MenuItem insertProductMenuItem;
    @FXML
    private MenuItem insertCardboardMenuItem;
    @FXML
    private MenuItem insertDefectiveProductMenuItem;
    @FXML
    private MenuItem insertAccountablePersonMenuItem;
    @FXML
    private MenuItem queryCustomerCardboardButton;
    @FXML
    private MenuItem queryAllProductsButton;
    @FXML
    private MenuItem queryByDMAOrDAButton;
    @FXML
    private MenuItem queryDefectiveProductsButton;
    @FXML
    private MenuItem queryStatusOfProductButton;

    public AdminController() {   }

    public AdminController(Stage stage){
        s=stage;
    }

    @FXML
    public void customerInsertByUser() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CUSTOMER_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new AddCustomerController(stage));
            Parent root3 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void productInsert() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PRODUCT_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new ProductInsertController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void customerCardBoardInsert() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CARDBOARD_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new CustomerCardBoardInsertController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void accountablePersonInsert() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ACCOUNTABLE_PERSON_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new AccountablePersonInsertController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void defectiveProductInsert() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DEFECTIVE_PRODUCT_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new DefectiveProductInsertController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void OnClickQueryCustomerCardboard(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(QUERY_CUSTOMER_CARDBOARD_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new QueryCustomerCardboardController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }


    }
    @FXML
    public void OnClickFullListOfAllProducts(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(QUERY_FULL_LIST_OF_PRODUCTS_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new QueryFullListOfAllProducts(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void OnClickFullListOfProductsByCategory(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(QUERY_FULL_LIST_OF_PRODUCTS_BY_CATEGORY_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new QueryFullListOfAllProductsByCategoryController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void OnClickQueryToDefectiveProducts(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(QUERY_DEFECTIVE_PRODUCTS_CONTROLLER));
            Stage stage = new Stage();
            fxmlLoader.setController(new QueryToDefectiveProductsController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void OnClickQueryToStatusOfProducts(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(QUERY_STATUS_OF_PRODUCTS_CONTROLLER));
            Stage stage = new Stage();
            fxmlLoader.setController(new QueryToStatusOfProductsController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void onLogOutClick(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(LOGIN_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new LoginScreenController(stage));
            Parent root1 = fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!user){
            insertAccountablePersonMenuItem.setVisible(false);
        }
    }
}
