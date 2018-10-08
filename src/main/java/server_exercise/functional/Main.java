package server_exercise.functional;

import server_exercise.common.VehicleRepository;

public class Main {

  public static void main(String[] args) throws Exception {
    /* TODO :
       1 - implements the VehicleService
       2 - then the HttpClient (including the way to build Vehicles from Strings)
       3 - then implements the VehicleApi
       4 - make sure your calls to the repository are non-blocking

       Start your server here and then test with POSTMAN or INSOMNIA
     */

    // DO NOT REMOVE THIS LINE
    VehicleRepository.start();
    // VehicleRepository answer any http request by sending a list of vehicles.
    // Its address can be retrieve with VehicleRepository.ADDRESS

    Server server = new Server("127.0.0.1", 9000);
    server.startSync();
  }
}
