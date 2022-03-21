import java.util.*;

public class Error {
    static Scanner scanner = new Scanner(System.in);
    public static long n;
    public static int digits;
    public static String digitsString;
    public static String guess;
    public static String target;
    public static final List<Character> fullList = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u'));
    public static final List<Character> symbolList = new ArrayList<>(List.of('a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u'));

    public static int symbolCount;









    public static void main(String[] args) {

        System.out.println("Input the length of the secret code:");


        digitsString = scanner.nextLine();


        if (digitsString.matches("\\d+")) {



            digits = Integer.parseInt(digitsString);
            if (digits == 0) {
                System.out.println("Error");

            } else {
                if (digits == 1) {

                    System.out.println("Input the number of possible symbols in the code:");

                    symbolCount = scanner.nextInt();

                    if (symbolCount > 36) {
                        System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    } else {

                        String str = "*";


                        if (digits > symbolCount) {
                            System.out.println("Error: it's not possible to generate a code with a length of " + digits + " with " + symbolCount + " unique symbols.");
                        } else {

                            Character[] symbolArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                                    'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                            int why = symbolCount - 1;


                            System.out.println("The secret is prepared: " + str.repeat(digits) + " (0-9, a- " + symbolArray[why] + ")");
                            System.out.println("Okay, let's start a game!");


                            Random random = new Random();
                            int min = 0;
                            int max = 9;
                            int rnd = random.nextInt(max - min + 1) + min;
                            target = String.valueOf(rnd);

                            String code = target;
                            System.out.println(code);


                            int feedback = 0;
                            for (int i = 0; i <= 10000; i++) {
                                System.out.println("Turn " + i + ":");
                                guess = scanner.nextLine();


                                feedback = feedback(target, String.valueOf(guess));
                                //Enter the print line here.

                                if (Objects.equals(guess, code)) {
                                    System.out.println("Grade: " + (feedback / 10) + " bulls");
                                    System.out.println("Congratulations! You guessed the secret code.");
                                    break;
                                } else {
                                    System.out.println("Grade: " + (feedback / 10) + " bull(s) and " + (feedback % 10) + " cow(s)" + ".");
                                }

                            }


                        }
                    }


                } else if (digits < 36) {

                    System.out.println("Input the number of possible symbols in the code:");

                    symbolCount = scanner.nextInt();

                    if (symbolCount > 36) {
                        System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    } else {


                        String str = "*";


                        if (digits > symbolCount) {
                            System.out.println("Error: it's not possible to generate a code with a length of " + digits + " with " + symbolCount + " unique symbols.");
                        } else {


                            Character[] symbolArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                                    'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                            int why = symbolCount - 1;


                            System.out.println("The secret is prepared: " + str.repeat(digits) + " (0-9, a-" + symbolArray[why] + ")");
                            System.out.println("Okay, let's start a game!");
                            codeGenerator(digits);


                            int feedback = 0;
                            for (int i = 0; i <= 1000000000; i++) {
                                System.out.println("Turn " + i + ":");
                                guess = scanner.nextLine();


                                feedback = feedback(target, String.valueOf(guess));
                                //Enter the print line here.

                                String code = target;

                                if (Objects.equals(guess, code)) {
                                    System.out.println("Grade: " + (feedback / 10) + " bulls");
                                    System.out.println("Congratulations! You guessed the secret code.");
                                    break;
                                } else {
                                    System.out.println("Grade: " + (feedback / 10) + " bull(s) and " + (feedback % 10) + " cow(s)" + ".");
                                }

                            }

                        }
                    }


                } else {
                    System.out.println("Error: can't generate a secret number with a length of " + digits + " " + "because there aren't enough unique digits");
                }


            }


        } else {


            System.out.println(" Error:  " + digitsString + "  isn't a valid number.");

        }

    }





 /*   public static String randomGenerator(int length, List<Character> xyz) {
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

  */


    static int feedback(String ans, String guess) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            int ind = ans.indexOf(guess.charAt(i));
            if (ind == i) bulls++;
            else if (ind >= 0) cows++;
        }
        return bulls * 10 + cows;
    }

   /* public static String symbolGenerator(int symbolCount) {
        List<Character> symbolList = new ArrayList<>(List.of('a',
                'b', 'c', 'd', 'e', 'f'));
        StringBuilder result = new StringBuilder();
        for (var ch : symbolList.subList(0, symbolCount)) {
            result.append(ch);
        }
        target = result.toString();
        System.out.println(result.toString());
        return result.toString();

    }

    */

    public static String codeGenerator(int length) {
        List<Character> fullList = new ArrayList<>(List.of( '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u'));
        Collections.shuffle(fullList);
        StringBuilder result = new StringBuilder();
        for (var ch : fullList.subList(0, length)) {
            result.append(ch);
        }
        target = result.toString();
        System.out.println(result.toString());
        return result.toString();
    }


}
