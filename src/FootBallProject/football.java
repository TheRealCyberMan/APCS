import java.util.*;

public class football {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int touchdown = 0;
        int downs = 1;
        int yards = 50; 
        int line = 50; 
        int userinput;

        while(yards > 0 && downs <= 4 && line >= 0 && line <= 100) { // Ensuring line stays within the field
            System.out.println("It is " + downs + " down, what play do you want to run? (1 for run, 2 for pass, 3 for screen)");
            userinput = sc.nextInt();

            System.out.println("How many yards did you gain from the last play?");
            int gainedYards = sc.nextInt();

            yards -= gainedYards;
            line -= gainedYards;

            // Ensuring line and yards stay non-negative
            yards = Math.max(yards, 0);
            line = Math.max(line, 0);

            if(gainedYards < 10) {
                downs++;
            } else {
                downs = 1;
            }

            if(yards <= 0) {
                touchdown++;
                System.out.println("Touchdown! You scored!");
                break;
            }

            System.out.println("You are at the " + line + " yard line");
        }

        if(downs > 4) {
            System.out.println("You did not make enough progress in 4 downs. Turnover!");
        } else if (line > 100 || line < 0) {
            System.out.println("Invalid play! You're off the field.");
        }

        if(touchdown == 0) {
            System.out.println("Your play ended at "+line+" yard line.");
        }
    }
}
