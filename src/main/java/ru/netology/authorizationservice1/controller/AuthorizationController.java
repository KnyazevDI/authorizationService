package ru.netology.authorizationservice1.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice1.authorities.Authorities;
import ru.netology.authorizationservice1.repository.UserRepository;
import ru.netology.authorizationservice1.service.AuthorizationService;

import java.util.List;

@RestController
@Validated
public class AuthorizationController {
    @NotBlank
    @Size (min=3, max=20)
    private String login, password;


    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }


    @GetMapping("/registration")
    public void userRegistration(@RequestParam("user") String user, @RequestParam("password") String password) {
        service.register(user, password);
    }
}