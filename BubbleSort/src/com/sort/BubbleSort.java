package com.sort;

/**
 * Requirements:
 * <p>
 * Implement a bubble sort algorithm to sort an array of SalesRepresentative objects in descending order.
 * The sorting should be done based on the amount of revenue generated via sales.
 * Each rep has a number of sales, and a quota / sale.
 * <p>
 * After the sorting, the first object should be the rep with the most revenue generated.
 * The last object in the array should be the rep with the least revenue generated.
 * <p>
 * E.g
 * <p>
 * Sales guy 1 has 10 sales with a quota of 500$. He has achieved 5000$ worth of sales.
 * <p>
 * Sales guy 2 has 7 sales with a quota of 800$. He has achieved 5600$ worth of sales.
 * <p>
 * <p>
 * Sorting code example:
 * <p>
 * SalesRepresentative [ ] reps = ...
 * <p>
 * SalesRepresentative [ ] sortedReps = sort(reps);
 * <p>
 * // you need to implement the sort(SalesRepresentative [ ] reps) method. This can not be a static method.
 */

public class BubbleSort {

    static class SalesRepresentative {

        /**
         * Constructor: creates a new instance of {@link SalesRepresentative}.
         */
        SalesRepresentative(int noOfSales, int quota) {
            this.noOfSales = noOfSales;
            this.quota = quota;
        }

        private int noOfSales;
        private int quota;

        int getWorthOfSales() {
            return noOfSales * quota;
        }

        @Override
        public String toString() {
            return "SalesRepresentative{" +
                    "noOfSales=" + noOfSales +
                    ", quota=" + quota +
                    ", worthOfSales=" + getWorthOfSales() +
                    '}';
        }
    }

    public static void main(String[] args) {

        //build {@link SalesRepresentative} objects
        SalesRepresentative[] salesRepresentatives = {
                new SalesRepresentative(10, 500),
                new SalesRepresentative(7, 800)
        };
        System.out.println("Sales representatives before sorting: ");
        printSalesRepresentatives(salesRepresentatives);

        //sort {@link SalesRepresentative}s using bubble sort
        BubbleSort bubbleSort = new BubbleSort();
        SalesRepresentative[] sortedSalesRepresentative = bubbleSort.sort(salesRepresentatives);
        System.out.println("Sales representatives after sorting: ");
        printSalesRepresentatives(sortedSalesRepresentative);
    }

    private static void printSalesRepresentatives(SalesRepresentative[] salesRepresentatives) {
        for (SalesRepresentative salesRepresentative : salesRepresentatives) {
            System.out.println(salesRepresentative);
        }
    }

    private SalesRepresentative[] sort(SalesRepresentative[] salesRepresentatives) {
        boolean sorted;
        do {
            // consider objects are sorted
            sorted = true;
            for (int i = 0; i < salesRepresentatives.length - 1; i++) {
                if (salesRepresentatives[i].getWorthOfSales() < salesRepresentatives[i+1].getWorthOfSales()) {
                    // switch sales representatives
                    SalesRepresentative tmp = salesRepresentatives[i];
                    salesRepresentatives[i] = salesRepresentatives[i+1];
                    salesRepresentatives[i+1] = tmp;
                    sorted = false;
                }
            }
        } while (!sorted);

        return salesRepresentatives;
    }
}













