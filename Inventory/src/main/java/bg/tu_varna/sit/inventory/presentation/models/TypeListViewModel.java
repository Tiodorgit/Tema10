package bg.tu_varna.sit.inventory.presentation.models;

import java.util.Objects;

public class TypeListViewModel {
    private String type;

    public TypeListViewModel(){}

    public TypeListViewModel(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeListViewModel that = (TypeListViewModel) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return type;
    }
}

