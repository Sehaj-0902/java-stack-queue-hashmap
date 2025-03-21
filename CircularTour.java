import java.util.Queue;
import java.util.LinkedList;

public class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // Method to find starting point
    static int findStartingPoint(PetrolPump[] pumps) {
        for (int start = 0; start < pumps.length; start++) {
            int currentPetrol = 0;
            boolean isPossibleSolution = true;

            Queue<PetrolPump> queue = new LinkedList<>();

            for (int i = 0; i < pumps.length; i++) {
                int currentIndex = (start + i) % pumps.length;
                PetrolPump currentPump = pumps[currentIndex];

                currentPetrol += currentPump.petrol - currentPump.distance;

                if (currentPetrol < 0) {
                    isPossibleSolution = false;
                    break;
                }
                queue.add(currentPump);
            }

            if(isPossibleSolution) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(2, 5),
                new PetrolPump(5, 4),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        int startingPoint = findStartingPoint(pumps);

        if (startingPoint != -1) {
            System.out.println("Starting point is: " + startingPoint);
        }
        else {
            System.out.println("No starting point found.");
        }
    }
}

/*
Input:
    PetrolPump[] pumps = {
        new PetrolPump(2, 5),
        new PetrolPump(5, 4),
        new PetrolPump(7, 3),
        new PetrolPump(4, 5)
    };
Output:
    Starting point is: 1
 */