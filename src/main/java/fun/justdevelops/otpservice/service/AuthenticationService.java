package fun.justdevelops.otpservice.service;


import fun.justdevelops.otpservice.dto.SignInRequest;
import fun.justdevelops.otpservice.model.Role;
import fun.justdevelops.otpservice.model.entity.User;
import fun.justdevelops.otpservice.dto.JwtAuthenticationResponse;
import fun.justdevelops.otpservice.dto.SignUpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(UserService userService, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        String encodedPassword = new BCryptPasswordEncoder().encode(request.getPassword());
        Role targetRole = Role.USER;
        if (!userService.isAdminExists()) {
            targetRole = Role.ADMIN;
        }
        var user = new User(request.getLogin(), encodedPassword, request.getOtpDestination(), targetRole, request.getChannelType());
        userService.create(user);
        var jwt = jwtService.generateToken(user);
        log.info("Пользователь создан: {}", user.getLogin());
        return new JwtAuthenticationResponse(jwt);
    }

    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getLogin(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getLogin());

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

}
