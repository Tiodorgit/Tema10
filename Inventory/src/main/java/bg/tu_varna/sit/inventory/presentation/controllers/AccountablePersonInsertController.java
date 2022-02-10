package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AccountablePersonService;
import bg.tu_varna.sit.inventory.business.services.AdminService;
import bg.tu_varna.sit.inventory.presentation.models.AccountablePersonListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventory.common.Constants.View.ADMIN_VIEW;

public class AccountablePersonInsertController {
        Stage s;
        private final AccountablePersonService accountablePersonService = AccountablePersonService.getInstance();
        @FXML
        private TextField TextBoxUsername;
        @FXML
        private PasswordField TextBoxPassword;

        public AccountablePersonInsertController(Stage stage){
            s=stage;
        }

        @FXML
        public void OnClickGoBackToMenu() {
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

        @FXML
        public void ClickButtonLogin() {
            if(TextBoxUsername.getText().equals("") || TextBoxPassword.getText().equals("")){

            }
            else {
                AccountablePersonListViewModel user = new AccountablePersonListViewModel(TextBoxUsername.getText(), TextBoxPassword.getText());
                if(accountablePersonService.createAccountablePerson(user)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "The Accountable person has been registered successfully!", ButtonType.OK);
                    alert.show();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "The Accountable person has been already added to customer's board!", ButtonType.OK);
                    alert.show();
                }
            }
        }
}
