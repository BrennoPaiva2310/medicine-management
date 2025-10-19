package com.guimaraes.medicine.service;

import com.guimaraes.medicine.dto.LoginDTO;
import com.guimaraes.medicine.model.User;
import com.guimaraes.medicine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public User userCreate(LoginDTO loginDTO) {

        User user = new User(null,loginDTO.getUsername(), loginDTO.getPassword());

        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }



    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

}
