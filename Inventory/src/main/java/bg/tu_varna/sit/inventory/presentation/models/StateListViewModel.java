package bg.tu_varna.sit.inventory.presentation.models;

import java.util.Objects;

public class StateListViewModel {
    private String State;

    public StateListViewModel() {
    }

    public StateListViewModel(String state) {
        State = state;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateListViewModel that = (StateListViewModel) o;
        return Objects.equals(State, that.State);
    }

    @Override
    public int hashCode() {
        return Objects.hash(State);
    }

    @Override
    public String toString() {
        return "StateListViewModel{" +
                "State='" + State + '\'' +
                '}';
    }
}
