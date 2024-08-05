package com.example.demo.Entity;

import java.util.Date;

import java.util.Set;

import com.example.demo.Service.MatriculeService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data

@Entity

public class Ordre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String matricule;

    
    private Long  client;
    private String chargementNom;
    private String chargementAdr1;
    private String chargementAdr2;
    private String chargementVille;
    @Temporal(TemporalType.DATE)
    private Date chargementDate;
    
    private String livraisonNom;
    private String livraisonAdr1;
    private String livraisonAdr2;
    private String livraisonVille;
    @Temporal(TemporalType.DATE)
    private Date livraisonDate;
    
    

    private String codeArticle;
    @Column(name = "designation")
   private String designation;
    @Column(name = "ut")
    private String ut;
    @Column(name = "dev")
    private String dev;
    @Column(name = "uf")
    private String uf;
    @Column(name = "qte_trs")
    private Double qteTrs;
    @Column(name = "qte_taxee")
    private Double qteTaxee;
   @Column(name = "prix_unitaire")
    private Double prixUnitaire;

    private Double montant1;
    @Column(name = "act")
    private String act; 
    
    
    



    private Double frais;
    private String numeroFR;
    
    private Double poids;
    private Double volume;
    private Integer nombrePalettes;
    private Integer nombreColis;
    private Double longueur;
    private String reference;

    

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date dateSaisie;
    private Double montant;
    
    @Enumerated(EnumType.STRING)
    private Statut statut;
    
   
   
    private Set<String> commentaires; 
    
    
    
    @OneToOne
  
    private Tranck trancking;
    
 
    
    @PrePersist
    protected void onCreate() {
        dateSaisie = new Date(); 
    }
}
