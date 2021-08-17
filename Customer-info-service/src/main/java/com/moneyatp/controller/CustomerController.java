package com.moneyatp.controller;

import com.moneyatp.model.Customer;
import com.moneyatp.model.JwtRequest;
import com.moneyatp.model.JwtResponse;
import com.moneyatp.service.CustomerService;
import com.moneyatp.service.UserService;
import com.moneyatp.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;


    @RequestMapping(method= RequestMethod.GET,value="/allCustomer")
    public List<Customer> getAllCustomer(@RequestHeader(name="Authorization") String token)
    {

        return  customerService.getAllCustomer();
    }

     @PostMapping("/customer")
    //@RequestMapping(method= RequestMethod.POST,value="/customer")
    public void addCustomer(@RequestHeader(name="Authorization") String token,@RequestBody Customer customer)
    {

         customerService.addCustomer(customer);
    }
    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}

