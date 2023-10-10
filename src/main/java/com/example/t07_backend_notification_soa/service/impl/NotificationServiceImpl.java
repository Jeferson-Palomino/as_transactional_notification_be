package com.example.t07_backend_notification_soa.service.impl;

import com.example.t07_backend_notification_soa.domain.dto.EntitiesDTO;
import com.example.t07_backend_notification_soa.domain.dto.FuncionaryDTO;
import com.example.t07_backend_notification_soa.domain.model.Notification;
import com.example.t07_backend_notification_soa.exception.NotFoundException;
import com.example.t07_backend_notification_soa.repository.NotificationRepository;
import com.example.t07_backend_notification_soa.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification crear(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> listNotification() {
        return (List<Notification>) notificationRepository.findAll();
    }

    @Override
    public Mono<FuncionaryDTO> validarfuncionario(Integer id) {
        log.info("Notification validar service ->" + id);
        WebClient webClient = WebClient.create("http://localhost:8081/v1/funcionary/" + id);
        ClientResponse response = webClient.get()
                .exchange()
                .block();
        log.info("webclient funcionario service ->" + response.bodyToMono(FuncionaryDTO.class));
        if (response.statusCode().value() == 200) {
            return webClient.get().retrieve().bodyToMono(FuncionaryDTO.class);
        }else {
            throw new NotFoundException("funcionario no existente");
        }
    }

    @Override
    public Mono<EntitiesDTO> validarentidad(Integer id) {
        log.info("Notification validar service ->" + id);
        WebClient webClient = WebClient.create("http://localhost:8080/v1/entidad/" + id);
        ClientResponse response = webClient.get()
                .exchange()
                .block();
        log.info("webclient entidad service ->" + response.bodyToMono(EntitiesDTO.class));
        if (response.statusCode().value() == 200) {
            return webClient.get().retrieve().bodyToMono(EntitiesDTO.class);
        }else {
            throw new NotFoundException("entidad no existente");
        }
    }
}
