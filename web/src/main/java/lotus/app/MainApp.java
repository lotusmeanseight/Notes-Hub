package lotus.app;

import org.springframework.boot.SpringApplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@EnableNeo4jRepositories(basePackages = {"lotus.entity"})
@SpringBootApplication
public class MainApp {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args){
        LOGGER.debug("Application started");
        SpringApplication.run(MainApp.class, args);
    }

}
