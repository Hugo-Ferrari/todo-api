package hugo.todo_api.controller;


import hugo.todo_api.model.User;
import hugo.todo_api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User novoUsuario = userService.register(user);
        return ResponseEntity.ok(novoUsuario);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String token = userService.login(
                user.getUsername(),
                user.getPassword()
        );
        return ResponseEntity.ok(token);
    }

}
