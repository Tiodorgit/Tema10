package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.LoginService;
import bg.tu_varna.sit.inventory.common.Constants;
import bg.tu_varna.sit.inventory.presentation.models.AccountablePersonListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.AdminListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventory.common.Constants.View.ADMIN_VIEW;

public class LoginScreenController {
    public Stage s;
    public static boolean user;
    @FXML
    private Button loginButton;
    @FXML
    private RadioButton asAdmin;
    @FXML
    private RadioButton asAccountablePerson;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public LoginScreenController(){ }
    public LoginScreenController(Stage stage) {
        s = stage;
    }
    private final LoginService logService=LoginService.getInstance();

    @FXML
    public void userLogin(ActionEvent actionEvent){
        AccountablePersonListViewModel molFind = new AccountablePersonListViewModel();
        AdminListViewModel adminFind = new AdminListViewModel();
        if(username.getText() == "" || password.getText() == "") {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Please,fill all fields!", ButtonType.OK);
            alert.show();
        }
        else {

            if(asAdmin.isSelected()){
                adminFind = new AdminListViewModel(username.getText(), password.getText());
                user = true;
                Constants.User.mol = null;
            }
            else if(asAccountablePerson.isSelected()) {
                molFind = new AccountablePersonListViewModel(username.getText(), password.getText());
                user = false;
                Constants.User.mol = molFind;
            }
            if (logService.isAdminExist(adminFind) || logService.isAccountablePersonExist(molFind))
            {
                try {
                    s.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_VIEW));
                    Stage stage = new Stage();
                    fxmlLoader.setController(new AdminController(stage));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setScene(new Scene(root1));
                    stage.setResizable(false);
                    stage.show();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"User not found!", ButtonType.OK);
                alert.show();
                username.setText("");
                password.setText("");
            }
        }
    }
}
