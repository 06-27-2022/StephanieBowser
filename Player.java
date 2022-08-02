import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position

            boolean North;
            boolean South;
            boolean West;
            boolean East;
        // game loop
        String answer;
        
        while (true) {
            if (lightX - initialTx < 0) {
                West = true; East = false;
                initialTx--;

            } else if (lightX - initialTx > 0) {
                East = true; West = false;
                initialTx++;

            } else { West = false ; East = false; }

                if (lightY - initialTy < 0) {
                North = true; South = false; 
                initialTy--;
            } else if (lightY - initialTy > 0) {
                South = true; North = false;
                initialTy++;
            } else { North = false ; South = false; }


            if (North && !West && !East && !South) {
                answer = "N";

            } else if (North && !West && East && !South) {
                answer = "NE";

            } else if (North && West && !East && !South) {
                answer = "NW";

            }

                else if (South && West && !East && !North) {
                answer = "SW";
                }
                else if (South && !West && !East && !North) {
                answer = "S";
                }
                else if (South && !West && East && !North) {
                answer = "SE";
                }

                else if (!North && West && !South && !East) {
                answer = "W";
                }
                else {
                answer = "E";
                }
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");



            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(answer);
        }
    }
}