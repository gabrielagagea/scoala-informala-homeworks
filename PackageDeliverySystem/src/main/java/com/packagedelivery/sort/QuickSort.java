package com.packagedelivery.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuickSort<T> {
    Comparator<T> comparator;

    public QuickSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * This method sort the input ArrayList using quick sort algorithm.
     *
     * @param input the ArrayList of integers.
     * @return sorted ArrayList of integers.
     */
    public List<T> quicksort(List<T> input) {

        if (input.size() <= 1) {
            return input;
        }

        int middle = (int) Math.ceil((double) input.size() / 2);
        T pivot = input.get(middle);

        List<T> less = new ArrayList<>();
        List<T> greater = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (comparator.compare(input.get(i), pivot) <= 0) {
                if (i == middle) {
                    continue;
                }
                less.add(input.get(i));
            } else {
                greater.add(input.get(i));
            }
        }

        return concatenate(quicksort(less), pivot, quicksort(greater));
    }

    /**
     * Join the less array, pivot integer, and greater array
     * to single array.
     *
     * @param less    integer ArrayList with values less than pivot.
     * @param pivot   the pivot integer.
     * @param greater integer ArrayList with values greater than pivot.
     * @return the integer ArrayList after join.
     */
    private List<T> concatenate(List<T> less, T pivot, List<T> greater) {

        List<T> list = new ArrayList<>();

        for (int i = 0; i < less.size(); i++) {
            list.add(less.get(i));
        }

        list.add(pivot);

        for (int i = 0; i < greater.size(); i++) {
            list.add(greater.get(i));
        }
        return list;
    }
}

