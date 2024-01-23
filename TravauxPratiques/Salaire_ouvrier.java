import java.util.Scanner;
class Salaire_ouvrier{
    /**  A partir de la lecture du salaire horaire et du nombre d’heures de travail, 
        déterminer le salaire net d’un 
        ouvrier en tenant compte des conditions suivantes :
        a-Tous les ouvriers participent à une caisse d’épargne à hauteur de 6% de leur salaire brut.
        b-Tous les ouvriers qui ont leur salaire brut supérieur à 10.000 gdes paient une taxe, cette taxe est de 
        5% si le salaire brut est supérieur à 20.000 gdes, 3% dans le cas contraire. 
     */
    public static void main(String args[]){

        // Condition pour le package auquel contient ce employer.
        System.out.println();
        System.out.println(" ****** PROGRAMME QUI NOUS PERMET DE CALCULER LE SAL_NET DUN EMPLOYER AVEC UN MODE DE PAIEMENT MENSUEL *******");
        System.out.println();
        System.out.println(" ============ Vous avez deux (2) options pour determiner votre salaire net ============ ");
        System.out.println(" ============ L'option (1) consiste dans quel vous y etes ============================= ");
        System.out.println(" ============ L'option (2) consiste dans quel vous y etes ============================= ");
        System.out.println();
    

        // Declaration de variable
        double salaireBrut,salaireNet1,salaireNet2,salaireNet3,salaireHoraire,tauxHoraire;
        double taxe1=0.005;
        double taxe2=0.003;
        double epargne=0.006;
        String nom,prenom,adresse;

        // La creation de l'instance de scanner afin de saisir et faire la stockage des informations saisir.
        Scanner pratique=new Scanner(System.in);

        System.out.println(" Entrer votre Nom ! ");
        nom=pratique.nextLine();
        System.out.println(" Entrer votre Prenom ! ");
        prenom=pratique.nextLine();
        System.out.println(" Entrer votre Adresse ! ");
        adresse=pratique.nextLine();

        
        System.out.println(" Entrer la quantite heure vous travaillez pendant le mois ");
        tauxHoraire=pratique.nextFloat();
        System.out.println("Entrer votre salaire pour chaque heure ");
        salaireHoraire=pratique.nextFloat();

       
        // Traitement pour determiner le salaireBrut.
        salaireBrut=(salaireHoraire)*(tauxHoraire);
       // Traitement pour les salaires net.
       salaireNet1=(salaireBrut-epargne);
       salaireNet2=(salaireBrut-taxe1);
       salaireNet3=(salaireBrut-taxe2);
        

        // Condition pour de terminer leur salaire net.
        System.out.println(" ***************** VOICI L'ENSEMBLE DES INFORMATIONS OBTENUES POUR VOUS ***************");
        if(salaireBrut<10000)
            {
            System.out.println();
            System.out.println(" ------------------- Votre nom c'est -------------------- "+(nom));
            System.out.println(" ------------------- Votre prenom c'est ----------------- "+(prenom));
            System.out.println(" ------------------- Votre adresse c'est ---------------- "+(adresse));
            System.out.println(" ------------------- VOUS N'AVEZ PAS DE TAXE ------------ ");
            System.out.println(" ------------------- Vous etes dans l'option 1 ---------- ");
            System.out.println(" ------------------- VOTRE SAL NET EST DE --------------- " +(salaireNet1)+"($)dollards");
            }

        else if(salaireBrut>=10000 && salaireBrut<20000)
            {
             System.out.println();
            System.out.println(" ------------------- Votre nom c'est -------------------- "+(nom));
            System.out.println(" ------------------- Votre prenom c'est ----------------- "+(prenom));
            System.out.println(" ------------------- Votre adresse c'est ---------------- "+(adresse));
            System.out.println(" ------------------- NB: VOUS AVEZ UN TAXE DE 5% -------- ");
            System.out.println(" ------------------- Vous etes dans l'option 2 ---------- ");
            System.out.println("-------------------- VOTRE SALAIRE NET EST DE ----------- " +(salaireNet2)+"($)dollards");
            }
        
        else if(salaireBrut>20000){
            System.out.println();
            System.out.println(" ------------------- Votre nom c'est -------------------- "+(nom));
            System.out.println(" ------------------- Votre prenom c'est ----------------- "+(prenom));
            System.out.println(" ------------------- Votre adresse c'est ---------------- "+(adresse));
            System.out.println(" ------------------- NB: VOUS AVEZ UN TAXE DE 3% -------- ");
            System.out.println(" ------------------- Vous etes dans l'option 2 ---------- ");
            System.out.println(" ------------------- VOTRE SALAIRE NET EST DE ----------- " +(salaireNet3)+"($)dollards");

        }
        else{
            
            System.out.println("======= AUCUN SOLDE POUR VOTRE COMPTE ==========");

        }  
    }
}