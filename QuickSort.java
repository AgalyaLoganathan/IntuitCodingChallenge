package Intuit;

/**
 * Created by agalya on 1/23/16.
 */
public class QuickSort {
    private int[] reOrderElements(int[] input, int lowerIndex, int higherIndex) {
        int lowerPointer = lowerIndex;
        int higherPointer = higherIndex;
        // pivot is middle element to avoid worst case n-square complexity
        int pivotElement = input[((higherPointer - lowerPointer) / 2 + lowerPointer)];
        while (lowerPointer <= higherPointer) {
            while (input[lowerPointer] < pivotElement) {
                lowerPointer++;
            }
            while (input[higherPointer] > pivotElement) {
                higherPointer--;
            }
            if (lowerPointer <= higherPointer) {
                int t = input[lowerPointer];
                input[lowerPointer] = input[higherPointer];
                input[higherPointer] = t;
                lowerPointer++;
                higherPointer--;
            }
        }
        if (lowerIndex < higherPointer) {
            reOrderElements(input, lowerIndex, higherPointer);
        }

        if (lowerPointer < higherIndex) {
            reOrderElements(input, lowerPointer, higherIndex);
        }

        return input;
    }

    public int[] sort(int[] input) {
        if (input.length == 0 || input.length == 1) return input;
        int lowerIndex = 0;
        int higherIndex = input.length - 1;
        return reOrderElements(input, lowerIndex, higherIndex);
    }


    public static void main(String args[]) {
        QuickSort quickSort = new QuickSort();

        int[] sortedContents = quickSort.sort(new int[]{1, 10, 5, 63, 29, 71, 10, 12, 44, 29, 10, -1});
        printArrayUtil(sortedContents);

        sortedContents = quickSort.sort(new int[]{1, 1, 2, 3, 4, 5, 6, 0});
        printArrayUtil(sortedContents);

        sortedContents = quickSort.sort(new int[]{100, 99, 98, 97, 96});
        printArrayUtil(sortedContents);
    }

    public static void printArrayUtil(int[] array) {
        System.out.println("Array Content: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
