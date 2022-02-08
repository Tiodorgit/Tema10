package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Types", schema = "dbo", catalog = "inventory")
public class TypesEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "type", nullable = true, length = 50)
    private String type;

    @OneToMany(mappedBy = "typesByTypeId")
    private Set<DefectiveProductsEntity> defectiveProductsById;
    @OneToMany(mappedBy = "typesByTypeId")
    private Set<ProductsEntity> productsById;

    public TypesEntity() {
    }

    public TypesEntity(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypesEntity that = (TypesEntity) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return type;
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
