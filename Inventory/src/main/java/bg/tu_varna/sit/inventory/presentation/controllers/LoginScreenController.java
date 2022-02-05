package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import bg.tu_varna.sit.inventory.business.services.LoginService;
import bg.tu_varna.sit.inventory.presentation.models.AccountablePersonListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.AdminListViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventory.common.Constants.View.ACCOUNTABLE_PERSON_VIEW;
import static bg.tu_varna.sit.inventory.common.Constants.View.ADMIN_VIEW;

public class LoginScreenController {
    Stage s = new Stage();

    public static boolean whichUser;

    @FXML
    private Button loginButton;
    @FXML
    private Button exitButton;
    @FXML
    private RadioButton asAdmin;
    @FXML
    private RadioButton asAccountablePerson;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    public LoginScreenController(){ }
    public LoginScreenController(Stage stage) {
        s = stage;
    }
    private final LoginService logService=LoginService.getInstance();

    @FXML
    public void userLogin(ActionEvent actionEvent){
        if(username.getText().equals("") || password.getText().equals("")){

        }
        else {
            if(asAdmin.isSelected()){
                AdminListViewModel adminFind = new AdminListViewModel(username.getText(), password.getText());
                if (logService.isAdminExist(adminFind))
                {
                    try
                    {   whichUser=false;
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
                else
                {
                    //wrongLogin.setText("No such Admin!");
                    username.setText("");
                    password.setText("");
                }
            }
            else if(asAccountablePerson.isSelected()) {
                AccountablePersonListViewModel molFind = new AccountablePersonListViewModel(username.getText(), password.getText());

                if (logService.isAccountablePersonExist(molFind))
                {
                    try
                    {
                        whichUser=true;
                        s.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ACCOUNTABLE_PERSON_VIEW));
                        Stage stage = new Stage();
                        fxmlLoader.setController(new AccountablePersonController(stage));
                        Parent root2 = fxmlLoader.load();
                        stage.setScene(new Scene(root2));
                        stage.show();
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    //wrongLogin.setText("No such Mol!");
                    username.setText("");
                    password.setText("");
                }
            }
        }
    }
}
