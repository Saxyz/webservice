package com.sena.webservice.service;

import com.sena.webservice.dto.UserDTO;
import com.sena.webservice.model.Userr;
import com.sena.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Userr create(UserDTO userDTO){
        Userr userr = new Userr(userDTO);
        if (userr != null){
            Userr userrSaved = userRepository.save(userr);
            return userrSaved;
        }else {
            return null;
        }

    }

    public UserDTO findById(Long id){
        Userr userr = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No se encontro el usuario"));
        UserDTO userDTO = new UserDTO(userr.getName(), userr.getPassword());
        return userDTO;
    }

    public List<UserDTO> findAll(){
        List<Userr> userrs = userRepository.findAll();
        List<UserDTO> usersDTO = userrs.stream()
                .map(userr -> new UserDTO(userr.getName(), userr.getPassword()))
                .collect(Collectors.toList());
        return usersDTO;
    }
}
