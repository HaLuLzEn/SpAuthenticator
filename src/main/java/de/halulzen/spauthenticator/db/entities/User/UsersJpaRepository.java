package de.halulzen.spauthenticator.db.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaRepository extends JpaRepository<User, String> {
}
