public class Toto {
    public static void main(String[] args) {

        countElements();
        normal();
        // countEl();

    }

    public static void countElements() {
        int numberOfTrees = 0;
        while (numberOfTrees < 10) {
            numberOfTrees += 1;
            System.out.println("I planted " + numberOfTrees + " trees");

        }
        System.out.println("I have a forest!");
    }

    public static void normal() {
        int pushUpGoal = 10;
        do {
            System.out.println("Push up!");
            pushUpGoal -= 1;
        } while (pushUpGoal > 0);
    }

    public static void psuh(){
        int pushUpGoal = 0;
        do {
            System.out.println("Push up!");
            pushUpGoal += 1;
        } while (pushUpGoal < 10);
    }
}
