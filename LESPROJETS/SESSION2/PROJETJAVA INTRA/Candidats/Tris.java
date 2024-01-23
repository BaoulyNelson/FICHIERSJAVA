import java.util.ArrayList;

public class Tris {
    public static void SelectionAsc(ArrayList<Candidat> tab) {
        Candidat temp;
        for (int i = 0; i < tab.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < tab.size(); j++) {
                if (tab.get(min).getMoyenne() > tab.get(j).getMoyenne()) {
                    min = j;
                }
            }
            temp = tab.get(i);
            tab.set(i, tab.get(min));
            tab.set(min, temp);
        }
    }

    public static void SelectionDesc(ArrayList<Candidat> tab) {
        Candidat temp;
        for (int i = 0; i < tab.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < tab.size(); j++) {
                if (tab.get(min).getMoyenne() < tab.get(j).getMoyenne()) {
                    min = j;
                }
            }
            temp = tab.get(i);
            tab.set(i, tab.get(min));
            tab.set(min, temp);
        }
    }
}
