package stream_exercise;

import java.util.*;
import java.util.function.Function;

import domain.*;

public class ImperativeParkingUtils {

    // In this file, do not make use of the Streams

    public static <T> List<T> arrayToList(T[] array) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }

    // I think is arrayToSet
    public static <T> Set<T> streamToSet(T[] array) {
        Set<T> result = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }
        return result;
    }

    public static Map<String, Vehicle> mapMakeModelWithVehicle(Vehicle[] vehicles) {
        Function<Vehicle, String> vehicleToMakeModel = (vehicle) -> "Make: " + vehicle.getMake() + ", Model: "
                + vehicle.getModel();

        Map<String, Vehicle> map = new HashMap<>();
        for (Vehicle v : vehicles) {
            map.put(vehicleToMakeModel.apply(v), v);
        }
        return map;
    }

    public static Set<String> findMakes(Vehicle[] vehicles) {
        Set<String> makes = new HashSet<>();
        for (Vehicle v : vehicles) {
            makes.add(v.getMake());
        }
        return makes;
    }

    public static Vehicle[] vehiclesWithMoreThan3Wheels(Vehicle[] vehicles) {
        Vehicle[] result = new Vehicle[vehicles.length];
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getNbWheels() > 3)
                result[i] = vehicles[i];
        }
        return result;
    }

    public static boolean hasAnyCar(Vehicle[] vehicles) {
        for (Vehicle v : vehicles) {
            if (v instanceof Car)
                return true;
        }
        return false;

    }

    public static boolean areAllCars(Vehicle[] vehicles) {

        // Hint : try to find if all vehicle in the stream match the predicate "is this
        // vehicle a Car ?"
        for (Vehicle v : vehicles) {
            if (v instanceof Car)
                continue;
            else return false;
        }
        return true;
    }

    public static int findMaxWeight(Vehicle[] vehicles) {
        int max = 0;
        for (Vehicle v : vehicles) {
            if (v.getWeight() > max)
                max = v.getWeight();
        }
        return max;
    }

    public static int findMinNbOfWheels(Vehicle[] vehicles) {
        int min = Integer.MAX_VALUE;
        for (Vehicle v : vehicles) {
            if (v.getNbWheels() < min)
                min = v.getNbWheels();
        }
        return min;
    }

    public static long countVehicles(Floor floor) {
        int nbr = 0;
        for (Aisle aisle : floor.getAisles().values()) {
            for (ParkingSlot parkingSlot : aisle.getParkingSlots().values()) {
                nbr = parkingSlot.getVehicle().isPresent() ? nbr++ : nbr;
            }
        }
        return nbr;
    }

    public static long countVehicles(Parking parking) {
        int nbr = 0;
        for (Floor floor : parking.getFloors()) {
            for (Aisle aisle : floor.getAisles().values()) {
                for (ParkingSlot parkingSlot : aisle.getParkingSlots().values()) {
                    nbr = parkingSlot.getVehicle().isPresent() ? nbr++ : nbr;
                }
            }
        }
        return nbr;
    }

    public static Floor findLeastOccupiedFloor(Parking parking) {
        int leastOccupiedIndex = 0;
        int leastOccupiedSize = Integer.MAX_VALUE;

        for (int i = 0; i < parking.getFloors().size(); i++) {
            if (countVehicles(parking.getFloors().get(i)) < leastOccupiedSize)
                leastOccupiedIndex = i;
        }
        return parking.getFloors().get(leastOccupiedIndex);
    }

    public static Set<String> findMakes(Parking parking) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Floor floor : parking.getFloors()) {
            for (Aisle aisle : floor.getAisles().values()) {
                for (ParkingSlot parkingSlot : aisle.getParkingSlots().values()) {
                    if (parkingSlot.getVehicle().isPresent())
                        vehicles.add(parkingSlot.getVehicle().get());
                }
            }
        }
        return findMakes((Vehicle[]) vehicles.toArray());
    }

    public static String listMakes(Parking parking) {
        Set<String> makes = findMakes(parking);
        StringBuilder stringBuilder = new StringBuilder();

        for (Iterator<String> it = makes.iterator(); it.hasNext(); ) {
            String str = it.next();
            stringBuilder.append(str + "\n");
        }
        return stringBuilder.toString();
    }

    public static String listMakesWithReduce(Parking parking) {
        // TODO
        // Desired result: for a Parking with cars of makes A and B, the string "A\nB"
        return null;
    }

    public static Optional<Truck> findAnyTruck(Vehicle[] vehicles) {
        // TODO
        return Optional.empty();
    }

    public static Vehicle[] listVehicles(Parking parking) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Floor floor : parking.getFloors()) {
            for (Aisle aisle : floor.getAisles().values()) {
                for (ParkingSlot parkingSlot : aisle.getParkingSlots().values()) {
                    if (parkingSlot.getVehicle().isPresent())
                        vehicles.add(parkingSlot.getVehicle().get());
                }
            }
        }
        return (Vehicle[]) vehicles.toArray();
    }


    public static List<Vehicle> listVehiclesDebug(Parking parking) {
        // TODO : same method as above but logging what each step do.
        return null;
    }

    public static void printVehicles(Parking parking) {
        Function<Vehicle, String> toStringVehicle = (vehicle) -> "Found a " + vehicle.getColor() + " " + vehicle.getMake()
                + " " + vehicle.getModel() + " with " + vehicle.getNbWheels() + " wheels that weights " + vehicle.getWeight()
                + "kg.";
     arrayToList(listVehicles(parking)).forEach(vehicle -> toStringVehicle.apply(vehicle));
    }

    public static Vehicle[] sortByMake(Vehicle[] vehicles) {
        // TODO
        return null;
    }
}
