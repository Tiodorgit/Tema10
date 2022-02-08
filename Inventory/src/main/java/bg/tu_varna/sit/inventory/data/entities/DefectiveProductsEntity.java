package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "DefectiveProducts", schema = "dbo", catalog = "inventory")
public class DefectiveProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "inventoryNumber", nullable = false)
    private int inventoryNumber;
    @Basic
    @Column(name = "description", nullable = true, length = 50)
    private String description;
    @ManyToOne
    @JoinColumn(name = "typeID", referencedColumnName = "id")
    private TypesEntity typesByTypeId;
    @Basic
    @Column(name = "dateOfRegistration", nullable = true)
    private Date dateOfRegistration;
    @Basic
    @Column(name = "waranty", nullable = true)
    private Integer waranty;
    @Basic
    @Column(name = "degreeOfDeprication", nullable = true, precision = 0)
    private Double degreeOfDeprication;
    @ManyToOne
    @JoinColumn(name = "stateID", referencedColumnName = "id")
    private StatesEntity statesByStateId;
    @Basic
    @Column(name = "status", nullable = true)
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "acountablePersonID", referencedColumnName = "id")
    private AccountablePersonsEntity accountablePersonsByAcountablePersonId;
    @Basic
    @Column(name = "dateOfScrapping", nullable = true)
    private Date dateOfScrapping;

    public DefectiveProductsEntity() {
    }

    public DefectiveProductsEntity(String description, TypesEntity typesByTypeId, Date dateOfRegistration, Integer waranty, Double degreeOfDeprication, StatesEntity statesByStateId, Boolean status, AccountablePersonsEntity accountablePersonsByAcountablePersonId, Date dateOfScrapping) {
        this.description = description;
        this.typesByTypeId = typesByTypeId;
        this.dateOfRegistration = dateOfRegistration;
        this.waranty = waranty;
        this.degreeOfDeprication = degreeOfDeprication;
        this.statesByStateId = statesByStateId;
        this.status = status;
        this.accountablePersonsByAcountablePersonId = accountablePersonsByAcountablePersonId;
        this.dateOfScrapping = dateOfScrapping;
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

    public Integer getWaranty() {
        return waranty;
    }

    public void setWaranty(Integer waranty) {
        this.waranty = waranty;
    }

    public Double getDegreeOfDeprication() {
        return degreeOfDeprication;
    }

    public void setDegreeOfDeprication(Double degreeOfDeprication) {
        this.degreeOfDeprication = degreeOfDeprication;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDateOfScrapping() {
        return dateOfScrapping;
    }

    public void setDateOfScrapping(Date dateOfScrapping) {
        this.dateOfScrapping = dateOfScrapping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectiveProductsEntity that = (DefectiveProductsEntity) o;
        return inventoryNumber == that.inventoryNumber && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryNumber, description);
    }

    @Override
    public String toString() {
        return inventoryNumber + ": '" + description;
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
