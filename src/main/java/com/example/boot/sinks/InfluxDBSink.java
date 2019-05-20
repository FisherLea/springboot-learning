package com.example.boot.sinks;

import org.apache.flume.Context;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InfluxDBSink extends AbstractSink implements Configurable {

    private final Logger logger = LoggerFactory.getLogger(InfluxDBSink.class);

    private String host;
    private String username;
    private String password;
    private String database;
    private String retentionPolicy;

    private InfluxDB influxDB;

    @Override
    public Status process() throws EventDeliveryException {
        return null;
    }

    @Override
    public void configure(Context context) {
        host = context.getString("host");
        username = context.getString("username");
        password = context.getString("password");
        database = context.getString("database");
        retentionPolicy = context.getString("retentionPolicy");
    }

    @Override
    public synchronized void start() {
        super.start();
        influxDB = InfluxDBFactory.connect(host, username, password);
    }

    @Override
    public synchronized void stop() {
        super.stop();
        if(influxDB != null){
            influxDB.close();
        }
    }
}
