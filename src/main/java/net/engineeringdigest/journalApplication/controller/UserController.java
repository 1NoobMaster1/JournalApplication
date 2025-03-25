package net.engineeringdigest.journalApplication.controller;

import net.engineeringdigest.journalApplication.entity.User;
import net.engineeringdigest.journalApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

     @Autowired
     private UserService userService;

     @GetMapping
     public List<User> findAllUsers() {
          return userService.findAll();
     }

     @PostMapping
     public void saveUser(@RequestBody User user) {
          userService.saveData(user);
     }

     @PutMapping("/{userName}")
     public ResponseEntity<?> updateUserById(@PathVariable String userName, @RequestBody User user) {
          User userInDB = userService.findByUserName(userName);
          if(userInDB != null) {
               userInDB.setUserName(user.getUserName());
               userInDB.setPassword(user.getPassword());
               userService.saveData(userInDB);
          }
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

}
