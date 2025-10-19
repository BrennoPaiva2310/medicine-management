package com.guimaraes.medicine.controller;

import com.guimaraes.medicine.dto.LoginDTO;
import com.guimaraes.medicine.dto.TokenDTO;
import com.guimaraes.medicine.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/authentication")
    public TokenDTO userAutetication(@RequestBody LoginDTO user) {
        Authentication token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication retorno  =  authenticationManager.authenticate(token);

        return ResponseEntity.ok(tokenService.createToken(user.getUsername())).getBody();

    }

    @PostMapping("/validate")
    public String validateToken(@RequestHeader("Authorization") String token, @RequestBody String username) {
        String tokenReplaced = token.replace("Bearer ", "");

        return ResponseEntity.ok(tokenService.validateToken(tokenReplaced)).getBody();

    }

}
