package bg.tu_varna.sit.inventory.presentation.models;

import bg.tu_varna.sit.inventory.data.entities.StatesEntity;
import bg.tu_varna.sit.inventory.data.entities.TypesEntity;

import java.util.Date;
import java.util.Objects;

public class DefectiveProductListViewModel {
    private String inventoryNumber;
    private String description;
    private TypesEntity typeID;
    private Date dateOfRegistration;
    private int warranty;
    private int degreeOfDepreciation;
    private StatesEntity stateID;
    private int status;
    private Date dateOfScrapping;

    public DefectiveProductListViewModel(){}

    public DefectiveProductListViewModel(String inventoryNumber, String description, TypesEntity typeID, Date dateOfRegistration, int warranty, int degreeOfDepreciation, StatesEntity stateID, int status, Date dateOfScrapping) {
        this.inventoryNumber = inventoryNumber;
        this.description = description;
        this.typeID = typeID;
        this.dateOfRegistration = dateOfRegistration;
        this.warranty = warranty;
        this.degreeOfDepreciation = degreeOfDepreciation;
        this.stateID = stateID;
        this.status = status;
        this.dateOfScrapping = dateOfScrapping;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
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

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfDepreciation(Date dateOfDepreciation) {
        this.dateOfRegistration = dateOfDepreciation;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public int getDegreeOfDepreciation() {
        return degreeOfDepreciation;
    }

    public void setDegreeOfDepreciation(int degreeOfDepreciation) {
        this.degreeOfDepreciation = degreeOfDepreciation;
    }

    public StatesEntity getStateID() {
        return stateID;
    }

    public void setStateID(StatesEntity stateID) {
        this.stateID = stateID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
        DefectiveProductListViewModel that = (DefectiveProductListViewModel) o;
        return warranty == that.warranty && degreeOfDepreciation == that.degreeOfDepreciation && status == that.status && Objects.equals(inventoryNumber, that.inventoryNumber) && Objects.equals(description, that.description) && Objects.equals(typeID, that.typeID) && Objects.equals(dateOfRegistration, that.dateOfRegistration) && Objects.equals(stateID, that.stateID) && Objects.equals(dateOfScrapping, that.dateOfScrapping);
    }


    @Override
    public int hashCode() {
        return Objects.hash(inventoryNumber, description, typeID, dateOfRegistration, warranty, degreeOfDepreciation, stateID, status, dateOfScrapping);
    }

    @Override
    public String
    toString() {
        return "DefectiveProductListViewModel{" +
                "inventoryNumber='" + inventoryNumber + '\'' +
                ", description='" + description + '\'' +
                ", typeID=" + typeID +
                ", dateOfDepreciation=" + dateOfRegistration +
                ", warranty=" + warranty +
                ", degreeOfDepreciation=" + degreeOfDepreciation +
                ", stateID=" + stateID +
                ", status=" + status +
                ", dateOfScrapping=" + dateOfScrapping +
                '}';
    }
}

