package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "States", schema = "dbo", catalog = "inventory")
public class StatesEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "state", nullable = true, length = 50)
    private String state;

    @OneToMany(mappedBy = "statesByStateId")
    private Collection<DefectiveProductsEntity> defectiveProductsById;
    @OneToMany(mappedBy = "statesByStateId")
    private Collection<ProductsEntity> productsById;

    public StatesEntity() {
    }

    public StatesEntity(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatesEntity that = (StatesEntity) o;
        return id == that.id && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state);
    }

    @Override
    public String toString() {
        return state;
    }

    public Collection<DefectiveProductsEntity> getDefectiveProductsById() {
        return defectiveProductsById;
    }

    public void setDefectiveProductsById(Collection<DefectiveProductsEntity> defectiveProductsById) {
        this.defectiveProductsById = defectiveProductsById;
    }

    public Collection<ProductsEntity> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<ProductsEntity> productsById) {
        this.productsById = productsById;
    }
}
