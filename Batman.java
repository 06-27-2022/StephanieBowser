import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        int presentx = 0;
        int presenty = 0;

        int pastx = W - 1;
        int pasty = H - 1;


        


        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

        if (bombDir.contains("U")){
            pasty = Y0 - 1;
            
        } else if (bombDir.contains("D")){
            presenty = Y0 + 1;

        } if (bombDir.contains("L")) {
            pastx = X0 - 1;
            
        }else if (bombDir.contains("R")) {
            presentx = X0 + 1;
        }
        X0 = presentx + (pastx - presentx) / 2;
        Y0 = presenty + (pasty - presenty) / 2;

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // the location of the next window Batman should jump to.
            System.out.println(X0+" "+Y0);
        }
    }
}