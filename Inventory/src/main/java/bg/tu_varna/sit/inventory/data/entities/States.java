package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "States")
@Entity
public class States implements Serializable{
    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "state", nullable = false)
    private String state;

    @OneToMany(mappedBy = "stateID")
    private Set<Product> productSet;

    @OneToMany(mappedBy = "stateID")
    private Set<DefectiveProduct> defectiveProductSet;

    public States(String state) {
        this.state = state;
    }

    public States() {

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
        return "States{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", productSet=" + productSet +
                ", defectiveProductSet=" + defectiveProductSet +
                '}';
    }
}
