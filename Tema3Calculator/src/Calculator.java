import java.util.Scanner;

public class Calculator{
    public static void main (String[] args) {
        double x, y;

        /**Am ales variabile de tip double pentru ca utilizatorul
         *sa poate introduce atat
         * numere intregi cat si numere zecimale
         */
        Scanner scanner = new Scanner (System.in);

        System.out.print("The first number is:");
        x = scanner.nextDouble();
        System.out.print("The second number is:");
        y = scanner.nextDouble();

        System.out.print("Enter an operator ( +, -, *, /): ");
        char operator = scanner.next().charAt(0);

        scanner.close();
        double output;

        switch (operator)
        {
            case'+':
                output = x + y;
                break;

            case'-':
                output = x-y;
                break;

            case'*':
                output = x*y;
                break;

            case '/':
                output = x/y;
                break;

            default:
                System.out.println("Error");
                return;
        }


        System.out.println( x+" "+operator+" " +y+" =" + output);
    }
}