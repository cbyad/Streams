package server_exercise.functional;

import reactor.ipc.netty.http.server.HttpServer;
import reactor.ipc.netty.http.server.HttpServerRoutes;
import reactor.ipc.netty.tcp.BlockingNettyContext;

public class Server {

  private final HttpServer httpServer;
  private final HttpServerRoutes routes;

  Server(String host, int port) {
    VehicleApi vehicleApi = new VehicleApi();

    this.routes = HttpServerRoutes.newRoutes().
      route(vehicleApi::isQueryPath, vehicleApi::handler);

    this.httpServer = HttpServer.create(host, port);
  }

  void startSync() {
    this.httpServer.startAndAwait(this.routes, this::onStart);
  }

  Thread start() {
    Thread t = new Thread(() -> this.startSync());
    t.start();
    return t;
  }

  private void onStart(BlockingNettyContext context) {
    System.out.println("Server started on Host: " + context.getHost() + ":" + context.getPort());
  }

}
