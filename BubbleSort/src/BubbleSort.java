/**
 * Requirements:
 *
 * Implement a bubble sort algorithm to sort an array of SalesRepresentative objects in descending order.
 * The sorting should be done based on the amount of revenue generated via sales.
 * Each rep has a number of sales, and a quota / sale.
 *
 * After the sorting, the first object should be the rep with the most revenue generated.
 * The last object in the array should be the rep with the least revenue generated.
 *
 * E.g
 *
 * Sales guy 1 has 10 sales with a quota of 500$. He has achieved 5000$ worth of sales.
 *
 * Sales guy 2 has 7 sales with a quota of 800$. He has achieved 5600$ worth of sales.
 *
 *
 * Sorting code example:
 *
 * SalesRepresentative [ ] reps = ...
 *
 * SalesRepresentative [ ] sortedReps = sort(reps);
 *
 * // you need to implement the sort(SalesRepresentative [ ] reps) method. This can not be a static method.
 */


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int salesRepresentative[] = new int[]{1, 2, 3, 4, 5};

        int numberOfSales[] = new int[]{10, 7, 5, 8, 9};
        int list[] = new int[]{500, 800, 400, 900, 700};


        System.out.println("Primul tabel inainte de transformare este: ");
        for (int n = 0; n < 5; n++) {

            System.out.println(salesRepresentative[n] + " ..... " + numberOfSales[n] + "......" + list[n]);
        }
        System.out.println("Lista dupa aplicarea metodei Boubble sort este:" + "");


        int bestQuotaSale = getBestQuotaSale(list, salesRepresentative);
        for (int i = 0; i < list.length; i++) {

        }
    }

    public static int getBestQuotaSale(int[] list, int[] salesRepresentative) {

        int temp;
        boolean fixed = false;
        while (fixed == false) {
            fixed = true;

            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] < list[i + 1]) {
                    temp = list[i + 1];
                    list[i + 1] = list[i];
                    list[i] = temp;
                    fixed = false;

                }

            }
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i] + "    ");
            }


        }
        return list.length;

    }

    /**
     * Pana aici se compileaza perfect;
     * De aici incolo nu imi da nici o eroare dar nici nu am reusit sa il fac
     * sa se aranjeze asa cum ar fi trebuit!
     * Si nu inteleg de ce?!!!!!
     */

    public int sortSalesRepresentative(int[] salesRepresentative) {

        int temp1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (salesRepresentative[j] > salesRepresentative[j + 1]) {
                    temp1 = salesRepresentative[j];
                    salesRepresentative[j] = salesRepresentative[j + 1];
                    salesRepresentative[j + 1] = temp1;
                }
            }
            for (i = 0; i < 5; i++) {
                System.out.println(salesRepresentative[i] + "");
            }


        }

        return salesRepresentative.length;
    }


    public int sortNumberOfSales(int[] numberOfSales, int[] list) {

        int temp2;
        for (int i = 0; i < 5; i++) {
            for (int y = 0; y < 4 - i; y++) {
                if ((numberOfSales[list[y]] > (numberOfSales[list[y]]))) {
                    temp2 = numberOfSales[y];
                    numberOfSales[y] = numberOfSales[y + 1];
                    numberOfSales[y + 1] = temp2;
                }

                for (i = 0; i < 5; i++) {
                    System.out.println(numberOfSales[i] + "");
                }


            }

        }
        return numberOfSales.length;
    }
}








