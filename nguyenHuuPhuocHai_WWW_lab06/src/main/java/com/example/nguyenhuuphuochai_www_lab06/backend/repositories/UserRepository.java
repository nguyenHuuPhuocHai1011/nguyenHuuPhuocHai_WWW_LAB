package com.example.nguyenhuuphuochai_www_lab06.backend.repositories;

import com.example.nguyenhuuphuochai_www_lab06.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByEmail(String email);

}