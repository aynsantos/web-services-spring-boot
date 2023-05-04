package com.webservices.resources;


import com.webservices.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L,"João", "joão@gmail.com", "3599972978", "12345");
        return ResponseEntity.ok().body(u);
    }
}
