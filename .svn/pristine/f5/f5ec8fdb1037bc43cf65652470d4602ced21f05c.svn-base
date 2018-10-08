package server_exercise.functional;

import io.netty.handler.codec.http.HttpMethod;
import org.reactivestreams.Publisher;
import reactor.ipc.netty.http.server.HttpServerRequest;
import reactor.ipc.netty.http.server.HttpServerResponse;

class VehicleApi {

  /*  ---
      Implements the methods below

      The list of the vehicles can be retrieved doing an HTTP request on the VehicleRepository.ADDRESS.
      Use the HttpClient to retrieve the vehicles as a String, you will then need to build instances of the proper
      classes from the String. Make use of Jackson Jr to do that.

      Make use of the common.JsonWriter.write method to transform your Java beans into json objects

      Note : for the make model and color API, you have to deal with the way users can send the value of their choice
      to your API
   */

  private final static String BASE_ROUTE = "vehicle";

  private final static String ALL_ROUTE = "all";
  private final static String CARS_ROUTE = "cars";
  private final static String MOTORCYCLE_ROUTE = "motorcycle";
  private final static String TRUCKS_ROUTE = "trucks";
  private final static String BY_MAKE_ROUTE = "make";
  private final static String BY_MODEL_ROUTE = "model";
  private final static String BY_COLOR_ROUTE = "color";

  public boolean isQueryPath(HttpServerRequest request) {
    return request.path().startsWith(BASE_ROUTE);
  }

  public Publisher<Void> handler(HttpServerRequest request, HttpServerResponse response) {
    if (!request.method().equals(HttpMethod.GET))
      return response.sendNotFound();

    return this.route(request, response);
  }

  private Publisher<Void> route(HttpServerRequest request, HttpServerResponse response) {
    String subRoute = request.path().substring(BASE_ROUTE.length() + 1);

    if(subRoute.equals(ALL_ROUTE))
      return this.all(request, response);
    else if (subRoute.equals(CARS_ROUTE))
      return this.cars(request, response);
    else if (subRoute.equals(MOTORCYCLE_ROUTE))
      return this.motorcycles(request, response);
    else if (subRoute.equals(TRUCKS_ROUTE))
      return this.trucks(request, response);
    else if (subRoute.equals(BY_MAKE_ROUTE))
      return this.make(request, response);
    else if (subRoute.equals(BY_MODEL_ROUTE))
      return this.model(request, response);
    else if (subRoute.equals(BY_COLOR_ROUTE))
      return this.color(request, response);

    else return response.sendNotFound();
  }

  private Publisher<Void> all(HttpServerRequest request, HttpServerResponse response) {
    // TODO
    return null;
  }

  private Publisher<Void> cars(HttpServerRequest request, HttpServerResponse response) {
    // TODO
    return null;
  }

  private Publisher<Void> motorcycles(HttpServerRequest request, HttpServerResponse response) {
    // TODO
    return null;
  }

  private Publisher<Void> trucks(HttpServerRequest request, HttpServerResponse response) {
    // TODO
    return null;
  }

  private Publisher<Void> make(HttpServerRequest request, HttpServerResponse response) {
    // TODO
    return null;
  }

  private Publisher<Void> model(HttpServerRequest request, HttpServerResponse response) {
    // TODO
    return null;
  }

  private Publisher<Void> color(HttpServerRequest request, HttpServerResponse response) {
    // TODO
    return null;
  }

}
