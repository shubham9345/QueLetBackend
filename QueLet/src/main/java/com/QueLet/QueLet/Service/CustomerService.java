package com.QueLet.QueLet.Service;

import com.QueLet.QueLet.Model.Customer;
import com.QueLet.QueLet.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Customer save(Customer user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }
//        if(!user.getPassword().equals(user.getConfirmPassword())){
//            throw new BadCredentialsException("password and confirm password must be same");
//        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return customerRepository.save(user);
    }

    public List<Customer> AllUser() {
        return customerRepository.findAll();
    }
}
