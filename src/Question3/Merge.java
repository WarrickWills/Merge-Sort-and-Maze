package Question3;

import java.util.*;

/**
 *
 * @author Warrick Wills - 13831575
 */
public class Merge {


    private int[][] arr;
    private int arrSize;

    public Merge(int size) {
        this.arrSize = size;
        arr = create2DArray(size, size);
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] tempArr = new int[arr1.length + arr2.length];
        int ti = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] <= arr2[index2]) {
                tempArr[ti++] = arr1[index1++];
            } else {
                tempArr[ti++] = arr2[index2++];
            }
        }
        while (index1 < arr1.length) {
            tempArr[ti++] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            tempArr[ti++] = arr2[index2++];
        }

        return tempArr;
    }

    public int[] mergeArray(int[][] arr) {
        int[] tempArr = merge(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            tempArr = merge(tempArr, arr[i]);
        }
        return tempArr;
    }

    public void mergeProcedure(int[] data, int[] temp, int low, int middle, int high) {
        int ri = 0;
        int ti = low;
        int di = middle;
        int[] result = new int[high - low + 1];
        while (ti < middle && di <= high) {
            if (data[di] <= temp[ti]) {
                result[ri++] = data[di++];
            } else {
                temp[ri++] = temp[ti++];
            }
        }
        while (ti < middle) {
            result[ri++] = temp[ti++];
        }
        while (di <= high) {
            result[ri++] = data[di++];
        }

        System.arraycopy(result, 0, data, low, high);
    }

    private void mergeSortRecursive(int[][] array, int[][] temp, int low, int high) {
        int n = high - low + 1;
        int middle = low + n / 2;
        int i;
        if (n < 2) {
            return;
        }

        for (i = low; i < middle; i++) {
            System.arraycopy(array[i], 0, temp[i], 0, array[i].length);
        }

        mergeSortRecursive(array, temp, low, middle - 1);
        mergeSortRecursive(array, temp, middle, high);
    }

    public int[][] getArray() {
        return arr;
    }
    
    private int[] createArray(int l) {
        Random r = new Random();
        int[] newArray = new int[l];
        newArray[0] = r.nextInt(100);
        for (int i = 1; i < l; i++) {
            int temp = newArray[i - 1] + r.nextInt(i * 2);
            newArray[i] = temp;
        }
        return newArray;
    }

    private int[][] create2DArray(int l, int w) {
        int[][] arr1 = new int[l][w];
        for (int[] array : arr1) {
            int[] rArray = createArray(w);
            System.arraycopy(rArray, 0, array, 0, array.length);
        }
        return arr1;
    }

    public static void main(String[] args) {
        //long startTime = System.currentTimeMillis();
        Merge m = new Merge(100);
        int[][] data = m.getArray();
        int n = data.length;
        m.mergeSortRecursive(data, new int[n][n], 0, n - 1);
        for (int[] arr : data) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        //long endTime = System.currentTimeMillis();
        //System.out.println("It took " + (endTime - startTime) + " milliseconds");
    }
}
