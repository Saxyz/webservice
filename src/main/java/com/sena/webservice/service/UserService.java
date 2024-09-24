package com.sena.webservice.service;

import com.sena.webservice.dto.UserDTO;
import com.sena.webservice.model.User;
import com.sena.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserDTO userDTO){
        User user = new User(userDTO);
        if (user != null){
            User userSaved = userRepository.save(user);
            return userSaved;
        }else {
            return null;
        }

    }

    public UserDTO findById(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No se encontro el usuario"));
        UserDTO userDTO = new UserDTO(user.getName(), user.getPassword());
        return userDTO;
    }

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = users.stream()
                .map(user -> new UserDTO(user.getName(), user.getPassword()))
                .collect(Collectors.toList());
        return usersDTO;
    }
}
