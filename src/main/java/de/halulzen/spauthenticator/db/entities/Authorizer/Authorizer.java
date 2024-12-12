package de.halulzen.spauthenticator.db.entities.Authorizer;

import de.halulzen.spauthenticator.db.entities.User.User;
import de.halulzen.spauthenticator.db.entities.User.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class Authorizer {
    HashMap<String, String> tokenMap = new HashMap<>();

    private final UserService userService;

    public Authorizer(UserService userService) {
        this.userService = userService;
    }

    public boolean checkAuthorization(String key) {
        return tokenMap.get(key) != null;
    }

    public void removeAuthorization(String key) {
        tokenMap.remove(key);
    }

    public String authorize(String id) {
        if (!tokenMap.containsValue(id)) {
            String key = UUID.randomUUID().toString();
            if (userService.findUserById(id) == null) return null;
            tokenMap.put(key, id);
            if (tokenMap.get(key).equals(id))
                return key;
            return null;
        } else
            return "User " + id + " is already authorized";
    }

    public User login(String username, String password) {
        List<User> users = userService.findAllUsers();
        User found = null;
        for (User u: users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                found = u;
            }
        }
        return found;
    }
}
