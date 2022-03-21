import java.util.*;

public class SecretCode {
    static Scanner scanner = new Scanner(System.in);
    public static long n;
    public static int digits;

    public static void main(String[] args) {


        digits = scanner.nextInt();

        if(digits<10){
            randomGenerator(digits);
        } else {
            System.out.println("Error: can't generate a secret number with a length of " + digits + " " + "because there aren't enough unique digits");
        }



    }

    public static void generateRandom() {


        digits = scanner.nextInt();


        n = 0;

        if (digits < 10) {
            if (digits == 1) {
                n = 9;
            } else if (digits == 2) {
                n = 99;
            } else if (digits == 3) {
                n = 999;
            } else if (digits == 4) {
                n = 9999;
            } else if (digits == 5) {
                n = 99999;
            } else if (digits == 6) {
                n = 999999;
            } else if (digits == 7) {
                n = 9999999;
            } else if (digits == 8) {
                n = 99999999;
            } else if (digits == 9) {
                n = 999999999;
            } else if (10 <= digits) {
                System.out.println(" Error: can't generate a secret number with a length of " + digits + " " + "because there aren't enough unique digits.");
            }
        } else {

            System.out.println(" Error: can't generate a secret number with a length of " + digits + " " + "because there aren't enough unique digits.");


        }

        Random rnd = new Random();
        int code = rnd.nextInt((int) n);

        System.out.println("The random secret number is " + code + ".");


        /* System.out.println(code);
        System.out.println("The secret code is prepared: ****");
        boolean condition = true;

         */
    }

    public static void arrayShuffler() {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(0);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        al.add(8);
        al.add(9);


        Collections.shuffle(al);
        System.out.println("After shuffling Arraylist:");

        Iterator itr = al.iterator();
        itr = al.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next());
        }


        digits = scanner.nextInt();


        n = 0;

        if (digits < 10) {
            if (digits == 1) {

            } else if (digits == 2) {

            } else if (digits == 3) {

            } else if (digits == 4) {

            } else if (digits == 5) {

            } else if (digits == 6) {

            } else if (digits == 7) {

            } else if (digits == 8) {

            } else if (digits == 9) {

            } else if (10 <= digits) {
                System.out.println(" Error: can't generate a secret number with a length of " + digits + " " + "because there aren't enough unique digits.");
            }
        } else {

            System.out.println(" Error: can't generate a secret number with a length of " + digits + " " + "because there aren't enough unique digits.");
        }
    }




    public static String randomGenerator(int length) {
        List<Integer> randomList = new ArrayList<>(List.of(0, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(randomList);
        StringBuilder result = new StringBuilder();
        for (var ch : randomList.subList(0, length)) {
            result.append(ch);
        }
        System.out.println(result.toString());
        return result.toString();

    }
}
