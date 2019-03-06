package stream_exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.Collectors;


import domain.*;

public class ParkingUtils {

    public static <T> List<T> streamToList(Stream<T> stream) {
        return stream.collect(Collectors.toList());
    }

    public static <T> Set<T> streamToSet(Stream<T> stream) {
        return stream.collect(Collectors.toSet());
    }


    public static Map<String, Vehicle> mapMakeModelWithVehicle(Stream<Vehicle> vehicles) {
        Function<Vehicle, String> vehicleToMakeModel = (vehicle) -> "Make: " + vehicle.getMake() + ", Model: " + vehicle.getModel();

        return vehicles.collect(Collectors.toMap(v -> vehicleToMakeModel.apply(v), Function.identity()));

    }

    public static Set<String> findMakes(List<Vehicle> vehicles) {
        return streamToSet(vehicles.stream().map(Vehicle::getMake));
    }

    public static List<Vehicle> vehiclesWithMoreThan3Wheels(List<Vehicle> vehicles) {
        return streamToList(vehicles.stream().filter(v -> v.getNbWheels() > 3));
    }

    public static boolean hasAnyCar(Stream<Vehicle> vehicles) {
        return vehicles.anyMatch(v -> v instanceof Car);
        //return rep = vehicles.filter(v-> v instanceof Car).count() >=1 ;
    }

    public static boolean areAllCars(Stream<Vehicle> vehicles) {
        return vehicles.allMatch(v -> v instanceof Car);
        //return rep = vehicles.filter(v-> v instanceof Car).count() == vehicles.count();
    }

    public static int findMaxWeight(List<Vehicle> vehicles) {
        return vehicles
                .stream()
                .map(Vehicle::getWeight)
                .max(Comparator.comparingInt(Integer::intValue))
                .orElse(0);
    }

    public static int findMinNbOfWheels(List<Vehicle> vehicles) {
        return vehicles
                .stream()
                .map(Vehicle::getNbWheels)
                .max(Comparator.comparingInt(Integer::intValue))
                .orElse(0);
    }

    public static long countVehicles(Floor floor) {
        // floor [getAisles] --> Map<char,Aisle [getParkingSlots] --> Map<Integer, ParkingSlot [getVehicule] --> Optional <Vehicule> >   >
        return floor.getAisles().values().stream()
                .flatMap(aisle -> aisle.getParkingSlots().values().stream())
                .map(ParkingSlot::getVehicle)
                .filter(Optional::isPresent)
                .count();

    }

    public static long countVehicles(Parking parking) {
        return parking.getFloors().stream()
                .map(floor -> countVehicles(floor))
                .reduce(0L, Long::sum); // Not sure
    }

    public static Floor findLeastOccupiedFloor(Parking parking) {
        return parking.getFloors().stream()
                .reduce(((floor1, floor2) -> countVehicles(floor1) < countVehicles(floor2) ? floor1 : floor2)).get();
    }


    public static Set<String> findMakes(Parking parking) {
        List<Vehicle> vehicles = parking.getFloors().stream()
                .flatMap(floor -> getAll(floor))
                .collect(Collectors.toList());
        return findMakes(vehicles);
    }

    private static Stream<Vehicle> getAll(Floor floor) {
        return floor.getAisles().values().stream()
                .flatMap(aisle -> aisle.getParkingSlots().values().stream())
                .map(ParkingSlot::getVehicle)
                .filter(Optional::isPresent)
                .map(Optional::get);
    }

    public static String listMakes(Parking parking) {
        return findMakes(parking).stream().collect(Collectors.joining("\n"));
    }

    public static String listMakesWithReduce(Parking parking) {
        // TODO
        // Desired result: for a Parking with cars of makes A and B, the string "A\nB"
        return null;
    }


    public static Optional<Truck> findAnyTruck(Stream<Vehicle> vehicles) {
        return vehicles.filter(vehicle -> vehicle instanceof Truck)
                .map(t -> (Truck) t).findAny();
    }

    public static <T> ArrayList<T> collectToListWithReduce(Stream<T> stream) {
        // TODO
        return null;
    }

    public static List<Vehicle> listVehicles(Parking parking) {
        return parking.getFloors().stream()
                .flatMap(floor -> getAll(floor))
                .collect(Collectors.toList());
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

        listVehicles(parking).stream()
                .map(vehicle -> toStringVehicle.apply(vehicle))
                .forEach(System.out::println);
    }

    public static Stream<Vehicle> sortByMake(Stream<Vehicle> vehicles) {
            return vehicles.sorted(Comparator.comparing(Vehicle::getMake));
    }
}
