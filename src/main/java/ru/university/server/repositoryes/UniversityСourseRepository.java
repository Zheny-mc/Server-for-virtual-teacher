package ru.university.server.repositoryes;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.university.server.model.entity.UniversityСourse;

public interface UniversityСourseRepository extends MongoRepository<UniversityСourse, String> {
}
