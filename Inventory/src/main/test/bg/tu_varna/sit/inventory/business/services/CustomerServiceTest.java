package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.repositories.CustomerRepository;
import bg.tu_varna.sit.inventory.presentation.models.CustomerListViewModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {
    private CustomerService customerService;
    private CustomerListViewModel customerListViewModel;
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        this.customerService = CustomerService.getInstance();
        this.customerRepository = CustomerRepository.getInstance();
        this.customerListViewModel = new CustomerListViewModel("CustomerName","CustomerLastName","0881111111");
    }

    @AfterEach
    void tearDown() {
        customerRepository.delete(customerService.listViewToEntity(customerListViewModel));
    }
    @Test
    void listViewToEntity() {
        CustomerListViewModel temp = new CustomerListViewModel("a","a","a");
        Assertions.assertNull(customerService.listViewToEntity(temp));
    }

    @Test
    void getAllCustomers() {
        ObservableList<CustomerListViewModel> customerListViewModels = customerService.getAllCustomers();
        assertEquals(customerListViewModels,customerService.getAllCustomers());
    }

    @Test
    void addCustomer() {
        Assertions.assertTrue(customerService.addCustomer(customerListViewModel));
    }
}