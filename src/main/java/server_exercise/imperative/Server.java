package server_exercise.imperative;

public class Server {

  private final org.eclipse.jetty.server.Server server;

  public Server(int port) {
    this.server = new org.eclipse.jetty.server.Server(port);

    VehicleApi vehicleApi = new VehicleApi();
    this.server.setHandler(vehicleApi.getHandler());
  }

  public void start() throws Exception {
    this.server.start();
    this.server.join();
  }
}
