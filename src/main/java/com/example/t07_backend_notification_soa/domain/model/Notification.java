package com.example.t07_backend_notification_soa.domain.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Entity
@Table(name = "notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer id_funcionary;
    private Integer id_entities;
    private String description;
    private Date date_notification;
    private String url;
    private  String active;
    private String name_funcionary;
    private String name_entities;


}
