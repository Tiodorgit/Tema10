package bg.tu_varna.sit.inventory.presentation.models;

import bg.tu_varna.sit.inventory.data.entities.AccountablePersonsEntity;
import bg.tu_varna.sit.inventory.data.entities.DegreeOfDepricationEntity;
import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class DefectiveProductListViewModel {
    private int inventoryNumber;
    private String description;
    private TypesEntity typeID;
    private LocalDate dateOfRegistration;
    private int warranty;
    private DegreeOfDepricationEntity degreeOfDepreciation;
    private StatesEntity stateID;
    private boolean status;
    private AccountablePersonsEntity accountablePersons;
    private LocalDate dateOfScrapping;

    public DefectiveProductListViewModel(){}

    public DefectiveProductListViewModel(int inventoryNumber, String description, TypesEntity typeID, LocalDate dateOfRegistration, int warranty, DegreeOfDepricationEntity degreeOfDepreciation, StatesEntity stateID, boolean status, AccountablePersonsEntity accountablePersons, LocalDate dateOfScrapping) {
        this.inventoryNumber = inventoryNumber;
        this.description = description;
        this.typeID = typeID;
        this.dateOfRegistration = dateOfRegistration;
        this.warranty = warranty;
        this.degreeOfDepreciation = degreeOfDepreciation;
        this.stateID = stateID;
        this.status = status;
        this.accountablePersons = accountablePersons;
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

    public TypesEntity getTypeID() {
        return typeID;
    }

    public void setTypeID(TypesEntity typeID) {
        this.typeID = typeID;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public DegreeOfDepricationEntity getDegreeOfDepreciation() {
        return degreeOfDepreciation;
    }

    public void setDegreeOfDepreciation(DegreeOfDepricationEntity degreeOfDepreciation) {
        this.degreeOfDepreciation = degreeOfDepreciation;
    }

    public StatesEntity getStateID() {
        return stateID;
    }

    public void setStateID(StatesEntity stateID) {
        this.stateID = stateID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public AccountablePersonsEntity getAccountablePersons() {
        return accountablePersons;
    }

    public void setAccountablePersons(AccountablePersonsEntity accountablePersons) {
        this.accountablePersons = accountablePersons;
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
        DefectiveProductListViewModel that = (DefectiveProductListViewModel) o;
        return warranty == that.warranty && status == that.status && Objects.equals(description, that.description) && Objects.equals(typeID, that.typeID) && Objects.equals(dateOfRegistration, that.dateOfRegistration) && Objects.equals(degreeOfDepreciation, that.degreeOfDepreciation) && Objects.equals(stateID, that.stateID) && Objects.equals(accountablePersons, that.accountablePersons) && Objects.equals(dateOfScrapping, that.dateOfScrapping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, typeID, dateOfRegistration, warranty, degreeOfDepreciation, stateID, status, accountablePersons, dateOfScrapping);
    }

    @Override
    public String toString() {
        return "DefectiveProductListViewModel{" +
                "inventoryNumber=" + inventoryNumber +
                ", description='" + description + '\'' +
                ", typeID=" + typeID +
                ", dateOfRegistration=" + dateOfRegistration +
                ", warranty=" + warranty +
                ", degreeOfDepreciation=" + degreeOfDepreciation +
                ", stateID=" + stateID +
                ", status=" + status +
                ", accountablePersons=" + accountablePersons +
                ", dateOfScrapping=" + dateOfScrapping +
                '}';
    }
}

