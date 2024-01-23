public class Baouly {
    public static void main(String[] args) {
        String chaine1 = "abc";
        String chaine2 = "abc";
        String chaine3 = null;
        String chaine4 = "";

        // Comparaison de contenu
        if (chaine1.equals(chaine2)) {
            System.out.println("Les chaînes chaine1 et chaine2 sont égales.");
        }

        // Vérification de null
        if (chaine3 == null) {
            System.out.println("La chaîne chaine3 est null.");
        }

        // Vérification de chaîne vide
        if (chaine4.isEmpty()) {
            System.out.println("La chaîne chaine4 est vide.");
        }
        if (chaine1==chaine2){
            System.out.println("elles sont egales");
        }
        if(chaine3.equals(chaine4)){
            System.out.println("elle sont egales");
        }
    }
}
