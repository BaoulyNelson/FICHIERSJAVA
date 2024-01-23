import javax.swing.*;
import java.awt.event.*;

public class AnneeChooser extends JFrame {
    private JComboBox<String> anneeListe;

    public AnneeChooser() {
        setTitle("Choisissez une année");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        anneeListe = new JComboBox<>();
        for (int annee = 1980; annee <= 2023; annee++) {
            anneeListe.addItem(Integer.toString(annee));
        }

        anneeListe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedAnnee = (String) anneeListe.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Année sélectionnée : " + selectedAnnee);
            }
        });

        getContentPane().add(anneeListe);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AnneeChooser().setVisible(true);
            }
        });
    }
}
