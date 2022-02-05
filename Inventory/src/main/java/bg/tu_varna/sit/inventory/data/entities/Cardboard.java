package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "Cardboards")
@Entity
public class Cardboard implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private Product product;

    @Column(name = "dateTaken")
    private LocalDate dateTaken;

    public Cardboard(Customer customer, Product product, LocalDate dateTaken) {
        this.customer = customer;
        this.product = product;
        this.dateTaken = dateTaken;
    }

    public Cardboard() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(LocalDate dateTaken) {
        this.dateTaken = dateTaken;
    }

    @Override
    public String toString() {
        return "Cardboard{" +
                "id=" + id +
                ", customer=" + customer +
                ", product=" + product +
                ", dateTaken=" + dateTaken +
                '}';
    }
}
