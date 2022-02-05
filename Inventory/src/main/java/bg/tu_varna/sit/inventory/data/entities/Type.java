package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "Types")
@Entity
public class Type implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "typeID")
    private Set<Product> productSet;

    @OneToMany(mappedBy = "typeID")
    private Set<DefectiveProduct> defectiveProductSet;

    public Type(String type) {
        this.type = type;
    }

    public Type() {

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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public Set<DefectiveProduct> getDefectiveProductSet() {
        return defectiveProductSet;
    }

    public void setDefectiveProductSet(Set<DefectiveProduct> defectiveProductSet) {
        this.defectiveProductSet = defectiveProductSet;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", productSet=" + productSet +
                ", defectiveProductSet=" + defectiveProductSet +
                '}';
    }
}
