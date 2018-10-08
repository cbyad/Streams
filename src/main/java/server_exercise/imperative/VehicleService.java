package server_exercise.imperative;

import java.util.List;

import domain.Car;
import domain.Motorcycle;
import domain.Truck;
import domain.Vehicle;
import server_exercise.common.VehicleServiceInterface;

public class VehicleService implements VehicleServiceInterface {

  /* ---
     Implements the methods using the VehicleRepository.all() as the source of data

     You can't make use of Java streams in this implementation, these are purely functional.
   */

  // INFO : you don't need to create a constructor if it has no parameter

  @Override
  public List<Vehicle> byMake(String make) {
    return null;
  }

  @Override
  public List<Vehicle> byModel(String model) {
    return null;
  }

  @Override
  public List<Vehicle> byColor(String color) {
    return null;
  }

  @Override
  public List<Car> allCars() {
    return null;
  }

  @Override
  public List<Motorcycle> allMotorcycles() {
    return null;
  }

  @Override
  public List<Truck> allTrucks() {
    return null;
  }

  @Override
  public List<Vehicle> allVehicles() {
    return null;
  }

}
