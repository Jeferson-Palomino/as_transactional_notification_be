package com.example.t07_backend_notification_soa.web;

import com.example.t07_backend_notification_soa.domain.dto.NotificationDTO;
import com.example.t07_backend_notification_soa.domain.model.Notification;
import com.example.t07_backend_notification_soa.service.NotificationService;
import com.example.t07_backend_notification_soa.web.mapper.NotificationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
@Slf4j
public class NotificationController {
    private final NotificationMapper notificationMapper;
    private  final NotificationService notificationService;

    public NotificationController(NotificationMapper notificationMapper, NotificationService notificationService) {
        this.notificationMapper = notificationMapper;
        this.notificationService = notificationService;
    }

    @PostMapping
    @CrossOrigin(origins="http://localhost:4200")
    public Notification crearNotification(@RequestBody NotificationDTO notificationDTO){
        log.info("Notification create controlador ->" + notificationDTO.toString());
        Notification notification = notificationMapper.crearNotificacion(notificationDTO);
        return notificationService.crear(notification);
    }

    @GetMapping()
    @CrossOrigin(origins="http://localhost:4200")
    public List<Notification> listar(){
        return notificationService.listNotification();
    }

}
