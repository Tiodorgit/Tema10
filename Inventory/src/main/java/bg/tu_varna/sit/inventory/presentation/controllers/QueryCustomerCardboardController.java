package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.AdminService;
import javafx.stage.Stage;

public class QueryCustomerCardboardController {
        Stage s;
        private final AdminService adminService = AdminService.getInstance();
        public QueryCustomerCardboardController(Stage stage){
            s=stage;
        }

}
