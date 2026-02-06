package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        switch (username.toLowerCase()) {
            case "zahra":
                return User.builder()
                        .username("zahra")
                        .password("{noop}1234") 
                        .roles("dba")
                        .build();
            case "doha":
                return User.builder()
                        .username("doha")
                        .password("{noop}1234")
                        .roles("doctor")
                        .build();
            case "noha":
                return User.builder()
                        .username("noha")
                        .password("{noop}1234")
                        .roles("patient")
                        .build();
            default:
                throw new UsernameNotFoundException("User not found");
        }
    }
}
/* 
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameWithRoles(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new CustomUserDetails(user);
    }
}*/
