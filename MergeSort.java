package project;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.PriorityQueue;
import java.util.Random;

public class MergeSort {
    public static int mergeSequence(int[] sizes) {
        // Create a min-heap using PriorityQueue
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        // Add all list sizes to the heap
        for (int size : sizes) {
            heap.add(size);
        }

        int totalCost = 0;

        // Process n-1 merges
        while (heap.size() > 1) {
            // Remove two smallest elements (log n time per removal)
            int first = heap.poll();
            int second = heap.poll();

            // Merge them, and add the resulting size back to the heap (log n time)
            int mergedSize = first + second;
            heap.add(mergedSize);

            // Add the merged size to the total cost
            totalCost += mergedSize;
        }

        // Return the total merge cost (which corresponds to the sequence of merges)
        return totalCost;
    }

    // Generate a random array of specified size
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000) + 1;  // Random values between 1 and 1000
        }
        return array;
    }

    public static void main(String[] args) {
        // Input sizes for generating arrays
        int[] sizes = {1000, 10000, 100000, 1000000, 10000000};

        for (int size : sizes) {
            // Generate random array of the current size
            int[] listSizes = generateRandomArray(size);

            // Measure the execution time in nanoseconds
            long startTime = System.nanoTime();
            
            // Call mergeSequence and get the result
            int totalCost = mergeSequence(listSizes);
            
            long endTime = System.nanoTime();
            
            // Calculate the total execution time
            long duration = endTime - startTime;
            
            // Print the input size, total merge cost, and the execution time
            System.out.println("Input size: " + size);
            System.out.println("Total merge cost: " + totalCost);
            System.out.println("Execution time (nanoseconds): " + duration);
            System.out.println("-----------------------------");
        }
    }
}
