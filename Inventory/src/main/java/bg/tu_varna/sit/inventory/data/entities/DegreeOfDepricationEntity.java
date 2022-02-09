package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DegreeOfDeprication", schema = "dbo", catalog = "inventory")
public class DegreeOfDepricationEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "category", nullable = true, length = 50)
    private String category;

    @OneToMany(mappedBy = "degreeOfDepricationByDegreeOfDeprication")
    private Set<DefectiveProductsEntity> defectiveProductsById;
    @OneToMany(mappedBy = "degreeOfDepricationByDegreeOfDeprication")
    private Set<ProductsEntity> productsById;

    public DegreeOfDepricationEntity() {
    }

    public DegreeOfDepricationEntity(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DegreeOfDepricationEntity that = (DegreeOfDepricationEntity) o;
        return Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
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
