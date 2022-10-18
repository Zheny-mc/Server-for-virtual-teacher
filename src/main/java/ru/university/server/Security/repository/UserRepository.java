package ru.university.server.Security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.university.server.Security.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
