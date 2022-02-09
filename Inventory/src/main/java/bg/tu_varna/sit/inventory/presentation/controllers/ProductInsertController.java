package bg.tu_varna.sit.inventory.presentation.controllers;

import bg.tu_varna.sit.inventory.business.services.*;
import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.data.entities.DegreeOfDepricationEntity;
import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;
import bg.tu_varna.sit.inventory.presentation.models.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ProductInsertController implements Initializable {
    Stage s;
    private final ProductService productService = ProductService.getInstance();
    private final TypeService typeService = TypeService.getInstance();
    private final StateService stateService = StateService.getInstance();
    private final AccountablePersonService accountablePersonService = AccountablePersonService.getInstance();
    private final DegreeOfDepricationService degreeOfDepricationService = DegreeOfDepricationService.getInstance();

    @FXML
    private TextField ProductDescriptionTextField;
    @FXML
    private RadioButton dmaRadioButton;
    @FXML
    private RadioButton maRadioButton;
    @FXML
    private DatePicker ProductDateOfRegistrationTextBox;
    @FXML
    private ComboBox<DegreeOfDepricationListViewModel> ProductDegreeOfAmortizationTextField;
    @FXML
    private TextField ProductWarrantyTextField;
    @FXML
    private Button InsertIntoProductButton;
    @FXML
    private Button BackButtonProduct;
    @FXML
    private ComboBox<AccountablePersonListViewModel> accountablePersonComboBox;
    public boolean MAOrDMA = true;

    public ProductInsertController(Stage stage){
        s=stage;
    }

    @FXML
    public void ClickInsertIntoProductButton(){
        TypesEntity type = new TypesEntity();
        DegreeOfDepricationEntity degree = new DegreeOfDepricationEntity();
        if(MAOrDMA){
            type = typeService.listViewToEntity(new TypeListViewModel("ДМА"));
            degree = degreeOfDepricationService.listViewToEntity(ProductDegreeOfAmortizationTextField.getValue());
        }
        else {
            type = typeService.listViewToEntity(new TypeListViewModel("МА"));
            degree = null;
        }
        ProductListViewModel productListViewModel = new ProductListViewModel(
                ProductDescriptionTextField.getText(),
                type,
                ProductDateOfRegistrationTextBox.getValue(),
                Integer.parseInt(ProductWarrantyTextField.getText()),
                degree,
                stateService.listViewToEntity(new StateListViewModel("добро")),
                true,
                accountablePersonService.listViewToEntity(accountablePersonComboBox.getValue())
        );
        productService.addProduct(productListViewModel);
    }
    @FXML
    public void OnClickBackProduct(){

    }
    @FXML
    public void dmaSelect(){
        MAOrDMA = true;
        ProductDegreeOfAmortizationTextField.setDisable(false);
        ProductWarrantyTextField.setDisable(false);
        ProductWarrantyTextField.setText("");
    }

    @FXML
    public void maSelect(){
        MAOrDMA = false;
        ProductDegreeOfAmortizationTextField.setDisable(true);
        ProductWarrantyTextField.setDisable(true);
        ProductWarrantyTextField.setText("1");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<AccountablePersonListViewModel> accountablePersonListViewModels = AccountablePersonService.getInstance().getAllAccountablePerson();
        accountablePersonComboBox.setItems(accountablePersonListViewModels);
        ObservableList<DegreeOfDepricationListViewModel> degreeOfDepricationListViewModels = DegreeOfDepricationService.getInstance().getAllDegreeOfDeprication();
        ProductDegreeOfAmortizationTextField.setItems(degreeOfDepricationListViewModels);
    }
}
