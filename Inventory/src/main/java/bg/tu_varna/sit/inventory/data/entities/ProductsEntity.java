package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Products", schema = "dbo", catalog = "inventory")
public class ProductsEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inventoryNumber", nullable = false)
    private int inventoryNumber;
    @Basic
    @Column(name = "description", nullable = true, length = 100)
    private String description;
    @ManyToOne
    @JoinColumn(name = "typeID", referencedColumnName = "id")
    private TypesEntity typesByTypeId;
    @Basic
    @Column(name = "dateOfRegistration", nullable = true)
    private LocalDate dateOfRegistration;
    @Basic
    @Column(name = "waranty", nullable = true)
    private Integer warranty;
    @ManyToOne
    @JoinColumn(name = "degreeOfDeprication", referencedColumnName = "id")
    private DegreeOfDepricationEntity degreeOfDepricationByDegreeOfDeprication;
    @ManyToOne
    @JoinColumn(name = "stateID", referencedColumnName = "id")
    private StatesEntity statesByStateId;
    @Basic
    @Column(name = "status", nullable = true)
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "AcountablePersonID", referencedColumnName = "id")
    private AccountablePersonsEntity accountablePersonsByAcountablePersonId;

    @OneToMany(mappedBy = "productsByProductId")
    private Set<CardboardsEntity> cardboardsByInventoryNumber;


    public ProductsEntity() {
    }

    public ProductsEntity(int inventoryNumber, Boolean status) {
        this.inventoryNumber = inventoryNumber;
        this.status = status;
    }

    public ProductsEntity(int inventoryNumber, String description) {
        this.inventoryNumber = inventoryNumber;
        this.description = description;
    }

    public ProductsEntity(String description, TypesEntity typesByTypeId, LocalDate dateOfRegistration, Integer warranty, DegreeOfDepricationEntity degreeOfDepricationByDegreeOfDeprication, StatesEntity statesByStateId, Boolean status, AccountablePersonsEntity accountablePersonsByAcountablePersonId) {
        this.description = description;
        this.typesByTypeId = typesByTypeId;
        this.dateOfRegistration = dateOfRegistration;
        this.warranty = warranty;
        this.degreeOfDepricationByDegreeOfDeprication = degreeOfDepricationByDegreeOfDeprication;
        this.statesByStateId = statesByStateId;
        this.status = status;
        this.accountablePersonsByAcountablePersonId = accountablePersonsByAcountablePersonId;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypesEntity getTypesByTypeId() {
        return typesByTypeId;
    }

    public void setTypesByTypeId(TypesEntity typesByTypeId) {
        this.typesByTypeId = typesByTypeId;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public DegreeOfDepricationEntity getDegreeOfDepricationByDegreeOfDeprication() {
        return degreeOfDepricationByDegreeOfDeprication;
    }

    public void setDegreeOfDepricationByDegreeOfDeprication(DegreeOfDepricationEntity degreeOfDepricationByDegreeOfDeprication) {
        this.degreeOfDepricationByDegreeOfDeprication = degreeOfDepricationByDegreeOfDeprication;
    }

    public StatesEntity getStatesByStateId() {
        return statesByStateId;
    }

    public void setStatesByStateId(StatesEntity statesByStateId) {
        this.statesByStateId = statesByStateId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public AccountablePersonsEntity getAccountablePersonsByAcountablePersonId() {
        return accountablePersonsByAcountablePersonId;
    }

    public void setAccountablePersonsByAcountablePersonId(AccountablePersonsEntity accountablePersonsByAcountablePersonId) {
        this.accountablePersonsByAcountablePersonId = accountablePersonsByAcountablePersonId;
    }

    public Set<CardboardsEntity> getCardboardsByInventoryNumber() {
        return cardboardsByInventoryNumber;
    }

    public void setCardboardsByInventoryNumber(Set<CardboardsEntity> cardboardsByInventoryNumber) {
        this.cardboardsByInventoryNumber = cardboardsByInventoryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return inventoryNumber == that.inventoryNumber;
    }

    @Override
    public String toString() {
        return inventoryNumber + ": " + description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryNumber);
    }


}
