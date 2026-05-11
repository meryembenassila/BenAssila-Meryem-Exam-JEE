package benassila.meryem.benassilameryem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BenassilaMeryemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BenassilaMeryemApplication.class, args);}

    @Bean
    CommandLineRunner start(){
        return args -> {
            System.out.println("hello");
        };
    }

}
