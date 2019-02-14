package lotus.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigApp {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args){
        LOGGER.debug("Config started");
        SpringApplication.run(ConfigApp.class, args);
    }

}
