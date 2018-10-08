package stream_exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import domain.Floor;
import domain.Parking;
import domain.Truck;
import domain.Vehicle;

public class ParkingUtils {

  public static <T> List<T> streamToList(Stream<T> stream) {
    // TODO
    return null;
  }

  public static <T> Set<T> streamToSet(Stream<T> stream) {
    // TODO
    return null;
  }

  public static Map<String, Vehicle> mapMakeModelWithVehicle(Stream<Vehicle> vehicles) {
    Function<Vehicle, String> vehicleToMakeModel = (vehicle) -> "Make: " + vehicle.getMake() + ", Model: " + vehicle.getModel();
    // TODO
    return null;
  }

  public static Set<String> findMakes(List<Vehicle> vehicles) {
    // TODO
    return null;
  }

  public static List<Vehicle> vehiclesWithMoreThan3Wheels(List<Vehicle> vehicles) {
    // TODO
    return null;
  }

  public static boolean hasAnyCar(Stream<Vehicle> vehicles) {
    // TODO
    return false;
  }

  public static boolean areAllCars(Stream<Vehicle> vehicles) {
    // TODO
    return false;
  }

  public static int findMaxWeight(List<Vehicle> vehicles) {
    // TODO
    return 0;
  }

  public static int findMinNbOfWheels(List<Vehicle> vehicles) {
    // TODO
    return 0;
  }

  public static long countVehicles(Floor floor) {
    // TODO
    return 0;
  }

  public static long countVehicles(Parking parking) {
    // TODO
    return 0;
  }

  public static Floor findLeastOccupiedFloor(Parking parking) {
    // TODO
    return null;
  }

  public static Set<String> findMakes(Parking parking) {
    // TODO
    return null;
  }

  public static String listMakes(Parking parking) {
    // TODO
    // Desired result: for a Parking with cars of makes A and B, the string "A\nB"
    return null;
  }

  public static String listMakesWithReduce(Parking parking) {
    // TODO
    // Desired result: for a Parking with cars of makes A and B, the string "A\nB"
    return null;
  }

  public static Optional<Truck> findAnyTruck(Stream<Vehicle> vehicles) {
    // TODO
    return Optional.empty();
  }

  public static <T> ArrayList<T> collectToListWithReduce(Stream<T> stream) {
    // TODO
    return null;
  }

  public static List<Vehicle> listVehicles(Parking parking) {
    // TODO
    return null;
  }

  public static List<Vehicle> listVehiclesDebug(Parking parking) {
    // TODO : same method as above but logging what each step do.
    // For example if you do stream.map.filter, you must log in the console map(...) and then filter(...). This,
    // without logging everything at the end of the method.
    return null;
  }

  public static void printVehicles(Parking parking) {
    Function<Vehicle, String> toStringVehicle = (vehicle) -> "Found a " + vehicle.getColor() + " " +
      vehicle.getMake() + " " + vehicle.getModel() + " with " + vehicle.getNbWheels() + " wheels that weights " +
      vehicle.getWeight() + "kg.";

    // TODO : for each vehicle, display the result of the above function into the stdout (standard output)
  }

  public static Stream<Vehicle> sortByMake(Stream<Vehicle> vehicles) {
    // TODO
    return null;
  }
}
