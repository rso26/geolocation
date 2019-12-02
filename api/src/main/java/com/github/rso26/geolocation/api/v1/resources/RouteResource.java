package com.github.rso26.geolocation.api.v1.resources;

import com.github.rso26.geolocation.services.beans.RouteBean;
import com.kumuluz.ee.common.runtime.EeRuntime;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.github.rso26.geolocation.models.Route;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Path("route")
@Produces(MediaType.APPLICATION_JSON)
public class RouteResource {

    @Inject
    private RouteBean routeBean;

    @Context
    protected UriInfo uriInfo;

    @GET
    @Path("instanceid")
    public Response getInstanceId() {
        String instanceId =
                "{\"instanceId\" : \"" + EeRuntime.getInstance().getInstanceId() + "\"}";
        return Response.ok(instanceId).build();
    }

    @GET
    @Operation(summary = "Get route by uuid", tags = {"route"}, description = "Return route details.",
            responses = {
                    @ApiResponse(description = "Route details", responseCode = "200", content = @Content(schema =
                    @Schema(implementation = Route.class))
                    )
            })
    @Path("{routeUuid}")
    public Response getRoute(@PathParam("routeUuid") String routeUuid) {
        Route route = routeBean.getRouteById(UUID.fromString(routeUuid));
        if(route == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(route).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRoutesNear(@QueryParam("lont") double lon, @QueryParam("lat") double lat) {
        Point refPoint = new Point(new Position(lon, lat));
        List<Route> re = routeBean.getRoutesNear(refPoint);
        return Response.status(Response.Status.OK).entity(re).build();
    }

    @POST
    @Operation(summary = "Create route", tags = {"route"}, description = "Create new route.",
            responses = {
                    @ApiResponse(description = "Route details", responseCode = "200", content = @Content(schema =
                    @Schema(implementation = Route.class))
                    )
            })
    public Response createRoute(Route route) {
        if(route == null) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
        routeBean.createRoute(route);
        return Response.status(Response.Status.OK).build();
    }

    // TODO: 05/11/2019 retrieve routes nearby, routes within the given polygon (isochrone), update waypoints, etc.
}
