package com.groupc.pt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupc.pt.model.User;

import com.groupc.pt.service.UserService;

@RestController
public class UserController{

   @Autowired
   private UserService UserService;

   /*---Add User user---*/
   @PostMapping("/user")
   public ResponseEntity<?> save(@RequestBody User User) {
      long id = UserService.save(User);
      return ResponseEntity.ok().body("User user has been saved with ID:" + id);
   }
   

   /*---Get a user by id---*/
   @GetMapping("/user/{id}")
   public ResponseEntity<User> get(@PathVariable("id") long id) {
      User User = UserService.getU(id);
      return ResponseEntity.ok().body(User);
   }

   /*---get all users---*/
   @GetMapping("/user")
   public ResponseEntity<List<User>> list() {
      List<User> Users = UserService.userlist();
      return ResponseEntity.ok().body(Users);
   }

   /*---Update a user by id---*/
   @PutMapping("/user/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User User) {
      UserService.update(id, User);
      return ResponseEntity.ok().body("user has been updated successfully.");
   }

   /*---Delete a user by id---*/
   @DeleteMapping("/user/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      UserService.deleteU(id);
      return ResponseEntity.ok().body("user has been deleted successfully.");
   }
   
}