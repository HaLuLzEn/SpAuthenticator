package de.halulzen.spauthenticator.db.entities.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsersJpaRepository repository;

    public UserService(UsersJpaRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User findUserById(String id) {
        return repository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user) {
        User userRef = repository.findById(user.getId()).orElse(null);
        if (userRef != null) {
            userRef.setUsername(user.getUsername());
            userRef.setEmail(user.getEmail());
            return repository.save(userRef);
        }
        return null;
    }

    public void deleteUserById(String id) {
        repository.deleteById(id);
    }
}
