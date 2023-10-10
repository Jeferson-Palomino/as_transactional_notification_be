package com.example.t07_backend_notification_soa.repository;

import com.example.t07_backend_notification_soa.domain.model.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository  extends CrudRepository<Notification,Long> {
}
