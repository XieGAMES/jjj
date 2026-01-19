package zd.zmk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zd.zmk.entities.User;
import zd.zmk.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @GetMapping
    public List<User> getAllUsers() {
        User user = new User();
        user.setLogin("aydar");
        User user2 = new User();
        user2.setLogin("ТИМУР");
        return List.of(user, user2);
    }


}
