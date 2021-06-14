package com.devsuperior.dslearnbds.service;

import com.devsuperior.dslearnbds.model.User;
import com.devsuperior.dslearnbds.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

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

}
