package com.example.t07_backend_notification_soa.web.mapper;

import com.example.t07_backend_notification_soa.domain.dto.EntitiesDTO;
import com.example.t07_backend_notification_soa.domain.dto.FuncionaryDTO;
import com.example.t07_backend_notification_soa.domain.dto.NotificationDTO;
import com.example.t07_backend_notification_soa.domain.model.Notification;
import com.example.t07_backend_notification_soa.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationMapper {
    private final NotificationService notificationService;

    public NotificationMapper(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public FuncionaryDTO obtenerFuncionary(Integer id){
        log.info("Notification mapper obtenerFumcionary -> " + id);
        ResponseEntity<FuncionaryDTO> funcionario = notificationService.validarfuncionario(id)
                .map(funcionarios -> ResponseEntity.ok().body(funcionarios))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).block();
        return funcionario.getBody();
    }

    public EntitiesDTO obtenerEntidades(Integer id){
        log.info("Notification mapper obtenerEntidades -> " + id);
        ResponseEntity<EntitiesDTO> entidad = notificationService.validarentidad(id)
                .map(entidades -> ResponseEntity.ok().body(entidades))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).build()).block();
        return entidad.getBody();
    }

    public Notification crearNotificacion(NotificationDTO notificationDTO){
        log.info("Notification mapper createnotification -> " + notificationDTO.toString());
        FuncionaryDTO funcionaryDTO = obtenerFuncionary(notificationDTO.getId_funcionary());
        EntitiesDTO entitiesDTO = obtenerEntidades(notificationDTO.getId_entities());
        log.info("Notification mapper obtenerentidades -> " + entitiesDTO.toString());

        Notification notification = new Notification();
        notification.setId_entities(notificationDTO.getId_entities());
        notification.setId_funcionary(notificationDTO.getId_funcionary());
        notification.setDescription(notificationDTO.getDescription());
        notification.setDate_notification(notificationDTO.getDate_notification());
        notification.setUrl(notificationDTO.getUrl());
        notification.setActive("A");
        notification.setName_entities(entitiesDTO.getNombre());
        String fullname = funcionaryDTO.getName()  + " " + funcionaryDTO.getSurname();
        notification.setName_funcionary(fullname);
        return  notification;
    }
}
