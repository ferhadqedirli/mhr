package az.evimtekstil.mhr;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "mhr Service API",
                description = "mhr crud services",
                version = "v1"
        )
)
public class MhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(MhrApplication.class, args);
        long start = System.nanoTime();
        System.out.println(start);
    }

}
