package bg.tu_varna.sit.inventory.presentation.models;

import bg.tu_varna.sit.inventory.data.entities.States;
import bg.tu_varna.sit.inventory.data.entities.Type;

import java.util.Date;
import java.util.Objects;

public class ProductListViewModel {
    private String inventoryNumber;
    private String description;
    private Type typeID;
    private Date dateOfRegistration;
    private int warranty;
    private int degreeOfDepreciation;
    private States stateID;
    private int status;

    public ProductListViewModel(){}

    public ProductListViewModel(String inventoryNumber, String description, Type typeID, Date dateOfRegistration, int warranty, int degreeOfDepreciation, States stateID, int status) {
        this.inventoryNumber = inventoryNumber;
        this.description = description;
        this.typeID = typeID;
        this.dateOfRegistration = dateOfRegistration;
        this.warranty = warranty;
        this.degreeOfDepreciation = degreeOfDepreciation;
        this.stateID = stateID;
        this.status = status;
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

    public Type getTypeID() {
        return typeID;
    }

    public void setTypeID(Type typeID) {
        this.typeID = typeID;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfDepreciation) {
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

    public States getStateID() {
        return stateID;
    }

    public void setStateID(States stateID) {
        this.stateID = stateID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductListViewModel that = (ProductListViewModel) o;
        return warranty == that.warranty && degreeOfDepreciation == that.degreeOfDepreciation && status == that.status && Objects.equals(inventoryNumber, that.inventoryNumber) && Objects.equals(description, that.description) && Objects.equals(typeID, that.typeID) && Objects.equals(dateOfRegistration, that.dateOfRegistration) && Objects.equals(stateID, that.stateID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryNumber, description, typeID, dateOfRegistration, warranty, degreeOfDepreciation, stateID, status);
    }


    @Override
    public String toString() {
        return "ProductListViewModel{" +
                "inventoryNumber='" + inventoryNumber + '\'' +
                ", description='" + description + '\'' +
                ", typeID=" + typeID +
                ", dateOfDepreciation=" + dateOfRegistration +
                ", warranty=" + warranty +
                ", degreeOfDepreciation=" + degreeOfDepreciation +
                ", stateID=" + stateID +
                ", status=" + status +
                '}';
    }

}


