import java.util.ArrayList;
import java.util.Scanner;

public class Grader {
    public static void main(String[] args) {
            final String target = getNum();
            Scanner in = new Scanner(System.in);
            String guess = in.next();
            int feedback = feedback(target, guess);
            System.out.println("Grade: " + (feedback / 10) + " bull(s) and " + (feedback % 10) + " cow(s)" + ". The code is " + target);
        }


        static String getNum() {
            ArrayList<String> possib = new ArrayList<String>();
            for (int a = 1; a <= 9; a++) {
                for (int b = 1; b <= 9; b++) {
                    if (b == a) continue;
                    for (int c = 1; c <= 9; c++) {
                        if (c == b || c == a) continue;
                        for (int d = 1; d <= 9; d++) {
                            if (d == a || d == b || d == c) continue;
                            String cnt = "" + a + b + c + d;
                            possib.add(cnt);
                        }
                    }
                }
            }
            String guess = possib.get((int) (Math.random() * possib.size()));
            return guess;
        }

        static int feedback(String ans, String guess) {
            int bulls = 0, cows = 0;
            for (int i = 0; i < guess.length(); i++) {
                int ind = ans.indexOf(guess.charAt(i));
                if (ind == i) bulls++;
                else if (ind >= 0) cows++;
            }
            return bulls * 10 + cows;
        }



    }
