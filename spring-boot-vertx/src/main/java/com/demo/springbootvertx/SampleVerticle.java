package com.demo.springbootvertx;

import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

@Component
public class SampleVerticle extends AbstractVerticle {

    private Vertx myVertx;

    @Override
    public void start() throws Exception {

        // SpringApplication.run(SampleVerticle.class);
        // System.out.println("SampleVerticle started!");
        // this.myVertx = vertx;
        // myVertx.createHttpServer().requestHandler(httpServerRequest -> {}).listen(8080);

        Vertx vertx = Vertx.vertx();
        System.out.println("Vert.x instance: " + vertx);

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

    @Override
    public void stop() throws Exception {

    }

    
}