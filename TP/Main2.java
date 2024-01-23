// Classe Fraction

import java.util.ArrayList;
import java.util.Scanner;

class Fraction {
    private int numerateur;
    private int denominateur;

    // Constructeur
    public Fraction(int numerateur, int denominateur) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }

    /**
     * @return the numerateur
     */
    public int getNumerateur() {
        return numerateur;
    }

    /**
     * @param numerateur the numerateur to set
     */
    public void setNumerateur(int numerateur) {
        this.numerateur = numerateur;
    }

    /**
     * @return the denominateur
     */
    public int getDenominateur() {
        return denominateur;
    }

    /**
     * @param denominateur the denominateur to set
     */
    public void setDenominateur(int denominateur) {
        this.denominateur = denominateur;
    }

    // Méthode pour afficher la fraction
    public void afficherFraction() {
        System.out.println(numerateur + "/" + denominateur);
    }

    // Méthode pour inverser la fraction
    public void inverser() {
        int temp = numerateur;
        numerateur = denominateur;
        denominateur = temp;
    }

    // Méthode pour comparer deux fractions
    public boolean comparer(Fraction autre) {
        return (numerateur == autre.numerateur && denominateur == autre.denominateur);
    }

    // Méthode pour additionner deux fractions
    public Fraction additionner(Fraction autre) {
        int nouveauNumerateur = (numerateur * autre.denominateur) + (autre.numerateur * denominateur);
        int nouveauDenominateur = denominateur * autre.denominateur;
        return simplifierFraction(new Fraction(nouveauNumerateur, nouveauDenominateur));
    }

    // Méthode pour soustraire deux fractions
    public Fraction soustraire(Fraction autre) {
        int nouveauNumerateur = (numerateur * autre.denominateur) - (autre.numerateur * denominateur);
        int nouveauDenominateur = denominateur * autre.denominateur;
        return simplifierFraction(new Fraction(nouveauNumerateur, nouveauDenominateur));
    }

    // Méthode pour multiplier deux fractions
    public Fraction multiplier(Fraction autre) {
        int nouveauNumerateur = numerateur * autre.numerateur;
        int nouveauDenominateur = denominateur * autre.denominateur;
        return simplifierFraction(new Fraction(nouveauNumerateur, nouveauDenominateur));
    }

    // Méthode pour diviser deux fractions (en appelant la méthode inverser et multiplier)
    public Fraction diviser(Fraction autre) {
        autre.inverser();
        return multiplier(autre);
    }

    // Méthode pour simplifier une fraction en utilisant le PGCD
    private Fraction simplifierFraction(Fraction fraction) {
        int pgcd = calculerPGCD(fraction.numerateur, fraction.denominateur);
        fraction.numerateur /= pgcd;
        fraction.denominateur /= pgcd;
        return fraction;
    }

    // Méthode pour calculer le PGCD (Algorithme d'Euclide)
    private int calculerPGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculerPGCD(b, a % b);
        }
    }


}

// Classe Personne
class Personnes {
    private String nom;
    private String prenom;
    private String sexe;
    private int age;
    private double poids;

    // Constructeur
    public Personnes(String nom, String prenom, String sexe, int age, double poids) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.age = age;
        this.poids = poids;
    }

    // Méthodes Set et Get pour les attributs
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getSexe() {
        return sexe;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getPoids() {
        return poids;
    }

    // Méthode pour afficher les informations de la personne
    @Override
    public String toString(){
        return " Nom: " + nom+"\n" +" Prenom: "+ prenom+"\n"+ " Sexe: "+sexe+"\n"+  " Age: "+age+ "\n"+ " Poids: "+poids+"\n";
    }
}


   // Classe principale
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Test de la classe Fraction
        System.out.print("Entrer un numerateur pour la fraction 1: ");
        int numerateur1 = sc.nextInt();
        System.out.print("Entrer un denominateur pour la fraction 1: ");
        int denominateur1 = sc.nextInt();
        Fraction fraction1 = new Fraction(numerateur1, denominateur1);

        System.out.print("Entrer un numerateur pour la fraction 2: ");
        int numerateur2 = sc.nextInt();
        System.out.print("Entrer un denominateur pour la fraction 2: ");
        int denominateur2 = sc.nextInt();
        Fraction fraction2 = new Fraction(numerateur2, denominateur2);

        fraction1.afficherFraction();
        fraction2.afficherFraction();

        fraction1.inverser();
        fraction2.inverser();
        fraction1.afficherFraction();
        fraction2.afficherFraction();

        System.out.println(fraction1.comparer(fraction2));

        Fraction somme = fraction1.additionner(fraction2);
        somme.afficherFraction();

        Fraction difference = fraction1.soustraire(fraction2);
        difference.afficherFraction();

        Fraction produit = fraction1.multiplier(fraction2);
        produit.afficherFraction();

        Fraction quotient = fraction1.diviser(fraction2);
        quotient.afficherFraction();

        // Test de la classe Personne
        sc.nextLine(); // Pour consommer la nouvelle ligne restante après la lecture du nombre
        System.out.print("Entrer le Nom: ");
        String nom = sc.nextLine();
        System.out.print("Entrer le Prenom: ");
        String prenom = sc.nextLine();
        System.out.print("Entrer le Sexe: ");
        String sexe = sc.nextLine();
        System.out.print("Entrer l'Age: ");
        int age = sc.nextInt();
        System.out.print("Entrer le Poids: ");
        double poids = sc.nextDouble();

        Personnes personne = new Personnes(nom, prenom, sexe, age, poids);
        ArrayList<Personnes> personnes = new ArrayList<Personnes>();
        personnes.add(personne);
        System.out.println("personne ajoutee");
        System.out.println(personne.toString());
    }
}