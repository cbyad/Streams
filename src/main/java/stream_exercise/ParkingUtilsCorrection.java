package stream_exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.Car;
import domain.Floor;
import domain.Parking;
import domain.ParkingSlot;
import domain.Truck;
import domain.Vehicle;

public class ParkingUtilsCorrection {

  public static <T> List<T> streamToList(Stream<T> stream) {
    return stream.collect(Collectors.toList());
  }

  public static <T> Set<T> streamToSet(Stream<T> stream) {
    return stream.collect(Collectors.toSet());
  }

  public static Map<String, Vehicle> mapMakeModelWithVehicle(Stream<Vehicle> vehicles) {
    Function<Vehicle, String> vehicleToMakeModel = (vehicle) -> "Make: " + vehicle.getMake() + ", Model: " + vehicle.getModel();
    return vehicles.collect(Collectors.toMap(
      vehicleToMakeModel::apply,
      Function.identity()
    ));
  }

  public static Stream<String> findMakes(List<Vehicle> vehicles) {
    return vehicles.stream().map(Vehicle::getMake);
  }

  public static Stream<Vehicle> vehiclesWithMoreThan3Wheels(List<Vehicle> vehicles) {
    return vehicles.stream().filter(v -> v.getNbWheels() > 3);
  }

  public static boolean hasAnyCar(Stream<Vehicle> vehicles) {
    return vehicles.anyMatch(vehicle -> vehicle instanceof Car);
  }

  public static boolean areAllCars(Stream<Vehicle> vehicles) {
    return vehicles.allMatch(vehicle -> vehicle instanceof Car);
  }

  public static int findMaxWeight(List<Vehicle> vehicles) {
    return vehicles.stream().
      map(Vehicle::getWeight).
      max(Comparator.comparingInt(Integer::intValue)).orElse(0);
  }

  public static int findMinNbOfWheels(List<Vehicle> vehicles) {
    return vehicles.stream().
      map(Vehicle::getNbWheels).
      min(Comparator.comparingInt(Integer::intValue)).orElse(0);
  }

  public static long countVehicles(Floor floor) {
    return floor.getAisles().values().stream().
      flatMap(aisle -> aisle.getParkingSlots().values().stream()).
      map(ParkingSlot::getVehicle).
      filter(Optional::isPresent).
      count();
  }

  public static long countVehicles(Parking parking) {
    return parking.getFloors().stream().map(ParkingUtilsCorrection::countVehicles).count();
  }

  public static Optional<Floor> findLeastOccupiedFloor(Parking parking) {
    return parking.getFloors().stream().reduce((f1, f2) -> countVehicles(f1) > countVehicles(f2) ? f1 : f2);
  }

  public static Stream<String> findMakes(Parking parking) {
    return parking.getFloors().stream().
      flatMap(floor -> floor.getAisles().values().stream()).
      flatMap(aisle -> aisle.getParkingSlots().values().stream()).
      map(ParkingSlot::getVehicle).
      filter(Optional::isPresent).
      map(Optional::get).
      map(Vehicle::getMake);
  }

  public static String listMakes(Parking parking) {
    return findMakes(parking).collect(Collectors.joining("\n"));
  }

  public static String listMakesWithReduce(Parking parking) {
    return findMakes(parking).
      reduce("", (m1, m2) -> m1 + "\n" + m2);
  }

  public static Optional<Truck> findAnyTruck(Stream<Vehicle> vehicles) {
    return vehicles.filter(vehicle -> vehicle instanceof Truck).map(v -> (Truck) v).findAny();
  }

  public static <T> ArrayList<T> collectToListWithReduce(Stream<T> stream) {
    return stream.reduce(
      new ArrayList<T>(),
      (acc, el) -> { acc.add(el) ; return acc; },
      (a, b) -> a
    );
  }

  public static List<Vehicle> listVehicles(Parking parking) {
    return parking.getFloors().stream().
      flatMap(floor -> floor.getAisles().values().stream()).
      flatMap(aisle -> aisle.getParkingSlots().values().stream()).
      map(ParkingSlot::getVehicle).
      filter(Optional::isPresent).
      map(Optional::get).
      collect(Collectors.toList());
  }

  public static List<Vehicle> listVehiclesDebug(Parking parking) {
    return parking.getFloors().stream().
      flatMap(floor -> floor.getAisles().values().stream()).
      peek(aisle -> System.out.println("Flatmapped floors to get aisle : " + aisle.toString())).
      flatMap(aisle -> aisle.getParkingSlots().values().stream()).
      peek(parkingSlot -> System.out.println("Flatmapped aisles to get parkingSlots : " + parkingSlot.toString())).
      map(ParkingSlot::getVehicle).
      peek(optVehicle -> System.out.println("Mapped aisles to get vehicles : " + optVehicle.toString())).
      filter(Optional::isPresent).
      peek(optVehicle -> System.out.println("Filtered vehicles to remove empty options : " + optVehicle.toString())).
      map(Optional::get).
      collect(Collectors.toList());
  }

  public static void printVehicles(Parking parking) {
    Function<Vehicle, String> toStringVehicle = (vehicle) -> "Found a " + vehicle.getColor() + " " +
      vehicle.getMake() + " " + vehicle.getModel() + " with " + vehicle.getNbWheels() + " wheels that weights " +
      vehicle.getWeight() + "kg.";
    listVehicles(parking).stream().map(toStringVehicle::apply).forEach(System.out::println);
  }

  public static Stream<Vehicle> sortByMake(Stream<Vehicle> vehicles) {
    return vehicles.sorted(Comparator.comparing(Vehicle::getMake));
  }

}
