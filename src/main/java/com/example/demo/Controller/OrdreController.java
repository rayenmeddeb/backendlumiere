package com.example.demo.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Ordre;
import com.example.demo.Service.OrdreService;

@RestController
@RequestMapping("/ordres")
public class OrdreController {

	 @Autowired
	    private OrdreService ordreService;

	    @GetMapping
	    public List<Ordre> getAllOrdres() {
	        return ordreService.findAll();
	    }

	    @GetMapping("/{id}")
	    public  Optional<Ordre> getOrdreById(@PathVariable(value = "id") Long id) {
	        Optional<Ordre> ordre = ordreService.findById(id);
	               
	        return ordre;
	    }

	    @PostMapping
	    public Ordre createOrdre(@RequestBody Ordre ordre) {
	        return ordreService.save(ordre);
	    }
	    
	    @PutMapping("/confirmer/{id}")
	    public  void confiermerordre(@PathVariable(value = "id") Long id){
	    	
	    	
	    	this.ordreService.confirmer(id);
	    	
	    } 

	    @PutMapping("/{id}")
	    public ResponseEntity<Ordre> updateOrdre(@PathVariable(value = "id") Long id, @RequestBody Ordre ordreDetails) {
	        Ordre updatedOrdre = ordreService.update(id, ordreDetails);
	        return ResponseEntity.ok(updatedOrdre);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteOrdre(@PathVariable(value = "id") Long id) {
	        ordreService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
