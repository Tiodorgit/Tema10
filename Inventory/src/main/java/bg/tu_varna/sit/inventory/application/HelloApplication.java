package bg.tu_varna.sit.inventory.application;

import bg.tu_varna.sit.inventory.common.Constants;
import bg.tu_varna.sit.inventory.presentation.controllers.LoginScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    private static final Logger log = Logger.getLogger(HelloApplication.class);

    @Override
    public void start(Stage stage) throws IOException {

        PropertyConfigurator.configure(HelloApplication.class.getResource(Constants.Configurations.LOG4J_PROPERTIES));
        URL path = getClass().getResource(Constants.View.LOGIN_VIEW);

        if(path != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(path);
            fxmlLoader.setController(new LoginScreenController(stage));
            Parent root = FXMLLoader.load(path);

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);

            stage.setTitle(Constants.Values.Title);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setWidth(1024);
            stage.setHeight(768);
            stage.show();
        } else {
            log.error("Sorry, the main fxm could not be loaded.");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        launch();
    }


}