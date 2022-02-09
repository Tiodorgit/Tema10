package bg.tu_varna.sit.inventory.presentation.models;

import java.util.Objects;

public class DegreeOfDepricationListViewModel {
    private String category;

    public DegreeOfDepricationListViewModel() {
    }

    public DegreeOfDepricationListViewModel(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DegreeOfDepricationListViewModel that = (DegreeOfDepricationListViewModel) o;
        return Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }

    @Override
    public String toString() {
        return category;
    }
}
