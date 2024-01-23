import java.util.ArrayList;
  // Import the Collections class
import java.util.Collections;
public class myfile {
  public static void main(String[] args) {
    //creation de l'obejet etudiantsESih dans arraylist
    ArrayList<String> etudiantsESih = new ArrayList<String>();
    etudiantsESih.add("Benito");
    etudiantsESih.add("Baouly");
    etudiantsESih.add("Clavensky");
    etudiantsESih.add("Bersony");
    etudiantsESih.get(1);
    etudiantsESih.set(0, "Les intrepides");
    System.out.println(etudiantsESih);
    //pour connaitre la size de la arraylist
    System.out.println(etudiantsESih.size());
    //on peut aussi parcourir l'arraylist
    for (int i = 0; i < etudiantsESih.size(); i++) {
        //affichage en ordre croissant 
     Collections.sort(etudiantsESih);
        System.out.println(etudiantsESih.get(i));
    }
  }
}