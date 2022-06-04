package com.udacity.jwdnd.course1.cloudstorage.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author Larbi
 */
public class BasicAuthService implements AuthService {

    private final UserService userService;
    private final HashService HashService;

    public BasicAuthService(UserService userService, HashService HashService) {
        this.userService = userService;
        this.HashService = HashService;
    }

    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
