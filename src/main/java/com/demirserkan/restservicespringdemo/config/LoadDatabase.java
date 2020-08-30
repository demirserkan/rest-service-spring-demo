package com.demirserkan.restservicespringdemo.config;

import com.demirserkan.restservicespringdemo.repository.Student;
import com.demirserkan.restservicespringdemo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initializeDatabase (StudentRepository studentRepository){
        return args -> {
            log.info("Preloading " + studentRepository.save(
                    new Student("John Doe","male",18)));

            log.info("Preloading " + studentRepository.save(
                    new Student("Jane Doe","female",19)));
        };
    }
}
