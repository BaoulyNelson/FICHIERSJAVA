class ExamenBac {
    private int mathematiques;
    private int philosophie;
    private int sciencesSociales;
    private int[] autresMatieres;

    public ExamenBac(int mathematiques, int philosophie, int sciencesSociales, int[] autresMatieres) {
        this.mathematiques = mathematiques;
        this.philosophie = philosophie;
        this.sciencesSociales = sciencesSociales;
        this.autresMatieres = autresMatieres;
    }

    public int getMathematiques() {
        return mathematiques;
    }

    public int getPhilosophie() {
        return philosophie;
    }

    public int getSciencesSociales() {
        return sciencesSociales;
    }

    public int[] getAutresMatieres() {
        return autresMatieres;
    }

    public int getTotalPoints() {
        int total = mathematiques + philosophie + sciencesSociales;
        for (int autreMatiere : autresMatieres) {
            total += autreMatiere;
        }
        return total;
    }

    public String lireNotes() {
        StringBuilder notesText = new StringBuilder();
        for (int i = 0; i < autresMatieres.length; i++) {
            notesText.append("Autre Matiere ").append(i + 1).append("...: ").append(autresMatieres[i]).append("\n");
        }
        return notesText.toString();
    }
    
    public double calculerMoyenneSur10() {
        double totalPoints = getTotalPoints();
        double moyenneSur10 = (totalPoints / 2600) * 10;
        return moyenneSur10;
    }
    
}
