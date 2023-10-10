package com.example.t07_backend_notification_soa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EntitiesDTO {
    private Integer id;
    private String nombre;
    private Integer contacto;
    private BigInteger ruc;
    private String direccion;
    private String estado;


}
