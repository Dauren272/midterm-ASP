package kz.aitu.chat.controller;

import kz.aitu.chat.model.Users;
import kz.aitu.chat.model.auth;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class Authcontroller {
    @PostMapping
    public ResponseEntity<?> authentication(@RequestParam auth auth, @RequestParam(name = "username") String username) {
        Users user = new Users(username);
        return ResponseEntity.ok("User created successfully");
    }

}
