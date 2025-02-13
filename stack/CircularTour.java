package stack;

import java.util.LinkedList;
import java.util.Queue;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int canCompleteTour(PetrolPump[] pumps) {
        int n = pumps.length;
        if (n == 0) {
            return -1; 
        }

        for (int start = 0; start < n; start++) {
            int currentPetrol = 0;
            boolean possible = true;
            Queue<Integer> tour = new LinkedList<>();

            
            for (int i = 0; i < n; i++) {
                int currentPump = (start + i) % n; 
                tour.offer(currentPump);
                currentPetrol += pumps[currentPump].petrol;

                if (currentPetrol < pumps[currentPump].distance) {
                    possible = false;
                    break; 
                }
                currentPetrol -= pumps[currentPump].distance;
            }

            if (possible && tour.size() == n) { 
                return start;
            }
        }

        return -1;
    }



    public static int canCompleteTourOptimized(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;
        int currentPetrol = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            currentPetrol += pumps[i].petrol - pumps[i].distance;

            if (currentPetrol < 0) {
                deficit += currentPetrol;
                currentPetrol = 0;     
                start = i + 1;         
            }
        }

        if (currentPetrol + deficit >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(3, 7)
        };

        int start = canCompleteTour(pumps);
        if (start != -1) {
            System.out.println("Starting point: " + start);
        } else {
            System.out.println("No starting point found.");
        }

        pumps = new PetrolPump[]{
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(3, 7)
        };

        start = canCompleteTourOptimized(pumps);
        if (start != -1) {
            System.out.println("Starting point (Optimized): " + start);
        } else {
            System.out.println("No starting point found. (Optimized)");
        }



        pumps = new PetrolPump[]{
                new PetrolPump(1, 2),
                new PetrolPump(2, 2),
                new PetrolPump(3, 1)
        };

        start = canCompleteTour(pumps);
        if (start != -1) {
            System.out.println("Starting point: " + start);
        } else {
            System.out.println("No starting point found.");
        }

        start = canCompleteTourOptimized(pumps);
        if (start != -1) {
            System.out.println("Starting point (Optimized): " + start);
        } else {
            System.out.println("No starting point found. (Optimized)");
        }
    }
}