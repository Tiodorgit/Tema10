package bg.tu_varna.sit.inventory.business.services;

import bg.tu_varna.sit.inventory.data.entities.CustomersEntity;
import bg.tu_varna.sit.inventory.data.repositories.CustomerRepository;
import bg.tu_varna.sit.inventory.presentation.models.CardboardListViewModel;
import bg.tu_varna.sit.inventory.presentation.models.CustomerListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    private final CustomerService customerService = CustomerService.getInstance();
    private static final Logger log = Logger.getLogger(CustomerService.class);
    private final CustomerRepository repository = CustomerRepository.getInstance();
    public static CustomerService getInstance() {
        return CustomerServiceHolder.INSTANCE;
    }

    public CustomersEntity listViewToEntity(CustomerListViewModel a) {
        CustomersEntity temp = new CustomersEntity(a.getFirstName(), a.getLastName(), a.getPhoneNumber());
        List<CustomersEntity> customers = repository.getAll();
        for (CustomersEntity customer: customers) {
            if(customer.equals(temp))
                return customer;
        }
        return null;
    }

    public ObservableList<CustomerListViewModel> getAllCustomers() {
        List<CustomersEntity> customers = repository.getAll();

        return FXCollections.observableList(
                customers.stream().map(c -> new CustomerListViewModel(
                        c.getFirstName(),c.getLastName(),c.getPhoneNumber()
                )).collect(Collectors.toList()));

    }

    public static class CustomerServiceHolder {
        public static final CustomerService INSTANCE = new CustomerService();
    }


    public boolean addCustomer(CustomerListViewModel c) {
        List<CustomersEntity> customers = repository.getAll();

        CustomersEntity customer=new CustomersEntity(c.getFirstName(), c.getLastName(), c.getPhoneNumber());
        for(CustomersEntity cus: customers ){
            if(cus.equals(customer))
                return false;
        }
        repository.save(customer);
        return true;
    }



}
