package ru.university.server.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.university.server.model.entity.Testing;
import ru.university.server.model.entity.UniversityСourse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
public class DataConfig {

    @Bean
    public UniversityСourse getCourse() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Path path = Path.of("course_content.json");
        String is = Files.readString(path);
        UniversityСourse universityСourse = mapper.readValue(is, UniversityСourse.class);

        return universityСourse;
    }

    @Bean
    public Testing getTesting() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Path path = Path.of("course_content.json");
        String is = Files.readString(path);
        UniversityСourse universityСourse = mapper.readValue(is, UniversityСourse.class);

        return universityСourse.getСhapterList().get(0).getTestingList().get(0);
    }

}
