package ru.netology.authorizationservice1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice1.service.AuthorizationService;

import javax.annotation.security.RolesAllowed;

@RestController
public class AuthorizationControllerMethods {

    @Autowired
    AuthorizationService service;

    @RolesAllowed({"ROLE_READ"})
    @GetMapping("/read")
    public String read() {
        return "From method Read";
    }

    @Secured({"ROLE_WRITE"})
    @GetMapping("/write")
    public String write() {
        return "From method Write";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, authenticated user";
    }

    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    @GetMapping("/authorize")
    public String authorize() {
        return "From method authorize";
    }

    @PreAuthorize("'Vasia' == authentication.principal.username")
    @GetMapping("/qery")
    public String qery(@RequestParam ("user") String username) {
        return "Hello  "+ username;
    }
}
