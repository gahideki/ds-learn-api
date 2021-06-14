package com.devsuperior.dslearnbds.service;

import com.devsuperior.dslearnbds.model.User;
import com.devsuperior.dslearnbds.repository.UserRepository;
import com.devsuperior.dslearnbds.service.exception.ForbiddenException;
import com.devsuperior.dslearnbds.service.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userRepository.findByEmail(username);
            return user;
        } catch (Exception ex) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validateSelfOrAdmin(Long userId) {
        User user = authenticated();

        if (!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN"))
            throw new ForbiddenException("Access denied");
    }

}
