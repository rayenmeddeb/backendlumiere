package com.example.demo.Service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Article;
import com.example.demo.Entity.Ordre;
import com.example.demo.Entity.PlaGenerator;
import com.example.demo.Entity.Statut;
import com.example.demo.Entity.Tranck;
import com.example.demo.Repository.OrdreRepository;
import com.example.demo.Repository.TranckRepository;
import com.example.demo.Service.TranckService;

import jakarta.transaction.Transactional;

@Service
public class OrdreService {
	
	
	
	@Autowired
	    private OrdreRepository ordreRepository;
	  @Autowired
	  private  MatriculeService matriculeService ;
	    @Autowired
	    private TranckRepository tranckRepository;
private PlaGenerator plaGenerator;

	    public List<Ordre> findAll() {
	        return ordreRepository.findAll();
	    }

	    public Optional<Ordre> findById(Long id) {
	        return ordreRepository.findById(id);
	    }

	    @Transactional
	    public Ordre save(Ordre ordre) {
	        Tranck tranck = new Tranck();
	        tranck.setDepart(false);
	        tranck.setChargement(false);
	        tranck.setLivraison(false);
	        tranck = tranckRepository.save(tranck);
	        
	        ordre.setTrancking(tranck);
	        tranck.setOrdre(ordre);
            ordre.setMatricule(matriculeService.generateMatricule());
            ordre.setStatut(Statut.NON_CONFIRME);
	        return ordreRepository.save(ordre);
	    }

	    @Transactional
	    public void deleteById(Long id) {
	        ordreRepository.deleteById(id);
	    }

	    
	    @Transactional
	    public Ordre confirmer(Long id) {
	    	
	    	
	    	
	    	Optional<Ordre> Ordre = ordreRepository.findById(id);
	    	Ordre ordre=Ordre.get();
	    	ordre.setStatut(Statut.NON_PLANIFIE);
	    	
	    	plaGenerator.generatePlaFile(ordre);
	    	final Ordre updatedOrdre = ordreRepository.save(ordre);
	        return updatedOrdre;
	    	
	    	
	    	
	    }

	    
	    
	    @Transactional
	    public Ordre update(Long id, Ordre ordreDetails) {
	    	Optional<Ordre> Ordre = ordreRepository.findById(id);
Ordre ordre=Ordre.get();
	        ordre.setMatricule(ordreDetails.getMatricule());
	        ordre.setClient(ordreDetails.getClient());
	        ordre.setChargementNom(ordreDetails.getChargementNom());
	        ordre.setChargementAdr1(ordreDetails.getChargementAdr1());
	        ordre.setChargementAdr2(ordreDetails.getChargementAdr2());
	        ordre.setChargementVille(ordreDetails.getChargementVille());
	        ordre.setChargementDate(ordreDetails.getChargementDate());
	        ordre.setLivraisonNom(ordreDetails.getLivraisonNom());
	        ordre.setLivraisonAdr1(ordreDetails.getLivraisonAdr1());
	        ordre.setLivraisonAdr2(ordreDetails.getLivraisonAdr2());
	        ordre.setLivraisonVille(ordreDetails.getLivraisonVille());
	        ordre.setLivraisonDate(ordreDetails.getLivraisonDate());
	        ordre.setCodeArticle(ordreDetails.getCodeArticle());
	        ordre.setDesignation(ordreDetails.getDesignation());
	        ordre.setUt(ordreDetails.getUt());
	        ordre.setDev(ordreDetails.getDev());
	        ordre.setUf(ordreDetails.getUf());
	        ordre.setQteTrs(ordreDetails.getQteTrs());
	        ordre.setQteTaxee(ordreDetails.getQteTaxee());
	        ordre.setPrixUnitaire(ordreDetails.getPrixUnitaire());
	        ordre.setMontant1(ordreDetails.getMontant1());
	        ordre.setAct(ordreDetails.getAct());
	        ordre.setFrais(ordreDetails.getFrais());
	        ordre.setNumeroFR(ordreDetails.getNumeroFR());
	        ordre.setPoids(ordreDetails.getPoids());
	        ordre.setVolume(ordreDetails.getVolume());
	        ordre.setNombrePalettes(ordreDetails.getNombrePalettes());
	        ordre.setNombreColis(ordreDetails.getNombreColis());
	        ordre.setLongueur(ordreDetails.getLongueur());
	        ordre.setReference(ordreDetails.getReference());
	        ordre.setMontant(ordreDetails.getMontant());
	        ordre.setStatut(ordreDetails.getStatut());
	        ordre.setCommentaires(ordreDetails.getCommentaires());
	        ordre.setTrancking(ordreDetails.getTrancking());

	        final Ordre updatedOrdre = ordreRepository.save(ordre);
	        return updatedOrdre;
	    }
    
}
