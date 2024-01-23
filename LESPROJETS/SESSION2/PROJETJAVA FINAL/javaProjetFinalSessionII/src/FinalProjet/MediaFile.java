/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProjet;

import java.util.Random;

/**
 *
 * @author Baouly NELSON
 */
public class MediaFile {
private int id;
private String nom;
private String emplacement;

public MediaFile(int id, String nom, String emplacement) {
    this.id = new Random().nextInt(100);
    this.nom = nom;
    this.emplacement = emplacement;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNom() {
    return nom;
}

public void setNom(String nom) {
    this.nom = nom;
}

public String getEmplacement() {
    return emplacement;
}

public void setEmplacement(String emplacement) {
    this.emplacement = emplacement;
}

}