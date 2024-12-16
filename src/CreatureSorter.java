import java.util.Stack;

public class CreatureSorter {

    // Creature class to store name and power level
    static class Creature {
        String name;
        int power;

        Creature(String name, int power) {
            this.name = name;
            this.power = power;
        }

        @Override
        public String toString() {
            return name + " - " + power;
        }
    }

    public static void main(String[] args) {
        // Fixed input data
        Creature[] creatures = {
                new Creature("Dragon", 95),
                new Creature("Griffin", 88),
                new Creature("Unicorn", 78),
                new Creature("Phoenix", 92),
                new Creature("Centaur", 85)
        };

        // Bubble Sort for descending order
        System.out.println("Bubble Sort : Descending Order by Power Level:");
        Creature[] bubbleSorted = bubbleSortDescending(creatures.clone());
        printCreatures(bubbleSorted);

        // Selection Sort for ascending order
        System.out.println("\nSelection Sort : Ascending Order by Power Level:");
        Creature[] selectionSorted = selectionSortAscending(creatures.clone());
        printCreatures(selectionSorted);

        // Stack implementation for descending order
        System.out.println("\nStack Implementation : Popping Creatures:");
        Stack<Creature> creatureStack = new Stack<>();
        for (Creature creature : bubbleSorted) { // Push sorted creatures onto the stack
            creatureStack.push(creature);
        }

        while (!creatureStack.isEmpty()) { // Pop and display details
            Creature popped = creatureStack.pop();
            System.out.println("Popped: " + popped);
        }
    }

    // Bubble Sort implementation for descending order
    public static Creature[] bubbleSortDescending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (creatures[j].power < creatures[j + 1].power) { // Compare power levels
                    // Swap if out of order
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
        return creatures;
    }

    // Selection Sort implementation for ascending order
    public static Creature[] selectionSortAscending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures[j].power < creatures[minIndex].power) {
                    minIndex = j;
                }
            }
            // Swap the found minimum with the first element
            Creature temp = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = temp;
        }
        return creatures;
    }

    // Utility function to print creatures array
    public static void printCreatures(Creature[] creatures) {
        for (Creature creature : creatures) {
            System.out.println(creature);
        }
    }
}
