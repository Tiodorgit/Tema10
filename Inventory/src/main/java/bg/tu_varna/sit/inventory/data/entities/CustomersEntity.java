package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Customers", schema = "dbo", catalog = "inventory")
public class CustomersEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "firstName", nullable = true, length = 50)
    private String firstName;
    @Basic
    @Column(name = "lastName", nullable = true, length = 50)
    private String lastName;
    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 50)
    private String phoneNumber;
    @OneToMany(mappedBy = "customersByCustomerId")
    private Set<CardboardsEntity> cardboardsById;

    public CustomersEntity() {
    }

    public CustomersEntity(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }

    public Set<CardboardsEntity> getCardboardsById() {
        return cardboardsById;
    }

    public void setCardboardsById(Set<CardboardsEntity> cardboardsById) {
        this.cardboardsById = cardboardsById;
    }

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName;
    }
}
