package com.example.t07_backend_notification_soa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotificationDTO {
    private Integer id;
    private Integer id_funcionary;
    private Integer id_entities;
    private String description;
    private Date date_notification;
    private String url;
    private  String active;

}
