package bg.tu_varna.sit.inventory.presentation.models;

import bg.tu_varna.sit.inventory.data.entities.CustomersEntity;
import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;

import java.util.Date;

public class CardboardListViewModel {
    private CustomersEntity customer;
    private ProductsEntity product;
    private Date dateTaken;

    public CardboardListViewModel() {
    }

    public CardboardListViewModel(CustomersEntity customer, ProductsEntity product, Date dateTaken) {
        this.customer = customer;
        this.product = product;
        this.dateTaken = dateTaken;
    }

    public CustomersEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomersEntity customer) {
        this.customer = customer;
    }

    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }


}
