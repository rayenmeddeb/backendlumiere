package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Client {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long code;
    private String civilite;
    private String type;
    private String statut;
    private String sType;
    private boolean confiere;
    private String societeFacturation;
    private String siteExploitation;
    private String service;

    // Adresse de facturation
    private String nom;
    private String adresse;
    private String ville;
    private String pays;

    // Mode de règlement
    private String client;
    private String siret;
    private Long idEdi;
    private Long idTva;
    private Long codeIso;
    private String contact;
    private String numeroPortable;
    private String telephone;
    private String fax;
    private String email;

	
}
