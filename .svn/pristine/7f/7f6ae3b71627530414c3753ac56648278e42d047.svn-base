package domain;

import java.util.Optional;

public class ParkingSlot {

  private final Optional<Vehicle> vehicle;

  public ParkingSlot(Optional<Vehicle> vehicle) {
    this.vehicle = vehicle;
  }

  public static ParkingSlot of(Vehicle v) {
    return new ParkingSlot(Optional.of(v));
  }

  public static ParkingSlot empty() {
    return new ParkingSlot(Optional.empty());
  }

  public boolean isFree() {
    return !this.vehicle.isPresent();
  }

  public Optional<Vehicle> getVehicle() {
    return this.vehicle;
  }
}
