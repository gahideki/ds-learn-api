package com.devsuperior.dslearnbds.service;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.model.User;
import com.devsuperior.dslearnbds.repository.UserRepository;
import com.devsuperior.dslearnbds.service.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(ObjectUtils.isEmpty(user)) {
            logger.error("User not found {}", username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User {} found", username);
        return user;
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        authService.validateSelfOrAdmin(id);

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return new UserDTO(user);
    }

}
