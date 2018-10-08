package server_exercise.common;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.netty.handler.codec.http.HttpResponseStatus;

import reactor.core.publisher.Mono;
import reactor.ipc.netty.http.server.HttpServer;
import reactor.ipc.netty.http.server.HttpServerRoutes;

import domain.Car;
import domain.Motorcycle;
import domain.Truck;
import domain.Vehicle;

public class VehicleRepository {

  private static String HOST = "127.0.0.1";
  private static int PORT = 7777;

  public static String ADDRESS = HOST + ":" + PORT;

  public static void start() {
    HttpServer httpServer = HttpServer.create(HOST, PORT);

    HttpServerRoutes routes = HttpServerRoutes.newRoutes().
      route((request) -> true, (request, response) -> {
        try {
          String message = JsonWriter.write(all());
          return response.
            status(HttpResponseStatus.OK).
            header("content-type", "application/json").
            sendString(Mono.just(message)).then();
        } catch (IOException e) {
          return response.status(HttpResponseStatus.INTERNAL_SERVER_ERROR).sendString(Mono.just(e.getMessage())).then();
        }
      });

    Thread t = new Thread(() -> httpServer.startAndAwait(routes));
    t.start();
  }

  private final static Car mercedes = new Car("mercedes", "a-class", "black", 1320);
  private final static Car clio = new Car("renault", "clio", "red", 1100);
  private final static Car peugeot = new Car("peugeot", "208", "grey", 1100);

  private final static Motorcycle gsxr = new Motorcycle("suzuki", "gsxr", "red-white-bleu", 180);
  private final static Motorcycle cross = new Motorcycle("yamaha", "yzf", "blue", 112);

  private final static Truck american = new Truck("chevy", "8000", "blue", 80000);
  private final static Truck european = new Truck("man", "carrier", "grey", 8000);

  private static List<Vehicle> all() {
    // Sleep the thread for a few ms to simulate a network call
    return Arrays.asList(mercedes, clio, peugeot, gsxr, cross, american, european);
  }

}
