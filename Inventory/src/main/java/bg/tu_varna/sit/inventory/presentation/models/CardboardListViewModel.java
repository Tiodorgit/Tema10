package bg.tu_varna.sit.inventory.presentation.models;

import bg.tu_varna.sit.inventory.data.entities.Customer;
import bg.tu_varna.sit.inventory.data.entities.Product;

import java.util.Date;

public class CardboardListViewModel {
    private Customer customer;
    private Product product;
    private Date dateTaken;

    public CardboardListViewModel() {
    }

    public CardboardListViewModel(Customer customer, Product product, Date dateTaken) {
        this.customer = customer;
        this.product = product;
        this.dateTaken = dateTaken;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }


}
