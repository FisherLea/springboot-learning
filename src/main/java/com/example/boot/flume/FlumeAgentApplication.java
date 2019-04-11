package com.example.boot.flume;

import org.apache.flume.node.Application;
import org.apache.flume.node.PropertiesFileConfigurationProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;

public class FlumeAgentApplication {

    private static final Logger logger = LoggerFactory.getLogger(FlumeAgentApplication.class);

    public static final String AGENT_NAME = "agent_app";

    public static void start(String propsFilePath){
        try{
            File file = ResourceUtils.getFile(propsFilePath);
            PropertiesFileConfigurationProvider configurationProvider =
                    new PropertiesFileConfigurationProvider(AGENT_NAME, file);
            Application application = new Application();
            application.handleConfigurationEvent(configurationProvider.getConfiguration());

            application.start();
            Runtime.getRuntime().addShutdownHook(new Thread("agent-shutdown-hook") {
                @Override
                public void run() {
                    application.stop();
                }
            });
        }catch (Exception e){
            logger.error("A fatal error occurred while running. Exception follows.", e);
        }
    }
}
