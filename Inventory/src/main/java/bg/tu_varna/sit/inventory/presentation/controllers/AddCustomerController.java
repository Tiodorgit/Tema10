package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.CustomerService;
import bg.tu_varna.sit.inventory.presentation.models.CustomerListViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCustomerController {
    private final CustomerService customerService=CustomerService.getInstance();
    Stage s;
    @FXML
    TextField firstNameTextField;
    @FXML
    TextField lastNameTextField;
    @FXML
    TextField phoneNumberTextField;
    @FXML
    Button insertIntoCustomersButton;
    @FXML
    Button goBackButton;

    public AddCustomerController() {
    }

    public AddCustomerController(Stage stage) {
        s = stage;
    }

    @FXML
    public void  onInsertIntoCustomers() {
        CustomerListViewModel customer = new CustomerListViewModel(firstNameTextField.getText(),lastNameTextField.getText(),phoneNumberTextField.getText());
        if(firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("") || phoneNumberTextField.getText().equals("")) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
            alert.show();
        }
        else {
            if (customerService.addCustomer(customer)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The customer has been registered successfully!", ButtonType.OK);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "The customer has been already added to customer's board!", ButtonType.OK);
                alert.show();
            }
        }
    }

    @FXML
    public void onGoBack() {

    }
}
