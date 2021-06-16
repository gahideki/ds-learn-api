package com.devsuperior.dslearnbds.dto;

import com.devsuperior.dslearnbds.model.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {

    private Long id;
    private String text;
    private Instant moment;
    private Boolean read;
    private String route;
    private Long userId;

    public NotificationDTO(Notification notification) {
        this.id = notification.getId();
        this.text = notification.getText();
        this.moment = notification.getMoment();
        this.read = notification.getRead();
        this.route = notification.getRoute();
        this.userId = notification.getId();
    }

}
