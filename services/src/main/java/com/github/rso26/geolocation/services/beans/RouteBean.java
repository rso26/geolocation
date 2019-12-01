package com.github.rso26.geolocation.services.beans;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.geojson.Point;
import org.bson.Document;
import org.github.rso26.geolocation.models.Route;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.near;

@ApplicationScoped
public class RouteBean {

    private static final String DB_NAME = "geolocation";
    private static final String DB_COLLECTION_ROUTES = "routes";
    private Logger log = Logger.getLogger(RouteBean.class.getName());
    private Jsonb jsonb = JsonbBuilder.create();;

//    this does not work
//    @Inject
//    private EntityManager em;
//    private EntityManagerFactory emf;
//    private javax.transaction.TransactionManager transactionManager;

    @Inject
    private MongoClientBean mcb;
    private MongoCollection<Document> routesCollection;

    @PostConstruct
    public void init() {
        log.info("init called!");
        MongoDatabase db = mcb.getMongoClient().getDatabase(DB_NAME);
        routesCollection = db.getCollection(DB_COLLECTION_ROUTES);
        routesCollection.createIndex(Indexes.geo2dsphere("snappedWaypoints", "points"));
//        emf = Persistence.createEntityManagerFactory("ogm-mongodb");
//        transactionManager = TransactionManager.transactionManager();
    }

    public Route getRouteById(UUID uuid) {
        Document result = routesCollection.find(eq("routeUuid", uuid.toString())).first();
        if(result != null) {
            return jsonb.fromJson(result.toJson(), Route.class);
        }
        return null;
    }

    public List<Route> getRoutesNear(Point refPoint) {
        // TODO: 05/11/2019 finish this
        MongoCursor<Document> iter = routesCollection.find(near("snappedWaypoints", refPoint, 10_000.0, 0.0)).limit(10).iterator();
        List<Route> results = new ArrayList<>();
        while(iter.hasNext()) {
            results.add(jsonb.fromJson(iter.next().toJson(), Route.class));
        }
        return results;
    }

    public void createRoute(Route route) {
        routesCollection.insertOne(Document.parse(jsonb.toJson(route)));
//        testOGM();
    }

// Object grid mapper (uses JPA and extends it)
//    private void testOGM() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            transactionManager.begin();
//            log.info("Persisting RouteEntity to db...");
//            em.persist(new RouteEntity(UUID.randomUUID().toString(), System.currentTimeMillis()));
//            em.close();
//            transactionManager.commit();
//        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
//            e.printStackTrace();
//            try {
//                transactionManager.rollback();
//            } catch (SystemException ex) {
//                ex.printStackTrace();
//            }
//        } finally {
//            if(em != null && em.isOpen()) {
//                em.close();
//            }
//        }
//    }
}
