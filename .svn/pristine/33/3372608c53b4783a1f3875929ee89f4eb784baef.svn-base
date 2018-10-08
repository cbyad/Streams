package domain;

public abstract class Vehicle {

  private final String make;
  private final String model;
  private final String color;
  private final int weight;
  private final int nbWheels;

  Vehicle(String make, String model, String color, int weight, int nbWheels) {
    this.make = make;
    this.model = model;
    this.color = color;
    this.weight = weight;
    this.nbWheels = nbWheels;
  }

  public String getMake() {
    return this.make;
  }

  public String getModel() {
    return this.model;
  }

  public String getColor() {
    return this.color;
  }

  public int getWeight() {
    return this.weight;
  }

  public int getNbWheels() {
    return this.nbWheels;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Vehicle vehicle = (Vehicle) o;

    if (weight != vehicle.weight) return false;
    if (nbWheels != vehicle.nbWheels) return false;
    if (make != null ? !make.equals(vehicle.make) : vehicle.make != null) return false;
    if (model != null ? !model.equals(vehicle.model) : vehicle.model != null) return false;
    return color != null ? color.equals(vehicle.color) : vehicle.color == null;
  }

  @Override
  public int hashCode() {
    int result = make != null ? make.hashCode() : 0;
    result = 31 * result + (model != null ? model.hashCode() : 0);
    result = 31 * result + (color != null ? color.hashCode() : 0);
    result = 31 * result + weight;
    result = 31 * result + nbWheels;
    return result;
  }
}
