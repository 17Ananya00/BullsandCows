import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class improving {
    static Scanner scanner = new Scanner(System.in);
    public static long n;
    public static int digits;
    public static int guess;
    public static String target;



        public static void main (String[]args){

            System.out.println("Please, enter the secret code's length:");

            digits = scanner.nextInt();

            System.out.println("Okay, let's start a game!");


            if (digits < 10) {
                randomGenerator(digits);
            } else {
                System.out.println("Error: can't generate a secret number with a length of " + digits + " " + "because there aren't enough unique digits");
            }
            int feedback = 0;
            for (int i = 1; i <= 100; i++) {
                System.out.println("Turn " + i + ":");
                guess = scanner.nextInt();


                feedback = feedback(target, String.valueOf(guess));
                //Enter the print line here.

                int code = Integer.parseInt(target);
                if (guess == code) {
                    System.out.println("Grade: " + (feedback / 10) + " bull(s)");
                    System.out.println("Congratulations! You guessed the secret code.");
                    break;
                } else {
                    System.out.println("Grade: " + (feedback / 10) + " bull(s) and " + (feedback % 10) + " cow(s)" + ".");
                }

            }


        }


        public static String randomGenerator ( int length){
            List<Integer> randomList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            Collections.shuffle(randomList);
            StringBuilder result = new StringBuilder();
            for (var ch : randomList.subList(0, length)) {
                result.append(ch);
            }
            target = result.toString();
            System.out.println(result.toString());
            return result.toString();

        }


        static int feedback (String ans, String guess){
            int bulls = 0, cows = 0;
            for (int i = 0; i < guess.length(); i++) {
                int ind = ans.indexOf(guess.charAt(i));
                if (ind == i) bulls++;
                else if (ind >= 0) cows++;
            }
            return bulls * 10 + cows;
        }

    }

