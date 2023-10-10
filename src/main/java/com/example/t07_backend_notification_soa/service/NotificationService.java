package com.example.t07_backend_notification_soa.service;

import com.example.t07_backend_notification_soa.domain.dto.EntitiesDTO;
import com.example.t07_backend_notification_soa.domain.dto.FuncionaryDTO;
import com.example.t07_backend_notification_soa.domain.model.Notification;
import reactor.core.publisher.Mono;

import java.util.List;

public interface NotificationService {
    Notification crear(Notification notification);
    List<Notification> listNotification();
    public Mono<FuncionaryDTO> validarfuncionario(Integer id);
    public Mono<EntitiesDTO> validarentidad(Integer id);
}
