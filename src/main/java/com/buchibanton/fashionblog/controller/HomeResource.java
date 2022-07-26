package com.buchibanton.fashionblog.controller;

import com.buchibanton.fashionblog.model.AuthenticationRequest;
import com.buchibanton.fashionblog.model.AuthenticationResponse;
import com.buchibanton.fashionblog.service.serviceImpl.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HomeResource {
//    @Autowired
    private final AuthenticationManager authenticationManager;
//    @Autowired
    private final UserDetailsService userDetailsService;
//    @Autowired
    private final JwtUtil jwtUtil;

    @RequestMapping("/hello")
    public String hello(){return "Hello World";}

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect Username or Password", e);
        }

        final UserDetails userDetails =userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt =jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
