import java.util.Random;

public class Etudiant{

private int code;
private String nom;
private String prenom;
private String niveau;

public Etudiant(int code,String nom,String prenom,String niveau){
    this.code=new Random().nextInt(100);this.nom=nom;this.prenom=prenom;this.niveau=niveau;
}
public int getCode() {
    return code;
}
public String getNom() {
    return nom;
}
public String getPrenom(){
    return prenom;
}
public String getNiveau() {
    return niveau;
}
public void setCode(int code) {
    this.code = code;
}
public void setNom(String nom) {
    this.nom = nom;
}
public void setPrenom(String prenom) {
    this.prenom = prenom;
}
public void setNiveau(String niveau) {
    this.niveau = niveau;
}

public String toString(){
    return "Etudiant{\nCode: " +code+"\n"+
    "Nom: "+nom+"\n"+"Prenom: "+prenom+"\n"+ "Niveau: " +niveau+"\n}\n";
}

}
