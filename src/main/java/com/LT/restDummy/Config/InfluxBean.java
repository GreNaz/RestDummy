package com.LT.restDummy.Config;

import com.LT.restDummy.influx.InfluxConnect;
import com.LT.restDummy.influx.InfluxWriter;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.TimeUnit;

@Configuration
@PropertySource("classpath:/influxDB.properties")
public class InfluxBean {

    @Bean("InfluxDB")
    public InfluxDB influxdbFactory(@Value("${influxdb.connect.url}") String url,
                                    @Value("${influxdb.username}") String username,
                                    @Value("${influxdb.batch.byCount}") int actions,
                                    @Value("${influxdb.batch.byTimeInMs}") int flush) {
        InfluxDBFactory factory;
        factory = InfluxDBFactory.INSTANCE;
        InfluxDB influxDB = factory.connect(url, username, username);
        influxDB.enableBatch(actions, flush, TimeUnit.MILLISECONDS);
        return influxDB;
    }

    @Bean("InfluxWriter")
    public InfluxWriter influxWriter(@Value("${influxdb.database}") String db,
                                     @Value("${influxdb.retentionpolicy}") String retentionpolicy) {
        return InfluxWriter.getInstance().initialize(db, retentionpolicy);
    }

    @Bean("InfluxConnect")
    public InfluxConnect InfluxConnect(@Value("${influxdb.database}") String db,
                                       @Value("${influxdb.retentionpolicy}") String retentionpolicy,
                                       @Value("${influxdb.subsystem}") String subsystem,
                                       @Value("${influxdb.block}") String block,
                                       @Value("${influxdb.chanel}") String chanel) {
        InfluxConnect influxConnect = new InfluxConnect();
        influxConnect.setDb(db);
        influxConnect.setRetentionPolicy(retentionpolicy);
        influxConnect.setSubsystem(subsystem);
        influxConnect.setBlock(block);
        influxConnect.setChanel(chanel);
        return influxConnect;
    }
}
