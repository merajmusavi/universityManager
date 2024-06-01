package com.example.universityManager;

import com.universitymanager.aggregate.DomainModuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({InfrastructureModuleConfig.class, DomainModuleConfig.class})
public class UniversityManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityManagerApplication.class, args);
    }

}
