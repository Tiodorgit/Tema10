package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

@Entity
@Table(name = "Cardboards", schema = "dbo", catalog = "inventory")
public class CardboardsEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "CustomerID", referencedColumnName = "id")
    private CustomersEntity customersByCustomerId;
    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "inventoryNumber")
    private ProductsEntity productsByProductId;

    @Basic
    @Column(name = "dateTaken", nullable = true)
    private LocalDate dateTaken;
    @Basic
    @Column(name = "dateReturn", nullable = true)
    private LocalDate dateReturn;

    public CardboardsEntity() {
    }

    public CardboardsEntity(CustomersEntity customersByCustomerId, ProductsEntity productsByProductId, LocalDate dateTaken, LocalDate dateReturn) {
        this.customersByCustomerId = customersByCustomerId;
        this.productsByProductId = productsByProductId;
        this.dateTaken = dateTaken;
        this.dateReturn = dateReturn;
    }

    public CardboardsEntity(int id, CustomersEntity customersByCustomerId, ProductsEntity productsByProductId, LocalDate dateTaken, LocalDate dateReturn) {
        this.id = id;
        this.customersByCustomerId = customersByCustomerId;
        this.productsByProductId = productsByProductId;
        this.dateTaken = dateTaken;
        this.dateReturn = dateReturn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        CardboardsEntity that = (CardboardsEntity) o;
        return Objects.equals(customersByCustomerId, that.customersByCustomerId) && Objects.equals(productsByProductId, that.productsByProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customersByCustomerId, productsByProductId);
    }

    @Override
    public String toString() {
        return "CardboardsEntity{" +
                "id=" + id +
                ", customersByCustomerId=" + customersByCustomerId +
                ", productsByProductId=" + productsByProductId +
                ", dateTaken=" + dateTaken +
                ", dateReturn=" + dateReturn +
                '}';
    }

    public CustomersEntity getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(CustomersEntity customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }

    public ProductsEntity getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(ProductsEntity productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}
