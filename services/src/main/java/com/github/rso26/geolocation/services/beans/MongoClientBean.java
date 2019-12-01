package com.github.rso26.geolocation.services.beans;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class MongoClientBean {

    private Logger log = Logger.getLogger(RouteBean.class.getName());

    private MongoClient mongoClient;
    @Inject
    private ConfigPropertiesMongoClient configPropertiesMongoClient;

    @PostConstruct
    private void init() {
        log.info("init (with MongoClient's configuration properties: " + configPropertiesMongoClient + ") called!");
        mongoClient = MongoClients.create(configPropertiesMongoClient.getConnectionString());
    }

    @PreDestroy
    private void dispose() {
        if(mongoClient != null) {
            mongoClient.close();
        }
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
