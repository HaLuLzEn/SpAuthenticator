package de.halulzen.spauthenticator.db.rest;

import de.halulzen.spauthenticator.db.entities.Authorizer.Authorizer;
import de.halulzen.spauthenticator.db.entities.Authorizer.authData.LoginRequestDTO;
import de.halulzen.spauthenticator.db.entities.Authorizer.authData.LoginResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
    private final Authorizer authorizer;

    public AuthRestController(Authorizer authorizer){
        this.authorizer = authorizer;
    }

    @GetMapping("/users/{token}")
    public boolean checkAuthorization(@PathVariable String token) {
        return authorizer.checkAuthorization(token);
    }

    @PostMapping("/users/authorize/{id}")
    public String authorizeUser(@PathVariable String id) {
        return authorizer.authorize(id);
    }

    @PostMapping("/users/remove/{id}")
    public void removeAuthorizedUser(@PathVariable String id) {
        authorizer.removeAuthorization(id);
    }

    @PostMapping("/users/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return authorizer.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
    }
}
