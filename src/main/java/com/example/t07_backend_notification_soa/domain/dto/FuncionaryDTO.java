package com.example.t07_backend_notification_soa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FuncionaryDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer dni;
    private Integer phonenumber;
    private String rank;
    private String department;
    private String address;
    private String email;
    private String estado;

}
