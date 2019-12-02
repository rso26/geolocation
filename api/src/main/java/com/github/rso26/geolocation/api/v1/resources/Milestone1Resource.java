package com.github.rso26.geolocation.api.v1.resources;

import com.kumuluz.ee.common.runtime.EeRuntime;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("milestone1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class Milestone1Resource {

    private Logger log = Logger.getLogger(Milestone1Resource.class.getName());

    @GET
    @Path("instanceid")
    public Response getInstanceId() {
        String instanceId =
                "{\"instanceId\" : \"" + EeRuntime.getInstance().getInstanceId() + "\"}";
        return Response.ok(instanceId).build();
    }

    @GET
    @Path("info")
    public Response info() {
        JsonObject json = Json.createObjectBuilder()
                .add("clani", Json.createArrayBuilder().add("at4005"))
                .add("opis_projekta", "Tema projekta, ki ga razvija skupina 26 je platforma za iskanje in organizacijo prevozov. Portal nam med drugim omogoča: objavo prevozov (in vodenih izletov), iskanje po katalogu aktualnih prevozov, obveščanje o novih prevozih, ki ustrezajo podanim parametrom iskanja (vstop, izstop, čas, tip vozila, ipd.), upravljanje prevoza (pridružitev, preklic, zapustitev, pregled dejavnosti oziroma aktivnosti v obliki dnevnika dogodkov), dodajanje komentarjev (besedila, slik, kratkih videoposnetkov) na oglasno desko posameznega prevoza in deljenje geolokacije voznika (opcijsko tudi potnika/ov) v realnem času. Cilj projekta je torej razviti programsko rešitev (\"cloud native\"), ki bo izkoriščala prednosti oblačnega okolja in temeljila na arhitekturi mikrostoritev (krajše MS).")
                .add("mikrostoritve", Json.createArrayBuilder()
                        .add("http://35.204.157.186/v1/ride_offers/instanceid")
                        .add("http://35.204.19.241/v1/route/instanceid")
                )
                .add("github", Json.createArrayBuilder()
                        .add("https://github.com/rso26/ride_catalog")
                        .add("https://github.com/rso26/geolocation")
                        .add("https://github.com/rso26/notification_mngt")
                        .add("https://github.com/rso26/attachments")
                        .add("https://github.com/rso26/timeline")
                )
                .add("travis", Json.createArrayBuilder()
                        .add("https://travis-ci.org/rso26/ride_catalog")
                        .add("https://travis-ci.org/rso26/geolocation")
                        .add("https://travis-ci.org/rso26/notification_mngt")
                )
                .add("dockerhub", Json.createArrayBuilder()
                        .add("https://hub.docker.com/repository/docker/rso26/geolocation")
                        .add("https://hub.docker.com/repository/docker/rso26/ride-catalogue")
                )
                .build();

        return Response.ok(json.toString()).build();
    }

}
