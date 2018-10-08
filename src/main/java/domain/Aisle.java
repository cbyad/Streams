package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Aisle {

  private final Map<Integer, ParkingSlot> parkingSlots;
  private final int nbOfSlots;

  public Aisle(int nbOfSlots) {
    this.nbOfSlots = nbOfSlots;
    this.parkingSlots = new HashMap<>();
  }

  public Map<Integer, ParkingSlot> getParkingSlots() {
    return this.parkingSlots;
  }

  public boolean park(int slotNb, Vehicle v) {
    assert(slotNb <= this.nbOfSlots);
    ParkingSlot parkedVehicle = this.parkingSlots.put(slotNb, ParkingSlot.of(v));
    if (parkedVehicle == null) return true;
    return parkedVehicle.getVehicle().map(vehicle -> vehicle.equals(v)).orElse(false);
  }

  public Optional<Vehicle> unpark(int slotNb) {
    assert(slotNb <= this.nbOfSlots);
    return this.parkingSlots.remove(slotNb).getVehicle();
  }

}
