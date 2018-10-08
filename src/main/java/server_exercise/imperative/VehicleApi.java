package server_exercise.imperative;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

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

  private final static String BASE_ROUTE = "/vehicle";

  private final static String ALL_ROUTE = "all";
  private final static String CARS_ROUTE = "cars";
  private final static String MOTORCYCLE_ROUTE = "motorcycle";
  private final static String TRUCKS_ROUTE = "trucks";
  private final static String BY_MAKE_ROUTE = "make";
  private final static String BY_MODEL_ROUTE = "model";
  private final static String BY_COLOR_ROUTE = "color";

  Handler getHandler() {
    return new AbstractHandler() {
      @Override
      public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!baseRequest.getMethod().equals(HttpMethod.GET.asString()) || !target.startsWith(BASE_ROUTE)) {
          response.sendError(HttpStatus.NOT_FOUND_404);
          baseRequest.setHandled(true);
        } else {
          String subRoute = target.substring(BASE_ROUTE.length() + 1);

          if(subRoute.equals(ALL_ROUTE))
            all(baseRequest, request, response);
          else if (subRoute.equals(CARS_ROUTE))
            cars(baseRequest, request, response);
          else if (subRoute.equals(MOTORCYCLE_ROUTE))
            motorcycles(baseRequest, request, response);
          else if (subRoute.equals(TRUCKS_ROUTE))
            trucks(baseRequest, request, response);
          else if (subRoute.equals(BY_MAKE_ROUTE))
            make(baseRequest, request, response);
          else if (subRoute.equals(BY_MODEL_ROUTE))
            model(baseRequest, request, response);
          else if (subRoute.equals(BY_COLOR_ROUTE))
            color(baseRequest, request, response);
        }
      }
    };
  }

  private void all(Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
    // TODO
  }

  private void cars(Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
    // TODO
  }

  private void motorcycles(Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
    // TODO
  }

  private void trucks(Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
    // TODO
  }

  private void make(Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
    // TODO
  }

  private void model(Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
    // TODO
  }

  private void color(Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
    // TODO
  }

}
