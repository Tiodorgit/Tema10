package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Products", schema = "dbo", catalog = "inventory")
public class ProductsEntity {
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
    private Date dateOfRegistration;
    @Basic
    @Column(name = "waranty", nullable = true)
    private Integer warranty;
    @Basic
    @Column(name = "degreeOfDeprication", nullable = true, precision = 0)
    private Double degreeOfDepreciation;
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

    public ProductsEntity(String description, TypesEntity typesByTypeId, Date dateOfRegistration, Integer warranty, Double degreeOfDepreciation, StatesEntity statesByStateId, Boolean status, AccountablePersonsEntity accountablePersonsByAcountablePersonId) {
        this.description = description;
        this.typesByTypeId = typesByTypeId;
        this.dateOfRegistration = dateOfRegistration;
        this.warranty = warranty;
        this.degreeOfDepreciation = degreeOfDepreciation;
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

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Integer getWarranty() {
        return warranty;
    }

    public void setWarranty(Integer waranty) {
        this.warranty = waranty;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getDegreeOfDepreciation() {
        return degreeOfDepreciation;
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

    public void setDegreeOfDepreciation(Double degreeOfDepreciation) {
        this.degreeOfDepreciation = degreeOfDepreciation;
    }

    public Set<CardboardsEntity> getCardboardsByInventoryNumber() {
        return cardboardsByInventoryNumber;
    }

    public void setCardboardsByInventoryNumber(Set<CardboardsEntity> cardboardsByInventoryNumber) {
        this.cardboardsByInventoryNumber = cardboardsByInventoryNumber;
    }

    public TypesEntity getTypesByTypeId() {
        return typesByTypeId;
    }

    public void setTypesByTypeId(TypesEntity typesByTypeId) {
        this.typesByTypeId = typesByTypeId;
    }

    public StatesEntity getStatesByStateId() {
        return statesByStateId;
    }

    public void setStatesByStateId(StatesEntity statesByStateId) {
        this.statesByStateId = statesByStateId;
    }

    public AccountablePersonsEntity getAccountablePersonsByAcountablePersonId() {
        return accountablePersonsByAcountablePersonId;
    }

    public void setAccountablePersonsByAcountablePersonId(AccountablePersonsEntity accountablePersonsByAcountablePersonId) {
        this.accountablePersonsByAcountablePersonId = accountablePersonsByAcountablePersonId;
    }
}
