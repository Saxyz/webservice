package com.sena.webservice.controller;

import com.sena.webservice.dto.UserDTO;
import com.sena.webservice.model.Userr;
import com.sena.webservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id){
        UserDTO userDTO = userService.findById(id);
        if (userDTO != null){
            return ResponseEntity.ok(userDTO);
        }else {
           return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> userList = userService.findAll();
        return ResponseEntity.ok(userList);
    }

    @PostMapping
    public ResponseEntity<Userr> createUser(@RequestBody UserDTO userDTO){
        Userr userrSaved = userService.create(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userrSaved);
    }
}
