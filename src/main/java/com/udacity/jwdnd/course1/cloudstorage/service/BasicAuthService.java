package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Larbi
 */
@Service
public class BasicAuthService implements AuthService {

    private final UserService userService;
    private final HashService hashService;

    public BasicAuthService(UserService userService, HashService HashService) {
        this.userService = userService;
        this.hashService = HashService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<User> user = userService.findByUsername(username);

        if (user.isPresent()) {
            String encodedSalt = user.get().getSalt();
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if (user.get().getPassword().equals(hashedPassword)) {
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
