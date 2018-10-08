package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parking {

  private final List<Floor> floors;

  private Parking(List<Floor> floors) {
    this.floors = floors;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public List<Floor> getFloors() {
    return this.floors;
  }

  public int getCapacity() {
    return this.floors.size();
  }

  public List<Vehicle> getParkedVehicles() {
    // TODO
    return null;
  }

  public boolean park(Vehicle v) {
    // TODO

    return false;
  }

  public boolean remove(Vehicle v) {
    // TODO
    return false;
  }

  public int parkedVehicleCount() {
    // TODO
    return 0;
  }

  public int availableSlots() {
    return this.getCapacity() - this.parkedVehicleCount();
  }

  public long parkedVehiclesWeightSum() {
    return this.getParkedVehicles().stream().map(Vehicle::getWeight).reduce((w1, w2) -> w1 + w2).orElse(0);
  }

  public static class Builder {

    private final List<Floor> floors;

    private Builder() {
      this.floors = new ArrayList<>();
    }

    public Builder floor(Floor floor) {
      this.floors.add(floor);
      return this;
    }

    public Parking build() {
      return new Parking(Collections.unmodifiableList(this.floors));
    }
  }
}
