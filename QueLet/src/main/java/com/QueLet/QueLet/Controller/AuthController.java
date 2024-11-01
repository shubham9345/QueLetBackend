package com.QueLet.QueLet.Controller;

import com.QueLet.QueLet.Model.Customer;
import com.QueLet.QueLet.Security.JwtUtil;
import com.QueLet.QueLet.Service.CustomUserDetailsService;
import com.QueLet.QueLet.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private CustomerService userService;

    @PostMapping("/customer-signup")
    public ResponseEntity<Customer> signup(@RequestBody Customer user) {
        try {
            Customer newUser = userService.save(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
