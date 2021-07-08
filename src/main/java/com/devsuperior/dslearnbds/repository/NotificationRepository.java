package com.devsuperior.dslearnbds.repository;

import com.devsuperior.dslearnbds.model.Notification;
import com.devsuperior.dslearnbds.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT obj FROM Notification obj WHERE (obj.user = :user) AND (:unreadOnly = false OR obj.read = false) " +
            "ORDER BY obj.moment DESC")
        Page<Notification> find(User user, boolean unreadOnly, Pageable pageable);

}
