public class PratiqueTableau {
    public static void main(String a[]) {
        int tableau[]={1,2,3,4,5,6};
        // Methode foreach pour parcourir un tableau
        for(int valeur:tableau)
        System.out.println(valeur);

        // Tableau a deux dimensions (type nomtablo[][]={})
        // Par definition c'est un tableau au milieu d'un tableau
        /* 2 akolad yo vle di tablo c kantite liy tablo a, epi kantite eleman eleman ki anndan
            akolad yo vle di c kantite kolonn tablo a ap genyen.
        */
        int tab1[][]={{1,2,3},{4,5,6}};
        for(int[] nombre:tab1)
            for(int j: nombre)
        System.out.println(j);

    }
}
