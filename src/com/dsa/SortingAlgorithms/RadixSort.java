package com.dsa.SortingAlgorithms;
import java.util.*;

public class RadixSort {
    public RadixSort() {
        int[] arr = {120,315,7,515,1,422};
        radixsort(arr, arr.length);
    }

    public int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    public void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public void radixsort(int arr[], int n)
    {
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
