package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Ordre;

public interface OrdreRepository extends JpaRepository<Ordre, Long>{

}
