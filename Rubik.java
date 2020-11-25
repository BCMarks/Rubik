import Models.*;
import java.util.Scanner;

public class Rubik {
    public static void main(String[] args) {
        // 1. Create Cube
        // 2. Mix Cube
        // 3. Solve and Print solution
        if (args.length == 1 && isValidArgument(args[0])) {
            if (true) {
                //if args[0] is int do random mix else do given mix
                //String[] mix = args[0].split(" ");
                Cube rubik = new Cube();
                rubik.showCube();
                //rubik.mixCube(mix);
                int mixNumber = 0;
                try {
                    mixNumber = Integer.parseInt(args[0]);
                } catch (Exception e) {
                    System.out.println("That aint an int chief");
                    System.exit(0);
                }
                rubik.mixCubeRandom(mixNumber);
                rubik.showCube();
            }
            //Scanner scanner = new Scanner(System.in);           
            /*
            while (true) {
                String input = scanner.nextLine();
                rubik.makeMove(input);
                //rubik.displayPieces();
                rubik.showCube();
                
            }
            */
        } else {
            System.out.println("Usage: java Rubik <mix string> or java Rubik <mix move length>");
        }
    }

    private static boolean isValidArgument(String arg) {
        // either an integer or space delimited commands
        return true;
    }
    
}
