import java.io.FileWriter;
import java.io.IOException;

public class Candidat {
    private int code;
    private String nomComplet;
    private char sexe;
    private String domaine;
    private int noteTP;
    private int noteQuestion1;
    private int noteQuestion2;
    private int noteQuestion3;
    private int noteQuestion4;
    private int moyenne;

    public Candidat(int code, String nomComplet, char sexe, String domaine, int noteTP, int noteQuestion1,
            int noteQuestion2, int noteQuestion3, int noteQuestion4) {
        this.code = code;
        this.nomComplet = nomComplet;
        this.sexe = sexe;
        this.domaine = domaine;
        this.noteTP = noteTP;
        this.noteQuestion1 = noteQuestion1;
        this.noteQuestion2 = noteQuestion2;
        this.noteQuestion3 = noteQuestion3;
        this.noteQuestion4 = noteQuestion4;
        switch (this.domaine) {
            case "Programmation":
                this.moyenne = (this.noteTP + this.noteQuestion1 + this.noteQuestion2 + this.noteQuestion3) * 100
                        / 1000;
                System.out.println();
                break;
            case "BDD":
                this.moyenne = (this.noteTP + this.noteQuestion1 + this.noteQuestion2) * 100 / 800;
                System.out.println();
                break;
            case "Reseau":
                this.moyenne = (this.noteTP + this.noteQuestion1 + this.noteQuestion2 + this.noteQuestion3
                        + this.noteQuestion4) * 100 / 1150;
                System.out.println();
                break;
        }
    }

    public void ecrire() {
        try {
            FileWriter monfichier = new FileWriter(this.domaine + ".txt", true);
            String contenu = "";
            switch (this.domaine) {
                case "Programmation":
                    contenu = String.format("%d | %s | %c | %s | %d | %d | %d | %d | %d\n", code, nomComplet, sexe,
                            domaine, noteTP, noteQuestion1, noteQuestion2, noteQuestion3, moyenne);
                    System.out.println();
                    break;
                case "BDD":
                    contenu = String.format("%d | %s | %c | %s | %d | %d | %d | %d\n", code, nomComplet, sexe, domaine,
                            noteTP, noteQuestion1, noteQuestion2, moyenne);
                    System.out.println();
                    break;
                case "Reseau":
                    contenu = String.format("%d | %s | %c | %s | %d | %d | %d | %d | %d | %d\n", code, nomComplet, sexe,
                            domaine, noteTP, noteQuestion1, noteQuestion2, noteQuestion3, noteQuestion4, moyenne);
                    System.out.println();
                    break;
            }
            monfichier.write(contenu);
            monfichier.flush();
            monfichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getCode() {
        return code;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public char getSexe() {
        return sexe;
    }

    public String getDomaine() {
        return domaine;
    }

    public int getNoteTP() {
        return noteTP;
    }

    public int getNoteQuestion1() {
        return noteQuestion1;
    }

    public int getNoteQuestion2() {
        return noteQuestion2;
    }

    public int getNoteQuestion3() {
        return noteQuestion3;
    }

    public int getNoteQuestion4() {
        return noteQuestion4;
    }

    public int getMoyenne() {
        return moyenne;
    }

}
