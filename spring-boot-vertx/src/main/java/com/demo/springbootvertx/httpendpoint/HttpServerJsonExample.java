package com.demo.springbootvertx.httpendpoint;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class HttpServerJsonExample {
    public static void main(String... args) {
        Vertx vertx = Vertx.vertx(); 
 
        vertx.createHttpServer()
         .requestHandler(req -> {
             JsonObject json = new JsonObject()
                 .put("message", "hello");
            req.response()
                 .putHeader("Content-Type", "application/json; charset=UTF8")
                 .end(json.encodePrettily());
         })
         .listen(8080);
     }
}
