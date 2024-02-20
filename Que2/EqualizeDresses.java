package Que2;

public class EqualizeDresses {

    public static int minimumMovesToEqualize(int[] sewingMachines) {
        int totalDresses = 0;
        int machinesCount = sewingMachines.length;
        // Calculate the total number of dresses
        for (int dresses : sewingMachines) {
            totalDresses += dresses;
        }
        if (totalDresses % machinesCount != 0) {
            return -1;
        }
        int targetDresses = totalDresses / machinesCount;
        int moves = 0;

        for (int dresses : sewingMachines) {
            int diff = dresses - targetDresses;
            if (diff > 0) {
                moves += diff;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        int[] sewingMachines = { 1, 5, 0 };
        System.out.println("The minimum number of moves required: " + minimumMovesToEqualize(sewingMachines));
    }
}