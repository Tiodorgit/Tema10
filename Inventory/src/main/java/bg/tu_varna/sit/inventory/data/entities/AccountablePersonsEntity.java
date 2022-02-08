package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AccountablePersons", schema = "dbo", catalog = "inventory")
public class AccountablePersonsEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "username", nullable = true, length = 50)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 50)
    private String password;
    @OneToMany(mappedBy = "accountablePersonsByAcountablePersonId")
    private Set<DefectiveProductsEntity> defectiveProductsById;
    @OneToMany(mappedBy = "accountablePersonsByAcountablePersonId")
    private Set<ProductsEntity> productsById;

    public AccountablePersonsEntity() {
    }

    public AccountablePersonsEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountablePersonsEntity that = (AccountablePersonsEntity) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "AccountablePersonsEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Set<DefectiveProductsEntity> getDefectiveProductsById() {
        return defectiveProductsById;
    }

    public void setDefectiveProductsById(Set<DefectiveProductsEntity> defectiveProductsById) {
        this.defectiveProductsById = defectiveProductsById;
    }

    public Set<ProductsEntity> getProductsById() {
        return productsById;
    }

    public void setProductsById(Set<ProductsEntity> productsById) {
        this.productsById = productsById;
    }
}
