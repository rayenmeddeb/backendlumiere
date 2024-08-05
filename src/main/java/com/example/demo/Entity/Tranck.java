package com.example.demo.Entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Entity

public class Tranck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIME)
    private LocalTime departureDateTime;
    private Boolean depart;
    private LocalTime loadingDateTime;
    @Temporal(TemporalType.TIME)
    private Boolean chargement;
    private LocalTime deliveryDateTime;
    @Temporal(TemporalType.TIME)
    private Boolean livraison;
    
    
    @OneToOne(mappedBy = "trancking")
    @JsonIgnore 
    private Ordre ordre;
}
