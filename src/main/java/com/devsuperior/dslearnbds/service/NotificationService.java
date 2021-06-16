package com.devsuperior.dslearnbds.service;

import com.devsuperior.dslearnbds.dto.NotificationDTO;
import com.devsuperior.dslearnbds.model.Notification;
import com.devsuperior.dslearnbds.model.User;
import com.devsuperior.dslearnbds.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private AuthService authService;

    public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable) {
        User userAuthenticated = authService.authenticated();
        Page<Notification> page = notificationRepository.findByUser(userAuthenticated, pageable);
        return page.map(NotificationDTO::new);
    }

}
