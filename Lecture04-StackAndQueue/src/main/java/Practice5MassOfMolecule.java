import java.util.Scanner;
import java.util.Stack;

public class Practice5MassOfMolecule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String formular = scanner.next();

        Stack<Integer> massStack = new Stack<>();
        for (int i = 0; i < formular.length(); i++) {
            char c = formular.charAt(i);
            if (Character.isLetter(c)) {
                int mass = 0;
                if (c == 'H') {
                    mass = 1;
                } else if (c == 'C') {
                    mass = 12;
                } else if (c == 'O') {
                    mass = 16;
                }
                massStack.push(mass);
            } else if (Character.isDigit(c)) {
                int occurrences = Integer.parseInt(Character.toString(c));
                Integer mass = massStack.pop();
                int newMass = occurrences * mass;
                massStack.push(newMass);
            } else if (c == '(') {
                massStack.push(-1);
            } else if (c == ')') {
                Integer mass = massStack.pop();
                int newMass = 0;
                while (mass != -1) {
                    newMass += mass;
                    mass = massStack.pop();
                }
                massStack.push(newMass);
            }
        }

        int totalMass = 0;
        while (!massStack.isEmpty()) {
            totalMass += massStack.pop();
        }

        System.out.println(totalMass);
    }
}
