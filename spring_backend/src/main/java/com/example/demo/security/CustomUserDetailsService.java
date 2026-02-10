package com.example.demo.security;
/*package com.example.demo.service;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.model.User;

public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public String getUsername() { return user.getUsername(); }

    @Override
    public String getPassword() { return user.getPassword(); }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                   .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
                   .collect(Collectors.toList());
    }

    // Other methods like isAccountNonExpired(), etc.
}
*/

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String cin) throws UsernameNotFoundException {
        LoginDto loginDto = userRepository.findUserForLogin(cin)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // ✅ Convert role from DB into Spring Security authority
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + loginDto.getRoleName().toUpperCase());

        // Build Spring Security UserDetails
        return new org.springframework.security.core.userdetails.User(
                loginDto.getCin(),
                loginDto.getPassword(),
                List.of(authority)
        );
    }
}

