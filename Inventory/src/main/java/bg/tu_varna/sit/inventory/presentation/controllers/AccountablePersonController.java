package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AccountablePersonService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventory.common.Constants.View.*;
import static bg.tu_varna.sit.inventory.common.Constants.View.QUERY_STATUS_OF_PRODUCTS_CONTROLLER;

public class AccountablePersonController {
    Stage s;
    private final AccountablePersonService adminService = AccountablePersonService.getInstance();

    @FXML
    private Button logOut;

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
    private Button queryStatusOfProductButton;
    @FXML
    private Button logOutButton;

    public AccountablePersonController(Stage stage) {
        s = stage;
    }

    public AccountablePersonController() {
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
}
