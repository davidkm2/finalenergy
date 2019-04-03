package davidkm2.finalenergy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties
@EntityScan(basePackages = {"davidkm2.finalenergy.model"})
@EnableAutoConfiguration
public class FinalenergyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalenergyApplication.class, args);
    }

}
