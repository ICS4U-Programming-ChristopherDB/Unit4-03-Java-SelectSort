
package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Change me.
 *
 * @author Christopher Di Bert
 * @version 1.0
 * @since 2024-05-14
 */

// SelectSort class
public final class SelectSort {

    /** Private constructor to prevent instantiation. */
    private SelectSort() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        File readFile = new File("input.txt");
        try {
        FileWriter fileWriter = new FileWriter("output.txt");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        Scanner sc = new Scanner(readFile);
        while (sc.hasNextLine()) {
            // Gets input lines.
            String inputElements = sc.nextLine();
            try {
            // Sets line to an array delimited by spaces.
            String[] lineArr = inputElements.split(" ");
            // Casts from string to int stream.
            IntStream ints = Arrays.stream(lineArr).mapToInt(Integer::parseInt);
            // Converts int stream to int array.
            int[] intArr = ints.toArray();
            // Writes the sorted array to the output file.
            writer.write(Arrays.toString(selectionSort(intArr)));
            // Exception thrown if the user didn't enter valid input.
            } catch (Exception e) {
            writer.write("Can only enter space-separated integers!");
            }
            writer.newLine();
        }
        writer.close();
        sc.close();
        } catch (Exception e) {
        System.out.println("Invalid path");
        }

    }

    /**
     * Selection sort.
     * @param arr
     * @return sorted array
     */
    private static int[] selectionSort(int[] arr) {
        // Iterates over every element of the array.
        for (int i = 0; i < arr.length; i++) {
            // Sets the minimum equal to current num at i.
            int min = i;
            // Goes through all other numbers, trying to find smaller numbers.
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            // Swaps the places of the minimum num and num at index i.
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

}
