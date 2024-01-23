import java.util.Scanner;

public class SalaireNet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le salaire brut de Paul : ");
        double salaireBrut = scanner.nextDouble();

        double taxe;
        if (salaireBrut <= 15000) {
            taxe = 0.01 * salaireBrut;
        } else if (salaireBrut <= 50000) {
            taxe = 0.04 * salaireBrut;
        } else {
            taxe = 0.1 * salaireBrut;
        }

        double salaireNet = salaireBrut - taxe;

        System.out.println("Le salaire net de Paul est : " + salaireNet + " gdes");
    }
}
