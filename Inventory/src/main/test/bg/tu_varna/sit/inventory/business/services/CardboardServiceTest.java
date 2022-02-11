package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.CardboardsEntity;
import bg.tu_varna.sit.inventory.data.entities.CustomersEntity;
import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;
import bg.tu_varna.sit.inventory.data.repositories.CustomerRepository;
import bg.tu_varna.sit.inventory.data.repositories.ProductRepository;
import bg.tu_varna.sit.inventory.presentation.models.CardboardListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.CustomerListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardboardServiceTest {
    private CardboardService cardboardService;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private CustomersEntity customers;
    private ProductsEntity products;
    private CardboardListViewModel cardboardListViewModel;
    @BeforeEach
    void setUp() {
        this.cardboardService = CardboardService.getInstance();
        this.productRepository = productRepository.getInstance();
        this.products = productRepository.getById(1);
        this.customerRepository = customerRepository.getInstance();
        this.customers = customerRepository.getById(1);
        this.cardboardListViewModel = new CardboardListViewModel(customers, products,LocalDate.now());
    }

    @Test
    void addCardboard() {
        assertEquals(1, cardboardService.addCardboard(cardboardListViewModel));
    }

    @Test
    void getAllBoards() {
        ObservableList<CardboardListViewModel> cardboardListViewModels = cardboardService.getAllBoards();
        assertEquals(cardboardListViewModels,cardboardService.getAllBoards());
    }

    @Test
    void returnProduct() {
        assertTrue(cardboardService.returnProduct(cardboardListViewModel));
    }

    @Test
    void getProductsByCustomerDuringThePeriod() {
        List<CardboardsEntity> temp = new ArrayList<>();
        assertEquals(temp,cardboardService.getProductsByCustomerDuringThePeriod(LocalDate.of(2023,2,1),LocalDate.of(2023, 3, 1),customers));
    }
}