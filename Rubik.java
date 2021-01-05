import java.util.ArrayList;

import Models.*;
import Algorithms.Solver;

public class Rubik {
    public static void main(String[] args) {
        // 1. Create Cube
        // 2. Mix Cube
        // 3. Solve and Print solution
        if (args.length == 1 && isValidArgument(args[0])) {
                Cube rubik = new Cube();
                rubik.showCube();
                try {
                    int mixNumber = Integer.parseInt(args[0]);
                    rubik.mixCubeRandom(mixNumber);
                } catch (Exception e) {
                    rubik.mixCube(args[0].split(" "));
                }
                rubik.showCube();
                Solver.solve(rubik);
        } else {
            System.out.println("Usage: java Rubik <mix string> or java Rubik <mix move length>");
        }
    }

    private static boolean isValidArgument(String arg) {
        ArrayList <String> validMoves = new ArrayList<String>();
        String[] validMovesArray = {
            "F", "F'", "F2",
            "B", "B'", "B2",
            "L", "L'", "L2",
            "R", "R'", "R2",
            "U", "U'", "U2",
            "D", "D'", "D2",
        };
        for (String move : validMovesArray) {
            validMoves.add(move);
        }

        try {
            int mixNumber = Integer.parseInt(arg);
            if (mixNumber < 1) {
                return false;
            }
        } catch (Exception e) {
            String[] mix = arg.split(" ");
            for (String string : mix) {
                if (!validMoves.contains(string.trim())) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
