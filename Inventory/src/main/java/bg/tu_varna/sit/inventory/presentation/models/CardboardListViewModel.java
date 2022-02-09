package bg.tu_varna.sit.inventory.presentation.models;

import bg.tu_varna.sit.inventory.data.entities.CustomersEntity;
import bg.tu_varna.sit.inventory.data.entities.ProductsEntity;

import java.time.LocalDate;
import java.util.Objects;

public class CardboardListViewModel {
    private  int idCustomerBoard;
    private CustomersEntity customer;
    private ProductsEntity product;
    private LocalDate dateTaken;
    private LocalDate dateReturn;

    public CardboardListViewModel() {
    }

    public CardboardListViewModel(CustomersEntity customer, ProductsEntity product, LocalDate dateTaken) {
        this.customer = customer;
        this.product = product;
        this.dateTaken = dateTaken;
        this.dateReturn = null;
    }

    public CardboardListViewModel(CustomersEntity customer, ProductsEntity product, LocalDate dateTaken, LocalDate dateReturn) {
        this.customer = customer;
        this.product = product;
        this.dateTaken = dateTaken;
        this.dateReturn = dateReturn;
    }

    public int getIdCustomerBoard() {
        return idCustomerBoard;
    }

    public void setIdCustomerBoard(int idCustomerBoard) {
        this.idCustomerBoard = idCustomerBoard;
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

    public LocalDate getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(LocalDate dateTaken) {
        this.dateTaken = dateTaken;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardboardListViewModel that = (CardboardListViewModel) o;
        return Objects.equals(customer, that.customer) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, product);
    }

    @Override
    public String toString() {
        return "CardboardListViewModel{" +
                "customer=" + customer +
                ", product=" + product +
                '}';
    }
}
