package tourist_guide_by_cities_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class TouristGuideByCitiesBotApplication {

    public static void main(String[] args) {

        ApiContextInitializer.init();
        SpringApplication.run(TouristGuideByCitiesBotApplication.class, args);
    }
}
