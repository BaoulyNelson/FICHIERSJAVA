import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class JwetLotbo {

    public static void main(String[] args) {
        // Kreye yon jwèt lòtbò
        JwetLotbo jwet = new JwetLotbo();
        jwet.jweJwet();
    }

    private int nimewoKache;
    private int chansRete;
    //private int ansyenSko;
    private int nouvoSko;
    private String nonItilizate;

    public JwetLotbo() {
        // Initializasyon nan konstriktè
        this.nimewoKache = randomNimewo();
        this.chansRete = 10;
        //this.ansyenSko = 0;
        this.nouvoSko = 0;
        this.nonItilizate = "Nouvo Jwet";
    }

    public void jweJwet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Byenveni nan Jwet lawoulet!");
        System.out.print("Antre non ou: ");
        this.nonItilizate = scanner.next();

        while (true) {
            System.out.print(nonItilizate+ " Antre yon nimewo nan enteval 0 ak 100: ");
            int nimewoItilizate = scanner.nextInt();

            while(nimewoItilizate<0 || nimewoItilizate>100){
                System.out.print("re antre nimewo a SVP: ");
               nimewoItilizate = scanner.nextInt();
            }

            if (nimewoItilizate == this.nimewoKache) {
                // Jwet la fini, moun kap jwe  a genyen
                System.out.println("BRAVO " +nonItilizate+ " !Ou jwenn nimewo kache a ki se: " + this.nimewoKache);
                this.nouvoSko = this.chansRete * 30;
                anrejistreSko();
                aficheSko();
                break;
            } else if (nimewoItilizate < this.nimewoKache) {
                // Nimewo a pi piti
                System.out.println(nonItilizate+ " Nimewo ou antre a pi piti ke nimewo kache a. Chans ki rete: " + this.chansRete);
            } else {
                // Nimewo a pi gran
                System.out.println(nonItilizate+ " Nimewo ou antre a pi gran ke nimewo kache a. Chans ki rete: " + this.chansRete);
            }

            this.chansRete--;

            if (this.chansRete == 0) {
                // Jwet la fini, moun kap jwe a pèdi
                System.out.println(nonItilizate+ " Ou pedi. Nimewo kache a te: " + this.nimewoKache);
                aficheSko();
                break;
            }
        }
    }

    private void anrejistreSko() {
        try {
            // Desereyalize ansyen skò yo
            FileInputStream fileInput = new FileInputStream("scores.pickle");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            ArrayList<String> skoList = (ArrayList<String>) objectInput.readObject();
            objectInput.close();

            // Ajoute nouvo skò nan list la
            skoList.add(this.nonItilizate + " - " + this.nouvoSko);

            // Sereyalize list la ak nouvo skò yo
            FileOutputStream fileOutput = new FileOutputStream("scores.pickle");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(skoList);
            objectOutput.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void aficheSko() {
        try {
            // Desereyalize skò yo
            FileInputStream fileInput = new FileInputStream("scores.pickle");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            ArrayList<String> skoList = (ArrayList<String>) objectInput.readObject();
            objectInput.close();

            System.out.println("Sko yo:");
            for (String sko : skoList) {
                System.out.println(sko);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int randomNimewo() {
        Random rand = new Random();
        return rand.nextInt(101); // Nimewo ale nan 0 ak 100
    }
}
