package peaksoft.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.restapi.dto.auth.AuthResponse;
import peaksoft.restapi.dto.register.RegisterRequest;
import peaksoft.restapi.entities.User;
import peaksoft.restapi.security.JwtProvider;
import peaksoft.restapi.services.UserService;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider provider;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        userService.saveUser(user);
        return "ok";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody RegisterRequest request) {
        System.out.println(1);
        User user = userService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        System.out.println(2);
        System.out.println(user);
        String token = provider.generaToken(user.getEmail());
        System.out.println(3);
        return new AuthResponse(token);
    }
}

