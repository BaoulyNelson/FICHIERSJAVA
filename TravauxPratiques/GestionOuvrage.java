import java.util.Scanner;
class Ouvrages{
	public String code;
	public String categorie;
	public String titre;
	public String auteur;
	public int nbExemplaire;
	Scanner sc=new Scanner(System.in);
    Scanner sc1=new Scanner(System.in);

	Ouvrages ouv[]=new Ouvrages[4];
	//int c=0;
	 void enregistrer(){ // Enregistrement des ouvrages
		for (int i=0;i<ouv.length;i++){
			ouv[i]=new Ouvrages();
			System.out.println("Ouvrage "+(i+1)+":");
		    System.out.print("Categorie:");
			ouv[i].categorie=sc.nextLine();
			System.out.print("Titre:");
			ouv[i].titre=sc.nextLine();
			System.out.print("Auteur:");
			ouv[i].auteur=sc.nextLine();
			System.out.print("NbExemplaire:");
			ouv[i].nbExemplaire=sc1.nextInt();
			ouv[i].code=ouv[i].categorie.substring(0,1)+
			ouv[i].titre.substring(0,1)+"-"+(i+1);
            // substring : Methode qui permet d'extraire un ou des mots dans une chaine de caractere.
			// System.console.clear();
	     	}
            
	}
	// Declaration de la methode afficher
	void afficher(){
	   for(Ouvrages o :ouv){
		   System.out.println(o.toString());
		   System.out.println("--------------------------------------");  
	   }
		
	}
	// Declaration de la methode rechercher
	Ouvrages rechercher(){
		return null;
	}
	
	// Declaration de la methode modifier
	void modifier(){
		
	}
	
	// Declaration de la methode supprimer
	void supprimer(){
		
	}
	
	public String toString(){
		return "Code      :"+code+"\n"+
		       "Categorie :"+categorie+"\n"+
			   "Titre     :"+titre+"\n"+
			   "Auteur    :"+auteur+"\n"+
			   "Nb Exempl.:"+nbExemplaire;	   
	}
	
	public static void main(String a[]){
     Ouvrages ov=new Ouvrages();	
    	ov.enregistrer();	
		ov.afficher();
	}
}