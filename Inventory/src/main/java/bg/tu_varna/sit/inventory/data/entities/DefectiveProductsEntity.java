package bg.tu_varna.sit.inventory.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DefectiveProducts", schema = "dbo", catalog = "inventory")
public class DefectiveProductsEntity implements Serializable {
    private static final long serialVersionUID=1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
        private int id;
    @Basic
    @Column(name = "inventoryNumber", nullable = true)
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
    private Integer waranty;
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
    @JoinColumn(name = "acountablePersonID", referencedColumnName = "id")
    private AccountablePersonsEntity accountablePersonsByAcountablePersonId;
    @Basic
    @Column(name = "dateOfScrapping", nullable = true)
    private LocalDate dateOfScrapping;

    public DefectiveProductsEntity() {
    }

    public DefectiveProductsEntity(int inventoryNumber, String description, TypesEntity typesByTypeId, LocalDate dateOfRegistration, Integer waranty, DegreeOfDepricationEntity degreeOfDepricationByDegreeOfDeprication, StatesEntity statesByStateId, Boolean status, AccountablePersonsEntity accountablePersonsByAcountablePersonId, LocalDate dateOfScrapping) {
        this.inventoryNumber = inventoryNumber;
        this.description = description;
        this.typesByTypeId = typesByTypeId;
        this.dateOfRegistration = dateOfRegistration;
        this.waranty = waranty;
        this.degreeOfDepricationByDegreeOfDeprication = degreeOfDepricationByDegreeOfDeprication;
        this.statesByStateId = statesByStateId;
        this.status = status;
        this.accountablePersonsByAcountablePersonId = accountablePersonsByAcountablePersonId;
        this.dateOfScrapping = dateOfScrapping;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getWaranty() {
        return waranty;
    }

    public void setWaranty(Integer waranty) {
        this.waranty = waranty;
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

        public LocalDate getDateOfScrapping() {
        return dateOfScrapping;
    }

    public void setDateOfScrapping(LocalDate dateOfScrapping) {
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

}
