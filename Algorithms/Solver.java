package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;
import Models.Cube;

public class Solver {
    private static Cube cube;
    private static String[] movesCross;
    private static String[] movesF2L;
    private static String[] movesOLL;
    private static String[] movesPLL;
    private static String[] combinedMovesFinal;

    public static void solve(Cube cubeInput, boolean shouldBreakdownSolution) {
        Cube cubeCopy = new Cube(cubeInput);
        cube = cubeInput;
        movesCross = condenseMoves(RubikCross.crossPermutation(cubeCopy));
        movesF2L = condenseMoves(RubikF2L.fillF2L(cubeCopy));
        movesOLL = condenseMoves(RubikOLL.orientateLastLayer(cubeCopy));
        movesPLL = condenseMoves(RubikSimplePLL.permutateLastLayer(cubeCopy));
        ArrayList<String> combinedMovesList = new ArrayList<String>();
        for (String move : movesCross) {
            combinedMovesList.add(move);           
        }
        for (String move : movesF2L) {
            combinedMovesList.add(move);           
        }
        for (String move : movesOLL) {
            combinedMovesList.add(move);           
        }
        for (String move : movesPLL) {
            combinedMovesList.add(move);           
        }

        // example of final condensing at work
        // D2 U2 L2 U F R' F' B' U R U' R' U F' U F U' R' U2 R U R' U' R U B' U B F U2 F' U' F U F' F R' F' R U R U' R' R B' R' F R B R' F' R B R' F R B' R' U' F U F U F U' F' U' F2
        // D2 U2 L2 U F R' F' B' U R U' R' U F' U F U' R' U2 R U R' U' R U B' U B F U2 F' U' F U R' F' R U R U' B' R' F R B R' F' R B R' F R B' R' U' F U F U F U' F' U' F2
        combinedMovesFinal = condenseMoves(combinedMovesList.toArray(new String[0]));

        if (shouldBreakdownSolution) {
            solutionBreakdown();
        }
        
        for (String move : combinedMovesFinal) {
            System.out.print(move+" ");
        }
    }

    private static String[] condenseMoves(String[] input) {
        StringBuilder output = new StringBuilder("");
        String prevMove = null;
        for (int i = 0; i < input.length; i++) {
            if (prevMove != null) {
                if (prevMove.substring(0, 1).equals(input[i].substring(0, 1))) {
                    String base = prevMove.substring(0, 1);
                    int prev;
                    int next;
                    if (prevMove.length() == 1) {
                        prev = 1;
                    } else if (prevMove.substring(1, 2).equals("2")) {
                        prev = 2;
                    } else {
                        prev = -1;
                    }
                    if (input[i].length() == 1) {
                        next = 1;
                    } else if (input[i].substring(1, 2).equals("2")) {
                        next = 2;
                    } else {
                        next = -1;
                    }
                    switch (prev + next) {
                        case 0:
                        case 4:
                            prevMove = null;
                            break;
                        case 1:
                            prevMove = base;
                            break;
                        case -2:
                        case 2:
                            prevMove = base.concat("2");
                            break;
                        case 3:
                            prevMove = base.concat("'");
                            break;
                        default:
                            break;
                    }
                } else {
                    output.append(prevMove);
                    output.append(",");
                    prevMove = input[i];
                }
            } else {
                prevMove = input[i];
            }
        }
        if (prevMove != null) {
            output.append(prevMove);
            output.append(",");
        }
        return output.toString().split(",");
    }

    private static void solutionBreakdown() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Mix: ");
        System.out.println(cube.getInitialMix());
        System.out.println("");
        cube.showCube();
        System.out.println("Press Enter to continue...");
        sc.nextLine();

        System.out.print("Cross: ");
        for (String move : movesCross) {
            System.out.print(move+" ");
        }
        System.out.println("\n");
        cube.moveSequence(movesCross);
        cube.showCube();      
        System.out.println("Press Enter to continue...");
        sc.nextLine();

        System.out.print("F2L: ");
        for (String move : movesF2L) {
            System.out.print(move+" ");
        }
        System.out.println("\n");
        cube.moveSequence(movesF2L);
        cube.showCube();
        System.out.println("Press Enter to continue...");
        sc.nextLine();

        System.out.print("OLL: ");
        for (String move : movesOLL) {
            System.out.print(move+" ");
        }
        System.out.println("\n");
        cube.moveSequence(movesOLL);
        cube.showCube();
        System.out.println("Press Enter to continue...");
        sc.nextLine();

        System.out.print("PLL: ");
        for (String move : movesPLL) {
            System.out.print(move+" ");
        }
        System.out.println("\n");
        cube.moveSequence(movesPLL);
        cube.showCube();
        System.out.println("Press Enter to continue...");
        sc.nextLine();

        int moveCount = combinedMovesFinal.length;
        System.out.println("Took "+String.valueOf(moveCount)+" moves to solve.");
        System.out.println("");
        sc.close();    
    }
}
