package com.github.rso26.geolocation.api.v1;

import com.kumuluz.ee.discovery.annotations.RegisterService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@RegisterService
@ApplicationPath("/v1")
@OpenAPIDefinition(info = @Info(title = "GeolocationApi", version = "v1.0.0"), servers = @Server(url = "http://localhost:8084/v1"))
public class GeolocationApplication extends Application {
}
