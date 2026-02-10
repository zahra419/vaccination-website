package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.dto.LoginDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String authenticateAndGenerateToken(String cin, String password,String full_name) {
        LoginDto user = userRepository.findUserForLogin(cin)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getCin(), user.getRoleName(),user.getFullName());
    }


}

/*
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173") // Vite frontend
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

  
    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginRequest request) {

        LoginDto loginDTO = authService.login(
                request.getCin(),
                request.getPassword()
        );

        return ResponseEntity.ok(loginDTO);
    }

    String role = loginDto.getAuthorities()
                .iterator()
                .next()
                .getAuthority()
                .replace("ROLE_", "");

            String token = jwtUtil.generateToken(request.username(), role);

            return ResponseEntity.ok(
                Map.of(
                    "username", request.username(),
                    "role", role,
                    "token", token
                );
           

    
    @GetMapping("/user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(authService.getFullUser(id));
    }
}



*/