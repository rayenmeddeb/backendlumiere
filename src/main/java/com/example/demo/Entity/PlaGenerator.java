package com.example.demo.Entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

public class PlaGenerator {

    public static void generatePlaFile(Ordre ordre) {
        StringBuilder sb = new StringBuilder();
        sb.append("Client: ").append(ordre.getClient()).append("\n");
       
        
        // Exemple de traitement pour écrire le fichier dans le système de fichiers
        try {
            Files.write(Paths.get("C:/Users/rayen/Desktop/PLA/fichier"+ordre.getId()+".pla"), sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
