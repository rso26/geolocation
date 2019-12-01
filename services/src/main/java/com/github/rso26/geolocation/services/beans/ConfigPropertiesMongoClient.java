package com.github.rso26.geolocation.services.beans;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigBundle("kumuluzee.mongoclient")
public class ConfigPropertiesMongoClient {
    private String connectionString;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public String toString() {
        return "ConfigPropertiesMongoClient{" +
                "connectionString='" + connectionString + '\'' +
                '}';
    }
}
